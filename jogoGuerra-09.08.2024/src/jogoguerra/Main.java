/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogoguerra;

/**
 *
 * @author dti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pais primeiroPais = new Pais("Russia", 200000, true);
        Pais segundoPais = new Pais ("Ucrania", 500000, false);
        
        System.out.println(primeiroPais);
        
        
        //Escolhendo a melhor estratégia conciderando o número de soldados
        if(primeiroPais.getQtdSoldados()> segundoPais.getQtdSoldados()){
            primeiroPais.setEstrategia(new AtacarSozinho());
            primeiroPais.declararGuerra(segundoPais);
            System.out.println("Primeiro país ataca o segundo");
        }else{
            primeiroPais.setEstrategia(new Diplomacia());
            primeiroPais.declararGuerra(segundoPais);
            System.out.println("Primeiro pais entra em diplomacia com o segundo");
        }
        
    }
    
}
