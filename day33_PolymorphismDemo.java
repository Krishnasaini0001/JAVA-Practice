import java.util.ArrayList;
import java.util.List;

public class day33_PolymorphismDemo {
    public static void main(String[] args) {
        // ----- Runtime polymorphism: the actual object's method runs, not the reference type's -----
        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("Aarav", 80000, 5));
        employees.add(new Developer("Priya", 70000, "Java"));
        employees.add(new Employee("Generic Emp", 50000));

        System.out.println("--- Polymorphic dispatch: one loop, different behavior per type ---");
        for (Employee emp : employees) {
            // 'emp' is declared as Employee, but calls the actual runtime type's overridden method
            System.out.println(emp.describeRole() + " | Bonus: " + emp.calculateBonus());
        }

        // ----- Upcasting: happens automatically and safely -----
        System.out.println("\n--- Upcasting ---");
        Manager manager = new Manager("Rohan", 90000, 8);
        Employee upcast = manager; // Manager -> Employee, always safe
        System.out.println("Upcast reference calls: " + upcast.describeRole());

        // ----- Downcasting: needs an explicit cast and an instanceof check first -----
        System.out.println("\n--- Downcasting safely ---");
        for (Employee emp : employees) {
            if (emp instanceof Developer dev) { // pattern-matching instanceof (modern Java)
                System.out.println(dev.getName() + " codes in: " + dev.getLanguage());
            }
        }

        // ----- What happens WITHOUT overriding: static field access is NOT polymorphic -----
        System.out.println("\n--- Field access is NOT polymorphic (only methods are) ---");
        Employee e = new Developer("Test", 1, "Python");
        System.out.println("e.category (field, resolved at compile time): " + e.category);
    }
}

class Employee {
    String name;
    double salary;
    String category = "Employee"; // fields are NOT polymorphic — resolved by declared type

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    double calculateBonus() {
        return salary * 0.05; // default 5% bonus
    }

    String describeRole() {
        return name + " is a general Employee";
    }
}

class Manager extends Employee {
    int teamSize;
    String category = "Manager"; // shadows the parent field — again, not polymorphic

    Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    @Override
    double calculateBonus() {
        return salary * 0.15 + teamSize * 500; // managers get a bigger, team-based bonus
    }

    @Override
    String describeRole() {
        return name + " manages a team of " + teamSize;
    }
}

class Developer extends Employee {
    private String language;

    Developer(String name, double salary, String language) {
        super(name, salary);
        this.language = language;
    }

    String getLanguage() {
        return language;
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    String describeRole() {
        return name + " develops in " + language;
    }
}
