package fr.jbwittner.tutojava;

import java.util.List;

import fr.jbwittner.tutojava.common.model.User;

public class FactoryModel {

    public static List<User> createUsers() {
        return List.of(
                new User("Alice", 30, true),
                new User("Alice", 30, true),
                new User("Alice", 30, true),
                new User("David", 25, false),
                new User("Eve", 20, true),
                new User("Frank", 40, false),
                new User("Grace", 28, true),
                new User("Hannah", 22, true),
                new User("Isaac", 19, false),
                new User("Jack", 14, true),
                new User("Kathy", 13, false),
                new User("Liam", 32, true),
                new User("Mia", 15, true),
                new User("Noah", 29, false),
                new User("Olivia", 12, true),
                new User("Paul", 33, false));
    }
}
