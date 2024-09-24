/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.testes;
import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUÁRIO
 */
public class TesteLIST {
    public static void main(String[] args) throws SQLException {

        //TESTE LISTAR OS REGISTROS DO BANCO DE DADOS
        ArrayList<Usuario> listaBD = UsuarioDAO.listarBD();
        
        for(int i=0; i<listaBD.size(); i++)
            System.out.println(listaBD.get(i));
    }
}
