# Tuto Java - Programmation Moderne en Java

Ce projet est un tutoriel pratique sur les fonctionnalités modernes de Java, avec un focus particulier sur l'API Stream et les bonnes pratiques de programmation fonctionnelle.

## 📋 Description

Ce projet multi-modules Maven illustre l'évolution du code Java, de la programmation impérative classique aux approches fonctionnelles modernes. Il contient des exemples pratiques et des cas d'usage réels pour maîtriser les Streams Java.

## 🏗️ Structure du Projet

Le projet est organisé en plusieurs modules :

- **[00-common](00-common/README.md)** - Modèles et classes communes utilisés dans tous les modules
- **[01-stream](01-stream/README.md)** - Tutoriel complet sur l'API Stream de Java

## 🔧 Prérequis

- **Java 25** ou supérieur
- **Maven 3.6+**

## 🚀 Compilation et Exécution

### Compiler tout le projet

```bash
mvn clean install
```

### Formater le code (Spotless)

```bash
mvn spotless:apply
```

### Vérifier le formatage

```bash
mvn spotless:check
```

## 📚 Contenu Pédagogique

### Modules Disponibles

Chaque module contient des exemples progressifs et documentés :

1. **Common** - Modèles de données (records Java)
2. **Stream** - API Stream, de la boucle for à la programmation fonctionnelle avancée

## 🛠️ Technologies

- Java 25
- Maven
- Lombok
- Spotless (formatage de code)

## 📖 Pour Commencer

1. Clonez le dépôt
2. Consultez le README de chaque module pour des exemples spécifiques
3. Explorez les classes Java commentées
4. Testez et modifiez les exemples

## 👤 Auteur

**JB Wittner**

## 📄 License

Ce projet est à usage éducatif.

