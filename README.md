# openapi-rest-archetype
Maven archetype generating basic structure for openapi-based REST project with contract tests.

## How to

To generate Maven project using this archetype, first install it to local Maven repository:

```bash
mvn install
```

Then, generate Maven project using command:

```bash
mvn archetype:generate -DarchetypeGroupId=com.example -DarchetypeArtifactId=openapi-rest-archetype
```

During generation, Maven will ask for a couple of project properties.
