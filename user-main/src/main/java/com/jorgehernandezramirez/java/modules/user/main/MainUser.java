package com.jorgehernandezramirez.java.modules.user.main;

import com.jorgehernandezramirez.java.modules.user.api.IUserService;
import java.util.ServiceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainUser {

    private static Logger LOGGER = LoggerFactory.getLogger(MainUser.class);

    public static void main(final String[] args){
        var userServiceLoader = ServiceLoader.load(IUserService.class);
        var userService = userServiceLoader.findFirst().get();
        LOGGER.info("{}", userService.getUsersDto());
    }
}
