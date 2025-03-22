<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Listar Medicos</title>
</head>
<body>
  <h1>Usuarios</h1>
  <a href="formulario.jsp">Agregar Nuevo Medico</a>
</form>
<br>
  <table border="1">
      <tr>
          <th>ID</th>
          <th>Apellido</th>
          <th>Área Especialización</th>
          <th>Contraseña</th>
          <th>Correo</th>
          <th>Dependencia</th>
          <th>Documento Identidad</th>
          <th>Horario Trabajo</th>
          <th>ID Médico</th>
          <th>No. Consultorio</th>
          <th>Nombre</th>
          <th>Número Licencia</th>
          <th>Rol</th>
          <th>Teléfono</th>
          <th>Acciones</th>
      </tr>
      <!-- Aquí se llenarán los datos desde el backend -->
      <c:forEach items="${medicos}" var="medico">
          <tr>
              <td>${medico.idUsuario}</td>
              <td>${medico.apellido}</td>
              <td>${medico.areaEspecializacion}</td>
              <td>${medico.contraseña}</td>
              <td>${medico.correo}</td>
              <td>${medico.dependencia}</td>
              <td>${medico.documentoIdentidad}</td>
              <td>${medico.horarioTrabajo}</td>
              <td>${medico.idMedico}</td>
              <td>${medico.noConsultorio}</td>
              <td>${medico.nombre}</td>
              <td>${medico.numeroLicencia}</td>
              <td>${medico.rol}</td>
              <td>${medico.telefono}</td>
              <td>
                  <a href="MedicoControlador?accion=editar&id=${medico.idUsuario}">Editar</a>
                  <a href="MedicoControlador?accion=eliminar&id=${medico.idUsuario}">Eliminar</a>
              </td>
          </tr>
      </c:forEach>
  </table>
</body>
</html>
