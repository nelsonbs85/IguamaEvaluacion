    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;
import ConexionBD.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Datos extends Conexion{

    private ResultSet resultado;

    public Datos()
    {
        Conectar();
    }

    public ResultSet Listado()throws Exception
    {
            try{
             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM transacciones order by tr_fecha");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }
    

}

