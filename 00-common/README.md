# 00-common - Module Commun

## 📋 Description

Ce module contient les modèles de données partagés utilisés dans tous les modules du tutoriel Java.

## 📦 Contenu

### Modèles

#### User.java

Record Java représentant un utilisateur avec les propriétés suivantes :

```java
public record User(String name, int age, boolean isActive, String city) {}
```

**Propriétés :**
- `name` - Nom de l'utilisateur
- `age` - Âge de l'utilisateur
- `isActive` - Statut d'activité (actif/inactif)
- `city` - Ville de résidence

## 🎯 Utilisation

Ce module est une dépendance utilisée par les autres modules du projet. Il fournit un modèle de données simple et cohérent pour les exemples et exercices.

### Exemple d'utilisation

```java
User user = new User("Alice", 30, true, "Lyon");
System.out.println(user.name()); // "Alice"
System.out.println(user.age());  // 30
```

## 💡 À Propos des Records

Les **records** Java (introduits en Java 14, finalisés en Java 16) sont des classes immuables parfaites pour représenter des données. Ils génèrent automatiquement :

- Constructeur canonique
- Getters (méthodes accesseurs)
- `equals()` et `hashCode()`
- `toString()`

## 🔧 Construction

```bash
# Depuis la racine du projet
mvn clean install -pl 00-common

# Depuis ce module
cd 00-common
mvn clean install
```

## 📚 Ressources

- [Documentation Java Records](https://docs.oracle.com/en/java/javase/17/language/records.html)
