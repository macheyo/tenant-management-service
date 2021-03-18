package zw.co.macheyo.tenantmanagementservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zw.co.macheyo.tenantmanagementservice.entity.UserDTO;

@FeignClient(name="USER-MANAGEMENT-SERVICE")
public interface UserManagementClient {
    @RequestMapping(method= RequestMethod.GET, value="/user/me")
    public UserDTO getUser(@RequestHeader("Authorization") String token);
}
