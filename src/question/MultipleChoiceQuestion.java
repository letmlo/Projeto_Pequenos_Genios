package question;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> alternativas;

    public MultipleChoiceQuestion(String enunciado, List<String> alternativas, String respostaCorreta, String categoria, int dificuldade) {
        super(enunciado, respostaCorreta, categoria, dificuldade);
        this.alternativas = alternativas;
    }

    @Override
    public void exibir() {
        System.out.println("\n[Múltipla Escolha | Dificuldade: " + dificuldade + " | " + categoria + "]");
        System.out.println(enunciado);
        char letra = 'A';
        for (String alt : alternativas) {
            System.out.println(letra + ") " + alt);
            letra++;
        }
        System.out.print("Sua resposta: ");
    }

    @Override
    public boolean verificarResposta(String resposta) {
        return resposta.trim().equalsIgnoreCase(respostaCorreta);
    }

    public List<String> getAlternativas() {
        return alternativas;
    }
}
