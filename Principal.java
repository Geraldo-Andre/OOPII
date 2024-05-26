import java.time.LocalDate;
import java.util.Random;
public class Principal {
   
    public static void main(String[] args) {
        // Testando métodos da classe Jogador
        Jogador jogador1 = new Jogador(1, "Jogador 1", "Apelido 1", LocalDate.of(1990, 1, 1), 10, "Atacante", 80);
        Jogador jogador2 = new Jogador(2, "Jogador 2", "Apelido 2", LocalDate.of(1992, 2, 2), 20, "Defensor", 85);
        
        System.out.println("Testando métodos da classe Jogador:");
        System.out.println("Jogador 1 - Nome: " + jogador1.getNome() + ", Qualidade: " + jogador1.getQualidade());
        System.out.println("Jogador 2 - Nome: " + jogador2.getNome() + ", Qualidade: " + jogador2.getQualidade());
        
        jogador1.aplicarCartaoAmarelo(1);
        jogador1.aplicarCartaoAmarelo(2); // Deve suspender o jogador
        
        System.out.println("Jogador 1 - Cartões Amarelos: " + jogador1.getCartoesAmarelos() + ", Suspenso: " + jogador1.isSuspenso());
        
        jogador2.aplicarCartaoVermelho();
        System.out.println("Jogador 2 - Cartões Vermelhos: " + jogador2.getCartoesVermelhos() + ", Suspenso: " + jogador2.isSuspenso());
        
        jogador1.cumprirSuspensao();
        System.out.println("Jogador 1 - Após cumprir suspensão - Cartões Amarelos: " + jogador1.getCartoesAmarelos() + ", Suspenso: " + jogador1.isSuspenso());
        
        jogador1.sofrerLesao();
        System.out.println("Jogador 1 - Após lesão - Qualidade: " + jogador1.getQualidade());
        
        jogador1.executarTreinamento();
        System.out.println("Jogador 1 - Após treinamento - Qualidade: " + jogador1.getQualidade());
        
        jogador1.resetarTreinamento();
        System.out.println("Jogador 1 - Treinamento resetado - Pode treinar: " + !jogador1.isTreinouAntesPartida());
        
        // Testando métodos da classe Equipa
        Equipa equipa1 = new Equipa("Equipe A", "A", LocalDate.of(1900, 1, 1));
        Equipa equipa2 = new Equipa("Equipe B", "B", LocalDate.of(1900, 1, 1));
        
        Random random = new Random();

        // Adicionando 23 jogadores a cada equipe
        for (int i = 1; i <= 23; i++) {
            Jogador jogadorA = new Jogador(i, "JogadorA" + i, "ApelidoA" + i, LocalDate.of(2000, random.nextInt(12) + 1, random.nextInt(28) + 1), i, "Posicao" + (i % 4), 50 + random.nextInt(51));
            Jogador jogadorB = new Jogador(i + 23, "JogadorB" + i, "ApelidoB" + i, LocalDate.of(2000, random.nextInt(12) + 1, random.nextInt(28) + 1), i, "Posicao" + (i % 4), 50 + random.nextInt(51));
            equipa1.adicionarJogador(jogadorA);
            equipa2.adicionarJogador(jogadorB);
        }

        // Imprimir plantel das equipes
        System.out.println("\nEquipe 1 Plantel:");
        equipa1.imprimirPlantel();
        
        System.out.println("\nEquipe 2 Plantel:");
        equipa2.imprimirPlantel();

        // Relacionar jogadores para a partida e imprimir escalações
        System.out.println("\nRelacionar Jogadores e Imprimir Escalação Equipe 1:");
        equipa1.relacionarJogadores();
        equipa1.imprimirEscalacao();

        System.out.println("\nRelacionar Jogadores e Imprimir Escalação Equipe 2:");
        equipa2.relacionarJogadores();
        equipa2.imprimirEscalacao();
        
        // Relacionar os 11 melhores jogadores
        System.out.println("\nRelacionar Melhores Jogadores Equipe 1:");
        equipa1.relacionarMelhoresJogadores();

        System.out.println("\nRelacionar Melhores Jogadores Equipe 2:");
        equipa2.relacionarMelhoresJogadores();

        ///////////////////////////////////////////////////////////////////

        // Criação de duas equipes com 23 jogadores cada

        // Criação de um jogo
        Jogo jogo = new Jogo(equipa1, equipa2, LocalDate.of(1900, 1, 1), "Estádio Municipal", "Cidade X", 0, 0);

        // Gerar resultado
        jogo.gerarResultado();
        System.out.println("Resultado do jogo:");
        System.out.println("Placar Mandante: " + jogo.getPlacarMandante());
        System.out.println("Placar Visitante: " + jogo.getPlacarVisitante());

        // Gerar lesões
        jogo.gerarLesoes();
        System.out.println("Lesões geradas.");
        System.out.println("\nEquipe 1 Plantel:");
        equipa1.imprimirPlantel();

        // Gerar cartões
        jogo.gerarCartoes();
        System.out.println("Cartões gerados.");
        System.out.println("\nEquipe 1 Plantel:");
        equipa1.imprimirPlantel();

        // Permitir treinamento
        jogo.permitirTreinamento();
        System.out.println("Treinamento permitido.");
        System.out.println("\nEquipe 1 Plantel:");
        equipa1.imprimirPlantel();

        ////////////////////////////////////////////////////////////////////////////

        // Imprimir plantel das equipes
        System.out.println("\nEquipe 1 Plantel:");
        equipa1.imprimirPlantel();
        
        System.out.println("\nEquipe 2 Plantel:");
        equipa2.imprimirPlantel();

        // Relacionar jogadores para a partida e imprimir escalações
        System.out.println("\nRelacionar Jogadores e Imprimir Escalação Equipe 1:");
        equipa1.relacionarJogadores();
        equipa1.imprimirEscalacao();

        System.out.println("\nRelacionar Jogadores e Imprimir Escalação Equipe 2:");
        equipa2.relacionarJogadores();
        equipa2.imprimirEscalacao();
        
        // Relacionar os 11 melhores jogadores
        System.out.println("\nRelacionar Melhores Jogadores Equipe 1:");
        equipa1.relacionarMelhoresJogadores();

        System.out.println("\nRelacionar Melhores Jogadores Equipe 2:");
        equipa2.relacionarMelhoresJogadores();
    }
}

