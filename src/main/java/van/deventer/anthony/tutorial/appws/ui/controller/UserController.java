package van.deventer.anthony.tutorial.appws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import van.deventer.anthony.tutorial.appws.shared.dto.UserDto;
import van.deventer.anthony.tutorial.appws.ui.model.request.UserDetailsRequestBody;
import van.deventer.anthony.tutorial.appws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestBody userDetails){

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser,returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
