package com.project.servletsapp.interfaces;

public interface MedicoCRUD {
    public int getIdUsuario();
    public void setIdUsuario(int idUsuario);
    public String getApellido();
    public void setApellido(String apellido);
    public String getAreaEspecializacion();
    public void setAreaEspecializacion(String areaEspecializacion);
    public String getContraseña();
    public void setContraseña(String contraseña);
    public String getCorreo();
    public void setCorreo(String correo);
    public String getDependencia();
    public void setDependencia(String dependencia);
    public String getDocumentoIdentidad();
    public void setDocumentoIdentidad(String documentoIdentidad);
    public String getHorarioTrabajo();
    public void setHorarioTrabajo(String horarioTrabajo);
    public Integer getIdMedico();
    public void setIdMedico(Integer idMedico);
    public String getNoConsultorio();
    public void setNoConsultorio(String noConsultorio);
    public String getNombre();
    public void setNombre(String nombre);
    public String getNumeroLicencia();
    public void setNumeroLicencia(String numeroLicencia);
    public String getRol();
    public void setRol(String rol);
    public String getTelefono();
    public void setTelefono(String telefono);
}
