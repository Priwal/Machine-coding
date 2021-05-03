package src.com.splitwise;

import java.util.HashMap;
import java.util.Map;

import src.com.splitwise.models.User;

public class Account {
    private Map<Long, User> userList;
    private static Account accountInstance;

    private Account() {
        userList = new HashMap<>();
    }

    public static synchronized Account getInstance() {
        if (accountInstance == null)
            accountInstance = new Account();

        return accountInstance;
    }

    public void addUser(User user) {
        userList.put(user.getuId(), user);
        System.out.println("New User account " + user.toString() + "is successfully added");

    }

    public User getUserById(Long id) {
        if (userList.containsKey(id))
            return userList.get(id);

        else {
            System.out.println("User not found");
            return null;
        }
    }

    public void getAllUsers() {
        System.out.println("List of users with non zero balance in account");
        for (Map.Entry<Long, User> users : userList.entrySet()) {
            if (users.getValue().getTotalBalance() > 0)
                System.out.println(users.getValue().toString());
        }
    }

}
