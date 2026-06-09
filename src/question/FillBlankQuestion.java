package question;

public class FillBlankQuestion extends Question {

    public FillBlankQuestion(String enunciado, String respostaCorreta, String categoria, int dificuldade) {
        super(enunciado, respostaCorreta, categoria, dificuldade);
    }

    @Override
    public void exibir() {
        System.out.println("\n[Complete a Lacuna | Dificuldade: " + dificuldade + " | " + categoria + "]");
        System.out.println(enunciado);
        System.out.print("Sua resposta: ");
    }

    @Override
    public boolean verificarResposta(String resposta) {
        return resposta.trim().equalsIgnoreCase(respostaCorreta.trim());
    }
}