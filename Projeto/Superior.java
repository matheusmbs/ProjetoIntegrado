import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Superior {
   private int id;
   private String nome;
   private String sobrenome;
   private Date dataNascimento;
   private String telefone;
   private String sexo;
   private String usuario;
   private String senha;
   
   //Construtor padrão
   public Superior (){
   
   }
   
   //Construtor que recebe somente a chave primaria
   
   public Superior (int id){
      this.id = id;   
   }
   //Construtor que recebe todos os parametros
   public Superior (int id, String nome, String sobrenome, Date dataNascimento, String telefone, String sexo,  String senha){
     this.id = id;
     this.nome = nome;
     this.sobrenome = sobrenome;
     this.dataNascimento = dataNascimento;
     this.telefone = telefone;
     this.sexo = sexo;
     this.senha = senha;
   }
 
 //  Metodos de acesso e modificadore ra
   public int getId (){
      return id;
   }
   
   public void setId (int id){
       this.id = id;
   }
   
  //Acesso e modificador nome 
   public String getNome (){
      return nome;
   }
   
   public void setNome (String nome){
      this.nome = nome;
   }
   
   //Acesso e modificador sobrenome
   
  public String getSobrenome (){
   return sobrenome;
  }
  
  public void setSobrenome (String sobrenome){
   this.sobrenome = sobrenome;
  }
     //Acesso e modificador dataNascimento
   public Date getDataNascimento (){
      return dataNascimento;
   }
     public void setDataNascimento (Date dataNascimento){
      this.dataNascimento = dataNascimento;
   }
   
    // Acesso e modificador telefone
   public String getTelefone (){
      return telefone;
   }
   
   public void setTelefone (String telefone){
      this.telefone = telefone;
   }

     //Acesso e modificador sexo
   public String getSexo (){
     return sexo;
   }
   
   public void setSexo (String sexo){
      this.sexo = sexo;
   }

     //Acesso e modificador senha
   public String getSenha (){
      return senha;
   }
   
   public void setSenha (String senha){
      this.senha = senha;
   }
   
   //implementando o banco
   
     public void incluir (Connection conn){
      String sqlInsert = "INSERT INTO superior (id,nome, sobrenome, dataNascimento, telefone, sexo, senha) VALUES (?,?,?,?,?,?,?)";
      
      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);){
         stm.setInt(1, getId ());
         stm.setString(2, getNome ());
         stm.setString(3, getSobrenome());
         stm.setDate(4, new java.sql.Date(this.getDataNascimento().getTime()));
         stm.setString(5, getTelefone ());
         stm.setString(6, getSexo ());
         stm.setString(7, getSenha ());

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