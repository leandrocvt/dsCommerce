package com.devsuperior.dscommerce.tests;

import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {

    public static User createClientUser(){
        User user = new User(1L, "Maria Brown", "maria@gmail.com", "988888888",LocalDate.parse("2001-07-25"), "$2a$10$8fDcrqLKWa89YPSSI74cxexplH.b8Lu5/9cWJGPyXKABthFvu5bjK");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser(){
        User user = new User(1L, "Alex", "alex@gmail.com", "988888888",LocalDate.parse("2001-07-25"), "$2a$10$8fDcrqLKWa89YPSSI74cxexplH.b8Lu5/9cWJGPyXKABthFvu5bjK");
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomAdminUser(Long id, String username){
        User user = new User(id, username, "alex@gmail.com", "988888888",LocalDate.parse("2001-07-25"), "$2a$10$8fDcrqLKWa89YPSSI74cxexplH.b8Lu5/9cWJGPyXKABthFvu5bjK");
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomClientUser(Long id, String username){
        User user = new User(id, username, "maria@gmail.com", "988888888",LocalDate.parse("2001-07-25"), "$2a$10$8fDcrqLKWa89YPSSI74cxexplH.b8Lu5/9cWJGPyXKABthFvu5bjK");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }
}
