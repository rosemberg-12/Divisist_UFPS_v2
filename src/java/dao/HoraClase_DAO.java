/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Grupo;
import dto.HoraClase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author Rosemberg
 */
public class HoraClase_DAO {

   public ArrayList<HoraClase> getHorasGrupo(Grupo g) {
       
         BaseDeDatos.conectar();
         System.out.println(g.getId()+" id");
         String consulta= "select hora_clase.dia, hora_clase.hora \n" +
            "from hora_clase\n" +
            "WHERE hora_clase.codigo_grupo='"+g.getId()+"'";
          ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
          ArrayList<HoraClase>horas=new ArrayList<HoraClase>();
          try {        
            while(resultados.next())
            {
                
                horas.add(new HoraClase(resultados.getString(1), (byte)(resultados.getInt(2))));

            }
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }
          return horas;
          
    }
    
}
