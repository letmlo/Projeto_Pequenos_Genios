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
        acertosAposUso = 0;
        dominioAtivo = true;
        return true;
    }

    /** consome o domínio e retorna se estava ativo. */
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
    public String getDescricaoSuper() { return "O especialista domina completamente o assunto."; }

    @Override
    public String getDescricao() { return "Especialista: alto poder de ataque, mas frágil na defesa."; }
}
