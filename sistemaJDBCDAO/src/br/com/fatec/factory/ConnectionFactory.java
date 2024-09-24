/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author dti
 */
public class ConnectionFactory {
    
    //1° DEFINIR O ACESSO AO BANCO DE DADOS E O LOCAL DESSE BANCO DE DADOS
    private static final String USERNAME="root";
    private static final String PASSWORD="alunofatec";
    private static final String DATABASE_URL="jdbc:mysql://localhost:3306/bancoteste";
    
    //2° CRIAR O MÉTODO DE CONEXÃO
    //O método createConnection() retorna um objeto do tipo Connection do 
    //import java.sql. Este método pode lançar exceções do tipo SQLException e 
    //ClassNotFoundException que vão precisar ser tratadas quando aprecerem 
    public static Connection createConnection() throws SQLException, ClassNotFoundException{
        
        //Carrega o driver JDBC do MySQL. Isso é necessário para que o Java 
        //possa se conectar ao banco de dados MySQL. O caminho do driver pode 
        //mudar conforme versões são atualizadas
        
        //O método Class.forName() é uma forma de carregar dinamicamente uma 
        //classe em tempo de execução no Java
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Estabelcendo conexão com o banco de dados usando o DriverManager. 
        //O método getConnection usa as constantes previamente definidas para 
        //criar a conexão. O resultado é armazenado na variável conn
        Connection conn= DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return conn;
    }

}
