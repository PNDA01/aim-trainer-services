package aimtrainer.aimtrainerservices;

import java.util.Optional;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<User> readUser(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User p) {
        return userRepository.save(p);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<User> readAllUsers() {
        return userRepository.findAll();
    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Long id) {
        userRepository.deleteById(id);
    }
}