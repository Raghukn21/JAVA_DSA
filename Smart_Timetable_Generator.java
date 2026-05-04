public class Smart_Timetable_Generator {

	// Data classes
	static class Subject {
		String name;
		String teacher;
		String room;
		Subject(String name, String teacher, String room) {
			this.name = name;
			this.teacher = teacher;
			this.room = room;
		}
	}

	// Example data
	Subject[] subjects = {
		new Subject("Math", "T1", "R1"),
		new Subject("Physics", "T2", "R2"),
		new Subject("Chemistry", "T1", "R2"),
		new Subject("Biology", "T3", "R1")
	};
	String[] slots = {"Mon-9AM", "Mon-10AM", "Tue-9AM", "Tue-10AM"};

	// Timetable: slot index -> subject index
	int[] timetable = new int[4]; // -1 means unassigned

	public Smart_Timetable_Generator() {
		for (int i = 0; i < timetable.length; i++) timetable[i] = -1;
	}

	// Main method to generate timetable
	public boolean generateTimetable() {
		return backtrack(0);
	}

	// Backtracking function
	private boolean backtrack(int subjectIdx) {
		if (subjectIdx == subjects.length) return true;
		for (int slot = 0; slot < slots.length; slot++) {
			if (isSafe(subjectIdx, slot)) {
				timetable[slot] = subjectIdx;
				if (backtrack(subjectIdx + 1)) return true;
				timetable[slot] = -1; // undo
			}
		}
		return false;
	}

	// Check if assigning subject to slot is safe
	private boolean isSafe(int subjectIdx, int slot) {
		Subject s = subjects[subjectIdx];
		for (int i = 0; i < timetable.length; i++) {
			if (timetable[i] == -1) continue;
			Subject assigned = subjects[timetable[i]];
			// Teacher or room conflict in same slot
			if (i == slot && (assigned.teacher.equals(s.teacher) || assigned.room.equals(s.room)))
				return false;
		}
		return timetable[slot] == -1;
	}

	// Print the timetable
	public void printTimetable() {
		for (int i = 0; i < slots.length; i++) {
			if (timetable[i] != -1)
				System.out.println(slots[i] + ": " + subjects[timetable[i]].name + " (" + subjects[timetable[i]].teacher + ", " + subjects[timetable[i]].room + ")");
			else
				System.out.println(slots[i] + ": Free");
		}
	}

	public static void main(String[] args) {
		Smart_Timetable_Generator gen = new Smart_Timetable_Generator();
		if (gen.generateTimetable()) {
			System.out.println("Valid Timetable:");
			gen.printTimetable();
		} else {
			System.out.println("No valid timetable found.");
		}
	}
}
