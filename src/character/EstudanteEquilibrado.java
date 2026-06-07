package character;

public class EstudanteEquilibrado extends Character {

    public EstudanteEquilibrado(String nome) {
        super(nome, 100, 15, 5);
    }

    @Override
    public String getDescricao() {
        return "Estudante equilibrado: bom em tudo, sem pontos fracos.";
    }
}
