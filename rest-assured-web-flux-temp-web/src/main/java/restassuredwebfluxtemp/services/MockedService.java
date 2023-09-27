package restassuredwebfluxtemp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restassuredwebfluxtemp.models.MultipleDataResponses;
import restassuredwebfluxtemp.models.SingleDataResponse;

@Service
public class MockedService {

    private final MockedProvider mockedProvider;

    @Autowired
    public MockedService(MockedProvider mockedProvider) {
        this.mockedProvider = mockedProvider;
    }

    public Mono<SingleDataResponse> getSingleDataResponse(String correlationId, Integer idValue, String contentType) {
        return mockedProvider.getSingleData(correlationId, idValue, contentType);
    }

    public Flux<MultipleDataResponses> getMultipleDataResponses(String correlationId, Integer idValue, String contentType) {
        return mockedProvider.getMultipleData(correlationId, idValue, contentType);
    }

}
