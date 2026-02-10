package app;

import enums.NivelAtividade;
import enums.Objetivo;
import model.*;
import service.GerenciamentoCalorico;
import service.RegistroArquivo;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Nome:");

        int idade = Integer.parseInt(
                JOptionPane.showInputDialog("Idade:")
        );

        double peso = Double.parseDouble(
                JOptionPane.showInputDialog("Peso (kg):")
        );

        double altura = Double.parseDouble(
                JOptionPane.showInputDialog("Altura (cm):")
        );

        char sexo = JOptionPane.showInputDialog("Sexo (M/F):")
                .toUpperCase().charAt(0);

        int opObjetivo = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Objetivo:\n1 - Emagrecer\n2 - Manter\n3 - Ganhar"
                )
        );

        Objetivo objetivo = switch (opObjetivo) {
            case 1 -> Objetivo.EMAGRECER;
            case 2 -> Objetivo.MANTER;
            default -> Objetivo.GANHAR;
        };

        int opAtividade = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Nivel de atividade:\n1 - Sedentario\n2 - Leve\n3 - Moderado\n4 - Intenso"
                )
        );

        NivelAtividade atividade = switch (opAtividade) {
            case 1 -> NivelAtividade.SEDENTARIO;
            case 2 -> NivelAtividade.LEVE;
            case 3 -> NivelAtividade.MODERADO;
            default -> NivelAtividade.INTENSO;
        };

        Usuario usuario = new Usuario(
                nome, idade, peso, altura, sexo, objetivo, atividade
        );

        GerenciamentoCalorico sistema = new GerenciamentoCalorico();

        JOptionPane.showMessageDialog(null,
                "Meta diaria de calorias: " +
                        String.format("%.0f", usuario.getMetaCalorias()) + " kcal"
        );

        while (!sistema.metaAtingida(usuario.getMetaCalorias())) {

            String nomeAlimento = JOptionPane.showInputDialog("Alimento:");
            double cal100 = Double.parseDouble(
                    JOptionPane.showInputDialog("Calorias por 100g:")
            );
            double gramas = Double.parseDouble(
                    JOptionPane.showInputDialog("Gramas consumidas:")
            );

            Alimento alimento = new Alimento(nomeAlimento, cal100);
            ConsumoAlimento consumo = new ConsumoAlimento(alimento, gramas);

            sistema.adicionarConsumo(consumo);


            RegistroArquivo.salvarTxt(usuario, consumo);
            RegistroArquivo.salvarCsv(usuario, consumo);

            JOptionPane.showMessageDialog(null,
                    "Consumido: " +
                            String.format("%.0f", consumo.getCaloriasConsumidas()) + " kcal\n" +
                            "Restante: " +
                            String.format("%.0f",
                                    sistema.getRestante(usuario.getMetaCalorias())) + " kcal"
            );
        }

        JOptionPane.showMessageDialog(null,
                "Meta diaria atingida!"
        );
    }
}
