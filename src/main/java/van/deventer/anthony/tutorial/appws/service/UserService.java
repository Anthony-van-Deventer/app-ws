package van.deventer.anthony.tutorial.appws.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import van.deventer.anthony.tutorial.appws.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
}
