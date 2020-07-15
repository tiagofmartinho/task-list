package pt.tiago.springapi.services;

import pt.tiago.springapi.models.Task;

import java.util.Collection;

public interface TaskService {

    Collection<Task> getAllTasks();

    Task getTask(int id);

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTask(int id);

}
