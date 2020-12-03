package ai.infrrd.idc.entity;

import java.util.ArrayList;
import java.util.List;

public class DeconfigResponseData {

    private String id;

    private String fieldName;

    private List<String> regexes;

    private List<String> vicinityWords = new ArrayList<>();

    private List<String> negativeVicinityWords;

    private List<String> extractors;

    private List<String> finalizers;

    private List<String> languages;

    private List<String> preprocessors;

    private String profile;

    private String customerId;

    private String userModelId;

    private String extractorFieldName;

    private  boolean status;

    private String extractionProcessType;

    private String extractorType;

    private Integer version;

    private String createdDate;

    private String modifiedDate;

    private String microserviceFieldConfig;

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

    public List<String> getNegativeVicinityWords() {
        return negativeVicinityWords;
    }

    public void setNegativeVicinityWords(List<String> negativeVicinityWords) {
        this.negativeVicinityWords = negativeVicinityWords;
    }

    public List<String> getExtractors() {
        return extractors;
    }

    public void setExtractors(List<String> extractors) {
        this.extractors = extractors;
    }

    public List<String> getFinalizers() {
        return finalizers;
    }

    public void setFinalizers(List<String> finalizers) {
        this.finalizers = finalizers;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getPreprocessors() {
        return preprocessors;
    }

    public void setPreprocessors(List<String> preprocessors) {
        this.preprocessors = preprocessors;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getExtractorFieldName() {
        return extractorFieldName;
    }

    public void setExtractorFieldName(String extractorFieldName) {
        this.extractorFieldName = extractorFieldName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getExtractionProcessType() {
        return extractionProcessType;
    }

    public void setExtractionProcessType(String extractionProcessType) {
        this.extractionProcessType = extractionProcessType;
    }

    public String getExtractorType() {
        return extractorType;
    }

    public void setExtractorType(String extractorType) {
        this.extractorType = extractorType;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getMicroserviceFieldConfig() {
        return microserviceFieldConfig;
    }

    public void setMicroserviceFieldConfig(String microserviceFieldConfig) {
        this.microserviceFieldConfig = microserviceFieldConfig;
    }
}
