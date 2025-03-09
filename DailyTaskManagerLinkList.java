import java.util.LinkedList; 
import java.util.Scanner;
import java.util.Stack;

public class DailyTaskManagerLinkList {
    public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList <String> tasks = new LinkedList<>();
    LinkedList <Boolean> done = new LinkedList<>();
    Stack <String> taskStack = new Stack<>();
    boolean run = true;

    //adding the initial tasks to the link list
    tasks.add("Eat");
    tasks.add("Sleep");
    tasks.add("Study");
    tasks.add("Clean");
    tasks.add("Workout");

    //to initialize all the task in tasks as incomplete
    for (int i = 0; i < tasks.size(); i++) {
        done.add(false);
    }

    //the main app
    do{
        System.out.println("What do you want to do\n1. View List\n2. Modify a task\n3. Mark a task as completed\n4. Undo a completed task\n5. Display complete/uncompleted task\n6. Peek operation\n7. Insert a new task\n8. Delete a task\n9. Exit\n");
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        switch (userChoice) {

            // for displaying
            case 1:
            clearScreen();
            while (true) {
            displayTasks(tasks);
            System.out.println("\nType 'back' to go back");
            String goBack = scanner.nextLine();

            if (goBack.equals("back")) {
                clearScreen();
                break;
            } else {
                clearScreen();
            }
    } 
    break;
            //Modify a task    
            case 2:
            clearScreen();

            while (true) {
            displayTasks(tasks);
            System.out.println("Enter which task to modify (1,2,3)");
            int taskIndex = scanner.nextInt() - 1; //- 1 is because the index starts with 0
            scanner.nextLine();

            //made a loop for troubleproofing
            if (taskIndex >= 0 && taskIndex < tasks.size() ) {
                System.out.println("Enter the modified task");
                String newTask = scanner.nextLine();
                tasks.set(taskIndex, newTask);
                clearScreen();
                break;
            } else {
                System.out.println("invalid task, press Enter to continue");
                scanner.nextLine();
                clearScreen();
            }
        
            }  break;

            //Marking a task as done
            case 3:
            while (true) {
            clearScreen();
            displayTasks(tasks);
            System.out.println("Select which task to mark as done (1,2,3)");
            int taskDone = scanner.nextInt() - 1;
            scanner.nextLine();
            
            //troubleproofing loop blah blah blah
            if (taskDone >= 0 && taskDone < tasks.size()) {
                if (!done.get(taskDone)) {
                    done.set(taskDone, true);
                    taskStack.push(tasks.get(taskDone));
                    tasks.remove(taskDone);
                    System.out.println("Task '" + tasks.get(taskDone) + "' marked as done!");

                    //for pressing enter to continue, i do this so it will pause and you will be able to read the displayed text before cls
                    System.out.println("\nPress Enter to continue");
                    scanner.nextLine();
                    clearScreen();
                    break;
                    
                } else {
                    System.out.println("The task is already marked as completed");
                }
            } else {
                System.out.println("invalid task");
            }
        }break;

            //undoing a complete task
            case 4:
            clearScreen();
            if (!taskStack.isEmpty()) {
                String undoneTask = taskStack.pop();
                tasks.add(undoneTask);
                done.add(false);
                System.out.println("Task '" + undoneTask + "' Has been added back to the list!\n");

                //for pressing enter to continue, i do this so it will pause and you will be able to read the displayed text before cls
                System.out.println("\nPress Enter to continue");
                scanner.nextLine();
                clearScreen();                
                
                    } else {
                        System.out.println("There are no completed task yet!\n");
                    }
                    break;
            
            case 5:
            while (true) {
            clearScreen();
            System.out.println("The uncompleted tasks are:");
            displayTasks(tasks);
            System.out.println("\nAnd the completed tasks are:");
            displayStack(taskStack);
            System.out.println("\nSo there are " + tasks.size() + " uncompleted tasks and " + taskStack.size() + " completed tasks");
            System.out.println("\nType 'back' to go back");
            String goBack = scanner.nextLine();
            if (goBack.equals("back")) {
                clearScreen();
                break;
            } else {
                clearScreen();
            }
            } break;

            case 6:
            clearScreen();
            if (!taskStack.isEmpty()) {
                System.out.println("The last completed task is: " + taskStack.peek());
            } else {
                System.out.println("There are no completed task yet!");
            }

            //a pause so the user can read the texts
            System.out.println("press Enter to continue");
            scanner.nextLine();
            clearScreen();
            break;

            case 7:
            while (true){
            System.out.println("Enter a new task:");
            String newTask = scanner.nextLine().trim(); //trim removes unnececarry spaceees

            //troubleproofing for if the input is empty
            if (!newTask.isEmpty()) {
                tasks.add(newTask);
                done.add(false);

                System.out.println("The new task has been added");

            //updated task list
            displayTasks(tasks);

            //another if for an option to go back or write another task
            System.out.println("\nAdd another task?(Type 1 for Yes, and literally anything else for No)");
            int yesNo = scanner.nextInt();
            scanner.nextLine();
                if (yesNo == 1) {
                    System.out.println("ok lol");
                    clearScreen();
                } else {
                    clearScreen();
                    break;
                }

            //this will show up if u type nothing and enter it
            } else {
                System.out.println("You can't input nothing lol, type Enter to continue");
                scanner.nextLine();
                clearScreen();
            } 
                }  break;

            //removing a task
            case 8:
            while (true) {
            clearScreen();
            displayTasks(tasks);
            System.err.println("input which one to remove");
            int indexRemove = scanner.nextInt() - 1;
            scanner.nextLine();
            
            //troubleproofing
            if (indexRemove >= 0 && indexRemove < tasks.size()) {
            tasks.remove(indexRemove);
            System.out.println("\ntask removed\n");
            System.out.println("Press Enter to continue");
            scanner.nextLine();
            displayTasks(tasks);
            clearScreen();
            break;
            } else {
            System.out.println("invalid index");
            }
        } break;

            case 9:
            run = false;
            System.out.println("Exiting...");
            break;

        default:
            System.out.println("Invalid choice. Try again.");
    }
} while (run);

scanner.close();
}

// Function to display tasks
private static void displayTasks(LinkedList<String> tasks) {
if (tasks.isEmpty()) {
    System.out.println("There are no tasks in the task list.");
} else {
    for (int i = 0; i < tasks.size(); i++) {
        System.out.println((i + 1) + ". " + tasks.get(i)); 
        } 
    } 
}     

// Function for displaying the completed tasks in the stack
private static void displayStack(Stack<String> taskStack) {
if (taskStack.isEmpty()) {
    System.out.println("There are no completed tasks yet");
}  else {
    for (int i = 0; i < taskStack.size(); i++) {
        System.out.println((i + 1) + ". " + taskStack.get(i));
        }
    }
}

// Function for clearing the screen
private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }
}
