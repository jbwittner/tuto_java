package fr.jbwittner.tutojava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.jbwittner.tutojava.common.model.User;

public class EvolutionLoop {

    static void main() {
        final List<User> users = FactoryModel.createUsers();
        System.out.println("Input : " + users);

        final List<User> activeAdultsForLoopResult = activeAdultsForLoop(users);
        System.out.println("Résultat for loop : " + activeAdultsForLoopResult);

        final List<User> activeAdultsForEachResult = activeAdultsForEach(users);
        System.out.println("Résultat for each : " + activeAdultsForEachResult);

        final List<User> activeAdultsStreamWithoutLambdaResult = activeAdultsStreamWithoutLambda(users);
        System.out.println("Résultat stream sans lambda : " + activeAdultsStreamWithoutLambdaResult);

        final List<User> activeAdultsStreamWithLambdaResult = activeAdultsStreamWithLambda(users);
        System.out.println("Résultat stream avec lambda : " + activeAdultsStreamWithLambdaResult);
    }

    public static List<User> activeAdultsForLoop(final List<User> users) {
        // Le bon vieux monde des années 90
        final List<User> activeAdults = new ArrayList<>();
        // Gestion manuelle de l'index (risque d'IndexOutOfBounds)
        for (int i = 0; i < users.size(); i++) {
            final User u = users.get(i);
            if (u != null) { // Defensive coding
                if (u.isActive()) {
                    if (u.age() >= 18) {
                        activeAdults.add(u); // Effet de bord (Side-effect)
                    }
                }
            }
        }

        return activeAdults;
    }

    public static List<User> activeAdultsForEach(final List<User> users) {
        final List<User> activeAdults = new ArrayList<>();
        // Cache un itérateur sous le capot
        for (User u : users) {
            // La logique métier est noyée dans la structure de contrôle
            if (u != null && u.isActive() && u.age() >= 18) {
                activeAdults.add(u);
            }
        }
        return activeAdults;
    }

    public static List<User> activeAdultsStreamWithoutLambda(final List<User> users) {
        // Ce que le compilateur voit (Classes Anonymes)
        final List<User> activeAdults = users.stream()
                .filter(
                        new Predicate<User>() { // On instancie une classe anonyme
                            @Override
                            public boolean test(User u) {
                                return u.isActive();
                            }
                        })
                .filter(
                        new Predicate<User>() { // Encore une...
                            @Override
                            public boolean test(User u) {
                                return u.age() >= 18;
                            }
                        })
                .collect(Collectors.toList());

        return activeAdults;
    }

    public static List<User> activeAdultsStreamWithLambda(final List<User> users) {
        // Ce que le compilateur voit (Classes Anonymes)
        final List<User> activeAdults = users.stream()
                .filter(u -> u.isActive()) // Le compilateur génère le Predicate
                .filter(u -> u.age() >= 18) // Code métier pur
                .toList(); // (Java 16+)

        return activeAdults;
    }
}
