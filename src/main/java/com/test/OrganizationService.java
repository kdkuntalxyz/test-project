package com.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrganizationService {
    Mono<Organization> saveOrg(OrganizationDto organizationDto);

    Mono<Organization> findById(String id);

    Flux<Organization> findAll();

    Mono<Organization> update(OrganizationDto organizationDto);

    Mono<Void> delete(String id);
}
