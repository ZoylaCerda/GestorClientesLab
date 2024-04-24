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

@WebServlet("/buscarClientePorId")
public class BuscarClienteIDServlet extends HttpServlet {

    @Inject
    IClienteService iClienteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente clienteBuscarId = new Cliente();
        clienteBuscarId.setId(3);

        Cliente cliente = iClienteService.buscarClientePorId(clienteBuscarId);

        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("/buscarClienteID.jsp").forward(req, resp);
    }
}
