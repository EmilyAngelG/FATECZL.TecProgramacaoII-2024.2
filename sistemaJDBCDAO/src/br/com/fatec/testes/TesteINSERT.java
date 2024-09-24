/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.testes;
import br.com.fatec.model.Usuario;
import br.com.fatec.dao.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author dti
 */
public class TesteINSERT {

    public static void main(String[] args) throws SQLException {
    
        //TESTE INSERT
        //Criaremos um usuário com todos os atributos menos o id pois ele será novo no banco
        //Esse é o usuário que criamos como classe do programa em br.com.fatec.model.Usuario
        Usuario user= new Usuario("Nelson Firmino","nelson@gmail.com","1234");
        
        //Agora entregamos esse usuario ao usuario DAO que criamos em br.com.fatec.dao.UsuarioDAO
        //É esse UsuarioDAO que possui o método insere que iremos utilizar aqui
        UsuarioDAO.insere(user);
        
        //Ou podemos fazer desse modo direto
        UsuarioDAO.insere(new Usuario("Vanessa Guedes","vanessa@gmail.com","1234"));
        
    }
}
