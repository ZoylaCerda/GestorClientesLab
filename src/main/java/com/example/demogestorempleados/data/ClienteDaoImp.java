package com.example.demogestorempleados.data;

import com.example.demogestorempleados.dominio.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ClienteDaoImp  implements IClienteDao{
    @PersistenceContext(unitName = "ClienteUP")
    EntityManager em;
    @Override
    public List<Cliente> buscarTodosClientes() {
        TypedQuery<Cliente> q = em.createQuery("SELECT e FROM Cliente e ORDER BY e.id", Cliente.class);
        return q.getResultList();
    }

    @Override
    public Cliente buscarClientePorId(Cliente cliente) {
        return em.find(Cliente.class, cliente.getId());
    }

    @Override
    public Cliente buscarClientePorApellido(Cliente cliente) {
        Query q = em.createQuery("select e from Cliente e where e.apellido = :apellido");
        q.setParameter("apellido", cliente.getApellido());
        return (Cliente) q.getSingleResult();
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        em.remove(em.merge(cliente));
    }
}
