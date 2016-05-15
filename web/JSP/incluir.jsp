<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
 <jsp:useBean id="facade" scope="page" class="facade.Fachada" />
 <jsp:useBean id="est" scope="page" class="dto.Estudiante" />

 <%
     HttpSession sesion=request.getSession();
     String codigo=sesion.getAttribute("codigo").toString();
     est.setCodigo(codigo);
     String nombreE=facade.getNombreEstudiante(est);
     
     String tablaPick=facade.getTablaPickGrupos(est);
    
     String tabla=facade.getTablaMatriculadas(est);
     %>
<html>
     <head>
        <meta charset="UTF-8">
        <title>UFPS</title>
        <!-- icono de proyecto palma -->
        <link rel="shortcut icon" href="./img/ico.png">
        <!-- -->
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- Bootstrap 3.3.2 -->
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />    
        <link href="../css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />    
        
        <!-- FontAwesome 4.3.0 -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons 2.0.0 -->
        <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />    
        <!-- Theme style -->
        <link href="../css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

        <!-- Mi style-->
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <!-- AdminLTE Skins. Choose a skin from the css/skins 
             folder instead of downloading all of them to reduce the load. -->
        <link href="../css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="../css/DataTables/datatables.min.css"/>

        <!-- Plugins -->
        <!-- iCheck -->
        <!--<link href="plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <!--<link href="plugins/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <!--<link href="plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <!--<link href="plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <!--<link href="plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <!--<link href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- End Plugins -->
    </head>
    <body class="skin-red">
        <div class="wrapper">
            <!-- Encabezado 
            
            <?php
            
              include('html/headerIndex.php');
            ?>-->
             <header class="main-header">
                <!-- Logo -->
                <a href="#" class="logo"><strong>UFPS </strong> </a>
                <!-- Header Navbar: style se encuentra en header.less -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="../img/Rosem.jpg" class="user-image" alt="User Image">
                  <span class="hidden-xs">
                       <%=nombreE%>
                      
                  </span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="../img/Rosem.jpg" class="img-circle" alt="User Image">
                    <p>
                        <%=nombreE%>
                
                    </p>
                  </li>
                  
                </ul>
              </li>
                         

                        </ul>
                    </div>
                </nav>
            </header>

            <!-- aca va la barra lateral -->
<aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Panel usuario -->
                    <div class="user-panel">
                       <div class="image" style="text-align: center;">
                            <img src="../img/Rosem.jpg" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p> <%=nombreE%></p>

                            <a  href="#" ><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">MENU PRINCIPAL</li>
                        <li class="treeview active">
                            <a href="incluir.jsp">
                                <i class="fa fa-dashboard"></i> <span>Incluir materias</span>
                            </a>                            
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-files-o"></i>
                                <span>Ver perfil</span>                                
                            </a>                            
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-files-o"></i>
                                <span>Ver materias cursadas</span>                                
                            </a>                            
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-files-o"></i>
                                <span>Ver notas</span>                                
                            </a>                            
                        </li>
                        <li class="treeview">
                            <a href="../index.html">
                                <i class="fa fa-times"></i> <span>Cerrar Sesion</span>
                            </a>                            
                        </li>                      
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Columna derecha. contiene navbar y la ruta de la pagina -->
            <div class="content-wrapper inicio">
                <!-- Encabezado -->
                

                <!-- Contenido Principal de la pagina -->
                <section class="content">
                    <!-- Incluir aqui el contenido-->
                    
                    <div class="row">
            <div class="col-md-5">
                
                
              <div class="box">
                
                <div class="box-header">
                    <h3 class="box-title">Materias a incluir</h3>
                    
                </div><!-- /.box-header -->
                
                <div class="box-body">
              
               
                    <%= tablaPick %>
                
                
                </div><!-- /.box-body -->
                
                
              </div><!-- /.box -->

            </div><!-- /.col -->
          
            <div class="col-md-7">
                
                
              <div class="box">
                
                <div class="box-header">
                    <h3 class="box-title">Horario de clase</h3>
                </div><!-- /.box-header -->
                
                <div class="box-body">
               
                    
                    <!-- aca va el calendario -->
                    <%=tabla%>
                
                
                </div><!-- /.box-body -->
                
                
              </div><!-- /.box -->

            </div><!-- /.col -->
                    
                    </div>

                </section><!-- /.contenido principal-->
            </div><!-- /.content-wrapper -->
            
            <!-- Pie de pagina -->
            
         <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 1.0
                </div>
                <strong>Copyright &copy; 2015 <a href="http://www.ufps.edu.co/ufps/index.php">U.F.P.S</a>.</strong>
            </footer>
        </div><!-- wrapper-->


        <!-- Funciones js -->

        
        <!-- jQuery 2.1.3 -->
        <script src="../js/plugins/jQuery/jQuery-2.1.3.min.js"></script>
        <!-- jQuery UI 1.11.2 -->
        <script src="../js/plugins/jQueryUI/jquery-ui.min.js" type="text/javascript"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.2 JS -->
        <script src="../js/bootstrap/bootstrap.min.js" type="text/javascript"></script>   
        <!-- AdminLTE App Oculta el menu-->
        <script src="../js/app/app.min.js" type="text/javascript"></script>
        <script src="../js/app/main.js" type="text/javascript"></script>
        
        <script type="text/javascript" src="../css/DataTables/datatables.min.js"></script>
 
    </body>

</html>