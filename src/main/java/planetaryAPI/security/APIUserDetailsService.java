package planetaryAPI.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import planetaryAPI.dtos.user.APIUserDTO;
import planetaryAPI.services.user.APIUserService;

import java.util.Collections;

@Service
@AllArgsConstructor
public class APIUserDetailsService implements UserDetailsService {
    private APIUserService APIUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        APIUserDTO user = APIUserService.findUserByName(username);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.type());
        return new User(
                user.name(),
                user.password(),
                user.enabled(),
                true,
                true,
                true,
                Collections.singletonList(authority)
        );
    }
}
