package service;

import model.ConsumoAlimento;

public class GerenciamentoCalorico {

    private double caloriasConsumidas = 0;

    public void adicionarConsumo(ConsumoAlimento consumo) {
        caloriasConsumidas += consumo.getCaloriasConsumidas();
    }

    public double getRestante(double meta) {
        double restante = meta - caloriasConsumidas;
        return Math.max(restante, 0);
    }

    public boolean metaAtingida(double meta) {
        return caloriasConsumidas >= meta;
    }
}
