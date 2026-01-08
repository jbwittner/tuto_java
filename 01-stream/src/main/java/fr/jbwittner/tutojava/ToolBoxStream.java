package fr.jbwittner.tutojava;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.jbwittner.tutojava.common.model.User;

public class ToolBoxStream {

    static void main() {
        final List<User> users = FactoryModel.createUsers();
        System.out.println("Input : " + users);

        filterExample(users);
        mapExample(users);
        flatMapExample(users);
        distinctExample(users);
        sortExample(users);
        peekExample(users);
        collectExample(users);
    }

    private static void filterExample(final List<User> users) {
        final List<User> activeAdults = users.stream()
                .filter(u -> u.isActive())
                .filter(u -> u.age() >= 18)
                .toList();

        System.out.println("Résultat filter : " + activeAdults);
    }

    private static void mapExample(final List<User> users) {
        final List<String> activeAdultNames = users.stream().map(u -> u.name()).toList();

        System.out.println("Résultat map : " + activeAdultNames);
    }

    private static void flatMapExample(final List<User> users) {
        final List<Character> allCharacters = users.stream()
                .map(u -> u.name())
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .toList();

        System.out.println("Résultat flatMap : " + allCharacters);
    }

    private static void distinctExample(final List<User> users) {
        final List<User> distinctNames = users.stream().distinct().toList();

        System.out.println("Résultat distinct : " + distinctNames);
    }

    private static void sortExample(final List<User> users) {
        final List<User> sortedUsers =
                users.stream().sorted((u1, u2) -> u1.age() - u2.age()).toList();

        System.out.println("Résultat sort : " + sortedUsers);
    }

    private static void peekExample(final List<User> users) {
        final List<User> activeAdults = users.stream()
                .filter(u -> u.isActive())
                .peek(u -> System.out.println("After filter: " + u))
                .filter(u -> u.age() >= 18)
                .peek(u -> System.out.println("After second filter: " + u))
                .toList();

        System.out.println("Résultat peek : " + activeAdults);
    }

    private static void collectExample(final List<User> users) {
        final List<User> activeAdultsToList = users.stream()
                .filter(u -> u.isActive())
                .filter(u -> u.age() >= 18)
                .toList(); // Version Java 16+

        System.out.println("Résultat collect toList : " + activeAdultsToList);

        final List<User> activeAdultsCollectorsToList = users.stream()
                .filter(u -> u.isActive())
                .filter(u -> u.age() >= 18)
                .collect(Collectors.toList()); // Version classique

        System.out.println("Résultat collect Collectors.toList : " + activeAdultsCollectorsToList);

        final Map<String, Integer> activeAdultsToMap =
                users.stream().distinct().collect(Collectors.toMap(u -> u.name(), u -> u.age()));

        System.out.println("Résultat collect toMap : " + activeAdultsToMap);
    }
}
