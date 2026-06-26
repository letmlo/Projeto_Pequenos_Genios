package question;

public class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(String enunciado, boolean respostaCorreta, String categoria, int dificuldade) {
        super(enunciado, respostaCorreta ? "V" : "F", categoria, dificuldade);
    }

    @Override
    public void exibir() {
        System.out.println("\n[Verdadeiro ou Falso | Dificuldade: " + dificuldade + " | " + categoria + "]");
        System.out.println(enunciado);
        System.out.println("V) Verdadeiro");
        System.out.println("F) Falso");
        System.out.print("Sua resposta: ");
    }

    @Override
    public boolean verificarResposta(String resposta) {
        return resposta.trim().equalsIgnoreCase(respostaCorreta);
    }

    @Override
    public String getDica() {
        String porExtenso = respostaCorreta.equalsIgnoreCase("V") ? "Verdadeiro" : "Falso";
        return "\n[COLA MENTAL] A resposta começa com: \"" + porExtenso.substring(0, 3) + "...\"";
    }
}
