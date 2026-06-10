package battle;

import character.Player;
import character.Enemy;
import character.EstudanteEquilibrado;
import character.EstudanteEspecialista;
import question.Question;
import ui.ConsoleUI;

public class Round {
    private Question pergunta;
    private Player player;
    private Enemy enemy;
    private AnswerEvaluator avaliador;

    public Round(Question pergunta, Player player, Enemy enemy) {
        this.pergunta = pergunta;
        this.player = player;
        this.enemy = enemy;
        this.avaliador = new AnswerEvaluator();
    }

    public void executar() {
        ConsoleUI.exibirSeparador();
        System.out.println("\nNOVA RODADA");
        ConsoleUI.exibirStatus(player, enemy);

        oferecerSuper();

        pergunta.exibir();

        boolean colaAtiva = false;
        if (player.getPersonagem() instanceof EstudanteEquilibrado eq) {
            colaAtiva = eq.consumirCola();
            if (colaAtiva) {
                System.out.println(pergunta.getDica());
                System.out.print("Sua resposta: ");
            }
        }

        String resposta = ConsoleUI.lerResposta();
        boolean acertou = avaliador.avaliar(pergunta, resposta);

        if (acertou) {
            int dano = avaliador.calcularDano(
                    player.getPersonagem().getAtaque(),
                    pergunta.getDificuldade()
            );
            int pontos = avaliador.calcularPontos(pergunta.getDificuldade());

            boolean dominioAtivo = false;
            if (player.getPersonagem() instanceof EstudanteEspecialista esp) {
                dominioAtivo = esp.consumirDominio();
                if (dominioAtivo) dano *= 2;
            }

            enemy.getPersonagem().receberDano(dano);
            player.adicionarPontos(pontos);

            if (dominioAtivo) {
                System.out.println("\n✦ DOMÍNIO ABSOLUTO! Dano dobrado!");
            }
            System.out.println("\n✔ Resposta correta! Você causou " + dano + " de dano e ganhou " + pontos + " pontos!");
        } else {
            if (player.getPersonagem() instanceof EstudanteEspecialista esp) {
                esp.consumirDominio(); // consome sem efeito
            }

            int penalidade = avaliador.calcularPenalidade(pergunta.getDificuldade());
            player.getPersonagem().receberDano(penalidade);
            System.out.println("\n✘ Resposta errada! Você perdeu " + penalidade + " de vida.");
        }
    }

    private void oferecerSuper() {
        character.Character personagem = player.getPersonagem();
        if (!personagem.isSuperDisponivel()) return;

        System.out.println("\n★ Você possui o Super \"" + personagem.getNomeSuper() + "\" disponível!");
        System.out.println("  Deseja usar agora? (S/N)");
        System.out.print("  Sua escolha: ");
        String escolha = ConsoleUI.lerResposta();

        if (escolha.equalsIgnoreCase("S")) {
            personagem.usarSuper();
            ConsoleUI.exibirMensagemSuper(personagem.getNomeSuper());
        }
    }
}
