package todosite.todoservices.user;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import todosite.todoservices.todo.ToDo;
import todosite.todoservices.todo.ToDoRepository;

@Path("users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoRepository todoRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<User> readAllUsers() {
        return userRepository.findAll();
    }

    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<User> readUser(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Long id) {
        userRepository.deleteById(id);
    }

    @POST
    @Path("{id}/todos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo createTodo(@PathParam("id") Long id, ToDo todo) {
        User user = userRepository.findById(id).get();
        todo.setUser(user);
        return todoRepository.save(todo);
    }
    
    @GET
    @Path("{id}/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> getTodos(@PathParam("id") Long id) {
        return todoRepository.findByUserId(id);
    }
}