package com.Mambu.MambuActivas.infraestructure;

import com.Mambu.MambuActivas.domain.dto.LoanBlockResponseDTO;
import com.Mambu.MambuActivas.domain.dto.LoanPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.LoanBlock;
import com.Mambu.MambuActivas.domain.model.LoanPayment;
import com.Mambu.MambuActivas.domain.service.LoanBlockService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.UUID;

public class LoanBlockRepository implements LoanBlockService {

    @Value("${spring.external.service.base-url}")
    private String basePath;
    @Value("${spring.user}")
    private String user;
    @Value("${spring.password}")
    private String password;

    @Override
    public LoanBlockResponseDTO block(LoanBlock loanBlock, String loanAccountId) {
        String credentials = user + ":" + password;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        RestTemplate restTemplate = new RestTemplate();

        UUID randomUUID = UUID.randomUUID();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedCredentials);
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/vnd.mambu.v2+json");
        headers.add("Idempotency-Key", randomUUID.toString());

        HttpEntity<LoanBlock> httpEntity = new HttpEntity<>(loanBlock, headers);
        LoanBlockResponseDTO responseBody = new LoanBlockResponseDTO();

        try {
            ResponseEntity<LoanBlockResponseDTO> response = restTemplate.exchange(basePath + "/loans/"+loanAccountId+"/lock-transactions", HttpMethod.POST, httpEntity, LoanBlockResponseDTO.class);
            responseBody = response.getBody();
            responseBody.setStatusCode(response.getStatusCode());
            responseBody.setNotes("SE BLOQUEO EL PRESTAMO DESDE EL BACKEND");

            return responseBody;
        } catch (RestClientException e) {

            LoanBlockResponseDTO createResponse = new LoanBlockResponseDTO();
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

                    if(errorCode == 2336){
                        String errorReason = gsonObj.get("errorReason").getAsString();
                        createResponse.setErrorReason(errorReason);
                        createResponse.setNotes("EL PRESTAMO YA ESTA EN ESTADO BLOQUEADO");

                    }else{
                        String errorReason = gsonObj.get("errorReason").getAsString();
                        createResponse.setErrorReason(errorReason);
                        String errorSource = gsonObj.get("errorSource").getAsString();
                        createResponse.setErrorSource(errorSource);
                    }


                    return createResponse;
                }
            }
            return createResponse;

        }
    }
}
