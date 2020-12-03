package ai.infrrd.idc.entity;

import java.util.List;

public class UpdatedResponseBody {
    private String id;

    private String fieldName;

    private List<String> regexes;

    private List<String> vicinityWords;

    private List<String> negativeVicinityWords;

    private List<String> extractors;

    private String customerId;

    private String userModelId;

    private boolean status;

    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<String> getRegexes() {
        return regexes;
    }

    public void setRegexes(List<String> regexes) {
        this.regexes = regexes;
    }

    public List<String> getVicinityWords() {
        return vicinityWords;
    }

    public void setVicinityWords(List<String> vicinityWords) {
        this.vicinityWords = vicinityWords;
    }

    public List<String> getExtractors() {
        return extractors;
    }

    public void setExtractors(List<String> extractors) {
        this.extractors = extractors;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserModelId() {
        return userModelId;
    }

    public void setUserModelId(String userModelId) {
        this.userModelId = userModelId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<String> getNegativeVicinityWords() {
        return negativeVicinityWords;
    }

    public void setNegativeVicinityWords(List<String> negativeVicinityWords) {
        this.negativeVicinityWords = negativeVicinityWords;
    }
}
