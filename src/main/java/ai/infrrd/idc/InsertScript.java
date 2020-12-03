package ai.infrrd.idc;

import ai.infrrd.idc.entity.FinalizedDeconfigResponse;
import ai.infrrd.idc.entity.SuccessfulUpdation;
import ai.infrrd.idc.entity.UpdateRequestBody;
import ai.infrrd.idc.entity.UpdatedResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InsertScript {
    static List<FinalizedDeconfigResponse> deconfigResponseList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertScript.class);

    public static void main( String[] args ) throws IOException {
        Properties properties = getPropValues();
        String updateUrl = properties.getProperty("updateurl");
        String patchUrl = properties.getProperty("apisurl");;
        String finalizedUrl =  properties.getProperty("finalizedurl");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(patchUrl);
        HttpPut httpPut = new HttpPut(updateUrl);

        JSONParser parser = new JSONParser();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("/home/users004/dummy.json"));
            for (Object object:array){
                String json = object.toString();
                StringEntity entity = new StringEntity(json);
                //PATCH call to update the extractor fieldnames and fieldname
                httpPatch.setEntity(entity);
                httpPatch.setHeader("Accept", "application/json");
                httpPatch.setHeader("Content-type", "application/json");
                CloseableHttpResponse response = client.execute(httpPatch);
                InputStream encoding = response.getEntity().getContent();
                InputStreamReader inputStreamReader = new InputStreamReader(encoding);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                    sb.append(str);
                }
                System.out.println(sb.toString());
                Gson g = new Gson();
                SuccessfulUpdation s = g.fromJson(String.valueOf(sb), SuccessfulUpdation.class);

                //PUT call to update the DEconfigs
                if ( sb.toString().contains("Successfully DEConfig updated")) {
                    UpdateRequestBody updateBody = mapper(s);
                    String updateString = objectMapper.writeValueAsString(updateBody);
                    StringEntity entity1 = new StringEntity(updateString);
                    httpPut.setEntity(entity1);
                    httpPut.setHeader("Accept", "application/json");
                    httpPut.setHeader("Content-type", "application/json");
                    CloseableHttpResponse response1 = client.execute(httpPut);
                    InputStream encoding1 = response1.getEntity().getContent();
                    InputStreamReader inputStreamReader1 = new InputStreamReader(encoding1);
                    BufferedReader reader1 = new BufferedReader(inputStreamReader1);
                    StringBuffer sb1 = new StringBuffer();
                    String str1;
                    while((str1 = reader1.readLine())!= null){
                        sb1.append(str1);
                    }
                    LOGGER.info("Updated Response is : "+sb1.toString());
                   //sending the id to finalized de config as param
                   UpdatedResponse deconfigResponse = g.fromJson(String.valueOf(sb), UpdatedResponse.class);
                   if (deconfigResponse.getMessage().contains("Successfully DEConfig updated")) {
                       callFinalizedDeConfig(finalizedUrl,updateBody.getId());
                   }else{
                       LOGGER.info("deconfig was finalized for the id : "+ deconfigResponse.getData().getId());
                   }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static UpdateRequestBody mapper(SuccessfulUpdation successfulUpdation) {
        UpdateRequestBody updateRequestBody = new UpdateRequestBody();
        //usermodelID and customerId has to be hardcoded
        updateRequestBody.setUserModelId("111");
        updateRequestBody.setCustomerId("111");
        updateRequestBody.setExtractionProcessType(successfulUpdation.getData().getExtractionProcessType());
        updateRequestBody.setExtractorFieldName(successfulUpdation.getData().getExtractorFieldName());
        updateRequestBody.setFieldName(successfulUpdation.getData().getFieldName());
        updateRequestBody.setMicroserviceFieldConfig(successfulUpdation.getData().getMicroserviceFieldConfig());
        updateRequestBody.setId(successfulUpdation.getData().getId());
        System.out.println(updateRequestBody.getId());
        return  updateRequestBody;
    }

    //finalized deconfig
    private  static  void callFinalizedDeConfig(String url,String id){
        Gson gson= new Gson();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            HttpUriRequest httppost = RequestBuilder.post()
                    .setUri(new URI(url))
                    .addParameter("id", id)
                    .build();

            CloseableHttpResponse response = httpclient.execute(httppost);
            InputStream encoding = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(encoding);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str);
            }

            FinalizedDeconfigResponse deconfigResponse = gson.fromJson(String.valueOf(sb), FinalizedDeconfigResponse.class);
            if (deconfigResponse.getMessage()!=null && deconfigResponse.getMessage().contains("Successfully  finalize deconfig"))
            {
                LOGGER.info("finalizedDeConfig reponse which were success are : " + sb);
                deconfigResponseList.add(deconfigResponse);
            }else
            {
                LOGGER.info("Deconfig has not been finalised");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static Properties getPropValues() throws IOException {
        Properties prop = new Properties();
        try {
            String propFileName = "application.properties";
            InputStream inputStream;
            inputStream = InsertScript.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return prop;
    }
}
