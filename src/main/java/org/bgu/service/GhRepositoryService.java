package org.bgu.service;

import java.util.concurrent.CompletableFuture;

import org.bgu.model.GhRepository;
import org.bgu.model.GhRepositoryResponse;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface GhRepositoryService {

	CompletableFuture<GhRepositoryResponse> createRepository(OAuth2Authentication authentication, GhRepository repository);
}
