/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ConexionBD.Datos;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nelso
 */



public class ListadoTransacciones extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try {
            ResultSet res;
            Datos transacciones = new Datos();
            float precio = 0.0f;
            String fecha="", fechadesp = "1900-01-01"; 
            int id =0; 
            int cliente =0; 
            float millas =0f;
            float cambio = 0.0f;
            DecimalFormat formato1 = new DecimalFormat("#.00");
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("   yyyy-MM-dd HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
            String producto = "";
            String boton="";
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Transacciones</title>");
            out.println("<tr></tr>");
            out.println(" <link href=Estilo.css rel=stylesheet type=text/css>");
            out.println("</head>");
            out.println("<body>");
            
            //res = calidad.ListadoTransacciones();
           /* if(request.getParameter("TR_PRODUCTO")!="")
                precio=Float.parseFloat(request.getParameter("TR_PRODUCTO"));
            if(request.getParameter("TR_PRECIO_TOTAL")!="")
                producto=request.getParameter("TR_PRECIO_TOTAL");*/
          //  if(boton.equals("ListadoTransacciones"))
          //  {
              res = transacciones.Listado();
                SimpleDateFormat fecha1= new SimpleDateFormat("yyyy-MM-dd");
              
               DecimalFormat formato = new DecimalFormat("#,###.00");
               
              while (res.next()) {
                id = res.getInt(("id_transaccion"));
                fecha = res.getString("tr_fecha");
                cliente = res.getInt("tr_id_cliente");
                millas = res.getFloat("tr_total_millas");
                cambio = res.getFloat("tr_tipo_cambio");
                precio = res.getFloat("tr_monto_total");
                producto = res.getString("tr_producto");
                
                
                
                 if ((fecha1.parse(fecha).equals(fecha1.parse(fechadesp)))!=true){  
                    out.println("<table align=center border=1 class=datos_form>");
                    out.println("<tr class=titulo_tabla><td colspan=7>LISTADO DE TRANSACCIONES </td></tr> ");
                    out.println("<tr><td class=td_cabecera>ID de Orden</td>"
                    + "<td class=td_cabecera>Fecha de Creación</td>"
                    + "<td class=td_cabecera>ID Cliente</td>"
                    + "<td class=td_cabecera>Nombre del Producto</td>"
                    + "<td class=td_cabecera>Monto Total</td>"
                    + "<td class=td_cabecera>Total de Millas Gastadas</td>"
                    + "<td class=td_cabecera>Tipo de Cambio</td>"
                    + "</tr>");
                     fechadesp = fecha; 
                     cambio = 0.0013f;
                }//si la fecha es diferente 0.010
                 else{
                     cambio = 0.0010f;
                 }
                
                    out.println("<tr>"
                        + " <td class=td_datos>" +id + "</td>"
                      // + " <td class=td_datos>" + formattedDate + "</td>"
                        + " <td class=td_datos>" + date(fecha) + "</td>"
                        + " <td class=td_datos>" + cliente + "</td>"
                        + " <td class=td_datos>" + producto + "</td>"
                        + " <td class=td_datos>$" + formato1.format(precio) + "</td>"
                        + " <td class=td_datos>" + formato.format(Math.round(precio/cambio))+ "</td>"
                        + " <td class=td_datos>" + cambio + "</td>"
                                + "</tr>");
             
                
            }
          //  }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(ListadoTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
