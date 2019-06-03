package org.bgu.service;

import org.bgu.model.GhRepository;
import org.bgu.model.GhRepositoryResponse;
import org.bgu.model.interfaces.BguUserDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author William Gentry
 */
@Service
public class AsyncGhRepositoryService {

    private final WebClient webClient;

    public AsyncGhRepositoryService(WebClient.Builder applicationWebClientBuilder) {
        this.webClient = applicationWebClientBuilder.build();
    }

    public Mono<List<GhRepositoryResponse>> getAllRepositories(OAuth2Authentication authentication) {
        BguUserDetails details = (BguUserDetails) authentication.getPrincipal();
        return webClient
                    .get()
                        .header(HttpHeaders.AUTHORIZATION, "token " + details.getGithubOAuthToken())
                    .exchange()
                        .doOnNext(clientResponse -> System.err.println("Status Code: " + clientResponse.statusCode()))
                        .flatMap(clientResponse -> clientResponse.bodyToMono(new ParameterizedTypeReference<List<GhRepositoryResponse>>() {}));
    }

    public Mono<List<GhRepositoryResponse>> getPaginatedRepositories(BguUserDetails userDetails, int page, int size) {
        return webClient
                .get()
                .uri("page={page}&per_page={size}", page, size)
                    .header(HttpHeaders.AUTHORIZATION, "token " + userDetails.getGithubOAuthToken())
                .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<GhRepositoryResponse>>() {});
    }

    public Mono<GhRepositoryResponse> attemptCreateRepository(BguUserDetails userDetails, GhRepository repository) {
        return webClient
                    .post()
                        .body(Mono.just(repository), GhRepository.class)
                    .header(HttpHeaders.AUTHORIZATION, "token " + userDetails.getGithubOAuthToken())
                    .retrieve()
                        .bodyToMono(GhRepositoryResponse.class);
    }
}
