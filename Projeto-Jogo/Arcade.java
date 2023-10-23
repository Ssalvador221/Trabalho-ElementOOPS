import Menu.MenuInicial;
import Torneio.Batalha;

public class Arcade {
    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
        Batalha batalha = new Batalha();
        menu.modelosMenu();
        if (menu.getOpcao() == 1){
            batalha.selecaoCriatura();
        }
        else {
            System.out.println("Finalizando o Programa ...!");
            System.exit(0);
        }
    }
}
