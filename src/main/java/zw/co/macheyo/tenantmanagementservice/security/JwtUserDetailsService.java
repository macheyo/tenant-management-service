package zw.co.macheyo.tenantmanagementservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zw.co.macheyo.tenantmanagementservice.entity.UserDTO;
import zw.co.macheyo.tenantmanagementservice.feign.UserManagementClient;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserManagementClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("2".equals(username)) {
            return new User("2", "$2a$10$Y0XgsRMJ9H30g5ChRLEUm.DcTvmOPmsObzHqpCN17IPyZvAbTeE5a",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserDetails getUser(String token){
        return UserPrincipal.create(client.getUser("Bearer "+token)) ;
    }

}
