package com.project.servletsapp.modeloDao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
              medico.setIdMedico(rs.getInt("id_medico")); // Puede ser null
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
