<%@page session="true"%><jsp:useBean id="facade" scope="page" class="facade.Fachada" /><jsp:useBean id="est" scope="page" class="dto.Estudiante" /><%=facade.getHorasGrupo(request.getParameter("id"))%>