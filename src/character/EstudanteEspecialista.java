package character;

public class EstudanteEspecialista extends Character {

    public EstudanteEspecialista(String nome) {
        super(nome, 80, 25, 2);
    }

    @Override
    public String getDescricao() {
        return "Especialista: alto poder de ataque, mas frágil na defesa.";
    }
}

