package com.jorgehernandezramirez.java.modules.user.impl.test;

import com.jorgehernandezramirez.java.modules.user.api.IUserService;
import com.jorgehernandezramirez.java.modules.user.api.dto.UserDto;
import com.jorgehernandezramirez.java.modules.user.api.exception.UserAlreadyExistsException;
import com.jorgehernandezramirez.java.modules.user.impl.UserServiceDummyImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {

    private final IUserService userService = new UserServiceDummyImpl();

    @Test
    public void shouldBeNotNullUserService(){
        assertNotNull(userService);
    }

    @Test
    public void shouldInsertOneUserCorrectly(){
        var numberOfUsers = userService.getUsersDto().size();
        userService.add(new UserDto("3", "Jorge"));
        assertEquals(1, userService.getUsersDto().size() - numberOfUsers);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void shouldReturnUserAlreadyExistsExceptionWhenUserExists(){
        userService.add(new UserDto("4", "Jorge"));
        userService.add(new UserDto("4", "Jose"));
    }

    @Test
    public void shouldRemoveOneUserCorrectly(){
        var numberOfUsers = userService.getUsersDto().size();
        userService.add(new UserDto("4", "Jorge"));
        assertEquals(1, userService.getUsersDto().size() - numberOfUsers);
        userService.remove(new UserDto("4", "Jorge"));
        assertEquals(0, userService.getUsersDto().size() - numberOfUsers);
    }
}
