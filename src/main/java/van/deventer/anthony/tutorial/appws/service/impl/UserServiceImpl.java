package van.deventer.anthony.tutorial.appws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import van.deventer.anthony.tutorial.appws.io.entity.UserEntity;
import van.deventer.anthony.tutorial.appws.repo.UserRepository;
import van.deventer.anthony.tutorial.appws.service.UserService;
import van.deventer.anthony.tutorial.appws.shared.Utils;
import van.deventer.anthony.tutorial.appws.shared.dto.UserDto;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDto createUser(UserDto userDto) {

        UserEntity storedUserDetails = userRepository.findByEmail(userDto.getEmail());
        if(storedUserDetails != null) throw new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto,userEntity);
        userEntity.setEncryptedPassword(encoder.encode(userDto.getPassword()));


        userEntity.setUserId(utils.generateUserId(30));

        UserEntity storedUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if( userEntity == null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity storedUser = userRepository.findByEmail(email);
        if(storedUser == null) throw new RuntimeException("No user with that email exists.");
        UserDto foundUser = new UserDto();
        BeanUtils.copyProperties(storedUser,foundUser);
        return foundUser;
    }
}
