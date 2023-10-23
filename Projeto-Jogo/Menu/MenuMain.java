package Menu;

import java.util.Scanner;

public abstract class MenuMain {
    int opcao;
    boolean valido;
    Scanner scan = new Scanner(System.in);

    public MenuMain(){
        setOpcao(opcao);
        setValido(valido);
        setScan(scan);
    }

    public int getOpcao(){
        return this.opcao;
    }

    public void setOpcao(int opcao){
        this.opcao = opcao;
    }

    public boolean getValido(){
        return this.valido;
    }

    public void setValido(boolean valido){
        this.valido = valido;
    }

    public Scanner getScan(){
        return this.scan;
    }

    public void setScan(Scanner scan){
        this.scan = scan;
    }

    public abstract void modelosMenu();
}
