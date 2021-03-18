package zw.co.macheyo.tenantmanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.macheyo.tenantmanagementservice.common.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.DefaultValue;

import java.sql.Statement;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {

    private @Id @GeneratedValue Long id;
    private String name;
    private Status status = zw.co.macheyo.tenantmanagementservice.common.Status.INACTIVE;
}
