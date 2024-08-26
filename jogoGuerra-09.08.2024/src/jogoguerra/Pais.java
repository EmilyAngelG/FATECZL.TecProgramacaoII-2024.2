/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoguerra;

public class Pais {
    
    private String nome;
    private int qtdSoldados;
    private int credibilidade = 31;
    private int economia = 500;
    private int territorio = 150;
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
    
    public int getCredibilidade() {
        return credibilidade;
    }
    
    public int getEconomia() {
        return economia;
    }

    public boolean isArmamento() {
        return armamento;
    }

    public void setQtdSoldados(int qtdSoldados){
        this.qtdSoldados = qtdSoldados;
    }
    
    public void setCredibilidade(int credibilidade){
        this.credibilidade = credibilidade;
    }
    
    public void setEconomia(int economia){
        this.economia = economia;
    }

    public void setEstrategia(EstrategiaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    
   
    
    public void declararGuerra(Pais inimigo){
        this.estrategia.atacar(inimigo);
        //this.estrategia.concluir(inimigo);
    }

    @Override
    public String toString() {
        return (this.nome);
    }
    
    
}
