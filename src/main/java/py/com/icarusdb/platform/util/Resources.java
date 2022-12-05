package py.com.icarusdb.platform.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * @author Roberto Gamarra [icarusdb@gmail.com]
 */
@Dependent
public class Resources {

    @Produces
    @PersistenceContext(unitName = "JakartaEE10DS")
    private EntityManager em;

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        //
        Logger logger = Logger.getLogger(
                                         injectionPoint.getMember().getDeclaringClass().getName());
        logger.setLevel(Level.INFO);
        return logger;
    }

}
