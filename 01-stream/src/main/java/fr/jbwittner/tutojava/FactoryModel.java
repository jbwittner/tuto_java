package fr.jbwittner.tutojava;

import java.util.List;

import fr.jbwittner.tutojava.common.model.User;

public class FactoryModel {

    public static List<User> createUsers() {
        return List.of(
                new User("Alice", 30, true, "Lyon"),
                new User("Alice", 30, true, "Lyon"),
                new User("Alice", 30, true, "Lyon"),
                new User("David", 25, false, "Paris"),
                new User("Eve", 20, true, "Nice"),
                new User("Frank", 40, false, "Bordeaux"),
                new User("Grace", 28, true, "Bordeaux"),
                new User("Hannah", 22, true, "Lille"),
                new User("Isaac", 19, false, "Nice"),
                new User("Jack", 14, true, "Lyon"),
                new User("Kathy", 13, false, "Paris"),
                new User("Liam", 32, true, "Colmar"),
                new User("Mia", 15, true, "Nice"),
                new User("Noah", 29, false, "Marseille"),
                new User("Olivia", 12, true, "Paris"),
                new User("Paul", 33, false, "Lille"));
    }
}
