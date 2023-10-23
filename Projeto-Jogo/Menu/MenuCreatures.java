package Menu;

public class MenuCreatures extends MenuMain{

  @Override
  public void modelosMenu() {
      do {
        System.out.println("#########################################");
        System.out.println("#        Escolha o seu Personagem       #");
        System.out.println("#                                       #");
        System.out.println("#  Selecione 1 para : BreezeHacker      #");
        System.out.println("#  Selecione 2 para : BurnCoder         #");
        System.out.println("#  Selecione 3 para : StoneDev          #");
        System.out.println("#  Selecione 4 para : WaveNerd          #");
        System.out.println("#  Selecione 5 para : Sair do Programa  #");
        System.out.println("#########################################");
        System.out.print("Selecione uma das Opçoes Acima: ");

        opcao = scan.nextInt();

        valido = (opcao > 0 && opcao < 6) ;
        if (!valido) {
          System.out.println("Opcao invalida! Selecione uma nova opção!!!");
        }
      } while (!valido);
  }
}