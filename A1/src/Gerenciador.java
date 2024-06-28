import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {
    private String arquivoAlunos = "C:\\Users\\autologon\\Documents\\GitHub\\A1\\A1\\src\\alunos.csv";
    private String arquivoResumo = "C:\\Users\\autologon\\Documents\\GitHub\\A1\\A1\\src\\resumo.csv";

    public List<Aluno> getAlunos() {
        List<Aluno> listaDeAlunos = new ArrayList<>();

        try (Scanner leitor = new Scanner(new File(arquivoAlunos))) {

            if (leitor.hasNextLine()) {
                leitor.nextLine();
            }
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String dados[] = linha.split(";");

                String matricula = dados[0];
                String nome = dados[1];
                String nota = dados[2];

                Aluno aluno = new Aluno(matricula, nome, nota);
                listaDeAlunos.add(aluno);

            }
        } catch (Exception e) {
            System.out.println("Arquivo de alunos não encontrado! " + e.getMessage());
        }

        return listaDeAlunos;
    }

    private int calcularAlunos(List<Aluno> alunos) {
        return alunos.size();
    }

    private int calcularAprovados(List<Aluno> alunos) {
        int count = 0;
        for (Aluno aluno : alunos) {
            if (Double.parseDouble(String.valueOf(aluno.getNota()).replace(",", ".")) >= 6.0) {
                count++;
            }
        }
        return count;
    }

    private int Reprovados(List<Aluno> alunos) {
        int count = 0;
        for (Aluno aluno : alunos) {
            if (Double.parseDouble(aluno.getNota().replace(",", ".")) < 6.0) {
                count++;
            }
        }
        return count;
    }

    private double MenorNota(List<Aluno> alunos) {
        double menorNota = Double.MAX_VALUE;
        for (Aluno aluno : alunos) {
            double nota = Double.parseDouble(aluno.getNota().replace(",", "."));
            if (nota < menorNota) {
                menorNota = nota;
            }
        }
        return menorNota;
    }

    private double MaiorNota(List<Aluno> alunos) {
        double maiorNota = Double.MIN_VALUE;
        for (Aluno aluno : alunos) {
            double nota = Double.parseDouble(aluno.getNota().replace(",", "."));
            if (nota > maiorNota) {
                maiorNota = nota;
            }
        }
        return maiorNota;
    }

    private double MediaGeral(List<Aluno> alunos) {
        double soma = 0.0;
        for (Aluno aluno : alunos) {
            soma += Double.parseDouble(aluno.getNota().replace(",", "."));
        }
        return soma / alunos.size();
    }

    public boolean gravarAlunoLista(List<Aluno> alunos) {
        try {
            FileWriter arquivoGravar = new FileWriter(arquivoResumo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            int TotalAlunos = calcularAlunos(alunos);
            int TotalAprovados = calcularAprovados(alunos);
            int TotalReprovados = Reprovados(alunos);
            double menorNota = MenorNota(alunos);
            double maiorNota = MaiorNota(alunos);
            double mediaGeral = MediaGeral(alunos);

            gravador.println(
                    "TotalAlunos; quantidadeAprovado;TotalReprovados;menorNota;maiorNota;mediaGeral");
            gravador.println(
                    TotalAlunos + "; " +
                            TotalAprovados + "; " +
                            TotalReprovados + "; " +
                            menorNota + "; " +
                            maiorNota + "; " +
                            mediaGeral);

            gravador.close();
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
        return false;
    }
}
