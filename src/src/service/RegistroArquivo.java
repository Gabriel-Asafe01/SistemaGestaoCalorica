package service;

import model.ConsumoAlimento;
import model.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroArquivo {

    private static final String CAMINHO =
            System.getProperty("user.dir") + File.separator + "historico";

    private static void criarPasta() {
        File pasta = new File(CAMINHO);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    public static void salvarTxt(Usuario usuario, ConsumoAlimento consumo) {
        criarPasta();

        File arquivo = new File(CAMINHO + File.separator + "registro.txt");

        try (FileWriter writer = new FileWriter(arquivo, true)) {

            writer.write("Meta diária: " + usuario.getMetaCalorias() + " kcal\n");
            writer.write("Consumido: " + consumo.getCaloriasConsumidas() + " kcal\n");
            writer.write("----------------------------------\n");

            System.out.println("Arquivo TXT salvo em: " + arquivo.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarCsv(Usuario usuario, ConsumoAlimento consumo) {
        criarPasta();

        File arquivo = new File(CAMINHO + File.separator + "registro.csv");

        boolean existe = arquivo.exists();

        try (FileWriter writer = new FileWriter(arquivo, true)) {

            if (!existe) {
                writer.write("MetaCalorias,Consumido\n");
            }

            writer.write(
                    usuario.getMetaCalorias() + "," +
                            consumo.getCaloriasConsumidas() + "\n"
            );

            System.out.println("Arquivo CSV salvo em: " + arquivo.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
