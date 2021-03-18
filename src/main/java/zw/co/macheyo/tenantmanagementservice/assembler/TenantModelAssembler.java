package zw.co.macheyo.tenantmanagementservice.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import zw.co.macheyo.tenantmanagementservice.common.Status;
import zw.co.macheyo.tenantmanagementservice.controller.TenantController;
import zw.co.macheyo.tenantmanagementservice.entity.Tenant;

@Component
public class TenantModelAssembler implements RepresentationModelAssembler<Tenant, EntityModel<Tenant>> {
    @Override
    public EntityModel<Tenant> toModel(Tenant entity) {
        EntityModel<Tenant> tenantEntityModel = EntityModel.of(entity, linkTo(methodOn(TenantController.class).one(entity.getId())).withSelfRel(),linkTo(methodOn(TenantController.class).all()).withRel("tenants"));
        if(entity.getStatus().equals(Status.ACTIVE))tenantEntityModel.add(linkTo(methodOn(TenantController.class).deactivate(entity.getId())).withRel("deactivate"));
        else tenantEntityModel.add(linkTo(methodOn(TenantController.class).activate(entity.getId())).withRel("activate"));
        return tenantEntityModel;
    }
}
