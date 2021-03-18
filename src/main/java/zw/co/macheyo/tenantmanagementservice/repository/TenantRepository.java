package zw.co.macheyo.tenantmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.macheyo.tenantmanagementservice.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
