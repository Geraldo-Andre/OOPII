import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Classe que representa um jogo de futebol entre duas equipes.
 */
public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private LocalDate dataDoJogo;
    private String estadio;
    private String cidade;
    private int placarMandante;
    private int placarVisitante;

    public int getPlacarMandante() {
        return placarMandante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    /**
     * Construtor padrão da classe Jogo.
     */
    public Jogo() {
    }

    /**
     * Construtor da classe Jogo com todos os atributos.
     *
     * @param mandante      Equipe mandante.
     * @param visitante     Equipe visitante.
     * @param dataDoJogo    Data do jogo.
     * @param estadio       Estádio onde o jogo será realizado.
     * @param cidade        Cidade onde o jogo será realizado.
     * @param placarMandante Placar da equipe mandante.
     * @param placarVisitante Placar da equipe visitante.
     */
    public Jogo(Equipa mandante, Equipa visitante, LocalDate dataDoJogo, String estadio, String cidade, int placarMandante, int placarVisitante) {
        this.mandante = mandante;
        this.visitante = visitante;
        this.dataDoJogo = dataDoJogo;
        this.estadio = estadio;
        this.cidade = cidade;
        this.placarMandante = placarMandante;
        this.placarVisitante = placarVisitante;
    }

    /**
     * Gera um resultado aleatório para o jogo baseado na qualidade dos titulares.
     */
    public void gerarResultado() {
        int qualidadeMandante = mandante.getQualidadeTotalTitulares();
        int qualidadeVisitante = visitante.getQualidadeTotalTitulares();
        
        Random random = new Random();
        int resultado = random.nextInt(100);

        if (resultado < 50) {
            if (qualidadeMandante > qualidadeVisitante) {
                placarMandante = random.nextInt(3) + 1; // 1 a 3 gols
                placarVisitante = random.nextInt(2); // 0 a 1 gol
            } else {
                placarMandante = random.nextInt(2); // 0 a 1 gol
                placarVisitante = random.nextInt(3) + 1; // 1 a 3 gols
            }
        } else if (resultado < 80) {
            if (qualidadeMandante < qualidadeVisitante) {
                placarMandante = random.nextInt(3) + 1; // 1 a 3 gols
                placarVisitante = random.nextInt(2); // 0 a 1 gol
            } else {
                placarMandante = random.nextInt(2); // 0 a 1 gol
                placarVisitante = random.nextInt(3) + 1; // 1 a 3 gols
            }
        } else {
            placarMandante = random.nextInt(2); // 0 a 1 gol
            placarVisitante = random.nextInt(2); // 0 a 1 gol
        }
    }

    /**
     * Gera aleatoriamente de 0 a 2 lesões por jogo.
     */
    public void gerarLesoes() {
        Random random = new Random();
        int numLesoes = random.nextInt(3); // 0 a 2 lesões

        for (int i = 0; i < numLesoes; i++) {
            boolean isMandante = random.nextBoolean();
            Equipa equipe = isMandante ? mandante : visitante;
            List<Jogador> jogadores = equipe.getPlantel();

            int jogadorIndex = random.nextInt(jogadores.size());
            Jogador jogador = jogadores.get(jogadorIndex);
            jogador.sofrerLesao();
        }
    }

    /**
     * Gera aleatoriamente de 0 a 10 cartões por jogo.
     */
    public void gerarCartoes() {
        Random random = new Random();
        int numCartoes = random.nextInt(11); // 0 a 10 cartões

        for (int i = 0; i < numCartoes; i++) {
            boolean isMandante = random.nextBoolean();
            Equipa equipe = isMandante ? mandante : visitante;
            List<Jogador> jogadores = equipe.getPlantel();

            int jogadorIndex = random.nextInt(jogadores.size());
            Jogador jogador = jogadores.get(jogadorIndex);
            jogador.aplicarCartaoAmarelo(1);

            if (random.nextBoolean()) { // 50% de chance de aplicar um segundo cartão
                jogador.aplicarCartaoAmarelo(1);
            }

            if (jogador.getCartoesAmarelos() >= 2) {
                jogador.aplicarCartaoVermelho();
            }
        }
    }

    /**
     * Permite que todos os jogadores possam treinar novamente após a conclusão do jogo.
     */
    public void permitirTreinamento() {
        mandante.getPlantel().forEach(Jogador::resetarTreinamento);
        visitante.getPlantel().forEach(Jogador::resetarTreinamento);
    }
}
