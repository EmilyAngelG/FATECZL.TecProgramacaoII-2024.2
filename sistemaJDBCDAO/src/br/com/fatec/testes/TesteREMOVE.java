/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.testes;
import br.com.fatec.dao.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author USUÁRIO
 */

public class TesteREMOVE {
    public static void main(String[] args) throws SQLException {

            //TESTE REMOVE
            UsuarioDAO.remove(1);

    }
}