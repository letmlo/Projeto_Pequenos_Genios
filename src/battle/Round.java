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

    private int acertos;
    private int erros;

    public Round(Question pergunta, Player player, Enemy enemy) {
        this.pergunta = pergunta;
        this.player = player;
        this.enemy = enemy;
        this.avaliador = new AnswerEvaluator();
        this.acertos = 0;
        this.erros = 0;
    }

    public void executar() {
        ConsoleUI.exibirSeparador();
        System.out.println("\nNOVA RODADA");
        ConsoleUI.exibirStatus(player, enemy);

        // Oferecer uso do Super antes da pergunta
        oferecerSuper();

        pergunta.exibir();

        // Aplicar Cola Mental (Equilibrado): exibe dica antes de ler a resposta
        if (player.getPersonagem() instanceof EstudanteEquilibrado eq && eq.consumirCola()) {
            System.out.println(pergunta.getDica());
            System.out.print("Sua resposta: ");
        }

        String resposta = ConsoleUI.lerResposta();
        boolean acertou = avaliador.avaliar(pergunta, resposta);

        if (acertou) {
            int dano = avaliador.calcularDano(
                    player.getPersonagem().getAtaque(),
                    pergunta.getDificuldade()
            );
            int pontos = avaliador.calcularPontos(pergunta.getDificuldade());

            // Aplicar Domínio Absoluto (Especialista): dobra o dano
            boolean dominioAtivo = false;
            if (player.getPersonagem() instanceof EstudanteEspecialista esp) {
                dominioAtivo = esp.consumirDominio();
                if (dominioAtivo) dano *= 2;
            }

            enemy.getPersonagem().receberDano(dano);
            player.adicionarPontos(pontos);

            // Registra acerto para recarga do Super
            player.getPersonagem().registrarAcerto();
            acertos++;

            if (dominioAtivo) {
                System.out.println("\n✦ DOMÍNIO ABSOLUTO! Dano dobrado!");
            }
            System.out.println("\n✔ Resposta correta! Você causou " + dano + " de dano e ganhou " + pontos + " pontos!");

        } else {
            // Se Domínio estava ativo e errou, consome sem efeito
            if (player.getPersonagem() instanceof EstudanteEspecialista esp) {
                esp.consumirDominio();
            }
            int penalidade = avaliador.calcularPenalidade(pergunta.getDificuldade());
            player.getPersonagem().receberDano(penalidade);
            erros++;

            System.out.println("\n✘ Resposta errada! Você perdeu " + penalidade + " de vida.");
            ConsoleUI.exibirRespostaCorreta(pergunta.getRespostaCorreta());
        }
    }

    private void oferecerSuper() {
        character.Character personagem = player.getPersonagem();
        if (!personagem.isSuperDisponivel()) return;

        System.out.println("\n★ Super disponível: \"" + personagem.getNomeSuper() + "\"");
        System.out.println("  " + personagem.getDescricaoSuper());
        System.out.println("  Deseja usar agora? (S/N)");
        System.out.print("  Sua escolha: ");
        String escolha = ConsoleUI.lerResposta();

        if (escolha.equalsIgnoreCase("S")) {
            personagem.usarSuper();
            ConsoleUI.exibirMensagemSuper(personagem.getNomeSuper());
        }
    }

    public int getAcertos() { return acertos; }
    public int getErros()   { return erros; }
}
