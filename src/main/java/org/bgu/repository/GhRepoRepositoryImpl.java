package org.bgu.repository;

import org.bgu.model.GhRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GhRepoRepositoryImpl implements GhRepoRepository {

	private final MongoTemplate ghMongoTemplate;
	
	public GhRepoRepositoryImpl(@Qualifier("ghMongoTemplate") MongoTemplate ghMongoTemplate) {
		this.ghMongoTemplate = ghMongoTemplate;
	}
	
	@Override
	public GhRepository saveRepository(GhRepository repository) {
		return ghMongoTemplate.save(repository, "gh_repository");
	}

}
