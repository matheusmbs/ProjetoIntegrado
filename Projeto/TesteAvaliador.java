import java.sql.SQLException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteAvaliador {
   public static void main (String [] args){
   
   Avaliador avaliador;
   Connection conn = null;
   
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
   
   try {
   ConexaoBD bd = new ConexaoBD ();
   conn = bd.conectar ();
   
   // adicionar o nome
   
    avaliador = new Avaliador ();
         avaliador.setId(123456);
         avaliador.setNome("Daniel");
         avaliador.setSobrenome("Almeida");
         avaliador.setDataNascimento((Date)formatter.parse("03/10/1969"));
         avaliador.setTelefone("1144759697");
         avaliador.setSexo("M");
         avaliador.setSenha("xxxxxxxx");
         avaliador.incluir(conn);
         
         
         }
                  
      catch(Exception e){
      
         e.printStackTrace ();
            if(conn != null){
            try {            
               conn.rollback();
               //desfazer a transação
            }
         
         catch (SQLException e1){
            System.out.print(e1.getStackTrace());
            
            }
           }
         }
      finally {
         //fechar a conexão aqui, pois este bloco é sempre executado,
         //quer tudo funcione bem ou dê problema e caia no catch.
            if(conn != null){
            
            try{
               conn.close();
            }
          
         catch (SQLException e1){
          System.out.print(e1.getStackTrace());
            }
        }
           
     }
            }
            }


jonathan viado