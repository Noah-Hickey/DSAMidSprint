package com.todo;

import java.util.LinkedList;

public class TaskList {

    private final LinkedList<Task> tasks;

    // New empty TaskList constructor //
    public TaskList(){
        this.tasks = new LinkedList<>();
    }

    public void addTask(String title, String description){

        tasks.add(new Task(title, description));
        System.out.println("Task added: " + title + " - " + description);

    }

    public void markTaskAsCompleted(String title, String description) {
       for (Task task : tasks){
            if (task.getTitle().equals(title) && task.getDescription().equals(description)) {
                task.markAsCompleted();
                System.out.println("Task: " + title + "Description: " + description);
                return;
            }
        }
        System.out.println("Task: " + title + "Description: " + description + " not found in the list.");

       }

       public void printAllTasks() {
           if (tasks.isEmpty()) {
               System.out.println("This to-do list is empty.");
               return;
           }
           System.out.println("--- To-Do List ---");
           int taskNumber = 1;
           for (Task task : tasks) {
               System.out.println(taskNumber + ". " + task);
               taskNumber++;
           }
           System.out.println("--------------------");
       }

    }






