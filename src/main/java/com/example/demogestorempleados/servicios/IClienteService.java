package com.example.demogestorempleados.servicios;

import com.example.demogestorempleados.dominio.Cliente;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IClienteService {
    public List<Cliente> buscarTodosClientes();
    public Cliente buscarClientePorId(Cliente cliente);
    public Cliente buscarClientePorApellido(Cliente cliente);
    public void insertarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public  void eliminarCliente(Cliente cliente);
}
