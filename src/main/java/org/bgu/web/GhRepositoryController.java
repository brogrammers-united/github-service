package org.bgu.web;

import java.util.concurrent.CompletableFuture;

import org.bgu.model.GhRepository;
import org.bgu.model.GhRepositoryResponse;
import org.bgu.service.GhRepositoryService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GhRepositoryController {

	private final GhRepositoryService repositoryService;
	
	public GhRepositoryController(GhRepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value="/repos", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CompletableFuture<GhRepositoryResponse> createRepository(@RequestBody GhRepository repository, OAuth2Authentication authentication) {
		return repositoryService.createRepository(authentication, repository);
	}
	
}
