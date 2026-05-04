# Java DSA Mini Projects

This repository contains two Java mini projects:
- **Ride Booking History System** (Linked List Based)
- **Smart Timetable Generator** (Backtracking Based)

---

## 1. Ride Booking History System

### Overview
A simple ride booking history manager using a singly linked list. It allows you to add, delete, search, display, and reverse ride records, similar to backend logs in ride-sharing apps.

### Features
- Add a new ride (at end)
- Cancel last ride (delete node)
- View all rides
- Search ride by location (pickup/drop)
- Reverse ride history (latest first view)

### Key Classes & Methods
- `Ride`: Stores rideId, pickup, drop, fare
- `Node`: Linked list node containing a Ride
- `addRide(Ride r)`: Add ride at end
- `deleteLastRide()`: Remove last ride
- `displayRides()`: Show all rides
- `searchRide(String location)`: Find rides by location
- `reverseHistory()`: Reverse the ride list

### Example Usage
```
Ride_Booking_History_System system = new Ride_Booking_History_System();
system.addRide(new Ride(1, "A", "B", 100));
system.displayRides();
system.reverseHistory();
system.displayRides();
```

### How to Run
1. Compile:
    ```
    javac Ride_Booking_History_System.java
    ```
2. Run:
    ```
    java Ride_Booking_History_System
    ```

---

## 2. Smart Timetable Generator

### Overview
A timetable generator for schools/colleges using backtracking. It assigns subjects to time slots, ensuring no teacher or room conflicts.

### Features
- Assigns subjects to available time slots
- Avoids teacher and room conflicts
- Uses backtracking to find a valid timetable
- Prints the generated timetable or notifies if no valid timetable exists

### Key Classes & Methods
- `Subject`: Represents a subject with a name, teacher, and room
- `generateTimetable()`: Starts timetable generation
- `isSafe(subjectIdx, slot)`: Checks for conflicts
- `backtrack(subjectIdx)`: Recursively assigns subjects
- `printTimetable()`: Prints the timetable

### Example Usage
```
Smart_Timetable_Generator gen = new Smart_Timetable_Generator();
if (gen.generateTimetable()) {
     gen.printTimetable();
} else {
     System.out.println("No valid timetable found.");
}
```

### How to Run
1. Compile:
    ```
    javac Smart_Timetable_Generator.java
    ```
2. Run:
    ```
    java Smart_Timetable_Generator
    ```

---

## Customization
- Edit the `subjects` and `slots` arrays in Smart Timetable Generator to match your data.
- Add more rides, subjects, teachers, or rooms as needed.

## License
This repository is for educational purposes.
