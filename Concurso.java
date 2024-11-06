import java.util.Scanner;

public class Concurso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quantidade de pessoas
        System.out.print("Digite a quantidade de pessoas: ");
        int N = scanner.nextInt();
        scanner.nextLine();

        // Coisas para armazenar os dados
        String[] nomes = new String[N];
        double[] notaEtapa1 = new double[N];
        double[] notaEtapa2 = new double[N];
        double[] medias = new double[N];

        // Dados das pessoas pro usuário digitar
        for (int i = 0; i < N; i++) {
            System.out.println("Digite os dados da pessoa " + (i + 1) + ":");

            // Nome
            System.out.print("Nome: ");
            nomes[i] = scanner.nextLine();

            // Notas (1 e 2)
            System.out.print("Nota da Etapa 1: ");
            notaEtapa1[i] = scanner.nextDouble();

            System.out.print("Nota da Etapa 2: ");
            notaEtapa2[i] = scanner.nextDouble();
            scanner.nextLine();

            // Média das notas 1 e 2
            medias[i] = (notaEtapa1[i] + notaEtapa2[i]) / 2;
        }

        // As mensagens que vai ser exibida
        System.out.println("\n### TABELA ###");
        for (int i = 0; i < N; i++) {
            System.out.printf("Nome da pessoa: %-20s| Notas: %.1f, %.1f | Média: %.2f\n",
                              nomes[i], notaEtapa1[i], notaEtapa2[i], medias[i]);
                              
        }

        // Códigos pras pessoas aprovadas
        int aprovadosCount = 0;
        double maiorMedia = -1;
        String nomeMaiorMedia = "";
        double somaMediasAprovados = 0;

        // Coisas pra gravar as pessoas aprovadas
        String[] aprovados = new String[N];
        int aprovadosIndex = 0;

        for (int i = 0; i < N; i++) { //Calculo gigante pra medir a maior média (pesquisar depois se tem como fazer isso mais otimizado)
            if (medias[i] >= 70) {
                aprovados[aprovadosIndex++] = nomes[i];
                aprovadosCount++;
                somaMediasAprovados += medias[i];
                if (medias[i] > maiorMedia) {
                    maiorMedia = medias[i];
                    nomeMaiorMedia = nomes[i];
                }
            }
        }

        // Exibindo os resultados
        System.out.println("\n### PESSOAS APROVADAS ###");
        if (aprovadosCount > 0) {
            for (int i = 0; i < aprovadosCount; i++) {
                System.out.println(aprovados[i]);
            }
            
            
            // Porcentagem de aprovação
            double porcentagemAprovacao = (aprovadosCount / (double) N) * 100;
            System.out.printf("Porcentagem de aprovação: %.1f %%\n", porcentagemAprovacao);

            // Nome da pessoa com maior média
            System.out.println("Maior média: " + nomeMaiorMedia);

            // Média das pessoas aprovadas
            double mediaAprovados = somaMediasAprovados / aprovadosCount;
            System.out.printf("Nota média dos aprovados: %.2f\n", mediaAprovados);
        } else {
            System.out.println("Não há candidatos aprovados.");
        }

        scanner.close();
    }
}

//oi professor :)