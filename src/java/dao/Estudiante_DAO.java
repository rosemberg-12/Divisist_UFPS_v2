/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.Estudiante;
import dto.Materia;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author Rosemberg
 */
public class Estudiante_DAO {

    public Estudiante_DAO() {
        
        
    }

    
    

    public boolean validarSesion(Estudiante e) {
       
        BaseDeDatos.conectar();
        
        String consulta="Select codigo, contraseña FROM estudiante where codigo='"+e.getCodigo()+"'";
        
        ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
        try {        
            while(resultados.next())
            {
                
                String pass=resultados.getString("contraseña");
                System.out.println("Resultado es "+pass+" "+e.getContraseña());
                if(pass.equals(e.getContraseña()))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        return false;
        
    }

    public String getNombreEstudiante(Estudiante e) {
        String x="Desconocido";
        BaseDeDatos.conectar();
        String consulta="Select nombre, apellido FROM estudiante where codigo='"+e.getCodigo()+"'";
         ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
        try {        
            while(resultados.next())
            {
                
                return resultados.getString("nombre")+" "+resultados.getString("apellido");
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }

    public ArrayList<Materia> getMateriasVistas(Estudiante e) {
        
        BaseDeDatos.conectar();
        System.out.println(e.getCodigo());
        String consulta="select * \n" +
                "FROM materia \n" +
                "where materia.codigo in(\n" +
                "    Select programa_materia.cod_materia \n" +
                "    from programa_materia \n" +
                "	where programa_materia.id in( \n" +
                "\n" +
                "    	Select grupo.id_materia FROM grupo \n" +
                "    	where grupo.id in( \n" +
                "        	Select inclusion.id_grupo FROM inclusion \n" +
                "        	WHERE inclusion.año<> (\n" +
"\n" +
"		select semestre.año FROM semestre \n" +
"		where semestre.es_actual=1 ) and inclusion.cod_est='"+e.getCodigo()+"') ) )";
        ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
        ArrayList<Materia>m=new ArrayList<>();
        
        try {        
            while(resultados.next())
            {
                Materia aux=new Materia();
                aux.setCodigo(resultados.getString(4));
                m.add(new Materia(resultados.getString(1), resultados.getString(2), resultados.getInt(3), aux));
                
            }
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }
        
        return m;
                
    }


    
}
