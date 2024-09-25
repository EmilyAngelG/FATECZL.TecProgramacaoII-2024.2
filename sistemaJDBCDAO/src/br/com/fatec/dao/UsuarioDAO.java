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
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author dti
 */

//AQUI FICAM OS MÉTODOS CRUD DA TABELA USUARIO DO BANCO DE DADOS
//Temos métodos para inserir, remover, listar e atualizar usuários

public class UsuarioDAO {

    //MÉTODO INSERT
    //Aqui recebemos um objeto do tipo USUARIO que está definido no model
    //Em seguida adcionamos ele ao banco de dados
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
    
    
    //MÉTODO REMOVE
    //Aqui podemos receber apenas no id do usuario que queremos remover
    public static void remove(int id) throws SQLException{
        
        String sql="DELETE FROM usuarios WHERE id = ?";
        
        Connection conn= null;
        PreparedStatement pstm=null;
        
        try{
            conn= ConnectionFactory.createConnection();
            pstm= (PreparedStatement) conn.prepareStatement(sql);
            
           // Substituindo no sql o número do id
            pstm.setString(1,String.valueOf(id));
            //Executando a query
             pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!=null)pstm.close();
            if(conn!=null)conn.close();
        }      
    }
    
    
    //MÉTODO PARA LISTAR TODOS OS REGISTROS
    public static ArrayList<Usuario> listarBD() throws SQLException{
    	 
        //Sql para selecionar todos os registros do banco de dados
        String sql = "SELECT * FROM usuarios";

        //Criando uma lista do tipo Usuario para receber os dados
        ArrayList<Usuario> lista = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while(rset.next()){

                Usuario user = new Usuario();    	 
                //Recupera o id do banco e atribui ele ao objeto
                user.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                user.setNome(rset.getString("nome"));

                //Recupera a login do banco e atribui ele ao objeto
                user.setLogin(rset.getNString("login"));

                //Recupera a senha do banco e atribui ela ao objeto
                user.setSenha(rset.getNString("senha"));

                //Adiciono o contato recuperado, a lista de contatos
                lista.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally{
            try{
                if(rset != null){
                    rset.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return lista;
    }
    
    
    //MÉTODO PARA ATUALIZAR OS DADOS DE UM USUÁRIO
    public static void atualizar(Usuario user) throws SQLException{
        
        //Sql para selecionar todos os registros do banco de dados
        String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn= ConnectionFactory.createConnection();
            pstm= (PreparedStatement) conn.prepareStatement(sql);
            
           // Substituindo no sql os valores a serem alterados
            pstm.setString(1,String.valueOf(user.getNome()));
            pstm.setString(2,String.valueOf(user.getLogin()));
            pstm.setString(3,String.valueOf(user.getSenha()));
            pstm.setString(4,String.valueOf(user.getId()));
            
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















