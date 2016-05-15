<%-- 
    Document   : validarInicioSesion
    Created on : 8/10/2015, 11:43:42 AM
    Author     : Rosemberg
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
 <jsp:useBean id="facade" scope="page" class="facade.Fachada" />
  <jsp:useBean id="est" scope="page" class="dto.Estudiante" />
  
 <%
     
     String documento=request.getParameter("documento");
     String clave=request.getParameter("password");
     
     est.setCodigo(documento);
     est.setContraseña(clave);
     
     boolean resultado=facade.validarInicioSesion(est);
     
      if(resultado){
      
     HttpSession sesion=request.getSession();
     sesion.setAttribute("codigo",documento);
     response.sendRedirect("../JSP/indexUser.jsp");
      }
      
      else{
          %>
                  <script type="text/javascript"> 
                  alert("Revisa los datos...");
                  location.href="../index.html";
                  </script>   
                  <%
      }
          
%>                  