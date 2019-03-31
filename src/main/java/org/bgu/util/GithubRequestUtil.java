package org.bgu.util;

import org.bgu.model.GhRepository;
import org.bgu.model.GhRepositoryResponse;
import org.bgu.model.interfaces.BguUserDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GithubRequestUtil {

	private final ObjectMapper mapper;
	private final RestTemplate restTemplate;
	
	public GithubRequestUtil(ObjectMapper mapper, RestTemplate restTemplate) {
		this.mapper = mapper;
		this.restTemplate = restTemplate;
	}
	
	public GhRepositoryResponse attemptCreateRepo(OAuth2Authentication authentication, GhRepository repository) {
		return this.restTemplate.postForObject("https://api.github.com/user/repos", getCreateRepoRequest(authentication, repository), GhRepositoryResponse.class);
	}
	
	/*
	 * Helper Methods
	 */
	
	private HttpHeaders getRequestHeaders(OAuth2Authentication authentication) {
		BguUserDetails details = (BguUserDetails) authentication.getPrincipal();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "token " + details.getGithubOAuthToken());
		return headers;
	}
	
	private HttpEntity<String> getCreateRepoRequest(OAuth2Authentication authentication, GhRepository repo) {
		try {
			return new HttpEntity<>(mapper.writeValueAsString(repo), getRequestHeaders(authentication));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
