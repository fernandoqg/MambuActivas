package com.Mambu.MambuActivas.domain.dto;

import com.Mambu.MambuActivas.domain.utils.InterestSettings;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatusCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDTO {

    private String encodedKey;
    private String id;
    private String name;
    private String notes;
    private String type;
    private String category;
    private String state;

    private InterestSettings interestSettings;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorSource;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorReason;

    private HttpStatusCode statusCode;
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorSource() {
        return errorSource;
    }

    public void setErrorSource(String errorSource) {
        this.errorSource = errorSource;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getEncodedKey() {
        return encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public InterestSettings getInterestSettings() {
        return interestSettings;
    }

    public void setInterestSettings(InterestSettings interestSettings) {
        this.interestSettings = interestSettings;
    }
}
