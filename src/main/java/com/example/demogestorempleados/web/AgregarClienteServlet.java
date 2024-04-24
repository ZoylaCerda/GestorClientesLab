package com.example.demogestorempleados.web;

import com.example.demogestorempleados.dominio.Cliente;
import com.example.demogestorempleados.servicios.IClienteService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agregarCliente")
public class AgregarClienteServlet extends HttpServlet {
    @Inject
    IClienteService iClienteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setApellido("Colocho");
        nuevoCliente.setEmail("karla@example.com");
        nuevoCliente.setNombre("Karla");

        iClienteService.insertarCliente(nuevoCliente);
        Cliente buscarNuevoCliente = iClienteService.buscarClientePorApellido(nuevoCliente);
        req.setAttribute("nuevoCliente", buscarNuevoCliente);
        req.getRequestDispatcher("/agregarCliente.jsp").forward(req, resp);
    }
}
