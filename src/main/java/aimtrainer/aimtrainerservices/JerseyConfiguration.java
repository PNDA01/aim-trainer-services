package aimtrainer.aimtrainerservices;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("rest")
@Configuration
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		register(UserResource.class);
	}
}