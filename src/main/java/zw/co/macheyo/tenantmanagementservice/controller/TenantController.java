package zw.co.macheyo.tenantmanagementservice.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import zw.co.macheyo.tenantmanagementservice.assembler.TenantModelAssembler;
import zw.co.macheyo.tenantmanagementservice.entity.Tenant;
import zw.co.macheyo.tenantmanagementservice.exception.TenantNotFoundException;
import zw.co.macheyo.tenantmanagementservice.repository.TenantRepository;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TenantController {
    private static final Logger logger = LoggerFactory.getLogger(TenantController.class);
    @Autowired
    TenantRepository tenantRepository;
    @Autowired
    TenantModelAssembler tenantModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Tenant>> all() {
        List<EntityModel<Tenant>> tenants = tenantRepository.findAll().stream().map(tenantModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(tenants, linkTo(methodOn(TenantController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Tenant> one(@PathVariable Long id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new TenantNotFoundException(id));
        return tenantModelAssembler.toModel(tenant);
    }

    @PostMapping("/create")
    public EntityModel<Tenant> create(@RequestBody Tenant tenant){

        tenantRepository.save(tenant);
        return tenantModelAssembler.toModel(tenant);
    }

    @PutMapping("/{id}")
    public Tenant update(@RequestBody Tenant tenant, @PathVariable Long id) {
        return tenantRepository.findById(id)
                .map(newTenant -> {
                    newTenant.setName(tenant.getName());
                    newTenant.setStatus(tenant.getStatus());
                    return tenantRepository.save(newTenant);
                })
                .orElseGet(() -> {
                    tenant.setId(id);
                    return tenantRepository.save(tenant);
                });
    }


    @GetMapping("/activate/{id}")
    public EntityModel<Tenant> activate(@PathVariable Long id){
        Tenant tenant = new Tenant();
        return tenantModelAssembler.toModel(tenant);
    }

    @GetMapping("/deactivate/{id}")
    public EntityModel<Tenant> deactivate(@PathVariable Long id){
        Tenant tenant = new Tenant();
        return tenantModelAssembler.toModel(tenant);
    }

}
