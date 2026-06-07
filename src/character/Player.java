package character;

public class Player {
    private String nome;
    private Character personagem;
    private int pontuacao;

    public Player(String nome, Character personagem) {
        this.nome = nome;
        this.personagem = personagem;
        this.pontuacao = 0;
    }

    public void adicionarPontos(int pontos) {
        this.pontuacao += pontos;
    }

    public String getNome() {
        return nome;
    }

    public Character getPersonagem() {
        return personagem;
    }
    public int getPontuacao() {
        return pontuacao;
    }
}

