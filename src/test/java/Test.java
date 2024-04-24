import com.example.demogestorempleados.dominio.Cliente;
import com.example.demogestorempleados.dominio.Direccion;
import org.apache.logging.log4j.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;

public class Test {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
//        crearClienteDireccion();
        probarCascada(5);
    }

    private static void crearClienteDireccion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClienteUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Cliente cliente = new Cliente("RA101621", "Marvin", "Ramos");
        em.persist(cliente);
        log.debug("Objeto creado: " + cliente);

        Direccion direccion = new Direccion(cliente,"mi casa","la mejor", "231");
        em.persist(direccion);
        log.debug("Objeto creado: " + direccion);

        tx.commit();
        em.close();
        emf.close();
    }

    private static void probarCascada(int clienteId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClienteUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Cliente cliente = em.find(Cliente.class, clienteId);
        log.debug("Cliente encontrado: " + cliente);

        // Modificar el cliente
        cliente.setNombre("Carlos");
        em.merge(cliente);
        log.debug("Cliente modificado: " + cliente);

        // Eliminar el cliente y probar la eliminación en cascada
        em.remove(cliente);
        log.debug("Cliente eliminado: " + cliente);

        tx.commit();
        em.close();
        emf.close();
    }
}
