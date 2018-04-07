package com.jorgehernandezramirez.java.modules.user.api;

import com.jorgehernandezramirez.java.modules.user.api.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getUsersDto();

    void remove(UserDto userDto);

    void add(UserDto userDto);
}
