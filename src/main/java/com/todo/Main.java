package com.todo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        System.out.println("-------------------------");
        System.out.println(" To-Do List Application");
        System.out.println("------------------------");
        System.out.println();

        while (true) {
            printMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        createUser();
                        break;
                    case 2:
                        addTask();
                        break;
                    case 3:
                        markTaskAsCompleted();
                        break;
                    case 4:
                        printTasksMenu();
                        break;
                    case 5:
                        removeTask();
                        break;
                    case 6:
                        listAllUsers();
                        break;
                    case 7:
                        System.out.println("Thank you for using the To-Do List Application!");
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1-8.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Create User");
        System.out.println("2. Add Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Print Tasks");
        System.out.println("5. Remove Task");
        System.out.println("6. List All Users");
        System.out.println("7. Show User Statistics");
        System.out.println("8. Exit");
        System.out.print("Please select an option (1-8): ");
    }

    private static void printTasks() {
        System.out.print("Enter user name to print tasks: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                user.printTasks();
                return;
            }
        }
        System.out.println("User not found: " + userName);
    }

    private static void markTaskAsCompleted() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                System.out.print("Enter task title to mark as completed: ");
                String title = scanner.nextLine();
                System.out.print("Enter task description to mark as completed: ");
                String description = scanner.nextLine();
                user.markTaskAsCompleted(title, description);
                return;
            }
        }
        System.out.println("Sorry! User not found: " + userName);
    }

    private static void addTask() {
        System.out.println("Enter the user's name to assign a task: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                System.out.print("Enter task title: ");
                String title = scanner.nextLine();
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                if (title.isEmpty() || description.isEmpty()) {
                    System.out.println("Error! Title and description cannot be empty.");
                    return;
                }
                System.out.println("Success! Adding task for user: " + userName);
                user.addTask(title, description);
                return;
            }
        }
        System.out.println("Sorry! User not found: " + userName);
    }

    private static void createUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        try {
            if (name.isEmpty()) {
                System.out.println("Sorry! User name cannot be empty.");
                return;
            }
            for (User user : users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    System.out.println("Sorry! User already exists: " + name);
                    return;
                }
            }
            User newUser = new User(name, users);
            users.add(newUser);
            System.out.println("Success! User " + name + " has been created.");
        } catch (IllegalArgumentException e) {
            System.out.println("Sorry! " + e.getMessage());

        }

    }

    private static void printTasksMenu(){
        System.out.println();
        System.out.println("=====================");
        System.out.println(" Task Printing Menu:");
        System.out.println("=====================");
        System.out.println();
        System.out.println("1. Print All Tasks");
        System.out.println("2. Print Only Pending Tasks");
        System.out.println("3. Print Only Completed Tasks");
        System.out.print("Please select an option (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                printTasks();
                break;
            case 2:
                printOnlyPendingTasks();
                break;
            case 3:
                printOnlyCompletedTasks();
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1-3.");
        }
    }
    private static void printOnlyPendingTasks() {
        System.out.print("Enter user name to print only pending tasks: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                user.printOnlyPendingTasks();
                return;
            }
        }
        System.out.println("User not found: " + userName);
    }

    private static void printOnlyCompletedTasks() {
        System.out.print("Enter user name to print only completed tasks: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                user.printOnlyCompletedTasks();
                return;
            }
        }
        System.out.println("Sorry! User not found: " + userName);
    }

    private static void removeTask() {
        System.out.print("Enter user name to remove a task: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                System.out.print("Enter task title to remove: ");
                String title = scanner.nextLine();
                System.out.print("Enter task description to remove: ");
                String description = scanner.nextLine();
                if (user.removeTask(title, description)) {
                    System.out.println("Task removed successfully.");
                } else {
                    System.out.println("Task not found or could not be removed.");
                }
                return;
            }
        }
        System.out.println("Sorry! User not found: " + userName);
    }

    private static void listAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            for (User user : users) {
                System.out.println("- " + user.getName());
            }
        }
    }

}
