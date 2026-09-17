import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// An immutable class: once created, its state can NEVER change
final class ImmutablePoint { // 'final' class: cannot be subclassed (prevents mutable subclasses)
    private final int x; // 'final' fields: can only be assigned once, in the constructor
    private final int y;

    ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() { return x; }
    int getY() { return y; }

    // Instead of mutating, "modifying" methods return a NEW immutable object
    ImmutablePoint translate(int dx, int dy) {
        return new ImmutablePoint(x + dx, y + dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// An immutable class containing a mutable field (List) — needs defensive copying
final class ImmutableTeam {
    private final String teamName;
    private final List<String> members; // List is mutable, so extra care is needed

    ImmutableTeam(String teamName, List<String> members) {
        this.teamName = teamName;
        this.members = new ArrayList<>(members); // defensive copy on the way IN
    }

    String getTeamName() {
        return teamName;
    }

    List<String> getMembers() {
        return Collections.unmodifiableList(members); // defensive copy on the way OUT
    }
}

public class Immutability {
    public static void main(String[] args) {
        // ----- Immutable Point -----
        ImmutablePoint p1 = new ImmutablePoint(2, 3);
        ImmutablePoint p2 = p1.translate(5, 5); // creates a brand new object

        System.out.println("--- Immutable Point ---");
        System.out.println("p1 (unchanged): " + p1);
        System.out.println("p2 (new object): " + p2);

        // ----- Immutable Team with defensive copying -----
        System.out.println("\n--- Immutable Team ---");
        List<String> originalMembers = new ArrayList<>();
        originalMembers.add("Aarav");
        originalMembers.add("Priya");

        ImmutableTeam team = new ImmutableTeam("Backend Squad", originalMembers);

        // Mutating the ORIGINAL list after construction should NOT affect the team's internal state
        originalMembers.add("Rohan");
        System.out.println("Team members (should NOT include Rohan): " + team.getMembers());

        // Attempting to mutate the returned list should fail — it's unmodifiable
        try {
            team.getMembers().add("Hacker");
        } catch (UnsupportedOperationException e) {
            System.out.println("Blocked attempt to mutate team members from outside: " + e.getClass().getSimpleName());
        }
    }
}