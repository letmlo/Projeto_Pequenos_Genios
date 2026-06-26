package question;

/**
 * Classe abstrata base para todas as perguntas.
 * Implementa perguntavel!!!!!!
 */
public abstract class Question implements Perguntavel {
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

    @Override
    public int getDificuldade() { return dificuldade; }

    public String getEnunciado()      { return enunciado; }
    public String getCategoria()      { return categoria; }
    public String getRespostaCorreta() { return respostaCorreta; }
}
