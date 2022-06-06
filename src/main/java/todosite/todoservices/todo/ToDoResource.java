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

    /**
     * This function takes a ToDo object as input, saves it to the database, and
     * returns the saved ToDo
     * object
     * 
     * @param todo The ToDo object that is being passed in the request body.
     * @return The todo object that was created.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo createToDo(ToDo todo) {
        return todoRepository.save(todo);
    }

    /**
     * This function returns all the todos in the database.
     * 
     * @return An Iterable of ToDo objects.
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<ToDo> readAllToDos() {
        return todoRepository.findAll();
    }

    /**
     * It takes a Long id as a path parameter, and returns an Optional of a ToDo
     * object
     * 
     * @param id The id of the ToDo item to be retrieved.
     * @return An Optional object.
     */
    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ToDo> readToDo(@PathParam("id") Long id) {
        return todoRepository.findById(id);
    }

    /**
     * The function takes the id of the todo item to be deleted as a path parameter
     * and deletes the todo item from the database
     * 
     * @param id The id of the todo item to delete
     */
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteToDo(@PathParam("id") Long id) {
        todoRepository.deleteById(id);
    }
}