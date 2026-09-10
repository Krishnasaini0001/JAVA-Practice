public class Person {
    // Instance fields — each Person object gets its own copy
    String name;
    int age;
    String city;

    public static void main(String[] args) {
        // ----- Creating objects (instances) of the Person class -----
        Person person1 = new Person();
        person1.name = "Aarav";
        person1.age = 28;
        person1.city = "Indore";

        Person person2 = new Person();
        person2.name = "Priya";
        person2.age = 24;
        person2.city = "Mumbai";

        // ----- Each object has independent state -----
        System.out.println("--- Person 1 ---");
        person1.introduce();

        System.out.println("\n--- Person 2 ---");
        person2.introduce();

        // ----- Changing one object doesn't affect the other -----
        person1.haveBirthday();
        System.out.println("\nAfter person1's birthday:");
        person1.introduce();
        person2.introduce(); // unaffected

        // ----- Objects can be passed to methods -----
        System.out.println("\n--- Comparing ages ---");
        Person older = getOlder(person1, person2);
        System.out.println("Older person: " + older.name);
    }

    // Instance method — operates on THIS object's fields
    void introduce() {
        System.out.println("Hi, I'm " + name + ", " + age + " years old, living in " + city + ".");
    }

    void haveBirthday() {
        age++;
        System.out.println(name + " just turned " + age + "!");
    }

    static Person getOlder(Person a, Person b) {
        return (a.age >= b.age) ? a : b;
    }
}