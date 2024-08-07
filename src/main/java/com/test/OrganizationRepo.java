package com.test;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrganizationRepo extends ReactiveMongoRepository<Organization, String> {


}
