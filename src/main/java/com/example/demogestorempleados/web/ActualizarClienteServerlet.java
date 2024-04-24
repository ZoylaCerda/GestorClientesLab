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

@WebServlet("/actualizarCliente")
public class ActualizarClienteServerlet extends HttpServlet {
    @Inject
    IClienteService iClienteService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente ClienteParaEncontrar = new Cliente();
        ClienteParaEncontrar.setId(3);

        Cliente ClienteAmodificar = iClienteService.buscarClientePorId(ClienteParaEncontrar);

        ClienteAmodificar.setNombre("Julia");
        ClienteAmodificar.setApellido("Lopez");
        ClienteAmodificar.setEmail("email@example.com");

        iClienteService.modificarCliente(ClienteAmodificar);

        req.setAttribute("ClienteAmodificar", ClienteAmodificar);

        req.getRequestDispatcher("/actualizarCliente.jsp").forward(req, resp);
    }
}
