package com.Mambu.MambuActivas.infraestructure;

import com.Mambu.MambuActivas.domain.dto.AppovedLoanResponseDTO;
import com.Mambu.MambuActivas.domain.dto.ClientCreateResponseDTO;
import com.Mambu.MambuActivas.domain.enums.ActionsLoan;
import com.Mambu.MambuActivas.domain.model.ApproveLoan;
import com.Mambu.MambuActivas.domain.model.Client;
import com.Mambu.MambuActivas.domain.service.ApproveLoanService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.UUID;

@Service
public class ApproveLoanRepository implements ApproveLoanService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Value("${spring.user}")
    private String user;

    @Value("${spring.password}")
    private String password;

    @Override
    public AppovedLoanResponseDTO approve(ApproveLoan approveLoan, String loanAccountId) {

        for(ActionsLoan action : ActionsLoan.values()){
            if(action.equals(approveLoan.getAction()));
        }

        String credentials = user + ":" + password;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        RestTemplate restTemplate = new RestTemplate();

        UUID randomUUID = UUID.randomUUID();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedCredentials);
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/vnd.mambu.v2+json");
        headers.add("Idempotency-Key", randomUUID.toString());

        HttpEntity<ApproveLoan> httpEntity = new HttpEntity<>(approveLoan, headers);
        AppovedLoanResponseDTO responseBody = new AppovedLoanResponseDTO();

        try {
            ResponseEntity<AppovedLoanResponseDTO> response = restTemplate.exchange(basePath + "/loans/"+loanAccountId, HttpMethod.POST, httpEntity, AppovedLoanResponseDTO.class);

            responseBody = response.getBody();
            responseBody.setStatusCode(response.getStatusCode());
            responseBody.setNotes("Creado desde el Backend");


            return responseBody;

        } catch (RestClientException e) {
            AppovedLoanResponseDTO createResponse = new AppovedLoanResponseDTO();
            createResponse.setStatusCode(((HttpStatusCodeException) e).getStatusCode());

            String jsonError = e instanceof HttpStatusCodeException ?
                    ((HttpStatusCodeException) e).getResponseBodyAsString() : "";

            if (!jsonError.isEmpty()) {
                jsonError = jsonError.substring(jsonError.indexOf("["), jsonError.indexOf("]") + 1);

                JsonParser parser = new JsonParser();

                JsonArray jsonArray = parser.parse(jsonError).getAsJsonArray();

                for (JsonElement element : jsonArray) {
                    JsonObject gsonObj = element.getAsJsonObject();

                    int errorCode = gsonObj.get("errorCode").getAsInt();

                    if(errorCode == 116){
                        String errorReason = gsonObj.get("errorReason").getAsString();
                        createResponse.setErrorReason(errorReason);
                        createResponse.setNotes("EL PRESTAMO YA FUE APROBADO ANTERIORMENTE");

                    }else{
                        String errorReason = gsonObj.get("errorReason").getAsString();
                        createResponse.setErrorReason(errorReason);
                        String errorSource = gsonObj.get("errorSource").getAsString();
                        createResponse.setErrorSource(errorSource);
                    }

                    createResponse.setErrorCode(errorCode);

                    return createResponse;
                }
            }
            return createResponse;
        }
    }
}
