import java.sql.SQLException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteColaborador {
   public static void main (String [] args){
      Connection conn = null;
      Colaborador colaborador;
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      try{
      ConexaoBD bd = new ConexaoBD();
      conn = bd.conectar();
      
        
         colaborador = new Colaborador();
         colaborador.setRa(8161143);
         colaborador.setNome("Ivaldo");
         colaborador.setSobrenome("Moura Borges");
         colaborador.setDataNascimento((Date)formatter.parse("19/04/1974"));
         colaborador.setTelefone("1143038711");
         colaborador.setSexo("m");
         colaborador.setSenha("123456");
         colaborador.incluir(conn);
 

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