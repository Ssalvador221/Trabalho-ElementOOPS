package Menu;

public class MenuContinuar extends MenuMain{

    @Override
    public void modelosMenu(){
        do{
            System.out.println("#########################################");
            System.out.println("#               VITÓRIA!!!              #");
            System.out.println("#########################################");
            System.out.println("#  Selecione 1 para : Próxima Batalha   #");
            System.out.println("#  Selecione 2 para : Sair do Programa  #");
            System.out.println("#########################################");
            System.out.print("Selecione uma das Opçoes Acima:");

            opcao = scan.nextInt();

            valido = (opcao == 1) || (opcao == 2);
            if (!valido) {
                System.out.println("Opcao invalida!");
            }
        } while (!valido);
    }
    
}
