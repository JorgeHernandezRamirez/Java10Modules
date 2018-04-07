package com.jorgehernandezramirez.java.modules.user.impl;

import com.jorgehernandezramirez.java.modules.user.api.IUserService;
import com.jorgehernandezramirez.java.modules.user.api.dto.UserDto;
import com.jorgehernandezramirez.java.modules.user.api.exception.UserAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceDummyImpl implements IUserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceDummyImpl.class);

    private static final List<UserDto> CURRENT_USERS = new ArrayList(List.of(new UserDto("1", "Jorge")));

    public UserServiceDummyImpl(){
        //Para Java
    }

    @Override
    public List<UserDto> getUsersDto() {
        LOGGER.info("Se va a devolver la lista de usuarios");
        return CURRENT_USERS;
    }

    @Override
    public void remove(final UserDto userDto) {
        LOGGER.info("Se va a eliminar el usuario {}", userDto);
        final Optional<UserDto> userDtoOptional = getUser(userDto);
        if(userDtoOptional.isPresent()) {
            CURRENT_USERS.remove(userDtoOptional.get());
        }
    }

    @Override
    public void add(final UserDto userDto) {
        LOGGER.info("Se va a añadir el usuario {}", userDto);
        if(existUser(userDto)){
            throw new UserAlreadyExistsException();
        }
        CURRENT_USERS.add(userDto);
    }

    private Boolean existUser(final UserDto userDto){
        return getUser(userDto).isPresent();
    }

    private Optional<UserDto> getUser(final UserDto userDto){
        return CURRENT_USERS.stream().filter(userDto1 -> userDto1.getId().equals(userDto.getId()))
                .findFirst();
    }
}
