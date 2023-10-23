package Characters;

import java.util.Random;

public class WaveNerd extends Creatures {


    public WaveNerd() {
        Random random = new Random();
        setNome(CreaturesName.WaveNerd);
        setElemento(CreaturesElements.Agua);
        setPoder(random.nextInt(21) + 10);
        setAtaque(random.nextInt(11) + 5);
        setDefesa(random.nextInt(11) + 5);
        setVelocidade(random.nextInt(10) + 1);
        setPontosDeVida(random.nextInt(201) + 200);
        setTotalVidaInicial(getPontosDeVida());
    }


    @Override
    public double fatorDanoCriaturas(Creatures criaturaAtacante, Creatures criaturaDefensora) {
        CreaturesElements elementoAtacante = criaturaAtacante.getElemento();
        CreaturesElements elementoDefensor = criaturaDefensora.getElemento();

        double fatorDano = 0;

        if (elementoAtacante == CreaturesElements.Agua) {
            if (elementoDefensor == CreaturesElements.Ar) {
                fatorDano = 1.0;
            } else if (elementoDefensor == CreaturesElements.Agua) {
                fatorDano = 0.5;
            } else if (elementoDefensor == CreaturesElements.Fogo) {
                fatorDano = 2.0;
            } else if (elementoDefensor == CreaturesElements.Terra) {
                fatorDano = 1.0;
            }
        }
        return (double) (criaturaAtacante.getPoder() * criaturaAtacante.getAtaque()) / criaturaDefensora.getDefesa() * fatorDano;
    }


    @Override
    public void ataqueElemental(Creatures criaturaAtacante, Creatures criaturaDefensora) {

        double fatorAtaque = fatorDanoCriaturas(criaturaAtacante, criaturaDefensora);

        System.out.println(criaturaAtacante.getNome() + " lançou um ataque elemental");
        System.out.println();

        defenderDano(criaturaAtacante, criaturaDefensora, fatorAtaque);
        if (criaturaDefensora.getPontosDeVida() <= 0) {
            System.out.println("Pontos de vida restante " + criaturaDefensora.getNome() + " : 0");
        } else {
            System.out.println("Pontos de vida restante " + criaturaDefensora.getNome() + ": " + criaturaDefensora.getPontosDeVida());
        }

    }
}
