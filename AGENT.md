# Copilot Instructions - Tuto Java

## Project Overview

Educational Java project demonstrating Stream API usage patterns across different complexity levels. Uses Maven multi-module structure with Java 25 and Lombok.

## Module Architecture

- **00-common**: Shared models (e.g., `User` record)

## Code Conventions

### Java Style (Enforced by Spotless)

- **Formatting**: Google Java Format + Palantir Java Format
- **Imports**: Custom order: `java|javax,org,com,com.diffplug,,\#com.diffplug,\#`
- **Organization**: Remove unused imports, format annotations
- **Records**: Use records for simple data models (see `User.java`)
- **Lombok**: Available project-wide (optional dependency in parent POM)

### Package Structure

All code under `fr.jbwittner.tutojava` with module-specific subpackages:
- Common models: `fr.jbwittner.tutojava.common.model`
- Stream examples: `fr.jbwittner.tutojava` (no deeper nesting)

### Educational Pattern

Tutorial files follow pedagogical progression:

1. **FactoryModel.java**: Test data factory (shared across examples)
2. **EvolutionLoop.java**: Loop → Stream migration patterns
3. **ToolBoxStream.java**: Stream operations catalog (filter, map, collect, etc.)
4. **AdvancedCases.java**: Complex collectors (groupingBy inception, teeing, flatMap)
5. **RealityCheck.java**: Anti-patterns (when NOT to use streams)

Each file contains `static void main()` demo methods (not standard `public static void main(String[] args)`)

## Build & Formatting

```bash
# Run from project root
mvn spotless:apply    # Format all files (Java, XML, Markdown, YAML, JSON, SQL)
mvn spotless:check    # Verify formatting
mvn clean install     # Build all modules
```

### Spotless Configuration

- **Java**: Google/Palantir formatting, import ordering, cleanthat refactoring
- **POM**: Sorted with `recommended_2008_06` order, 4-space indentation
- **Markdown**: Flexmark formatting
- **YAML/JSON**: Jackson-based formatting with specific quote/indent rules

## Code Patterns

### Streams (from tutorial examples)

- **Chaining filters**: Separate logical conditions for clarity
  ```java
  users.stream()
      .filter(u -> u.isActive())
      .filter(u -> u.age() >= 18)
  ```

- **Complex collectors**: Nest downstream collectors for multi-level transformations
  ```java
  Collectors.groupingBy(
      User::city,
      Collectors.filtering(u -> u.age() >= 18,
          Collectors.mapping(User::name, Collectors.toList())))
  ```

- **Java 16+ syntax**: Prefer `.toList()` over `.collect(Collectors.toList())`

### When to Avoid Streams

Per `RealityCheck.java`: Use loops for:
- Multi-dimensional array operations with early exits
- Performance-critical paths with minimal allocations
- Complex state tracking requiring nested breaks

## No Testing Framework

Project has no test infrastructure. Examples use `static void main()` methods with `System.out.println` for demonstration.

## Java Version Features

Uses **Java 25** features including:
- Records (data carriers)
- `Stream.toList()` (Java 16+)
- `Gatherers` API (Java 21+)
- `mapMulti` (Java 16+)

## Adding New Modules

1. Create `XX-module-name/` directory
2. Add `<module>XX-module-name</module>` to parent POM
3. Create module POM with parent reference and sequential artifactId
4. Follow `fr.jbwittner.tutojava.*` package naming

## Common Gotchas

- Spotless runs `cleanthat` refactoring - may restructure code automatically
- Stream examples use non-standard `main()` signatures (no args)
- Distribution configured for GitHub Packages (jbwittner/bankwiz_server)
