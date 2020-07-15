package pt.tiago.springapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.tiago.springapi.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
