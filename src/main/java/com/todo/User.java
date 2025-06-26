package com.todo;

public class User {

    private String name;
    private TaskList toDoList;

    // Constructor //
    public User(String name){
        this.name = name;
        this.toDoList = new TaskList();
    }

    // Getters & Setters //

    public String setName(String name){
        this.name = name;
        return this.name;
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

    public void printTasks(){
        System.out.println();
        System.out.println("Tasks for " + this.name);
        System.out.println("--------------------------------");
        System.out.println(this.toDoList.toString());
    }

}
