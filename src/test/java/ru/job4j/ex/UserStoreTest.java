package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserStoreTest {
    @Test(expected = UserInvalidException.class)
    public void whenUserIsNotValid() throws UserInvalidException {
        User notValid = new User("User Name", false);
        boolean out = UserStore.validate(notValid);
    }

    @Test(expected = UserInvalidException.class)
    public void whenUserNameIsShort() throws UserInvalidException {
        User notValid = new User("Li", true);
        boolean out = UserStore.validate(notValid);
    }

    @Test(expected = UserNotFoundException.class)
    public void whenUserNotFound() throws UserNotFoundException {
        User notFound = UserStore.findUser(new User[] {}, "SuperUser123");
    }
}