package com.project.servletsapp.modeloDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.servletsapp.config.Conexion;
import com.project.servletsapp.modelo.Medico;

public class MedicoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicos";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setIdUsuario(rs.getInt("id_usuario"));
                medico.setApellido(rs.getString("apellido"));
                medico.setAreaEspecializacion(rs.getString("area_especializacion"));
                medico.setContraseña(rs.getString("contraseña"));
                medico.setCorreo(rs.getString("correo"));
                medico.setDependencia(rs.getString("dependencia"));
                medico.setDocumentoIdentidad(rs.getString("documento_identidad"));
                medico.setHorarioTrabajo(rs.getString("horario_trabajo"));
                medico.setIdMedico(rs.getString("id_medico")); // Puede ser null
                medico.setNoConsultorio(rs.getString("no_consultorio"));
                medico.setNombre(rs.getString("nombre"));
                medico.setNumeroLicencia(rs.getString("numero_licencia"));
                medico.setRol(rs.getString("rol"));
                medico.setTelefono(rs.getString("telefono"));
                lista.add(medico);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public boolean add(Medico medico) {
        String sql = "INSERT INTO medicos (nombre, apellido, area_especializacion, contraseña, correo, dependencia, documento_identidad, horario_trabajo, id_medico, no_consultorio, numero_licencia, rol, telefono) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Obtener el ID generado
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            // rs = ps.executeQuery(); // Asignar el ID generado al objeto Medico
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getAreaEspecializacion());
            ps.setString(4, medico.getContraseña());
            ps.setString(5, medico.getCorreo());
            ps.setString(6, medico.getDependencia());
            ps.setString(7, medico.getDocumentoIdentidad());
            ps.setString(8, medico.getHorarioTrabajo());
            ps.setString(9, medico.getIdMedico());
            ps.setString(10, medico.getNoConsultorio());
            ps.setString(11, medico.getNumeroLicencia());
            ps.setString(12, medico.getRol());
            ps.setString(13, medico.getTelefono());

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            /*
             * throw new RuntimeException("Error al insertar el médico en la base de datos",
             * e);
             */
            return false;
        }
    }

    public Medico getMedicoById(int id) {
        Medico medico = null; // Inicializa el objeto medico.
        String sql = "SELECT id_usuario, nombre, apellido, telefono,  correo, contraseña, rol, id_medico, dependencia, horario_trabajo, numero_licencia, area_especializacion, no_consultorio FROM medicos WHERE id_usuario="
                + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) { // Si hay resultados
                medico = new Medico();
                medico.setIdUsuario(rs.getInt("id_usuario"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setCorreo(rs.getString("correo"));
                medico.setContraseña(rs.getString("contraseña"));
                medico.setRol(rs.getString("rol"));
                medico.setIdMedico(rs.getString("id_medico"));
                medico.setDependencia(rs.getString("dependencia"));
                medico.setHorarioTrabajo(rs.getString("horario_trabajo"));
                medico.setNumeroLicencia(rs.getString("numero_licencia"));
                medico.setAreaEspecializacion(rs.getString("area_especializacion"));
                medico.setNoConsultorio(rs.getString("no_consultorio"));
            }
        } catch (Exception e) {
            System.out.println("Error al Obtoner Medico: " + e.getMessage());
        }
        return medico;
    };

    public boolean editarMedico(Medico medico, int id) {
        String sql = "UPDATE medicos SET nombre = ?, apellido = ?, area_especializacion = ?, contraseña = ?, correo = ?, dependencia = ?, documento_identidad = ?, horario_trabajo = ?, no_consultorio = ?, numero_licencia = ?, rol = ?, telefono = ?, id_medico = ? WHERE id_usuario=" + id;
                
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            // Establecer los valores de los parámetros para la actualización
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getAreaEspecializacion());
            ps.setString(4, medico.getContraseña());
            ps.setString(5, medico.getCorreo());
            ps.setString(6, medico.getDependencia());
            ps.setString(7, medico.getDocumentoIdentidad());
            ps.setString(8, medico.getHorarioTrabajo());
            ps.setString(9, medico.getNoConsultorio());
            ps.setString(10, medico.getNumeroLicencia());
            ps.setString(11, medico.getRol());
            ps.setString(12, medico.getTelefono());
            ps.setInt(13, Integer.parseInt(medico.getIdMedico()));

            // El ID del médico es el que se usa para localizar el registro que se va a
            // actualizar

            // Ejecutar la actualización
            int rowsUpdated = ps.executeUpdate();

            // Si se actualizaron filas, significa que el médico fue editado correctamente
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR EN EL DAO");
            return false; // Si ocurre algún error, se devuelve false
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM medicos WHERE id_usuario=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

}
