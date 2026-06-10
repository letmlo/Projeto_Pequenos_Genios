package character;

public abstract class Character {
    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int ataque;
    protected int defesa;
    protected boolean superDisponivel;

    public Character(String nome, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
        this.superDisponivel = true;
    }

    public void receberDano(int dano) {
        int danoReal = Math.max(1, dano - defesa);
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
        String superStatus = superDisponivel ? " [SUPER ✔]" : " [SUPER ✘]";
        System.out.printf("%-15s HP: %s %d/%d%s%n", nome, barra, vidaAtual, vidaMaxima, superStatus);
    }
    public abstract boolean usarSuper();

    public abstract String getNomeSuper();

    public abstract String getDescricao();

    public boolean isSuperDisponivel() { return superDisponivel; }
    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
}
