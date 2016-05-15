/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Estudiante;
import dto.Grupo;
import util.BaseDeDatos;

/**
 *
 * @author Rosemberg
 */
public class Inclusion_DAO {

    

    public boolean incluir(Grupo g, Estudiante e, String currentDate) {
        
         BaseDeDatos.conectar();
         
         
         
         String consulta="INSERT INTO `inclusion`.`inclusion` (`fecha`, `cod_est`, `id_grupo`, `año`, `id`) VALUES ('"+currentDate+"', '"+e.getCodigo()+"', '"+g.getId()+"', '2015-1', NULL);";
    
         return BaseDeDatos.ejecutarActualizacionSQL(consulta);
    }
    
}
