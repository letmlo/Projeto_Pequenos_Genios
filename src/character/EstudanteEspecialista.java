package character;

public class EstudanteEspecialista extends Character {
    private boolean dominioAtivo;

    public EstudanteEspecialista(String nome) {
        super(nome, 80, 25, 2);
        this.dominioAtivo = false;
    }

    @Override
    public boolean usarSuper() {
        if (!superDisponivel) return false;
        superDisponivel = false;
        dominioAtivo = true;
        return true;
    }

    public boolean consumirDominio() {
        if (dominioAtivo) {
            dominioAtivo = false;
            return true;
        }
        return false;
    }

    public boolean isDominioAtivo() { return dominioAtivo; }

    @Override
    public String getNomeSuper() { return "Domínio Absoluto"; }

    @Override
    public String getDescricao() {
        return "Especialista: alto poder de ataque, mas frágil na defesa.";
    }
}
