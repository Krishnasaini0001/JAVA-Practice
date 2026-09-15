# Day 26 — Packages: How to Compile & Run

Package-based projects need to be compiled from the root folder (the one containing
the `shapes/` and `app/` directories), not from inside the subfolders.

```bash
# from inside Day26-Packages/
javac shapes/*.java app/*.java
java -cp . app.PackageDemo
```

The directory structure must mirror the package declaration:
- `shapes/Circle.java` starts with `package shapes;`
- `app/PackageDemo.java` starts with `package app;`