package com.todo;

import java.util.ArrayList;

public class User {

    private String name;
    private TaskList toDoList;
    private static ArrayList<User> allUsers;

    // Constructor //
    public User(String name, ArrayList<User> users){
        allUsers = users;
        setName(name); // Using setter to validate name //
        this.toDoList = new TaskList();
    }


    // Getters & Setters //

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        // Check for duplicates (excluding current user)
        if (allUsers != null) {
            for (User user : allUsers) {
                if (user != this && user.getName().equalsIgnoreCase(name.trim())) {
                    throw new IllegalArgumentException("User with name '" + name + "' already exists");
                }
            }
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    // Other methods //

    public void addTask(String title, String description){
        toDoList.addTask(title, description);
    }

    public void markTaskAsCompleted(String title, String description){
        this.toDoList.markTaskAsCompleted(title, description);
    }

    public boolean removeTask(String title, String description) {
        return this.toDoList.removeTask(title, description);
    }

    public void printTasks(){
        System.out.println();
        System.out.println("📋Tasks for " + this.name);
        System.out.println("--------------------------------");
        this.toDoList.printAllTasks();
    }

    public void printOnlyPendingTasks(){
        System.out.println();
        System.out.println("⭕️Pending Tasks for " + this.name);
        System.out.println("--------------------------------");
        this.toDoList.printOnlyPendingTasks();
    }

    public void printOnlyCompletedTasks(){
        System.out.println();
        System.out.println("☑️Completed Tasks for " + this.name);
        System.out.println("--------------------------------");
        this.toDoList.printOnlyCompletedTasks();
    }

    public int getTotalTasks() {
        return toDoList.getTotalTasks();
    }
    public int getCompletedTasks() {
        return toDoList.getCompletedTasksCount();
    }
    public int getPendingTasks() {
        return this.toDoList.getPendingTasksCount();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", totalTasks=" + getTotalTasks() +
                ", pendingTasks=" + getPendingTasks() +
                ", completedTasks=" + getCompletedTasks() +
                '}';
    }
}
