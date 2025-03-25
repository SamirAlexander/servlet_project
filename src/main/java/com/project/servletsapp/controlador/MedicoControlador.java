package com.project.servletsapp.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
                    ObtenerMedico(request, response); // Implementar lógica de edición
                    break;
                case "eliminar":
                    eliminarMedico(request, response);
                    break;
                case "editado":
                    editarMedico(request, response);
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
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }

    private void eliminarMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica para eliminar un médico
        int id = Integer.parseInt(request.getParameter("id"));
        medicoDAO.eliminar(id);
        listarMedicos(request, response); // Refrescar la lista después de eliminar
    }

    private void ObtenerMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Medico medico = medicoDAO.getMedicoById(id);
        request.setAttribute("medico", medico);
        

        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void editarMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el ID del médico a editar
        System.out.println("YA ESTAMOS ESTAMOS EN EDITAR MEDICO");
        

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        // Obtener los parámetros del formulario
        String apellido = request.getParameter("apellido");
        String areaEspecializacion = request.getParameter("areaEspecializacion");
        String contraseña = request.getParameter("contraseña");
        String correo = request.getParameter("correo");
        String dependencia = request.getParameter("dependencia");
        String documentoIdentidad = request.getParameter("documentoIdentidad");
        String horarioTrabajo = request.getParameter("horarioTrabajo");
        String idMedico = request.getParameter("idMedico");
        String noConsultorio = request.getParameter("noConsultorio");
        String nombre = request.getParameter("nombre");
        String numeroLicencia = request.getParameter("numeroLicencia");
        String rol = request.getParameter("rol");
        String telefono = request.getParameter("telefono");  
        
        System.out.println("ID USUARIO: " + idUsuario);
        System.out.println("APELLIDO: " + apellido);
        System.out.println("AREA ESPECIALIZACION: " + areaEspecializacion);
        System.out.println("CONTRASEÑA: " + contraseña);
        System.out.println("CORREO: " + correo);
        System.out.println("DEPENDENCIA: " + dependencia);
        System.out.println("DOCUMENTO IDENTIDAD: " + documentoIdentidad);
        System.out.println("HORARIO TRABAJO: " + horarioTrabajo);
        System.out.println("ID MEDICO: " + idMedico);
        System.out.println("NO CONSULTORIO: " + noConsultorio);
        System.out.println("NOMBRE: " + nombre);
        System.out.println("NUMERO LICENCIA: " + numeroLicencia);
        System.out.println("ROL: " + rol);
        System.out.println("TELEFONO: " + telefono);



        // Crear un objeto Medico con los datos obtenidos
        Medico medico = new Medico(apellido, areaEspecializacion, contraseña, correo, dependencia, documentoIdentidad, horarioTrabajo, idMedico, noConsultorio, nombre, numeroLicencia, rol, telefono);

        // Llamar al método editarMedico en el DAO
        boolean actualizado = medicoDAO.editarMedico(medico, idUsuario);

        // Redirigir a la página adecuada según el resultado
        String acceso = actualizado ? "listar.jsp" : "error.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

   /*  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los parámetros del formulario para agregar un médico
        String apellido = request.getParameter("apellido");
        String areaEspecializacion = request.getParameter("areaEspecializacion");
        String contraseña = request.getParameter("contrasena");
        String correo = request.getParameter("correo");
        String dependencia = request.getParameter("dependencia");
        String documentoIdentidad = request.getParameter("documentoIdentidad");
        String horarioTrabajo = request.getParameter("horarioTrabajo");
        String noConsultorio = request.getParameter("noConsultorio");
        String nombre = request.getParameter("nombre");
        String numeroLicencia = request.getParameter("numeroLicencia");
        String rol = request.getParameter("rol");
        String telefono = request.getParameter("telefono");
        String idMedico = request.getParameter("idMedico");

        // Crear un nuevo objeto Medico con los datos obtenidos
        Medico medico = new Medico(apellido, areaEspecializacion, contraseña, correo, dependencia, documentoIdentidad,
                horarioTrabajo, idMedico, noConsultorio, nombre, numeroLicencia, rol, telefono);

        // Intentar agregar el nuevo médico a la base de datos
        boolean agregado = medicoDAO.add(medico);

        // Determinar a qué vista redirigir
        String acceso = agregado ? "listar.jsp" : "error.jsp";

        // Redirigir a la vista correspondiente
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    } */
}
