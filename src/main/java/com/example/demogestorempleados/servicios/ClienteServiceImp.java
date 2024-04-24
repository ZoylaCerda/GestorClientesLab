package com.example.demogestorempleados.servicios;

import com.example.demogestorempleados.dominio.Cliente;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class ClienteServiceImp implements IClienteService{

    @Inject
    private IClienteService iCliente;

    @Override
    public List<Cliente> buscarTodosClientes() {
        return iCliente.buscarTodosClientes();
    }

    @Override
    public Cliente buscarClientePorId(Cliente cliente) {
        return iCliente.buscarClientePorId(cliente);
    }

    @Override
    public Cliente buscarClientePorApellido(Cliente cliente) {
        return iCliente.buscarClientePorApellido(cliente);
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        iCliente.insertarCliente(cliente);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        iCliente.modificarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        iCliente.eliminarCliente(cliente);
    }
}
