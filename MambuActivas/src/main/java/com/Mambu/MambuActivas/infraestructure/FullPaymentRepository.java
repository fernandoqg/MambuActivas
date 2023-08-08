package com.Mambu.MambuActivas.infraestructure;

import com.Mambu.MambuActivas.domain.dto.ChangeInterestResponseDTO;
import com.Mambu.MambuActivas.domain.dto.FullPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.ChangeInterestRate;
import com.Mambu.MambuActivas.domain.model.FullPayment;
import com.Mambu.MambuActivas.domain.service.FullPaymentService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.UUID;

@Service
public class FullPaymentRepository  implements FullPaymentService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Value("${spring.user}")
    private String user;

    @Value("${spring.password}")
    private String password;

    @Override
    public FullPaymentResponseDTO payment(FullPayment fullPayment, String loanAccountId) {
        String credentials = user + ":" + password;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        RestTemplate restTemplate = new RestTemplate();

        UUID randomUUID = UUID.randomUUID();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedCredentials);
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/vnd.mambu.v2+json");
        headers.add("Idempotency-Key", randomUUID.toString());

        HttpEntity<FullPayment> httpEntity = new HttpEntity<>(fullPayment, headers);
        FullPaymentResponseDTO responseBody = new FullPaymentResponseDTO();


        try {
            ResponseEntity<FullPaymentResponseDTO> response = restTemplate.exchange(basePath+"/loans/"+loanAccountId+":payOff", HttpMethod.POST, httpEntity, FullPaymentResponseDTO.class);

            responseBody = response.getBody();
            System.out.println(responseBody);
            //responseBody.setStatusCode(response.getStatusCode());
            //responseBody.setNotes("SE REALIZO EL PAGO TOTAL DEL PRESTAMO CON EXITO");




            return responseBody;

        } catch (RestClientException e) {
            FullPaymentResponseDTO createResponse = new FullPaymentResponseDTO();
            //createResponse.setStatusCode(((HttpStatusCodeException) e).getStatusCode());
            //createResponse.setNotes("NO SE HA REALIZADO EL PAGO TOTAL ");

            String jsonError = e instanceof HttpStatusCodeException ?
                    ((HttpStatusCodeException) e).getResponseBodyAsString() : "";

            if (!jsonError.isEmpty()) {
                jsonError = jsonError.substring(jsonError.indexOf("["), jsonError.indexOf("]") + 1);

                JsonParser parser = new JsonParser();

                JsonArray jsonArray = parser.parse(jsonError).getAsJsonArray();

                /*


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

                 */
            }
            return createResponse;
        }
    }
}
