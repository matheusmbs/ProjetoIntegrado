import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

public class Colaborador {
   private int ra;
   private String nome;
   private String sobrenome;
   private Date   dataNascimento;
   private String telefone;
   private String sexo;
   private String senha;
   
   //Construtor padrão
   public Colaborador(){}
   
   //construtor recebe ra
   public Colaborador (int ra){
      this.ra = ra;
   }
   
   //construtor recebe todos os parametros
   public Colaborador (int ra, String nome, String sobrenome, Date dataNascimento, String telefone, String sexo, String email, String senha){
      this.ra = ra;
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.dataNascimento = dataNascimento;
      this.telefone = telefone;
      this.sexo = sexo;
      this.senha = senha;
   }
   
   //metodos de acesso e modificadores
   public int getRa(){
      return ra;
   }
   public void setRa (int ra){
      // Validador de RA
      while (ra == getRa()){
         JOptionPane.showMessageDialog(null, "RA já Cadastrado, porfavor tente novamente");
      }
      this.ra = ra;
      
   }
   public String getNome(){
      return nome;
   }
   public void setNome (String nome){
      this.nome = nome;
   }
   public String getSobrenome(){
      return sobrenome;
   }
   public void setSobrenome(String sobrenome){
      this.sobrenome = sobrenome;
   }
   public Date getDataNascimento(){
      return dataNascimento;
   }
   public void setDataNascimento(Date dataNascimento){
      this.dataNascimento = dataNascimento;
   }
   public String getTelefone(){
      return telefone;
   }
   public void setTelefone (String telefone){
      this.telefone = telefone;
   }
   public String getSexo(){
              return sexo;
   }
   public void setSexo(String sexo){
      this.sexo = sexo;
   }
   public String getSenha(){
      return senha;
   }
   public void setSenha(String senha){
      this.senha = senha;
   }
   
   public void incluir (Connection conn){
      String sqlInsert = "INSERT INTO colaborador(ra, nome, sobrenome, dataNascimento, telefone, sexo, senha) VALUES (?,?,?,?,?,?,?)";
      
      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);){
         stm.setInt(1, getRa());
         stm.setString (2, getNome ());
         stm.setString (3, getSobrenome());
         stm.setDate(4, new java.sql.Date(this.getDataNascimento().getTime()));
         stm.setString (5, getTelefone());
         stm.setString (6, getSexo());
         stm.setString (7, getSenha());
         stm.execute ();
      }
      catch (Exception e){
         e.printStackTrace ();
      }
      try {
         conn.rollback ();
      }
      catch (SQLException e1) {
         System.out.print(e1.getStackTrace());
      }
   }

 
}  