package pt.tiago.springapi.services;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.tiago.springapi.models.Task;
import pt.tiago.springapi.repositories.TaskRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {

    final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Task> getAllTasks() {
        return ImmutableList.copyOf(repository.findAll());
    }

    @Override
    public Task getTask(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Transactional
    @Override
    public Task addTask(Task task) {
        return repository.save(task);
    }

    @Transactional
    @Override
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    @Transactional
    @Override
    public void deleteTask(int id) {
        Task task = getTask(id);
        repository.delete(task);
    }
}
