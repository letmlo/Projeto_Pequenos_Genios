package question;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public String getDica() {
        int indiceCorreto = respostaCorreta.charAt(0) - 'A';

        List<Integer> errados = new ArrayList<>();
        for (int i = 0; i < alternativas.size(); i++) {
            if (i != indiceCorreto) errados.add(i);
        }
        Collections.shuffle(errados);

        List<Integer> eliminados = errados.subList(0, Math.min(2, errados.size()));

        StringBuilder sb = new StringBuilder();
        sb.append("\n[COLA MENTAL] Duas alternativas erradas foram eliminadas!\n");
        char letra = 'A';
        for (int i = 0; i < alternativas.size(); i++) {
            if (!eliminados.contains(i)) {
                sb.append(letra).append(") ").append(alternativas.get(i)).append("\n");
            } else {
                sb.append(letra).append(") ██████████ [ELIMINADA]\n");
            }
            letra++;
        }
        return sb.toString();
    }

    public List<String> getAlternativas() {
        return alternativas;
    }
}
