/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

/**
 *
 * @author dti
 */

//AQUI FICAM AS CLASSES USADAS DENTRO DO PROGRAMA

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
 
    //Esse construtor tem o id porque ele irá ser usado para receber os usuários 
    //vindo do banco de dados, portanto, esse id é o que já está no banco
    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    //Esse construtor está sem id para quando nós formos criar um usuário no 
    //banco de dados, pois, o id é fornecido pelo banco não por nós
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuário:\n ID: "+ this.id +"\nNome: "+this.nome+
                "\nLogin: "+this.login+"\nSenha: "+this.senha;
    }
    
    

    
    
    
    
}
