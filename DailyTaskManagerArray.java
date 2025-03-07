import java.util.Scanner;
import java.util.Stack;


//initialization
public class DailyTaskManagerArray {
    public static void main (String[] args) {

        Stack<String> completedStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        boolean run = true;
        String[] activities = {
            "Eat","Sleep","Study","Clean","Workout"
        };
        boolean[] completedStatus = new boolean[activities.length];

        //while true so the program loops when an activity is completed
        do {
            System.out.println("What do you want to do\n1. View List\n2. Modify a task\n3. Mark a task as completed\n4. Undo a completed task\n5. Display complete/uncompleted task\n6. Display stack\n7. Exit");
            userChoice = scanner.nextInt();
            switch (userChoice) {

                // for displaying
                case 1:
                    System.out.println("Your Tasks:");
                    for (int i = 0; i < activities.length; i++) {
                        String status = completedStatus[i] ? " (DONE)" : ""; // Check if completed
                        System.out.println((i+1) + ". " + activities[i] + status);
                    }
                    break;

                //for modifying/updating tasks
                case 2:
                System.out.println("Your Tasks:");
                for (int i = 0; i < activities.length; i++) {
                    String status = completedStatus[i] ? " (DONE)" : ""; // Check if completed
                    System.out.println((i+1) + ". " + activities[i] + status);
                }
                    System.out.println("Which task do you want to modify?");
                    int userIndex = scanner.nextInt() - 1;

                    if (userIndex >= 0 && userIndex < activities.length) {
                        System.out.println("Insert the new task:");
                        String userMod = scanner.nextLine();
                        activities[userIndex] = userMod;
                        completedStatus[userIndex] = false; // Reset completion status
                        System.out.println("Task updated successfully.");
                    } else {
                        System.out.println("Invalid task number.");
                    }                    if (userIndex >= 0 && userIndex < activities.length) {
                        System.out.println("Insert the new task:");
                        String userMod = scanner.nextLine();
                        activities[userIndex] = userMod;
                        completedStatus[userIndex] = false; // Reset completion status
                        System.out.println("Task updated successfully.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                // System.out.println("Insert the task");
                // scanner.nextLine();
                // String userMod = scanner.nextLine();
                // activities[userIndex] = userMod;
                // break;

                //to mark a task as done
                case 3:
                System.out.println("Your Tasks:");
                for (int i = 0; i < activities.length; i++) {
                    String status = completedStatus[i] ? " (DONE)" : ""; // Check if completed
                        System.out.println((i+1) + ". " + activities[i] + status);
                    }
                    System.out.println("Which task is completed?");
                    int completedTask = scanner.nextInt() - 1;

                    if (completedTask >= 0 && completedTask< activities.length) {
                        if (!completedStatus[completedTask]){
                            completedStatus[completedTask] = true;
                            completedStack.push(activities[completedTask]);
                            System.out.println("Task " + (completedTask+1) + " Is marked as done!");
                        }
                        else {
                            System.out.println("Task is already completed");
                        }
                    } else {
                        System.out.println("Invalid task");
                    }
                    break;


                case 4:
                if (!completedStack.isEmpty()) {
                    String undoneTask = completedStack.pop(); // Remove from stack
                    for (int i = 0; i < activities.length; i++) {
                        if (activities[i].equals(undoneTask)) {
                            completedStatus[i] = false; // Unmark as completed
                            System.out.println("Task '" + undoneTask + "' has been undone!");
                            break;
                        }
                    }
                } else {
                    System.out.println("No completed tasks to undo.");
                }
                break;
                
                //to display complete/uncompleted task
                case 5:
                //these two are counters for complete and uncompleted task
                int completeCount = 0;
                int uncompleteCount = 0;

                System.out.println("Your Tasks:");
                for (int i = 0; i < activities.length; i++) {
                    String status = completedStatus[i] ? " (DONE)" : ""; // Check if completed
                        System.out.println((i+1) + ". " + activities[i] + status);
                    
                
                if (completedStatus[i]) {
                    completeCount++;
                } else {
                    uncompleteCount++;
                }
            }
            System.out.println("Total tasks: " + activities.length + "\nCompleted tasks: " + completeCount + "\nUncompleted tasks: " + uncompleteCount);
            break;

                case 6:
                System.out.println("Completed Tasks");

                if (completedStack.isEmpty()){
                    System.out.println("No completed task yet");
                }else {
                int count = 1;
                for (String task : completedStack) {
                System.out.println(count + ". " + task );
                count++; }
                }
                break;
                //System.out.println(completedStack);

            //This case is for exiting the code
                case 7:
                System.out.println("Are you sure? (1,2)\n1.No\n2.Yes");
                int exitChoice = scanner.nextInt();
                if (exitChoice == 1) {
                    break;
                } else {
                    System.out.println("Goodbye!");
                    run = false;                    
                }
                break;

                default:
                System.out.println("invalid option");
                break;
    }
} while (run == true);
scanner.close();
    }
}
