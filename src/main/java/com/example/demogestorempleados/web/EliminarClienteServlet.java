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

@WebServlet("/eliminarCandidato")
public class EliminarClienteServlet extends HttpServlet {
    @Inject
    IClienteService iClienteService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente ClienteParaEncontrar = new Cliente();
        ClienteParaEncontrar.setId(2);
        req.setAttribute("ClienteEliminadoID", ClienteParaEncontrar.getId());
        Cliente ClienteAEliminar = iClienteService.buscarClientePorId(ClienteParaEncontrar);
        iClienteService.eliminarCliente(ClienteAEliminar);
        req.getRequestDispatcher("/eliminarCliente.jsp").forward(req, resp);
    }
}
