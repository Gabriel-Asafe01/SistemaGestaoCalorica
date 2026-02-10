package model;

public class ConsumoAlimento {

    private Alimento alimento;
    private double gramas;

    public ConsumoAlimento(Alimento alimento, double gramas) {
        this.alimento = alimento;
        this.gramas = gramas;
    }

    public double getCaloriasConsumidas() {
        return alimento.calcularCalorias(gramas);
    }
}
