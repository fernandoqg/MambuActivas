package com.Mambu.MambuActivas.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.net.http.HttpClient;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefinanceResponseDTO {

    private String encodedKey;
    private String id;
    private String creationDate;
    private String accountState;
    private String productTypeKey;
    private String loanName;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int loanAmount;
    private String notes;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorSource;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorReason;

    private HttpStatusCode StatusCode;

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
        return StatusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        StatusCode = statusCode;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public String getProductTypeKey() {
        return productTypeKey;
    }

    public void setProductTypeKey(String productTypeKey) {
        this.productTypeKey = productTypeKey;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
