import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Resumo {
    public void criarArquivoDeResumo(String arquivo, List<Aluno> alunos) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write("Matrícula, Nome, Nota, Situação\n");

            for (Aluno aluno : alunos) {
        
                double media = aluno.getNota();

                String situacao = (media >= 6.0) ? "Aprovado" : "Reprovado";

                fw.write(aluno.getMatricula() + "," + aluno.getNome() + "," + aluno.getNota() + "," + situacao + "\n");
            }

            System.out.println("Arquivo de resumo CSV criado com sucesso: " + arquivo);

        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo de resumo CSV: " + e.getMessage());
        }
    }
}
