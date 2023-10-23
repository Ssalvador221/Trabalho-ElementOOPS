package Menu;

public class MenuAtaques extends MenuMain{

    @Override
    public void modelosMenu(){
        do {
            System.out.println("#########################################");
            System.out.println("#           Escolha sua ação            #");
            System.out.println("#                                       #");
            System.out.println("#  Selecione 1 para : Ataque Físico     #");
            System.out.println("#  Selecione 2 para : Ataque Elemental  #");
            System.out.println("#  Selecione 3 para : Sair do Programa  #");
            System.out.println("#########################################");
            System.out.print("Selecione uma das Opçoes Acima: ");

            opcao = scan.nextInt();

            valido = (opcao > 0 && opcao < 4) ;
            if (!valido) {
                System.out.println("Opcao invalida! Selecione uma nova opção!!!");
            }
            } while (!valido);
    }

}