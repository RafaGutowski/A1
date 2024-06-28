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

            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                int matricula = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                double nota = Double.parseDouble(dados[2].trim());

                Aluno aluno = new Aluno(matricula, nome, nota);
                listaDeAlunos.add(aluno);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return listaDeAlunos;
    }
}


