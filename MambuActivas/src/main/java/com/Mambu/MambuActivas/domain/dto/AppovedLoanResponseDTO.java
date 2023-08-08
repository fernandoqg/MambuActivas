package com.Mambu.MambuActivas.domain.dto;

import com.Mambu.MambuActivas.domain.utils.ScheduleSettings;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatusCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppovedLoanResponseDTO {

    private String encodedKey;
    private String id;
    private String approvedDate;
    private String accountState;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int loanAmount;
    private String notes;
    private ScheduleSettings scheduleSettings;
    private String futurePaymentsAcceptance;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorSource;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorReason;

    private HttpStatusCode statusCode;

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

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
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

    public ScheduleSettings getScheduleSettings() {
        return scheduleSettings;
    }

    public void setScheduleSettings(ScheduleSettings scheduleSettings) {
        this.scheduleSettings = scheduleSettings;
    }

    public String getFuturePaymentsAcceptance() {
        return futurePaymentsAcceptance;
    }

    public void setFuturePaymentsAcceptance(String futurePaymentsAcceptance) {
        this.futurePaymentsAcceptance = futurePaymentsAcceptance;
    }

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
}
