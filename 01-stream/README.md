# 01-stream - Maîtriser l'API Stream de Java

## 📋 Description

Ce module est un tutoriel complet sur l'API Stream de Java. Il illustre l'évolution progressive du code impératif classique vers la programmation fonctionnelle moderne, avec des exemples pratiques et commentés.

## 📚 Contenu du Module

### 1. EvolutionLoop.java - L'Évolution des Boucles

Démonstration progressive de la transformation d'une boucle `for` classique vers les Streams modernes.

**Exemples inclus :**
- `activeAdultsForLoop()` - Boucle for avec index (années 90)
- `activeAdultsForEach()` - Boucle for-each améliorée
- `activeAdultsStreamWithoutLambda()` - Streams avec classes anonymes
- `activeAdultsStreamWithLambda()` - Streams avec lambdas (approche moderne)

**Ce que vous apprendrez :**
- Pourquoi les boucles classiques sont verboses
- Les risques des effets de bord (side-effects)
- Comment passer progressivement aux Streams
- Les avantages de la programmation déclarative

### 2. ToolBoxStream.java - La Boîte à Outils Stream

Guide complet des opérations Stream les plus utilisées avec des exemples pratiques.

**Opérations intermédiaires :**
- `filter()` - Filtrer les éléments
- `map()` - Transformer les éléments
- `flatMap()` - Aplatir les structures imbriquées
- `mapMulti()` - Transformation multiple (Java 16+)
- `distinct()` - Éliminer les doublons
- `sorted()` - Trier les éléments
- `peek()` - Observer les éléments (debugging)

**Opérations terminales :**
- `collect()` - Collecter en List, Map, etc.
- `reduce()` - Réduire à une valeur unique
- `allMatch() / anyMatch() / noneMatch()` - Vérifications
- `findFirst() / findAny()` - Recherche d'éléments

**Opérations avancées :**
- `gather()` - Transformations personnalisées (Java 21+)

### 3. AdvancedCases.java - Cas Avancés

Exemples de patterns avancés pour des traitements complexes.

**Patterns couverts :**
- **groupingByInception()** - Groupement imbriqué avec filtrage et mapping
  - Créer une Map<Ville, Liste<Noms des majeurs>>
  - Combiner `groupingBy()`, `filtering()` et `mapping()`
  
- **teeinExample()** - Traitement en parallèle avec `teeing()`
  - Calculer plusieurs statistiques en un seul passage
  - Moyenne d'âge des actifs et inactifs simultanément
  
- **flatMapComplexExample()** - FlatMap avancé
  - Extraire tous les caractères uniques des noms d'utilisateurs actifs
  - Chaîner `filter()`, `map()`, `flatMap()` et `distinct()`

### 4. RealityCheck.java - La Réalité du Terrain

Comparaison honnête entre Streams et boucles classiques.

**Exemple :**
Trouver les coordonnées du premier élément négatif dans une matrice 2D.

**Enseignement :**
- Les Streams ne sont pas toujours la meilleure solution
- Certains cas justifient les boucles classiques
- Importance de la lisibilité et de la performance
- Éviter le dogmatisme en programmation

### 5. FactoryModel.java - Générateur de Données

Classe utilitaire pour créer des jeux de données de test.

**Fournit :**
- Liste de `User` pour les exemples
- Données variées (âges, villes, statuts)
- Doublons intentionnels pour tester `distinct()`