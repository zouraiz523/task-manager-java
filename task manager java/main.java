import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + title;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== TASK MANAGER ======");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("✅ Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("📭 No tasks available.");
                    } else {
                        System.out.println("\n📋 Your Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = sc.nextInt() - 1;
                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).isCompleted = true;
                        System.out.println("✅ Task marked as completed!");
                    } else {
                        System.out.println("❌ Invalid task number!");
                    }
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = sc.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("🗑️ Task deleted!");
                    } else {
                        System.out.println("❌ Invalid task number!");
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting Task Manager. Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
