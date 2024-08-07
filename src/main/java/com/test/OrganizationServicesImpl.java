package com.test;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class OrganizationServicesImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo orgRepo;


    @Override
    public Mono<Organization> saveOrg(OrganizationDto organizationDto) {
        if (Objects.nonNull(organizationDto)) {
            return orgRepo.save(organizationDtoToEntity(organizationDto));
        } else {
            return null;
        }
    }


    @Override
    public Mono<Organization> findById(String id) {
        return orgRepo.findById(id);
    }

    @Override
    public Flux<Organization> findAll() {
        return orgRepo.findAll();
    }

    @Override
    public Mono<Organization> update(OrganizationDto organizationDto) {
        return this.orgRepo.findById(organizationDto.getOrgId())
                .map(org -> organizationDtoToEntity(organizationDto))
                .flatMap(this.orgRepo::save);
    }

    @Override
    public Mono<Void> delete(String id) {
        return orgRepo.deleteById(id);
    }

    public static Organization organizationDtoToEntity(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        BeanUtils.copyProperties(organizationDto, organization);
        return organization;
    }


}
