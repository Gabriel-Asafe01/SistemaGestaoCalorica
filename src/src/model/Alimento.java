package model;

public class Alimento {

    private String nome;
    private double caloriasPor100g;

    public Alimento(String nome, double caloriasPor100g) {
        this.nome = nome;
        this.caloriasPor100g = caloriasPor100g;
    }

    public double calcularCalorias(double gramas) {
        return (gramas * caloriasPor100g) / 100;
    }

    public String getNome() {
        return nome;
    }
}
