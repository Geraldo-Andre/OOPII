import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que representa uma equipe de futebol.
 */
public class Equipa {
    private String nome;
    private String apelido;
    private LocalDate fundacao;
    private List<Jogador> plantel;

    /**
     * Construtor da classe Equipa.
     *
     * @param nome      Nome da equipe.
     * @param apelido   Apelido da equipe.
     * @param fundacao  Data de fundação da equipe.
     */
    public Equipa(String nome, String apelido, LocalDate fundacao) {
        this.nome = nome;
        this.apelido = apelido;
        this.fundacao = fundacao;
        this.plantel = new ArrayList<>();
    }
    /**
     * Obtém o plantel da equipe.
     *
     * @return O plantel da equipe.
     */
    public List<Jogador> getPlantel() {
        return plantel;
    }

    /**
     * Define o plantel da equipe.
     *
     * @param plantel O novo plantel da equipe.
     */
    public void setPlantel(List<Jogador> plantel) {
        this.plantel = plantel;
    }

    /**
     * Adiciona um jogador ao plantel da equipe.
     *
     * @param jogador O jogador a ser adicionado.
     */
    public void adicionarJogador(Jogador jogador) {
        this.plantel.add(jogador);
    }

    /**
     * Imprime o plantel da equipe, mostrando quem está apto a jogar.
     */
    public void imprimirPlantel() {
        System.out.println("Jogadores Cadastrados:");
        plantel.forEach(jogador -> {
            String condicao = jogador.aptoParaJogar() ? "Apto" : "Suspenso";
            System.out.println(jogador.getPosicao() + ": " + jogador.getId() + " " + jogador.getNome() + " " +
                    jogador.getApelido() + " " + jogador.getDataNascimento() + " " + condicao);
        });
    }

    /**
     * Relaciona os 18 jogadores para a partida, sendo 11 titulares e 7 reservas, com base na qualidade.
     * Os 11 titulares são os melhores em suas posições e os 7 reservas são os próximos melhores jogadores.
     */
    public void relacionarJogadores() {
        List<Jogador> relacionados = plantel.stream()
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(18)
                .collect(Collectors.toList());

        List<Jogador> titulares = relacionados.subList(0, 11);
        List<Jogador> reservas = relacionados.subList(11, 18);

        System.out.println("Titulares:");
        titulares.forEach(jogador -> System.out.println(jogador.getNome() + " - Qualidade: " + jogador.getQualidade()));

        System.out.println("Reservas:");
        reservas.forEach(jogador -> System.out.println(jogador.getNome() + " - Qualidade: " + jogador.getQualidade()));
    }

    /**
     * Relaciona os 11 melhores jogadores para a partida com base na qualidade.
     */
    public void relacionarMelhoresJogadores() {
        List<Jogador> melhores = plantel.stream()
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(11)
                .collect(Collectors.toList());

        System.out.println("Melhores Jogadores:");
        melhores.forEach(jogador -> System.out.println(jogador.getNome() + " - Qualidade: " + jogador.getQualidade()));
    }

    /**
     * Imprime as escalações dos titulares e reservas.
     */
    public void imprimirEscalacao() {
        List<Jogador> relacionados = plantel.stream()
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(18)
                .collect(Collectors.toList());

        List<Jogador> titulares = relacionados.subList(0, 11);
        List<Jogador> reservas = relacionados.subList(11, 18);

        System.out.println("Escalação:");
        System.out.println("Titulares:");
        titulares.forEach(jogador -> System.out.println(jogador.getNome() + " - Qualidade: " + jogador.getQualidade()));

        System.out.println("Reservas:");
        reservas.forEach(jogador -> System.out.println(jogador.getNome() + " - Qualidade: " + jogador.getQualidade()));
    }
    /**
     * Obtém a soma da qualidade dos jogadores titulares.
     *
     * @return Soma da qualidade dos titulares.
     */
    public int getQualidadeTotalTitulares() {
        return plantel.stream()
                .sorted(Comparator.comparingInt(Jogador::getQualidade).reversed())
                .limit(11)
                .mapToInt(Jogador::getQualidade)
                .sum();

    }
}

