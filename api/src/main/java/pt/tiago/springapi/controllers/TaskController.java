package pt.tiago.springapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.tiago.springapi.models.Task;
import pt.tiago.springapi.services.TaskService;

import java.util.Collection;

@RequestMapping("api/task")
@RestController
public class TaskController {

    final TaskService service;


    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<Task>> getAllTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        return ResponseEntity.ok(service.getTask(id));
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody String description) {
        return ResponseEntity.ok().body(service.addTask(new Task(null, description)));
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(service.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
