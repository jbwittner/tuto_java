package fr.jbwittner.tutojava;

import java.util.Optional;
import java.util.stream.IntStream;

public class RealityCheck {

    static void main() {
        final int[][] matrix = {
            {10, 3, 3, 8},
            {1, 2, 3, 4},
            {4, 5, -6, 0},
            {7, 8, 9, 10}
        };

        // Le challenge : Trouver les coordonnées (x, y) du premier élément négatif d'une matrice

        // ❌ Version Stream : "J'ai lu un livre sur la programmation fonctionnelle"
        // Illisible, boxing inutile, overhead massif

        Optional<int[]> coordinates = IntStream.range(0, matrix.length)
                .boxed()
                .flatMap(r -> IntStream.range(0, matrix[r].length)
                        .filter(c -> matrix[r][c] < 0)
                        .mapToObj(c -> new int[] {r, c}))
                .findFirst();

        int[] resultStream;
        resultStream = coordinates.orElse(new int[] {-1, -1});

        // ✅ Version Boucle : "Je veux juste que ça marche"
        // Simple, performant, zéro allocation mémoire superflue
        int[] resultLoop = new int[] {-1, -1};

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] < 0) {
                    resultLoop = new int[] {r, c};
                    break;
                }
            }
        }

        System.out.println("Résultat Stream : " + resultStream[0] + ", " + resultStream[1]);
        System.out.println("Résultat Boucle : " + resultLoop[0] + ", " + resultLoop[1]);
    }
}
