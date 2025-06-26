package com.todo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("To-Do List Application");
        System.out.println("------------------------");
        System.out.println();
        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Print Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

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
                    printTasks();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }




    }

    private static void printTasks() {
    }

    private static void markTaskAsCompleted() {
    }

    private static void addTask() {
    }

    private static void createUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = new User(name);
        users.add(user);
        System.out.println("Success! User created: " + name);
    }
}
