/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Estudiante;
import dto.Grupo;
import dto.HoraClase;
import dto.Materia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author Rosemberg
 */
public class Grupo_DAO {

    public ArrayList<String[]> getTablaMateriasInclusion(Estudiante e) {
        BaseDeDatos.conectar();
        System.out.println(e.getCodigo());
        String consulta="SELECT grupo.id, programa_materia.cod_programa, programa_materia.cod_materia, grupo.codigo, materia.nombre, materia.cod_requisito\n" +
"FROM grupo, programa_materia, materia where grupo.id_materia in(\n" +
"\n" +
"    select programa_materia.id FROM programa_materia\n" +
"    where programa_materia.cod_programa=(\n" +
"                \n" +
"                SELECT estudiante.cod_programa FROM estudiante \n" +
"                WHERE estudiante.codigo="+e.getCodigo() +" ) ) and grupo.cod_año=(\n" +
"        \n" +
"        select semestre.año FROM semestre \n" +
"        where semestre.es_actual=1) and grupo.id_materia not in( \n" +
"                                            \n" +
"    	Select grupo.id_materia FROM grupo \n" +
"    	where grupo.id in( \n" +
"            \n" +
"        	Select inclusion.id_grupo FROM inclusion \n" +
"        	WHERE inclusion.cod_est="+e.getCodigo() +"   ) ) and grupo.id_materia=programa_materia.id and 							programa_materia.cod_materia= materia.codigo";
        System.out.println(BaseDeDatos.hayConexion());
        
        ArrayList<String[]>retorna=new ArrayList<String[]>();
        
        ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
        int cont=0;
        try {        
            while(resultados.next())
            {
                cont++;
              String[]v=new String[6];
              
              v[0]=resultados.getInt("id")+"";
              
              v[1]=resultados.getString("cod_programa");
              v[2]=resultados.getString("cod_materia");
              v[3]=resultados.getString("codigo");
              v[4]=resultados.getString("nombre");
              v[5]=resultados.getString("cod_requisito");
              
              retorna.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(cont+ "cosas");
        BaseDeDatos.desconectar();
            
        return retorna;
    }
    
        public ArrayList<Grupo> getMateriasVistasActual(Estudiante e) {
    
      BaseDeDatos.conectar();
        System.out.println(e.getCodigo());
        String consulta="Select grupo.id, programa_materia.cod_programa, programa_materia.cod_materia, grupo.codigo, \n" +
"materia.nombre, materia.cod_requisito \n" +
"        FROM grupo, programa_materia, materia \n" +
"    	where grupo.id in( \n" +
"            \n" +
"        	Select inclusion.id_grupo FROM inclusion \n" +
"        	WHERE inclusion.cod_est='"+e.getCodigo()+"' and inclusion.año= (\n" +
"\n" +
"		select semestre.año FROM semestre \n" +
"		where semestre.es_actual=1 ) )  \n" +
"		and grupo.id_materia=programa_materia.id and programa_materia.cod_materia=materia.codigo";
        ResultSet resultados=BaseDeDatos.ejecutarSQL(consulta);
        ArrayList<Grupo>m=new ArrayList<>();
        
        try {        
            while(resultados.next())
            {
               
                Materia materia=new Materia();
                materia.setCodigo(resultados.getString(2)+resultados.getString(3));
                materia.setNombre(resultados.getString(5));
                Grupo g=new Grupo(
                resultados.getString(1),
                resultados.getString(2)+resultados.getString(3)+"-"+resultados.getString(4),
                0,materia,null,null);

                HoraClase_DAO hora=new HoraClase_DAO();
                ArrayList<HoraClase>horario=hora.getHorasGrupo(g);
                System.out.println("Tamaño de horas "+horario.size());
                g.setHoras(horario);
                m.add(g);
            }
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }
        
        return m;
    
    }
    
}
