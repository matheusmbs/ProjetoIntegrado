import java.sql.SQLException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteSuperior {
   public static void main (String [] args){
      Connection conn = null;
      Superior superior;
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      try{
      ConexaoBD bd = new ConexaoBD();
      conn = bd.conectar();
      
         superior = new Superior();
         superior.setId(816114937);
         superior.setNome("Matheus");
         superior.setSobrenome("Moura Borges");
         superior.setDataNascimento((Date)formatter.parse("19/04/1997"));
         superior.setTelefone("1143038711");
         superior.setSexo("m");
         superior.setSenha("12345");
         superior.incluir(conn);
         

      }
      
      catch (Exception e) {
      
         e.printStackTrace();
         if (conn != null) {
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      } 
      finally {
         if (conn != null) {
            try {
               conn.close();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      }
      
   }
}