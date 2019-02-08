package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.infra.AuthData;
import com.twu.biblioteca.services.AuthService;
import org.junit.Test;

import javax.security.auth.login.LoginException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class AuthServiceTest {

    @Test
    public void whenUserMakeLoginAssertNotThrowException() {
        AuthData.generateUsers();
        AuthService authService = new AuthService(AuthData.users);
        try {
            authService.login("111-1111", "123");
        } catch (LoginException ex) {
            assertNull(ex);
        } catch (UserNotFoundException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenUserMakeLoginWithWrongPasswordAssertThrowException() {
        AuthData.generateUsers();
        AuthService authService = new AuthService(AuthData.users);
        try {
            authService.login("111-1111", "batata");
        } catch (LoginException ex) {
            assertNotNull(ex);
        } catch (UserNotFoundException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenUserMakeLoginWithWrongUserAssertThrowException() {
        AuthData.generateUsers();
        AuthService authService = new AuthService(AuthData.users);
        try {
            authService.login("raryson", "123");
        } catch (LoginException ex) {
            assertNull(ex);
        } catch (UserNotFoundException ex) {
            assertNotNull(ex);
        }
    }


}
