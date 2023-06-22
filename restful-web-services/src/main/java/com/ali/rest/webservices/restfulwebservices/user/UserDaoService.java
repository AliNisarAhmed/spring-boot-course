package com.ali.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount =  0;

    static {
        users.add(new User(++usersCount, "Ali", LocalDate.now().minusYears(35)));
        users.add(new User(++usersCount, "Samrah", LocalDate.now().minusYears(35)));
        users.add(new User(++usersCount, "Azlan", LocalDate.now().minusYears(1)));
    }

    public List<User> findAll() {
        return users;
    }

    public User getUserById(Integer id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void deleteById(int userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
