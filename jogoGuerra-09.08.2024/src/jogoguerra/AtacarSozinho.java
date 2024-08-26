package jogoguerra;

import java.util.Random;
import java.util.Scanner;

public class AtacarSozinho implements EstrategiaStrategy {
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    int credibilidadeInicio = 100;

    @Override
    public void atacar(Pais inimigo) {
        int j = 1;
        while (j != 0) {
            System.out.println("Vamos atacar sozinhos. \nEscolha como comeÃ§ar:");
            System.out.println("1 - Implantar evidÃªncias falsas");
            System.out.println("2 - Ataque direto");
            System.out.println("3 - Encerrar o jogo");
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    implantarEvidencias(inimigo);
                    break;
                case 2:
                    tiposAtaque(inimigo);
                    break;
                case 3:
                    System.out.println("\nEncerrando o jogo");
                    j = 0; // Sair do loop principal
                    break;
                default:
                    System.out.println("\nOpÃ§Ã£o invÃ¡lida.");
                    break;
            }
        }
    }

    @Override
    public void concluir(Pais inimigo) {
        //processamento
        System.out.println("Finalizado");
    }

    private void implantarEvidencias(Pais inimigo) {
        System.out.println("\nTentando implantar evidÃªncias falsas");
        if (inimigo.getCredibilidade() <= 30) {
            System.out.println("O inimigo jÃ¡ estÃ¡ com credibilidade baixa demais para este ataque.");
            System.out.println("Vamos tentar DERRUBAR O GOVERNO");
            derrubarGoverno(inimigo);
            return;
        } else {
            double chance = Math.random() * 100;
            if (chance <= 20) {
                inimigo.setCredibilidade(inimigo.getCredibilidade() - (inimigo.getCredibilidade() / 3));
                inimigo.setEconomia(inimigo.getEconomia() - (inimigo.getEconomia() / 5));
                System.out.println("Ataque bem-sucedido! O inimigo perdeu 33% da credibilidade e 20% da economia.");
                System.out.println("credibilidade atual: " + inimigo.getCredibilidade() + " Economia atual:" + inimigo.getEconomia());
                return;
            } else if (chance <= 45) {
                inimigo.setCredibilidade(inimigo.getCredibilidade() - (inimigo.getCredibilidade() / 4));
                inimigo.setEconomia(inimigo.getEconomia() - (inimigo.getEconomia() / 5));
                System.out.println("Ataque bem-sucedido! O inimigo perdeu 25% da credibilidade e 20% da economia.");
                System.out.println("credibilidade atual: " + inimigo.getCredibilidade() + " Economia atual:" + inimigo.getEconomia());
                return;
            } else if (chance <= 80) {
                inimigo.setCredibilidade(inimigo.getCredibilidade() - (inimigo.getCredibilidade() / 5));
                inimigo.setEconomia(inimigo.getEconomia() - (inimigo.getEconomia() / 10));
                System.out.println("Ataque bem-sucedido! O inimigo perdeu 20% da credibilidade e 10% da economia.");
                System.out.println("credibilidade atual: " + inimigo.getCredibilidade() + " Economia atual:" + inimigo.getEconomia());
                return;
            } else {
                inimigo.setEconomia(inimigo.getEconomia() + (inimigo.getEconomia() / 20));
                System.out.println("Fomos descobertos! Inimigo recuperou 5% da economia.");
                if (inimigo.getCredibilidade() + 15 < 100) {
                    inimigo.setCredibilidade(inimigo.getCredibilidade() + (inimigo.getCredibilidade() / 10));
                    System.out.println("Inimigo tambÃ©m recuperou 10% da credibilidade.");
                    System.out.println("credibilidade atual: " + inimigo.getCredibilidade() + " Economia atual:" + inimigo.getEconomia());
                    return;
                }
                System.out.println("Agora tentaremos DERRUBAR O GOVERNO");
                derrubarGoverno(inimigo);
                return;
            }
        }
    }

    private void tiposAtaque(Pais inimigo) {
        int decisao1 = 0, decisao2 = 0;

        if (inimigo.getQtdSoldados() < 10) {
            System.out.println("A quantidade de soldados do(a) " + inimigo.getNome() + " estÃ¡ baixa, podemos tentar derrubar o governo!");
            derrubarGoverno(inimigo);
        } else {
            do {
                System.out.println("\n[1] Ataque AÃ‰REO \n[2] Ataque TERRESTRE \n[3] Cancelar ataque");
                decisao1 = scan.nextInt();

                switch (decisao1) {
                    case 1: {
                        int reducaoSoldadosAereo = 25 + random.nextInt(16); // reduÃ§Ã£o aleatÃ³ria entre 25% a 40%
                        inimigo.setQtdSoldados(inimigo.getQtdSoldados() - (int) (inimigo.getQtdSoldados() * (reducaoSoldadosAereo / 100.0)));
                        System.out.println("Quantidade de soldados inimigos reduzidos em " + reducaoSoldadosAereo + "%");

                        System.out.println("Gostaria de tentar derrubar o governo? \n[1] Sim \n[2] NÃ£o");
                        decisao2 = scan.nextInt();
                        if (decisao2 == 1) {
                            derrubarGoverno(inimigo);
                        }
                        break;
                    }
                    case 2: {
                        int reducaoSoldadosTerrestre = 5 + random.nextInt(26); // reduÃ§Ã£o aleatÃ³ria entre 5% a 30%
                        inimigo.setQtdSoldados(inimigo.getQtdSoldados() - (int) (inimigo.getQtdSoldados() * (reducaoSoldadosTerrestre / 100.0)));
                        System.out.println("Quantidade de soldados inimigos reduzidos em " + reducaoSoldadosTerrestre + "%");

                        System.out.println("Gostaria de tentar derrubar o governo? \n[1] Sim \n[2] NÃ£o");
                        decisao2 = scan.nextInt();
                        if (decisao2 == 1) {
                            derrubarGoverno(inimigo);
                        }
                        break;
                    }
                    case 3:
                        System.out.println("Finalizando o ataque...");
                        break;
                    default:
                        System.out.println("OpÃ§Ã£o invÃ¡lida.");
                }
            } while (decisao1 != 3); // O loop termina quando decisao1 Ã© 3
        }
    }

    public void derrubarGoverno(Pais inimigo) {
        int i = 1;
        int decisao3 = 0;
        while (i != 0) {
            if (inimigo.getCredibilidade() < 35) {
                if (inimigo.getEconomia() < 7) {
                    String escolha;
                    System.out.println("Governo Derrubado com sucesso!");
                    System.out.println("Obrigado por participar!");
                    i = 0;
                } else {
                    int decisaoRandomizada = random.nextInt(2);

                    String alternativa1 = "Falhamos em derrubÃ¡-los, deseja tentar novamente? \n [1]Sim [2]NÃ£o";
                    decisao3 = scan.nextInt();
                    if(decisao3 == 1) {
                    	derrubarGoverno(inimigo);
                    }else if(decisao3 == 2) {
                        System.out.println("Obrigado por participar!");
                        i = 0;
                    }                    
                    String alternativa2 = "Governo derrubado com sucesso";

                    if (decisaoRandomizada == 0) {
                        System.out.println(alternativa1);
                        System.out.println("Obrigado por participar!");
                        i = 0;
                    } else {
                        System.out.println(alternativa2);
                        System.out.println("Obrigado por participar!");
                        i = 0;
                    }
                }
            } else {
                if (inimigo.getEconomia() < 7) {
                    int decisaoRandomizada = random.nextInt(2);

                    String alternativa1 = "Falhamos em derrubÃ¡-los, deseja tentar novamente?";
                    String alternativa2 = "Governo derrubado com sucesso";

                    if (decisaoRandomizada == 0) {
                        System.out.println(alternativa1);
                        System.out.println("Obrigado por participar!");
                        i = 0;
                    } else {
                        System.out.println(alternativa2);
                        System.out.println("Obrigado por participar!");
                        i = 0;
                    }
                } else {
                    System.out.println("Falha no ataque!");
                    System.out.println("Obrigado por participar!");
                    i = 0;
                }
            }
        }
        System.exit(0); // Encerra o programa
    }
}

