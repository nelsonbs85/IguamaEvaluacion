package ConexionBD;
import java.sql.*;


public class Conexion {
         protected Connection con;
         protected Statement stmt;
         private String serverName= "localhost";
         private String portNumber = "3306";
         private String databaseName= "iguama";
         private String url = "jdbc:mysql://localhost:3306/" + databaseName;
         private String userName = "root";
         private String password = "15Mar2010*!"; // Indica al controlador que debe utilizar un cursor de servidor, // lo que permite más de una instrucción activa // en una conexión. private final String selectMethod = "cursor";
         //private String selectMethod = "cursor";
         private String errString;
     // Constructor public Connect(){}

      public Conexion()
      {

      }
        private String getConnectionUrl()
     {
         return url;
     }


     public Connection Conectar(){
        con=null;
         try{
              Class.forName("org.gjt.mm.mysql.Driver");
              con = DriverManager.getConnection(getConnectionUrl(),userName,password);
              stmt=con.createStatement();
              System.out.println("Conectado");
         }catch(Exception e){
             errString= "Error Mientras se conectaba a la Base de Datos";
             System.out.println(errString);
             return null;
         }
          return con;
     }

     /* Mostrar las propiedades del controlador y los detalles de la base de datos */

       public void Desconectar()
     {
         try{
              stmt.close();
              con.close();
         }catch(SQLException e){
             errString= "Error Mientras se Cerraba la Conexion a la Base de Datos";
         }
     }
       public Statement getStmt()
       {
          return this.stmt;
       }


}
