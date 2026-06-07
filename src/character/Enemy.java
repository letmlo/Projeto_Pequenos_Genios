package character;

public class Enemy {
    private String nome;
    private Character personagem;

    public Enemy(String nome, Character personagem) {
        this.nome = nome;
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }
    public Character getPersonagem() {
        return personagem;
    }
}
