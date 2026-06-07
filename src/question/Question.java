package question;

public class Question {public abstract class Question {
    protected String enunciado;
    protected String respostaCorreta;
    protected String categoria;
    protected int dificuldade;

    public Question(String enunciado, String respostaCorreta, String categoria, int dificuldade) {
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
        this.categoria = categoria;
        this.dificuldade = dificuldade;
    }

    public abstract void exibir();

    public abstract boolean verificarResposta(String resposta);

    public int getDificuldade() {
        return dificuldade;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getCategoria() {
        return categoria;
    }
}
}
