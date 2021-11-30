package van.deventer.anthony.tutorial.appws.service;

import van.deventer.anthony.tutorial.appws.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
