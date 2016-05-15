/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.Estudiante_DAO;
import dao.Grupo_DAO;
import dao.HoraClase_DAO;
import dao.Inclusion_DAO;
import dto.Estudiante;
import dto.Grupo;
import dto.HoraClase;
import dto.Materia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Rosemberg
 */
public class ControlInclusion {

    public String getTablaPickGrupos(Estudiante e) {
        Grupo_DAO g=new Grupo_DAO();
        ArrayList<String[]>picks=g.getTablaMateriasInclusion(e);
        Estudiante_DAO estud=new Estudiante_DAO();
        
        ArrayList<Materia>materiasVistas=estud.getMateriasVistas(e);
        
        
        String tabla=" <div class=\"box-body\">\n" +
"                  <table id=\"materias\" class=\"table table-bordered table-hover\">\n" +
"                    <thead>\n" +
"                      <tr>\n" +
"                        <th>Codigo</th>\n" +
"                        <th>Nombre</th>\n" +
"                        <th>Accion</th>\n" +
"                        \n" +
"                      </tr>\n" +
"                    </thead>\n" +
"                    <tbody>";
        for(String[] x: picks)
        {
            if(cumpleRequisito(x[5],materiasVistas)){
            String codigo=x[1]+"0"+x[2]+"-"+x[3]+"<br>"+x[4];
            tabla+="<tr id=\"-"+x[0]+"\" ><td>"+x[1]+"0"+x[2]+"-"+x[3]+"</td>";

            tabla+="<td>"+x[4]+"</td>";
            tabla+="<td>"+"<center><button id=\""+x[0]+"\"  type='button' class='btn btn-default btn-sm' onclick=\"dibujar("+x[0]+",'"+codigo+"')\">Previa</button>"
                    + "<button type='button' class='btn btn-default btn-sm' onclick='incluir("+x[0]+")'>Incluir</button></center>"+"</td></tr>";
            }
        }
        tabla+="</tbody></table></div>";
        
        System.out.println(tabla);
        
        return tabla;
        
    }

    private boolean cumpleRequisito(String requisitoM, ArrayList<Materia> materiasVistas) {
    
        if(requisitoM.isEmpty())
            return true;
        
        for(Materia m:materiasVistas){
            
            if(requisitoM.equals(m.getCodigo())){
                return true;
            }
            
        }
        
        return false;
        
    }

    public String getTablaMatriculadas(Estudiante e) {
        
        Grupo_DAO estud=new Grupo_DAO();
         ArrayList<Grupo>materiasVistasActual=estud.getMateriasVistasActual(e);
         
         String tabla="<table align=\"center\" cellspacing=\"1\" cellpadding=\"2\" border=\"1\" style=\"border-collapse: collapse; width: 100%; height: 100%;\" >\n" +
"\n" +
"      <tbody><tr>\n" +
"\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">HORA</td>\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">LUNES</td>\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">MARTES</td>\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">MIERCOLES</td>\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">JUEVES</td>\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">VIERNES</td>\n" +
"      <td width=\"70\" align=\"center\" class=\"mensajeazul\">SABADO</td>\n" +
"\n" +
"      </tr> <tr><th class=\"mensajeazul\"><font size=\"-2\">06:00-07:00</font></th>				  \n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-6\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-6\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-6\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-6\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-6\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-6\">.</td>\n" +
"      </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">07:00-08:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-7\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-7\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-7\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-7\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-7\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-7\">.</td>   \n" +
"      </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">08:00-09:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-8\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-8\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-8\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-8\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-8\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-8\">.</td>   \n" +
"      </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">09:00-10:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-9\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-9\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-9\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-9\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-9\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-9\">.</td>   \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">10:00-11:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-10\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-10\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-10\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-10\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-10\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-10\">.</td>   \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">11:00-12:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-11\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-11\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-11\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-11\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-11\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-11\">.</td>   \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">12:00-13:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-12\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-12\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-12\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-12\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-12\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-12\">.</td> \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">13:00-14:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-13\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-13\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-13\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-13\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-13\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-13\">.</td>  \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">14:00-15:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-14\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-14\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-14\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-14\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-14\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-14\">.</td>  \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">15:00-16:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-15\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-15\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-15\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-15\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-15\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-15\">.</td>   \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">16:00-17:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-16\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-16\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-16\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-16\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-16\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-16\">.</td>\n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">17:00-18:00</font></th>				  \n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-17\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-17\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-17\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-17\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-17\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-17\">.</td>    \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">18:00-19:00</font></th>				  \n" +
"                                   <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-18\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-18\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-18\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-18\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-18\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-18\">.</td>  \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">19:00-20:00</font></th>				  \n" +
"                                   <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-19\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-19\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-19\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-19\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-19\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-19\">.</td>   \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">20:00-21:00</font></th>				  \n" +
"                                   <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-20\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-20\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-20\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-20\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-20\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-20\">.</td>   \n" +
"     </tr><tr><th class=\"mensajeazul\"><font size=\"-2\">21:00-22:00</font></th>				  \n" +
"                                   <td align=\"center\" class=\"fila_tabla\" id=\"Lunes-21\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Martes-21\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Miercoles-21\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Jueves-21\">.</td>\n" +
"				  <td align=\"center\" class=\"fila_tabla\" id=\"Viernes-21\">.</td>\n" +
"                                  <td align=\"center\" class=\"fila_tabla\" id=\"Sabado-21\">.</td>  \n" +
"      </tr></tbody></table>";
         
         String var1="", var2="";
        
         
         for(Grupo g: materiasVistasActual){
             
             for(HoraClase h: g.getHoras()){
                 
                 var1=h.getDia(); 
                 var2=h.getHora()+"";
                  String formato="id=\""+var1+"-"+var2+"\">.";
                  String formato2="id=\""+var1+"-"+var2+"\">"+g.getCodigo()+"<br>"+g.getMyMateria().getNombre();
                  System.out.println(formato2);
                  tabla=tabla.replaceAll(formato, formato2);
                 
             }
             
         }
         
         return tabla;
         
         
    }

    public String getHorasGrupo(String id) {
        
        Grupo g=new Grupo();
        g.setId(id);
        
        ArrayList<HoraClase> h= new HoraClase_DAO().getHorasGrupo(g);
        
        int i=0;
        String retorna="";
        
        for(HoraClase hora: h){
            
            if(i==0)
            retorna+=hora.getDia()+"-"+hora.getHora();
            else
            retorna+=","+ hora.getDia()+"-"+hora.getHora();
            i++;
        }
        System.out.println(retorna);
        return retorna;
        
    }

    public boolean incluir(String codigoGrupo, String codigoE) {
        
        Grupo g=new Grupo();
        g.setId(codigoGrupo);
        Estudiante e=new Estudiante();
        e.setCodigo(codigoE);
        
        
        Grupo_DAO estud=new Grupo_DAO();
        ArrayList<Grupo>materiasVistasActual=estud.getMateriasVistasActual(e);
        
        ArrayList<HoraClase> h= new HoraClase_DAO().getHorasGrupo(g);
        
        if(!tieneCoincidencia(materiasVistasActual,h)){
        
        Inclusion_DAO inc=new Inclusion_DAO();
        
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String currentDate = ft.format(dNow);
        
        return inc.incluir(g,e,currentDate);
        }
        return false;
        
    }

    private boolean tieneCoincidencia(ArrayList<Grupo> materiasVistasActual, ArrayList<HoraClase> horasGrupo) {
        
        for(Grupo grupo: materiasVistasActual){
            
            for(HoraClase hora: grupo.getHoras()){
                
                if(horasGrupo.contains (hora))
                return true;
            }
            
        }
        return false;
        
    }


    
}
