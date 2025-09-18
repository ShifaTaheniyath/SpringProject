import java.util.ArrayList;
import java.util.List;

class Task {
    private String taskId;
    private String description;
    private boolean isCompleted;

    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.isCompleted = false;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public void markPending() {
        this.isCompleted = false;
    }
 @Override
    public String toString() {
        return "[" + (isCompleted ? "✔" : "✗") + "] " + taskId + ": " + description;
    }

}

public class ToDoList {
    List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(String taskId) {
        tasks.removeIf(task -> task.getTaskId().equals(taskId));
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Your Tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task t1 = new Task("1", "Complete Java assignment");
        Task t2 = new Task("2", "Prepare for Hackathon");
        toDoList.addTask(t1);
        toDoList.addTask(t2);

        toDoList.displayTasks();

        t1.markCompleted();
        System.out.println("\nAfter marking task 1 as completed:");
        toDoList.displayTasks();

        toDoList.removeTask("2");
        System.out.println("\nAfter removing task 2:");
        toDoList.displayTasks();
    }
}
