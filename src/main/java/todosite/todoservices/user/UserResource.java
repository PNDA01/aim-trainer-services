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

    /**
     * It takes a user object, saves it to the database, and returns the saved user object
     * 
     * @param user The user object that is being passed in the request body.
     * @return The user object is being returned.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * It returns all the users in the database
     * 
     * @return An Iterable of User objects.
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<User> readAllUsers() {
        return userRepository.findAll();
    }

    /**
     * It takes a Long id as a path parameter, and returns a User object
     * 
     * @param id The id of the user to be read
     * @return User
     */
    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<User> readUser(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    /**
     * It deletes a user from the database by id
     * 
     * @param id The id of the user to be deleted.
     */
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Long id) {
        userRepository.deleteById(id);
    }

    /**
     * It takes a user id and a todo object, finds the user by id, sets the user on the todo object,
     * and then saves the todo object
     * 
     * @param id The id of the user
     * @param todo The ToDo object that is being created.
     * @return A ToDo object
     */
    @POST
    @Path("{id}/todos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo createTodo(@PathParam("id") Long id, ToDo todo) {
        User user = userRepository.findById(id).get();
        todo.setUser(user);
        return todoRepository.save(todo);
    }
    
    /**
     * It returns a list of ToDo objects that are associated with the user whose id is passed in as a
     * parameter
     * 
     * @param id The id of the user
     * @return A list of ToDo objects
     */
    @GET
    @Path("{id}/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> getTodos(@PathParam("id") Long id) {
        return todoRepository.findByUserId(id);
    }
}