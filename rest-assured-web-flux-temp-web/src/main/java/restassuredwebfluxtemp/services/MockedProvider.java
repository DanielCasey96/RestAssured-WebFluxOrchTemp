package restassuredwebfluxtemp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restassuredwebfluxtemp.models.MultipleDataResponses;
import restassuredwebfluxtemp.models.SingleDataResponse;

import static restassuredwebfluxtemp.common.Constants.CORRELATION_ID_HEADER;

public class MockedProvider {

    private final WebClient apiClient;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public MockedProvider(WebClient apiClient) {

        this.apiClient = apiClient;
    }

    public Mono<SingleDataResponse> getSingleData(String correlationId, Integer idValue) {
        return apiClient
                .get()
                .uri("/rest-assured-template/service/data/single/{idValue}", idValue)
                .header(CORRELATION_ID_HEADER, correlationId)
                .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .retrieve()
                .bodyToMono(SingleDataResponse.class)
                .doOnNext(response -> logger.info(String.format("Service Response Body: " + response.getSingleData()))
                );
    }

    public Flux<MultipleDataResponses> getMultipleData(String correlationId, Integer idValue) {
        return null;
    }

}
