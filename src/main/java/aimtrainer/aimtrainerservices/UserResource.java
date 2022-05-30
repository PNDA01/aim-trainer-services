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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

@Path("users")
public class UserResource {

    public Response addHeader(Object body) {
        Response.ResponseBuilder rb = Response.ok(body);
        Response response = rb
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Headers", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
                .build();
        return response;
    }

    @Autowired
    private UserRepository userRepository;

    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readUser(@PathParam("id") Long id) {
        return addHeader(userRepository.findById(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(MultivaluedMap<String, String> userParams) {
        User p = new User(userParams.getFirst("name"), userParams.getFirst("username"),
                userParams.getFirst("password"));
        return addHeader(userRepository.save(p));
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllUsers() {
        return addHeader(userRepository.findAll());
    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Long id) {
        userRepository.deleteById(id);
    }
}