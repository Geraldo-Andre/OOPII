import java.time.LocalDate;
import java.util.Random;

/**
 * Classe que representa um jogador de futebol.
 */
public class Jogador {
    private int id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private int numero;
    private String posicao;
    private int qualidade;
    private int cartoesAmarelos;
    private int cartoesVermelhos;
    private boolean suspenso;
    private boolean treinouAntesPartida;

    /**
     * Construtor da classe Jogador.
     *
     * @param id             Identificador do jogador.
     * @param nome           Nome do jogador.
     * @param apelido        Apelido do jogador.
     * @param dataNascimento Data de nascimento do jogador.
     * @param numero         Número do jogador.
     * @param posicao        Posição do jogador em campo.
     * @param qualidade      Qualidade do jogador (0 a 100).
     */
    public Jogador(int id, String nome, String apelido, LocalDate dataNascimento, int numero, String posicao, int qualidade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
        this.suspenso = false;
        this.treinouAntesPartida = false;
    }

    /**
     * Obtém o ID do jogador.
     *
     * @return ID do jogador.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do jogador.
     *
     * @return Nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o apelido do jogador.
     *
     * @return Apelido do jogador.
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * Obtém a data de nascimento do jogador.
     *
     * @return Data de nascimento do jogador.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Obtém o número do jogador.
     *
     * @return Número do jogador.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtém a posição do jogador.
     *
     * @return Posição do jogador.
     */
    public String getPosicao() {
        return posicao;
    }

    /**
     * Obtém a qualidade do jogador.
     *
     * @return Qualidade do jogador.
     */
    public int getQualidade() {
        return qualidade;
    }

    /**
     * Obtém a quantidade de cartões amarelos recebidos pelo jogador.
     *
     * @return Quantidade de cartões amarelos.
     */
    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    /**
     * Obtém a quantidade de cartões vermelhos recebidos pelo jogador.
     *
     * @return Quantidade de cartões vermelhos.
     */
    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    /**
     * Verifica se o jogador está suspenso.
     *
     * @return true se o jogador está suspenso, false caso contrário.
     */
    public boolean isSuspenso() {
        return suspenso;
    }

    /**
     * Verifica se o jogador treinou antes da partida.
     *
     * @return true se o jogador treinou antes da partida, false caso contrário.
     */
    public boolean isTreinouAntesPartida() {
        return treinouAntesPartida;
    }

    /**
     * Define se o jogador treinou antes da partida.
     *
     * @param treinouAntesPartida true se o jogador treinou antes da partida, false caso contrário.
     */
    public void setTreinouAntesPartida(boolean treinouAntesPartida) {
        this.treinouAntesPartida = treinouAntesPartida;
    }

    /**
     * Verifica se o jogador está apto para jogar.
     *
     * @return true se o jogador está apto para jogar, false caso contrário.
     */
    public boolean aptoParaJogar() {
        return !suspenso;
    }

    /**
     * Aplica cartões amarelos ao jogador e verifica se ele deve ser suspenso.
     *
     * @param quantidade Quantidade de cartões amarelos a serem aplicados.
     */
    public void aplicarCartaoAmarelo(int quantidade) {
        this.cartoesAmarelos += quantidade;
        if (this.cartoesAmarelos >= 3) {
            this.suspenso = true;
        }
    }

    /**
     * Aplica um cartão vermelho ao jogador, suspendendo-o.
     */
    public void aplicarCartaoVermelho() {
        this.cartoesVermelhos += 1;
        this.suspenso = true;
    }

    /**
     * Suspende o jogador por decisão do tribunal.
     */
    public void suspenderPorDecisaoTribunal() {
        this.suspenso = true;
    }

    /**
     * Cumpre a suspensão do jogador, resetando os cartões amarelos e vermelhos e removendo a suspensão.
     */
    public void cumprirSuspensao() {
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
        this.suspenso = false;
    }

    /**
     * Simula o jogador sofrendo uma lesão, que diminui sua qualidade.
     */
    public void sofrerLesao() {
        Random random = new Random();
        int probabilidade = random.nextInt(100) + 1;
        int decremento = 0;

        if (probabilidade <= 5) {
            decremento = (int) (this.qualidade * 0.15);
        } else if (probabilidade <= 15) {
            decremento = (int) (this.qualidade * 0.10);
        } else if (probabilidade <= 30) {
            decremento = (int) (this.qualidade * 0.05);
        } else if (probabilidade <= 60) {
            decremento = 2;
        } else {
            decremento = 1;
        }

        this.qualidade = Math.max(this.qualidade - decremento, 0);
    }

    /**
     * Executa o treinamento do jogador, aumentando sua qualidade.
     */
    public void executarTreinamento() {
        if (!this.treinouAntesPartida) {
            Random random = new Random();
            int probabilidade = random.nextInt(100) + 1;
            int incremento = 0;

            if (probabilidade <= 5) {
                incremento = 5;
            } else if (probabilidade <= 15) {
                incremento = 4;
            } else if (probabilidade <= 30) {
                incremento = 3;
            } else if (probabilidade <= 60) {
                incremento = 2;
            } else {
                incremento = 1;
            }

            this.qualidade = Math.min(this.qualidade + incremento, 100);
            this.treinouAntesPartida = true;
        }
    }

    /**
     * Reseta o status de treinamento do jogador, permitindo que ele possa treinar novamente antes da próxima partida.
     */
    public void resetarTreinamento() {
        this.treinouAntesPartida = false;
    }
}
