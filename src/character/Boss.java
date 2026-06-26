package character;

public class Boss extends Character {

    public Boss(String nome, int vidaMaxima, int ataque, int defesa) {
        super(nome, vidaMaxima, ataque, defesa);
    }

    @Override
    public boolean usarSuper() { return false; }

    @Override
    public String getNomeSuper() { return ""; }

    @Override
    public String getDescricaoSuper() { return ""; }

    @Override
    public String getDescricao() {
        return "⚠ BOSS: " + nome + "! HP: " + vidaMaxima + " | ATK: " + ataque + " | DEF: " + defesa;
    }
}
