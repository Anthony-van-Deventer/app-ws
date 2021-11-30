package van.deventer.anthony.tutorial.appws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import van.deventer.anthony.tutorial.appws.io.entity.UserEntity;
import van.deventer.anthony.tutorial.appws.repo.UserRepository;
import van.deventer.anthony.tutorial.appws.service.UserService;
import van.deventer.anthony.tutorial.appws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        UserEntity userEntity = new UserEntity();




        BeanUtils.copyProperties(userDto,userEntity);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }
}
