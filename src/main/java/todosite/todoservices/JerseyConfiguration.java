package todosite.todoservices;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import todosite.todoservices.todo.ToDoResource;
import todosite.todoservices.user.UserResource;

@Component
@ApplicationPath("api")
@Configuration
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		register(UserResource.class);
		register(ToDoResource.class);
		register(CORSResponseFilter.class);
	}
}