package org.bgu.web;

import org.bgu.config.annotation.CurrentUser;
import org.bgu.model.GhRepository;
import org.bgu.model.GhRepositoryResponse;
import org.bgu.model.interfaces.BguUserDetails;
import org.bgu.service.AsyncGhRepositoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author William Gentry
 */
@RestController
public class AsyncGhRepositoryController {

    private final AsyncGhRepositoryService repositoryService;

    public AsyncGhRepositoryController(AsyncGhRepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<List<GhRepositoryResponse>> getAllRepositoriesPaginated(@CurrentUser BguUserDetails userDetails, @RequestParam(value = "page", required = false, defaultValue = "1") int page, @RequestParam(value="per_page", required = false, defaultValue = "10") int perPage) {
        return repositoryService.getPaginatedRepositories(userDetails, page, perPage);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<GhRepositoryResponse> createRepository(@CurrentUser BguUserDetails userDetails, GhRepository repository) {
        return repositoryService.attemptCreateRepository(userDetails, repository);
    }
}
