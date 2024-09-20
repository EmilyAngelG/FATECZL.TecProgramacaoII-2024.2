/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.dao;
import br.com.fatec.model.Usuario;
import br.com.fatec.factory.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author dti
 */

//AQUI FICAM AS CLASSES MODELOS DAO QUE IRÃO RECEBER OS DADOS DO BANCO DE DADOS
public class UsuarioDAO {

//CRUD DO BANCO DE DADOS - INSERT    
    public static void insere(Usuario user) throws SQLException{
        
        //Para manipular o banco de dados usamos comandos sql
        //Então vamos agora definir uma String para a nossa linha de comando
        //nesse caso para um comando insert
        
        //Esses "???" serão substituidos pelos conteúdos a serem inseridos
        
        //Lembrando que estamos utilizando MySQL caso utilizemos outro banco de 
        //dados com sintaxe diferente essa linha deve ser alterada nos conformes
        String sql="INSERT INTO usuarios(nome,login,senha) VALUES (?,?,?) ";
        
        //Vamos chamar o conector e inicializar com null
        Connection conn= null;
        
        //O PreparedStatement é uma interface do Java JDBC que permite executar consultas SQL
        //Vamos inicializa-la com null
        PreparedStatement pstm=null;
        
        try{
            //Criar uma conexão com o BD pelo createConnection() do Factory
            conn= ConnectionFactory.createConnection();
            
            //Preparando a query
            //conn.prepareStatement(sql) chama o método prepareStatement na 
            //conexão (conn), passando a string SQL (sql) como argumento.
            //Detalhe: O cast (PreparedStatement) é usado para converter o 
            //tipo retornado (que é do tipo Statement) para PreparedStatement. 
            //Embora isso não seja necessário na maioria das implementações de 
            //JDBC, é uma prática comum para deixar claro que você está lidando 
            //com um PreparedStatement.
            pstm= (PreparedStatement) conn.prepareStatement(sql);
            
           // indicar as substituições na query- noem, login e senha do usuário
            pstm.setString(1,user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3,user.getSenha());
            //Executando a query
             pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!=null)pstm.close();
            if(conn!=null)conn.close();
        }      
    }

}
