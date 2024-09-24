/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.testes;
import java.sql.SQLException;
import java.sql.Connection;
import br.com.fatec.factory.ConnectionFactory;

/**
 *
 * @author dti
 */
public class TestaConexao {

public static void main(String[] args) throws ClassNotFoundException, SQLException {

    //Criando um objeto do tipo Connection vindo do import java.sql
    Connection conexao;
    
    //Chamando o método de conexao da classe Factory e atribuindo ao objeto conexao criado aqui
    conexao= ConnectionFactory.createConnection();

    //Se a conexao não for nula é porque funcionou e exibimos uma mensagem de confirmação
    if(conexao != null)
        System.out.println("Conexão aberta com sucesso");
    
    //Se não exibimos a mensagem de falha
    else
        System.out.println("Falha em abrir conexão");

    }
}

