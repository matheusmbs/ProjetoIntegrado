import java.sql.SQLException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {
   public static void main (String [] args){
      Connection conn = null;
      Colaborador colaborador;
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      try{
      ConexaoBD bd = new ConexaoBD();
      conn = bd.conectar();
      
         colaborador = new Colaborador();
         colaborador.setRa(816114937);
         colaborador.setNome("Matheus");
         colaborador.setSobrenome("Moura Borges");
         colaborador.setDataNascimento((Date)formatter.parse("19/04/1997"));
         colaborador.setTelefone("1143038711");
         colaborador.setSexo("m");
         colaborador.setSenha("12345");
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