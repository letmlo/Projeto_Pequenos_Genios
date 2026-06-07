package battle;

import question.Question;

public class AnswerEvaluator {

    public boolean avaliar(Question pergunta, String resposta) {
        return pergunta.verificarResposta(resposta);
    }

    public int calcularDano(int ataque, int dificuldade) {
        return ataque + (dificuldade * 5);
    }

    public int calcularPenalidade(int dificuldade) {
        return 5 + (dificuldade * 3);
    }

    public int calcularPontos(int dificuldade) {
        return dificuldade * 10;
    }
}
