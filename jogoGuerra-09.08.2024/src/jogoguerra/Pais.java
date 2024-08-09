/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoguerra;

/**
 *
 * @author dti
 */
public class Pais {
    
    private String nome;
    private int qtdSoldados;
    private boolean armamento;
    private EstrategiaStrategy estrategia;

    public Pais(String nome, int qtdSoldados, boolean armamento) {
        this.nome = nome;
        this.qtdSoldados = qtdSoldados;
        this.armamento = armamento;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdSoldados() {
        return qtdSoldados;
    }

    public boolean isArmamento() {
        return armamento;
    }


    public void setEstrategia(EstrategiaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    
   
    
    public void declararGuerra(Pais inimigo){
        this.estrategia.atacar(inimigo);
        this.estrategia.concluir(inimigo);
    }

    @Override
    public String toString() {
        return ("\nNome: "+this.nome);
    }
    
    
}
