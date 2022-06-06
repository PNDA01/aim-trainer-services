package todosite.todoservices.todo;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("todos")
public class ToDoResource {

    @Autowired
    private ToDoRepository todoRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo createToDo(ToDo todo) {
        return todoRepository.save(todo);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<ToDo> readAllToDos() {
        return todoRepository.findAll();
    }

    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ToDo> readToDo(@PathParam("id") Long id) {
        return todoRepository.findById(id);
    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteToDo(@PathParam("id") Long id) {
        todoRepository.deleteById(id);
    }
}