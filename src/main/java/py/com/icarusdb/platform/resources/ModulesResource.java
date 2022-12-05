package py.com.icarusdb.platform.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import py.com.icarusdb.platform.model.Module;
import py.com.icarusdb.platform.repository.ModuloRepository;

/**
 * @author Roberto Gamarra [icarusdb@gmail.com]
 */
@Path("modules")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ModulesResource {

    @Inject
    private Logger logger;

    @Inject
    private ModuloRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        String message = "Hello! from " + getClass().getSimpleName() + " -> " + LocalDateTime.now()
                                                                                             .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        logger.info(message);
        return message;
    }

    @GET
    @Path("all")
    public List<Module> all() {
        if (repository == null) {
            logger.severe("repository is null");
            return Collections.emptyList();
        }
        logger.severe("repository is ok!!");
        return repository.all();
    }

    @GET
    @Path("actives")
    public Response actives(@Context UriInfo info) {
        return Response.ok(repository.allActives()).build();
    }

    @GET
    @Path("{id}")
    public Response findById(Long id) {
        return Response.ok(repository.findById(id)).build();
    }
}
