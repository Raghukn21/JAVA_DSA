class Ride {
    int id;
    String path; // Combining pickup and drop for simplicity
    double fare;

    Ride(int id, String p, String d, double f) {
        this.id = id;
        this.path = p + " -> " + d;
        this.fare = f;
    }

    public String toString() {
        return id + ": " + path + " | Rs." + fare;
    }
}

public class RideSystem {
    class Node {
        Ride ride;
        Node next;
        Node(Ride r) { this.ride = r; }
    }

    Node head;

    // Adds a ride to the end
    public void add(Ride r) {
        Node newNode = new Node(r);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Removes the very last node
    public void deleteLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    // Reverses the pointers (Iterative)
    public void reverse() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void display() {
        if (head == null) System.out.println("Empty");
        for (Node t = head; t != null; t = t.next) System.out.println(t.ride);
    }

    public static void main(String[] args) {
        RideSystem rs = new RideSystem();
        rs.add(new Ride(1, "A", "B", 100));
        rs.add(new Ride(2, "B", "C", 150));
        rs.add(new Ride(3, "C", "D", 200));

        System.out.println("Current History:");
        rs.display();
        
        System.out.println("\nAfter Reversing:");
        rs.reverse();
        rs.display();
    }
}