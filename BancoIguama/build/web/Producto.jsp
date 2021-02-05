

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Transacciones</title>
    </head>
     <link href="Estilo.css" rel="stylesheet" type="text/css">
      
       <body>
        <form method="post" action="ListadoTransacciones">
        <table align="center" width="289" border="1" class="datos_form">
          <tr class=titulo_tabla><td colspan=2>Listado de Transacciones </td></tr>
            <tr>
               <td>Nombre del Producto</td>
               <td><input type ="text" name="tr_producto" class="texto"></td>
                
            </tr>
            <tr>
                <td>Precio Total</td>
                <td><input type ="text" name="tr_monto_total" class="texto"></td>
            </tr>    
            

        </table>
           <table align="center">
               <tr></tr>
               <tr>  
                <td><input type ="submit" name="Boton" value="Listado" class="texto"></td>
            </tr>
               
           </table>
            </form>
       </body>
      </form>
</html>
