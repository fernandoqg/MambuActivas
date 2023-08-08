package com.Mambu.MambuActivas.infraestructure;

import com.Mambu.MambuActivas.domain.dto.FullPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.dto.LoanPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.dto.RefinanceResponseDTO;
import com.Mambu.MambuActivas.domain.model.Refinance;
import com.Mambu.MambuActivas.domain.service.RefinanceService;
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

public class RefinanceRepository implements RefinanceService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Value("${spring.user}")
    private String user;

    @Value("${spring.password}")
    private String password;

    @Override
    public RefinanceResponseDTO refinance(Refinance refinance, String loanAccountId) {

        String credentials = user + ":" + password;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        RestTemplate restTemplate = new RestTemplate();

        UUID randomUUID = UUID.randomUUID();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedCredentials);
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/vnd.mambu.v2+json");
        headers.add("Idempotency-Key", randomUUID.toString());

        HttpEntity<Refinance> httpEntity = new HttpEntity<>(refinance, headers);
        RefinanceResponseDTO responseBody = new RefinanceResponseDTO();

        try {
            ResponseEntity<RefinanceResponseDTO> response = restTemplate.exchange(basePath+"/loans/"+loanAccountId+":refinance", HttpMethod.POST, httpEntity, RefinanceResponseDTO.class);
            responseBody = response.getBody();
            responseBody.setStatusCode(response.getStatusCode());
            responseBody.setNotes("Respuesta desde el Backend");

            return responseBody;
        } catch (RestClientException e) {

            RefinanceResponseDTO createResponse = new RefinanceResponseDTO();
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
                    String errorSource = gsonObj.get("errorSource").getAsString();
                    String errorReason = gsonObj.get("errorReason").getAsString();

                    createResponse.setErrorCode(errorCode);
                    createResponse.setErrorSource(errorSource);
                    createResponse.setErrorReason(errorReason);

                    return createResponse;
                }
            }
            return createResponse;

        }
    }
}
