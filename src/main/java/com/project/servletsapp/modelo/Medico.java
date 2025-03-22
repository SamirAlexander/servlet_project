package com.project.servletsapp.modelo;

public class Medico {
  private int    idUsuario;
  private String apellido;
  private String areaEspecializacion;
  private String contraseña;
  private String correo;
  private String dependencia;
  private String documentoIdentidad;
  private String horarioTrabajo;
  private Integer idMedico; // Puede ser null
  private String noConsultorio;
  private String nombre;
  private String numeroLicencia;
  private String rol;
  private String telefono;

  public Medico() {}

  public Medico(String apellido, String areaEspecializacion, String contraseña, String correo, 
                 String dependencia, String documentoIdentidad, String horarioTrabajo, Integer idMedico, 
                 String noConsultorio, String nombre, String numeroLicencia, String rol, String telefono) {
      this.apellido = apellido;
      this.areaEspecializacion = areaEspecializacion;
      this.contraseña = contraseña;
      this.correo = correo;
      this.dependencia = dependencia;
      this.documentoIdentidad = documentoIdentidad;
      this.horarioTrabajo = horarioTrabajo;
      this.idMedico = idMedico;
      this.noConsultorio = noConsultorio;
      this.nombre = nombre;
      this.numeroLicencia = numeroLicencia;
      this.rol = rol;
      this.telefono = telefono;
  }

  public int getIdUsuario() { return idUsuario; }
  public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

  public String getApellido() { return apellido; }
  public void setApellido(String apellido) { this.apellido = apellido; }

  public String getAreaEspecializacion() { return areaEspecializacion; }
  public void setAreaEspecializacion(String areaEspecializacion) { this.areaEspecializacion = areaEspecializacion; }

  public String getContraseña() { return contraseña; }
  public void setContraseña(String contraseña) { this.contraseña = contraseña; }

  public String getCorreo() { return correo; }
  public void setCorreo(String correo) { this.correo = correo; }

  public String getDependencia() { return dependencia; }
  public void setDependencia(String dependencia) { this.dependencia = dependencia; }

  public String getDocumentoIdentidad() { return documentoIdentidad; }
  public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }

  public String getHorarioTrabajo() { return horarioTrabajo; }
  public void setHorarioTrabajo(String horarioTrabajo) { this.horarioTrabajo = horarioTrabajo; }

  public Integer getIdMedico() { return idMedico; }
  public void setIdMedico(Integer idMedico) { this.idMedico = idMedico; }

  public String getNoConsultorio() { return noConsultorio; }
  public void setNoConsultorio(String noConsultorio) { this.noConsultorio = noConsultorio; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public String getNumeroLicencia() { return numeroLicencia; }
  public void setNumeroLicencia(String numeroLicencia) { this.numeroLicencia = numeroLicencia; }

  public String getRol() { return rol; }
  public void setRol(String rol) { this.rol = rol; }

  public String getTelefono() { return telefono; }
  public void setTelefono(String telefono) { this.telefono = telefono; }

  // Método toString() para evitar referencias de memoria
  @Override
  public String toString() {
      return "Medico{" +
              "idUsuario=" + idUsuario +
              ", apellido='" + apellido + '\'' +
              ", areaEspecializacion='" + areaEspecializacion + '\'' +
              ", contraseña='" + contraseña + '\'' +
              ", correo='" + correo + '\'' +
              ", dependencia='" + dependencia + '\'' +
              ", documentoIdentidad='" + documentoIdentidad + '\'' +
              ", horarioTrabajo='" + horarioTrabajo + '\'' +
              ", idMedico=" + idMedico +
              ", noConsultorio='" + noConsultorio + '\'' +
              ", nombre='" + nombre + '\'' +
              ", numeroLicencia='" + numeroLicencia + '\'' +
              ", rol='" + rol + '\'' +
              ", telefono='" + telefono + '\'' +
              '}';
  }
}


