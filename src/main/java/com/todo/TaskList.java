package com.todo;

import java.util.LinkedList;

public class TaskList {

    private final LinkedList<Task> tasks;

    // New empty TaskList constructor //
    public TaskList() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(String title, String description) {

        tasks.add(new Task(title, description));
        System.out.println("Task added: " + title + " Description: " + description);

    }

    public void markTaskAsCompleted(String title, String description) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title.trim()) &&
                    task.getDescription().equalsIgnoreCase(description.trim())) {
                if (task.isCompleted()) {
                    System.out.println("Task: " + title + " is already completed!");
                    return;
                }
                task.markAsCompleted();
                System.out.println("Task: " + title + " Description: " + description + " marked as completed!");
                return;
            }
        }
        System.out.println("Task: " + title + " Description: " + description + " not found in the list.");
    }


    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("This to-do list is empty.");
            return;
        }
        System.out.println("--- To-Do List ---");
        int taskNumber = 1;
        int pendingCount = 0;
        int completedCount = 0;
        for (Task task : tasks) {
            String status = task.isCompleted() ? "☑️ COMPLETED" : "⭕ PENDING";
            System.out.println(taskNumber + ". [" + status + "] " + task.getTitle() + " - " + task.getDescription());
            taskNumber++;

            if (task.isCompleted()) {
                completedCount++;
            } else {
                pendingCount++;
            }
        }

        System.out.println("--------------------");
        System.out.println("Summary: " + pendingCount + " pending, " + completedCount + " completed");
        System.out.println();

    }

    public int getTotalTasks() {
        return tasks.size();
    }

    public int getCompletedTasksCount() {
        int count = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                count++;
            }
        }
        return count;
    }

    public int getPendingTasksCount() {
        return getTotalTasks() - getCompletedTasksCount();
    }

    public boolean removeTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title.trim())) {
                tasks.remove(task);
                System.out.println("Task: " + title + " Description: " + " removed from the list.");
                return true;
            }
        }
        System.out.println("Task: " + title + " Description: " + " not found in the list.");
        return false;
    }

    public void printOnlyPendingTasks() {
        System.out.println("--- Pending Tasks ---");
        int taskNumber = 1;
        boolean hasPending = false;

        for (Task task : tasks) {
            if (!task.isCompleted()) {
                System.out.println(taskNumber + ". [⭕ PENDING] " + task.getTitle() + " - " + task.getDescription());
                taskNumber++;
                hasPending = true;
            }
        }

        if (!hasPending) {
            System.out.println("No pending tasks! Great job!");
        }
        System.out.println("---------------------");
    }

    public void printOnlyCompletedTasks() {
        System.out.println("--- Completed Tasks ---");
        int taskNumber = 1;
        boolean hasCompleted = false;

        for (Task task : tasks) {
            if (task.isCompleted()) {
                System.out.println(taskNumber + ". [☑️ COMPLETED] " + task.getTitle() + " - " + task.getDescription());
                taskNumber++;
                hasCompleted = true;
            }
        }

        if (!hasCompleted) {
            System.out.println("No completed tasks yet.");
        }
        System.out.println("-----------------------");
    }

    public void printLastTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to display.");
            return;
        }

        Task lastTask = tasks.getLast();
        String status = lastTask.isCompleted() ? "☑️ COMPLETED" : "⭕ PENDING";

        System.out.println("--- Last Task ---");
        System.out.println("[" + status + "] " + lastTask.getTitle() + " - " + lastTask.getDescription());
        System.out.println("------------------");

    }
}





