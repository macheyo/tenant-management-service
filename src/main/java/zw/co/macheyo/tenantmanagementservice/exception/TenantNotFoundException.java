package zw.co.macheyo.tenantmanagementservice.exception;

public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(Long id) { super("Could not find tenant with id " + id); }
}
