package com.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/v1/org")
public class OrganizationController {

    @Autowired
    private OrganizationService orgService;

    @PostMapping("/save")
    public ResponseEntity<Mono<Organization>> save(@RequestBody OrganizationDto organizationDto) throws ExecutionException, InterruptedException {
        Mono<Organization> orgSave = orgService.saveOrg(organizationDto);
        return new ResponseEntity<Mono<Organization>>(orgSave, HttpStatus.OK);
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<Mono<Organization>> findById(@PathVariable("orgId") String id) {
        Mono<Organization> findId = orgService.findById(id);
        return new ResponseEntity<Mono<Organization>>(findId, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Flux<Organization> findAll() {
        Flux<Organization> orgAll = orgService.findAll();
        return orgAll;
    }

    @PutMapping("/update")
    public Mono<Organization> update(@RequestBody OrganizationDto organizationDto) {
        return orgService.update(organizationDto);
    }

    @DeleteMapping("/{orgId}")
    public void delete(@PathVariable("orgId") String id) {
        orgService.delete(id).subscribe();
    }
}
