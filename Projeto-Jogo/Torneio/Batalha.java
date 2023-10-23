package Torneio;

import Characters.*;
import Menu.MenuInicial;
import Menu.MenuCreatures;
import Menu.MenuAtaques;


import java.util.Random;
import java.util.Scanner;

public class Batalha {
  Scanner scanner;
  private static Creatures[] creature = new Creatures[4];

  public Batalha() {
    this.scanner = new Scanner(System.in);
  }

  int criaturaAdversaria = 1;

  public void selecaoCriatura() {
    MenuCreatures menuCreatures = new MenuCreatures();
    menuCreatures.modelosMenu();

    int selecao = menuCreatures.getOpcao();

    if (selecao > 0 && selecao < 6) {
      switch (selecao) {
        case 1:
          creature[0] = new BreezeHacker();
          creature[1] = new BurnCoder();
          creature[2] = new StoneDev();
          creature[3] = new WaveNerd();
          break;
        case 2:
          creature[0] = new BurnCoder();
          creature[1] = new StoneDev();
          creature[2] = new WaveNerd();
          creature[3] = new BreezeHacker();
          break;
        case 3:
          creature[0] = new StoneDev();
          creature[1] = new BurnCoder();
          creature[2] = new WaveNerd();
          creature[3] = new BreezeHacker();
          break;
        case 4:
          creature[0] = new WaveNerd();
          creature[1] = new BreezeHacker();
          creature[2] = new StoneDev();
          creature[3] = new BurnCoder();
          break;
        case 5:
          System.out.println("#########################################");
          System.out.println("#           Você realmente sair?        #");
          System.out.println("#                                       #");
          System.out.println("#                1 - Sim                #");
          System.out.println("#                2 - Não                #");
          System.out.println("#########################################");

          int confirmacao = scanner.nextInt();
          if (confirmacao == 1) {
            System.out.println("Processando..");
            System.out.println("Jogo finalizado!");
            System.exit(0);
          } else {
            System.out.println("Continuando o programa..");
            selecaoCriatura();
            break;
          }
      }
      this.iniciarBatalha();
    } else {
      System.out.println("Escolha Inválida, Selecione Novamente.");
      this.selecaoCriatura();
    }
  }

  public void iniciarBatalha() {
    System.out.println();
    System.out.println("Criatura Selecionada: " + creature[0].getNome());
    System.out.println("-- Elemento: " + creature[0].getElemento());
    System.out.println("-- Poder: " + creature[0].getPoder());
    System.out.println("-- Pontos de vida inicial: " + creature[0].getTotalVidaInicial());
    System.out.println("-- Velocidade total: " + creature[0].getVelocidade());
    
    
    System.out.println();
    System.out.println(criaturaAdversaria + "º Oponente: ");
    System.out.println("Criatura Adversaria: " + creature[criaturaAdversaria].getNome());
    System.out.println("-- Elemento: " + creature[criaturaAdversaria].getElemento());
    System.out.println("-- Poder: " + creature[criaturaAdversaria].getPoder());
    System.out.println("-- Pontos de vida inicial: " + creature[criaturaAdversaria].getTotalVidaInicial());
    System.out.println("-- Velocidade total: " + creature[criaturaAdversaria].getVelocidade());
    System.out.println();

    System.out.println("1. iniciar a batalha? \n" +
        "2. Sair do programa");
    int selecao = this.scanner.nextInt();
    scanner.nextLine();
    if (selecao >= 1 && selecao <= 2) {
      switch (selecao) {
        case 1:
          this.batalhar();
          break;
        case 2:
          System.out.println("Deseja realmente sair?\n" +
              "1. Sim\n" +
              "2. Não");

          int confirmacao = scanner.nextInt();
          if (confirmacao == 1) {
            System.out.println("Processando..");
            System.out.println("Jogo finalizado!");
            System.exit(0);
          } else {
            System.out.println("Continuando o programa.");
            iniciarBatalha();
            break;
          }
      }
    } else {
      System.out.println("selecao inválida. Tente novamente.");
      this.iniciarBatalha();
    }

  }

  public void batalhar() {
    if (creature[0].getVelocidade() >= creature[criaturaAdversaria].getVelocidade()) {
      personagemEscolhido(creature[0], creature[criaturaAdversaria]);
      if (this.statusDaBatalha() == false) {
        personagemInimigo(creature[criaturaAdversaria], creature[0]);
      }
      this.continuarBatalha();

    } else {
      personagemInimigo(creature[criaturaAdversaria], creature[0]);
      if (this.statusDaBatalha() == false) {
        personagemEscolhido(creature[0], creature[criaturaAdversaria]);
      }
      this.continuarBatalha();

    }
  }

  public void personagemEscolhido(Creatures atacante, Creatures defensor) {
    MenuAtaques menuAtaques = new MenuAtaques();
    menuAtaques.modelosMenu();

    int selecao = menuAtaques.getOpcao();

    System.out.println();
    System.out.println("SEU ATAQUE: ");
    switch (selecao) {
      case 1:
        atacante.ataqueBasico(atacante, defensor);
        break;
      case 2:
        atacante.ataqueElemental(atacante, defensor);
        break;
      case 3:
        System.out.println("Deseja realmente sair?\n" +
            "1. Sim\n" +
            "2. Não");

        int confirmacao = scanner.nextInt();
        if (confirmacao == 1) {
          System.out.println("Processando..");
          System.out.println("Jogo finalizado!");
          System.exit(0);
        } else {
          System.out.println("Continuando o programa.");
          this.personagemEscolhido(atacante, defensor);
          break;
        }
    }
  }

  public void personagemInimigo(Creatures atacante, Creatures defensor) {
    System.out.println("ATAQUE INIMIGO: ");
    Random rand = new Random();
    int selecao = rand.nextInt(2) + 1;
    switch (selecao) {
      case 1:
        atacante.ataqueBasico(atacante, defensor);
        break;
      case 2:
        atacante.ataqueElemental(atacante, defensor);
        break;
    }
  }

  public boolean statusDaBatalha() {
    return creature[0].getPontosDeVida() <= 0 || creature[criaturaAdversaria].getPontosDeVida() <= 0;
  }

  public static void resetarPontoDeVida() {
    creature[0].setPontosDeVida(creature[0].getTotalVidaInicial());
  }

  public void continuarTorneio() {
    if (creature[0].getPontosDeVida() <= 0) {
      System.out.println("VOCÊ FOI ELIMINADO! ");

    } else if (creature[criaturaAdversaria].getPontosDeVida() <= 0) {
      System.out.println("LUTA ENCERRADA");
      System.out.println(creature[0].getNome() + " VENCEU A " + criaturaAdversaria + "ª RODADA!!!");
      resetarPontoDeVida();
      System.out.println();
      System.out.println("SUA VIDA FOI REGENERADA " + creature[0].getPontosDeVida() + "\n");
      ++criaturaAdversaria;
      if (criaturaAdversaria >= creature.length) {
        System.out.println(creature[0].getNome() + " GANHOU  O TORNEIO!!!");
        System.out.println(creature[0]);
        criaturaAdversaria = 1;
        System.out.println("\n" + "VOCÊ VENCEU PARABÉNS!!!!");
        return;
      } else {
        this.iniciarBatalha();
      }
    }
  }

  public void continuarBatalha() {
    if (statusDaBatalha() == false) {
      this.batalhar();

    } else {
      this.continuarTorneio();
    }
  }


}