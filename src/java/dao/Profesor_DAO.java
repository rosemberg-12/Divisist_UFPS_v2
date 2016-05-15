/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import dto.Estudiante;
import util.BaseDeDatos;

/**
 *
 * @author Rosemberg
 */
public class Profesor_DAO {
    
    public boolean validarSesion(Estudiante e) {
       
        BaseDeDatos.conectar();
        
        String consulta="Select codigo, contraseña FROM estudiante where codigo='"+e.getCodigo()+"'";
        
        ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
        try {        
            while(resultados.next())
            {
                
                String pass=resultados.getString("password");
                
                if(pass.equals(e.getContraseña()))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        return false;
        
    }
    
}
