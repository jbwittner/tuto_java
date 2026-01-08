package fr.jbwittner.tutojava;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.jbwittner.tutojava.common.model.User;

public class AdvancedCases {

    static void main() {
        groupingByInception();
        teeinExample();
        flatMapComplexExample();
    }

    static void groupingByInception() {

        final List<User> users = FactoryModel.createUsers();
        System.out.println("Input : " + users);

        // Objectif : Map<Ville, Liste<Noms des majeurs>>
        final Map<String, List<String>> namesByCity = users.stream()
                .distinct()
                .collect(Collectors.groupingBy(
                        User::city, // Clé du map (Ville)
                        Collectors.filtering( // Downstream 1 : Filtre avant d'accumuler
                                u -> u.age() >= 18,
                                Collectors.mapping( // Downstream 2 : Transforme User -> String (Nom)
                                        User::name, Collectors.toList() // Downstream 3 : Accumule en Liste
                                        ))));

        System.out.println("Résultat groupingBy inception : " + namesByCity);
    }

    static void teeinExample() {
        final List<User> users = FactoryModel.createUsers();
        System.out.println("Input : " + users);

        // Objectif : Obtenir la moyenne d'âge des utilisateurs actifs et inactifs
        final Map<Boolean, Double> averageAgeByActiveStatus = users.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(u -> u.isActive(), Collectors.averagingInt(User::age)),
                        Collectors.filtering(u -> !u.isActive(), Collectors.averagingInt(User::age)),
                        (activeAvg, inactiveAvg) -> Map.of(
                                true, activeAvg,
                                false, inactiveAvg)));

        System.out.println("Résultat teeing example : " + averageAgeByActiveStatus);
    }

    static void flatMapComplexExample() {
        final List<User> users = FactoryModel.createUsers();
        System.out.println("Input : " + users);

        // Objectif : Obtenir une liste de tous les caractères uniques dans les noms des utilisateurs
        // actifs
        final List<Character> uniqueCharsInActiveUserNames = users.stream()
                .filter(User::isActive)
                .map(User::name)
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .distinct()
                .toList();

        System.out.println("Résultat flatMap complex example : " + uniqueCharsInActiveUserNames);
    }
}
