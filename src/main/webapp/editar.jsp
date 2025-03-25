<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Nuevo Médico</title>
</head>
<body>
    <h1>Editar Médico</h1>
    <form accion="MedicoControlador?accion=editado" method="get">
        <input type="hidden" name="accion" value="editado">        
    
        <label for="nombre">ID medico:</label>
        <input type="text" name="idMedico" value="${medico.idMedico}">
        
        <label for="nombre">ID USUARIO:</label>
        <input type="text" id="idUsuario" name="idUsuario" value="${medico.idUsuario}" required><br><br>
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${medico.nombre}" required><br><br>

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" value="${medico.apellido}" required><br><br>

        <label for="areaEspecializacion">Área de Especialización:</label>
        <input type="text" id="areaEspecializacion" name="areaEspecializacion" value="${medico.areaEspecializacion}" required><br><br>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" value="${medico.contraseña}" required><br><br>

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" value="${medico.correo}" required><br><br>

        <label for="dependencia">Dependencia:</label>
        <input type="text" id="dependencia" name="dependencia" value="${medico.dependencia}" required><br><br>

        <label for="documentoIdentidad">Documento de Identidad:</label>
        <input type="text" id="documentoIdentidad" name="documentoIdentidad" value="${medico.documentoIdentidad}" required><br><br>

        <label for="horarioTrabajo">Horario de Trabajo:</label>
        <input type="text" id="horarioTrabajo" name="horarioTrabajo" value="${medico.horarioTrabajo}" required><br><br>

        <label for="noConsultorio">Número de Consultorio:</label>
        <input type="text" id="noConsultorio" name="noConsultorio" value="${medico.noConsultorio}" required><br><br>

        <label for="numeroLicencia">Número de Licencia:</label>
        <input type="text" id="numeroLicencia" name="numeroLicencia" value="${medico.numeroLicencia}" required><br><br>

        <label for="rol">Rol:</label>
        <input type="text" id="rol" name="rol" value="${medico.rol}" required><br><br>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" value="${medico.telefono}" required><br><br>

                  
        <button type="submit" >Confirmar Edicion</button>
    </form>

    <br>
    <a href="MedicoControlador">Volver a la lista de médicos</a>
</body>
</html>
