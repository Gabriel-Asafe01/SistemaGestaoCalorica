package model;

import enums.Objetivo;
import enums.NivelAtividade;

public class Usuario {

    private String nome;
    private int idade;
    private double pesoKg;
    private double alturaCm;
    private char sexo;
    private Objetivo objetivo;
    private NivelAtividade atividade;
    private double metaCalorias;

    public Usuario(String nome, int idade, double pesoKg, double alturaCm,
                   char sexo, Objetivo objetivo, NivelAtividade atividade) {

        this.nome = nome;
        this.idade = idade;
        this.pesoKg = pesoKg;
        this.alturaCm = alturaCm;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.atividade = atividade;

        calcularMetaCalorias();
    }

    private void calcularMetaCalorias() {
        double tmb;

        if (sexo == 'M') {
            tmb = (10 * pesoKg) + (6.25 * alturaCm) - (5 * idade) + 5;
        } else {
            tmb = (10 * pesoKg) + (6.25 * alturaCm) - (5 * idade) - 161;
        }

        metaCalorias = (tmb * atividade.getFator()) + objetivo.getAjusteCalorico();
    }

    public String getNome() {
        return nome;
    }

    public double getMetaCalorias() {
        return metaCalorias;
    }
}
