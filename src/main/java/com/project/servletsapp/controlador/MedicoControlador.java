package com.project.servletsapp.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.servletsapp.modelo.Medico;
import com.project.servletsapp.modeloDao.MedicoDAO;

@WebServlet("/MedicoControlador") // URL del servlet
public class MedicoControlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedicoDAO medicoDAO = new MedicoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            listarMedicos(request, response);
        } else {
            switch (accion) {
                case "editar":
                    // Implementar lógica de edición
                    
                    break;
                case "eliminar":
                    // Implementar lógica de eliminación
                    eliminarMedico(request, response);
                    break;
                default:
                    listarMedicos(request, response);
                    break;
            }
        }
    }

    private void listarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Medico> medicos = medicoDAO.listar();
        request.setAttribute("medicos", medicos);
        System.out.println("Listando medicos..." + medicos);
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }

  

    private void eliminarMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica para eliminar un médico
        int id = Integer.parseInt(request.getParameter("id"));
        medicoDAO.eliminar(id);
        listarMedicos(request, response); // Refrescar la lista después de eliminar
    }

    

}
