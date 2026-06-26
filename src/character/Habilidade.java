package character;

/**
 * Interface que define o contrato de habilidade especial (Super) de um personagem.
 */
public interface Habilidade {

    /**
     * Tenta ativar o super. Retorna true se foi ativado com sucesso, false se não está disponível.
     */
    boolean usarSuper();

    /**
     * Nome do super para exibição na interface.
     */
    String getNomeSuper();

    /**
     * Descrição do efeito do super.
     */
    String getDescricaoSuper();

    /**
     * Indica se o super está disponível para uso.
     */
    boolean isSuperDisponivel();

    /**
     * Registra um acerto: a cada 2 acertos após o uso do super, ele é recarregado.
     */
    void registrarAcerto();
}
