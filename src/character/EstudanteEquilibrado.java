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
        colaAtiva = true;
        return true;
    }

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
    public String getDescricao() {
        return "Estudante equilibrado: bom em tudo, sem pontos fracos.";
    }
}
