package question;

public interface Perguntavel {
    void exibir();
    boolean verificarResposta(String resposta);
    String getDica();
    int getDificuldade();
}
