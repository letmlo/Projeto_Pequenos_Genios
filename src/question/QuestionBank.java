package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> perguntas;

    public QuestionBank() {
        perguntas = new ArrayList<>();
        carregarPerguntas();
    }

    private void carregarPerguntas() {
        // Múltipla escolha - Fácil
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é a capital do Brasil?",
                List.of("Rio de Janeiro", "São Paulo", "Brasília", "Salvador"),
                "C", "Geografia", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quantos continentes existem no mundo?",
                List.of("5", "6", "7", "8"),
                "C", "Geografia", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual planeta é conhecido como Planeta Vermelho?",
                List.of("Júpiter", "Vênus", "Saturno", "Marte"),
                "D", "Ciências", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quem pintou a Mona Lisa?",
                List.of("Michelangelo", "Rafael", "Leonardo da Vinci", "Picasso"),
                "C", "Arte", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o maior oceano do mundo?",
                List.of("Atlântico", "Índico", "Ártico", "Pacífico"),
                "D", "Geografia", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o animal mais rápido do mundo?",
                List.of("Leão", "Guepardo", "Cavalo", "Águia"),
                "B", "Ciências", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quantas horas tem um dia?",
                List.of("12", "24", "36", "48"),
                "B", "Cultura Geral", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o maior país do mundo em extensão territorial?",
                List.of("Estados Unidos", "China", "Brasil", "Rússia"),
                "D", "Geografia", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual instrumento tem teclas pretas e brancas?",
                List.of("Violão", "Piano", "Flauta", "Tambor"),
                "B", "Arte", 1
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quantos lados tem um triângulo?",
                List.of("2", "3", "4", "5"),
                "B", "Matemática", 1
        ));

        // Múltipla escolha - Médio
        perguntas.add(new MultipleChoiceQuestion(
                "Em que ano o Brasil foi descoberto pelos portugueses?",
                List.of("1492", "1500", "1510", "1488"),
                "B", "História", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o elemento químico de símbolo 'O'?",
                List.of("Ouro", "Osmio", "Oxigênio", "Ósmio"),
                "C", "Ciências", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quantos ossos tem o corpo humano adulto?",
                List.of("186", "206", "226", "246"),
                "B", "Ciências", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é a língua mais falada no mundo?",
                List.of("Inglês", "Espanhol", "Mandarim", "Hindi"),
                "C", "Cultura Geral", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual cientista desenvolveu a teoria da relatividade?",
                List.of("Newton", "Tesla", "Einstein", "Hawking"),
                "C", "Ciências", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o rio mais longo do mundo?",
                List.of("Amazonas", "Nilo", "Mississippi", "Yangtzé"),
                "B", "Geografia", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quantos planetas tem o Sistema Solar?",
                List.of("7", "8", "9", "10"),
                "B", "Ciências", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é a moeda do Japão?",
                List.of("Yuan", "Won", "Iene", "Rupia"),
                "C", "Cultura Geral", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quem escreveu Dom Casmurro?",
                List.of("José de Alencar", "Machado de Assis", "Clarice Lispector", "Carlos Drummond"),
                "B", "Literatura", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é a fórmula química da água?",
                List.of("CO2", "O2", "H2O", "NaCl"),
                "C", "Ciências", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Em que continente fica o Egito?",
                List.of("Ásia", "Europa", "América", "África"),
                "D", "Geografia", 2
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o osso mais longo do corpo humano?",
                List.of("Úmero", "Fêmur", "Tíbia", "Rádio"),
                "B", "Ciências", 2
        ));

        // Múltipla escolha - Difícil
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o país com maior número de fusos horários?",
                List.of("Rússia", "Estados Unidos", "China", "França"),
                "D", "Geografia", 3
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Em que ano ocorreu a Revolução Francesa?",
                List.of("1776", "1804", "1789", "1815"),
                "C", "História", 3
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o menor país do mundo?",
                List.of("Mônaco", "San Marino", "Vaticano", "Liechtenstein"),
                "C", "Geografia", 3
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Quem desenvolveu a teoria da evolução das espécies?",
                List.of("Gregor Mendel", "Louis Pasteur", "Charles Darwin", "Isaac Newton"),
                "C", "Ciências", 3
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Qual é o elemento mais abundante no universo?",
                List.of("Oxigênio", "Carbono", "Hidrogênio", "Hélio"),
                "C", "Ciências", 3
        ));
        perguntas.add(new MultipleChoiceQuestion(
                "Em que ano ocorreu a Segunda Guerra Mundial?",
                List.of("1914-1918", "1939-1945", "1929-1933", "1950-1953"),
                "B", "História", 3
        ));

        // Verdadeiro ou Falso - Fácil
        perguntas.add(new TrueFalseQuestion(
                "O Sol é uma estrela.", true, "Ciências", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "A água ferve a 100°C ao nível do mar.", true, "Ciências", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "O pinguim é uma ave que sabe voar.", false, "Ciências", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "O idioma oficial do Brasil é o espanhol.", false, "Cultura Geral", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "A Lua é um planeta.", false, "Ciências", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "O Brasil fica na América do Sul.", true, "Geografia", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "O coelho é um réptil.", false, "Ciências", 1
        ));
        perguntas.add(new TrueFalseQuestion(
                "O número zero é par.", true, "Matemática", 1
        ));

        // Verdadeiro ou Falso - Médio
        perguntas.add(new TrueFalseQuestion(
                "O coração humano tem quatro câmaras.", true, "Ciências", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "A Grande Muralha da China é visível a olho nu do espaço.", false, "Cultura Geral", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "O DNA humano é composto por quatro bases nitrogenadas.", true, "Ciências", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "O som viaja mais rápido que a luz.", false, "Ciências", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "A língua portuguesa tem origem no latim.", true, "Literatura", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "O coração de um adulto bate em média 60 a 100 vezes por minuto.", true, "Ciências", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "A Groenlândia pertence aos Estados Unidos.", false, "Geografia", 2
        ));
        perguntas.add(new TrueFalseQuestion(
                "Shakespeare escreveu Romeu e Julieta.", true, "Literatura", 2
        ));

        // Verdadeiro ou Falso - Difícil
        perguntas.add(new TrueFalseQuestion(
                "O teorema de Pitágoras se aplica a qualquer triângulo.", false, "Matemática", 3
        ));
        perguntas.add(new TrueFalseQuestion(
                "O elemento com maior número atômico na tabela periódica é o Oganessônio.", true, "Ciências", 3
        ));
        perguntas.add(new TrueFalseQuestion(
                "O número Pi é um número racional.", false, "Matemática", 3
        ));
        perguntas.add(new TrueFalseQuestion(
                "A velocidade da luz no vácuo é aproximadamente 300.000 km/s.", true, "Ciências", 3
        ));
        perguntas.add(new TrueFalseQuestion(
                "O átomo é a menor partícula existente na natureza.", false, "Ciências", 3
        ));
        perguntas.add(new TrueFalseQuestion(
                "A Antártida é considerada um continente.", true, "Geografia", 3
        ));
        perguntas.add(new TrueFalseQuestion(
                "O teorema de Fermat ficou sem prova por mais de 350 anos.", true, "Matemática", 3
        ));

        Collections.shuffle(perguntas);
    }

    public List<Question> getPerguntasPorDificuldade(int dificuldade) {
        List<Question> filtradas = new ArrayList<>();
        for (Question q : perguntas) {
            if (q.getDificuldade() == dificuldade) {
                filtradas.add(q);
            }
        }
        return filtradas;
    }

    public List<Question> getTodasPerguntas() {
        return perguntas;
    }
}