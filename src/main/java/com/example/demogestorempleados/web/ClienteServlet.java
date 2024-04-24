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
import java.util.List;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    @Inject
    IClienteService iClienteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> candidatos = iClienteService.buscarTodosClientes();
        req.setAttribute("candidatos", candidatos);
        req.getRequestDispatcher("/listadoClientes.jsp").forward(req,resp);
    }
}

