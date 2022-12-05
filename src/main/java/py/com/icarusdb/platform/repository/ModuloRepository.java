package py.com.icarusdb.platform.repository;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import jakarta.validation.constraints.NotNull;
import py.com.icarusdb.platform.model.Module;

@ApplicationScoped
public class ModuloRepository {

    @Inject
    private EntityManager em;

    @Inject
    private Logger logger;

    @Transactional(value = TxType.REQUIRES_NEW)
    public List<Module> all() {
        if (em == null) {
            logger.severe("no entityManeger !!!!");
            return Collections.emptyList();
        }
        return em.createNamedQuery("Modulo.findAll", Module.class).getResultList();
    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public List<Module> allActives() {
        //
        return em.createNamedQuery("Modulo.findAllActives", Module.class)
                 .setParameter("active", true)
                 .getResultList();
    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public Module findById(@NotNull Long id) {
        return em.find(Module.class, id);
    }
}
