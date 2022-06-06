package todosite.todoservices.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    List<ToDo> findByUserId(Long userId);
}