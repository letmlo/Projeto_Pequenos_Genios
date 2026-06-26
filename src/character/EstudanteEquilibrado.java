package character;

public class EstudanteEquilibrado extends Character {
    private boolean colaAtiva;

    public EstudanteEquilibrado(String nome) {
        super(nome, 100, 15, 5);
        this.colaAtiva = false;
    }

    @Override
    public boolean usarSuper() {
        if (!superDisponivel) return false;
        superDisponivel = false;
        acertosAposUso = 0;
        colaAtiva = true;
        return true;
    }

    /** consome a cola e retorna se estava ativa. */
    public boolean consumirCola() {
        if (colaAtiva) {
            colaAtiva = false;
            return true;
        }
        return false;
    }

    public boolean isColaAtiva() { return colaAtiva; }

    @Override
    public String getNomeSuper() { return "Cola Mental"; }

    @Override
    public String getDescricaoSuper() { return "Lembra de algo que estudou anteriormente."; }

    @Override
    public String getDescricao() { return "Estudante equilibrado: bom em tudo, sem pontos fracos."; }
}
