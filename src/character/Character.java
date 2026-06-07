package character;

public abstract class Character {
    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int ataque;
    protected int defesa;

    public Character(String nome, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public void receberDano(int dano) {
        int danoReal = Math.max(1, dano - defesa); // ataque com pelo menos 1 de dano
        vidaAtual = Math.max(0, vidaAtual - danoReal);
    }

    public void recuperarVida(int quantidade) {
        vidaAtual = Math.min(vidaMaxima, vidaAtual + quantidade);
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void exibirStatus() {
        int barras = (int) ((double) vidaAtual / vidaMaxima * 20);
        String barra = "[" + "█".repeat(barras) + "░".repeat(20 - barras) + "]";
        System.out.printf("%-15s HP: %s %d/%d%n", nome, barra, vidaAtual, vidaMaxima);
    }

    public abstract String getDescricao();

    // getters:

    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
}
