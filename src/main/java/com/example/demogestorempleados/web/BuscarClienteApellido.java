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

@WebServlet("/buscarClienteApellido")
public class BuscarClienteApellido extends HttpServlet {
    @Inject
    IClienteService iClienteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente clienteBuscarPorCarnet = new Cliente();
        clienteBuscarPorCarnet.setApellido("Lopez");

        Cliente cliente = iClienteService.buscarClientePorApellido(clienteBuscarPorCarnet);

        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("/buscarClienteApellido.jsp").forward(req, resp);
    }
}
