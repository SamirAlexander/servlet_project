package com.project.servletsapp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/servlet_data_base";
    private String usuario = "root";
    private String contrasena = "";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, contrasena);
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return con;
    }  
}