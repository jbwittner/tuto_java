package fr.jbwittner.tutojava;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;

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
        reduceExample(users);
        matchExample(users);
        findExample(users);
        mapMultiExample(users);
        gatherExample(users);
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

    private static void mapMultiExample(final List<User> users) {
        // Exemple fictif de mapMulti (Java 16+)
        final List<Object> allCharacters = users.stream()
                .mapMulti((user, consumer) -> {
                    consumer.accept(user.age());
                    consumer.accept(user.age() * 10);
                })
                .toList();

        System.out.println("Résultat mapMulti : " + allCharacters);
    }

    private static void gatherExample(final List<User> users) {
        // Exemple fictif de gather (Java 21+)
        final List<List<User>> activeAdults =
                users.stream().gather(Gatherers.windowFixed(3)).toList();

        System.out.println("Résultat Gatherers : " + activeAdults);
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

        final Map<Integer, List<User>> activeAdultsGroupingBy =
                users.stream().distinct().collect(Collectors.groupingBy(u -> u.age()));

        System.out.println("Résultat collect groupingBy : " + activeAdultsGroupingBy);
    }

    private static void reduceExample(final List<User> users) {
        // Somme des âges des utilisateurs actifs et majeurs
        final int totalAge = users.stream()
                .filter(u -> u.isActive())
                .filter(u -> u.age() >= 18)
                .map(u -> u.age())
                .reduce(0, (a, b) -> a + b);

        System.out.println("Résultat reduce : " + totalAge);
    }

    private static void matchExample(final List<User> users) {
        // Vérifier si tous les utilisateurs sont actifs
        final boolean allActive = users.stream().allMatch(u -> u.isActive());

        System.out.println("Résultat allMatch : " + allActive);

        // Vérifier si au moins un utilisateur est majeur
        final boolean anyAdult = users.stream().anyMatch(u -> u.age() >= 18);

        System.out.println("Résultat anyMatch : " + anyAdult);

        // Vérifier si aucun utilisateur n'a un âge négatif
        final boolean noneNegativeAge = users.stream().noneMatch(u -> u.age() < 0);

        System.out.println("Résultat noneMatch : " + noneNegativeAge);
    }

    private static void findExample(final List<User> users) {
        // Trouver le premier utilisateur actif
        final User firstActiveUser =
                users.stream().filter(u -> u.isActive()).findFirst().orElse(null);

        System.out.println("Résultat findFirst : " + firstActiveUser);

        // Trouver n'importe quel utilisateur majeur
        final User anyAdultUser =
                users.stream().filter(u -> u.age() >= 32).findAny().orElse(null);

        System.out.println("Résultat findAny : " + anyAdultUser);
    }
}
