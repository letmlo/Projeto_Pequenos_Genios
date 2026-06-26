package character;


public abstract class Character implements Habilidade {
    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int ataque;
    protected int defesa;

    //recarga do super
    protected boolean superDisponivel;
    protected int acertosAposUso;
    private static final int ACERTOS_PARA_RECARREGAR = 2;

    public Character(String nome, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
        this.superDisponivel = true;
        this.acertosAposUso = 0;
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
        String superStatus = superDisponivel ? " [SUPER ✔]" : " [SUPER " + acertosAposUso + "/" + ACERTOS_PARA_RECARREGAR + "]";
        System.out.printf("%-15s HP: %s %d/%d%s%n", nome, barra, vidaAtual, vidaMaxima, superStatus);
    }

    //habilidade

    @Override
    public boolean isSuperDisponivel() { return superDisponivel; }

    @Override
    public void registrarAcerto() {
        if (!superDisponivel) {
            acertosAposUso++;
            if (acertosAposUso >= ACERTOS_PARA_RECARREGAR) {
                superDisponivel = true;
                acertosAposUso = 0;
                System.out.println("\n★ Super \"" + getNomeSuper() + "\" recarregado!");
            }
        }
    }

    public abstract String getDescricao();

    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
}
