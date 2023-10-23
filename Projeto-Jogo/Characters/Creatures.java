
package Characters;

public abstract class Creatures {
    private CreaturesName nome;
	private CreaturesElements elemento;
    private int poder; 
    private int ataque;
    private int defesa;
    private int velocidade;
    private int pontosDeVida;
    private int totalVidaInicial;
    
    public Creatures() {
        setNome(nome);
        setElemento(elemento);
        setPoder(poder);
        setAtaque(ataque);
        setDefesa(defesa);
        setVelocidade(velocidade);
        setPontosDeVida(pontosDeVida);
        setTotalVidaInicial(totalVidaInicial);
    }

    public CreaturesName getNome() {
        return nome;
    }

    public void setNome(CreaturesName nome) {
        this.nome = nome;
    }

    public CreaturesElements getElemento() {
        return elemento;
    }

    public void setElemento(CreaturesElements elemento) {
        this.elemento = elemento;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getTotalVidaInicial() {
        return totalVidaInicial;
    }

    public void setTotalVidaInicial(int totalVidaInicial) {
        this.totalVidaInicial = totalVidaInicial;
    }

    public void defenderDano(Creatures criaturaAtacante, Creatures criaturaDefensora, double fatorAtaque){
        
        if(fatorAtaque == 0){
            
            int recebeDano = (criaturaAtacante.getPoder() * criaturaAtacante.getAtaque()) / criaturaDefensora.getDefesa();
            
            criaturaDefensora.setPontosDeVida(criaturaDefensora.getPontosDeVida() - recebeDano);
        }else{
            double recebeDano = fatorAtaque;
            criaturaDefensora.setPontosDeVida((int) (criaturaDefensora.getPontosDeVida() - recebeDano));
        }

    }   


    public void ataqueBasico(Creatures criaturaAtacante, Creatures criaturaDefensora){

        int efetuaDano = (criaturaAtacante.getPoder() * criaturaAtacante.getAtaque()) / criaturaDefensora.getDefesa();

        System.out.println(criaturaAtacante.getNome() + "realiza um Ataque Básico!");
        

        defenderDano(criaturaAtacante, criaturaDefensora, 0);
        System.out.println("Dano causado: " + efetuaDano);

        if(criaturaDefensora.getPontosDeVida() <= 0){
            System.out.println("Pontos de vida restantes:" + criaturaDefensora.getPontosDeVida() + " : 0");
            System.out.println();
        }else{
            System.out.println("Pontos de vida restantes:" + criaturaDefensora.getNome() + ": " + criaturaDefensora.getPontosDeVida());
            System.out.println();
        }
    }

    public String atributesStats(Creatures creature) {
        return String.format("" +
                        "Nome da Criatura: %s\n" +
                        "Elemento: %s\n" +
                        "Pontos de Poder: %d\n" +
                        "Pontos de Ataque: %d\n" +
                        "Pontos de Defesa: %d\n" +
                        "Pontos de Velocidade: %d\n" +
                        "Pontos de Vida: %d\n" +
                        "_", creature.getNome(), creature.getElemento(),
                creature.getPoder(), creature.getAtaque(),
                creature.getDefesa(), creature.getVelocidade(),
                creature.getPontosDeVida());
    }

    public abstract void ataqueElemental(Creatures criaturaAtacante, Creatures criaturaDefensora);
    public abstract double fatorDanoCriaturas(Creatures criaturaAtacante, Creatures criaturaDefensora);




   


    
}
