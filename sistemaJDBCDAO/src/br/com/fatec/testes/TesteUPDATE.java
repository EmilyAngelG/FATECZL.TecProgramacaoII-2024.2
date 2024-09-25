/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.testes;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author USUÁRIO
 */
public class TesteUPDATE {
    public static void main(String[] args) throws SQLException{
    
        //Verificando os usuários do banco de dados
        ArrayList<Usuario> listaBD = UsuarioDAO.listarBD();

        System.out.println("Lista de usuários do Banco de Dados:\n");
        for(int i=0; i<listaBD.size(); i++)
            System.out.println(listaBD.get(i));
        System.out.println("----------------------------------------");

        Usuario user = listaBD.get(0);
        System.out.println("Vamos atualizar o primeiro usuário\n"+user);
        System.out.println("Vamos alterar a senha colocando um número randomico");
        System.out.println("----------------------------------------");
        
        Random gerador = new Random();
        user.setSenha(String.valueOf(gerador.nextInt(10000)));
        
        UsuarioDAO.atualizar(user);
        System.out.println("Agora o usuário foi atualizado\n"+user);
        System.out.println("----------------------------------------");
        
        System.out.println("Lista atualizada de usuários do Banco de Dados:\n");
        for(int i=0; i<listaBD.size(); i++)
            System.out.println(listaBD.get(i));
        
    }
}