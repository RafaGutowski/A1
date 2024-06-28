import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraDeAlunos {

    public List<Aluno> lerArquivo(String arquivo) {
        List<Aluno> listaDeAlunos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Separar os dados da linha
                String[] dados = linha.split(",");

                // Converter para os tipos apropriados
                int matricula = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                double nota = Double.parseDouble(dados[2].trim());

                // Criar objeto Aluno e adicionar à lista
                Aluno aluno = new Aluno(matricula, nome, nota);
                listaDeAlunos.add(aluno);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return listaDeAlunos;
    }
}


