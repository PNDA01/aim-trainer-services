package aimtrainer.aimtrainerservices;

import java.util.Optional;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("personnes")
public class UserResource {

    @Autowired
    private UserRepository personneRepository;

    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<User> recupererInd(@PathParam("id") Long id) {
        return personneRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User inserer(User p) {
        return personneRepository.save(p);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<User> recupererAge(@QueryParam("age") Integer age) {
        if (age == null) {
            return personneRepository.findAll();
        } else {
            return personneRepository.findByAge(age);
        }
    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        personneRepository.deleteById(id);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User ecraser(@PathParam("id") Long id, User p) {
        p.setId(id);
        return personneRepository.save(p);
    }
}