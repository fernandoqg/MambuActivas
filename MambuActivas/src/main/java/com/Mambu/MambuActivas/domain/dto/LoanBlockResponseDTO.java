package com.Mambu.MambuActivas.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatusCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanBlockResponseDTO {
    private String notes;

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
