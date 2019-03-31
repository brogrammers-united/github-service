package org.bgu.service;

import java.util.concurrent.CompletableFuture;

import org.bgu.exception.InvalidRepositoryOperationException;
import org.bgu.model.GhRepository;
import org.bgu.model.GhRepositoryResponse;
import org.bgu.model.interfaces.BguUserDetails;
import org.bgu.util.GithubRequestUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

@Service
public class GhRepositoryServiceImpl implements GhRepositoryService {

	private final GithubRequestUtil requestUtil;
	
	public GhRepositoryServiceImpl(GithubRequestUtil requestUtil) {
		this.requestUtil = requestUtil;
	}
	
	@Async
	@Override
	public CompletableFuture<GhRepositoryResponse> createRepository(OAuth2Authentication authentication, GhRepository repository) {
		try {
			repository.setUsername(((BguUserDetails) authentication.getPrincipal()).getUsername());
			return CompletableFuture.completedFuture(requestUtil.attemptCreateRepo(authentication, repository));
		} catch (Exception e) {
			throw new InvalidRepositoryOperationException("Failed to create repository with name " + repository.getName());
		}
	}

}
