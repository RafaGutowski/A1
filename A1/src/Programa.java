import java.util.List;

public class Programa {
public static void main(String[] args) {

        System.out.println("\n--- Prova A1 ---");

        Gerenciador gArquivos = new Gerenciador();

        List<Aluno> listaAlunos;
        listaAlunos = gArquivos.getAlunos();

        System.out.println("\nLista de Alunos: ");

        if (listaAlunos.size() == 0) {
            System.out.println("Não há Alunos cadastrados");
        } else {
            System.out.println(listaAlunos.toString());
        }

        if (gArquivos.gravarAlunoLista(listaAlunos) == true) {
            System.out.println("Arquivo Gravado com sucesso!");
        } else {
            System.out.println("Falha ao gravar arquivo");
        }

    }

}
