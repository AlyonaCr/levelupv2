package lesson1;

public class CoffeeMachine {
    private String brand;
    private double weight;
    private double power;
    private String typeOfCoffeeMachine;

    public CoffeeMachine(String brand, double weight, double power, String typeOfCoffeeMachine) {
        this.brand = brand;
        this.weight = weight;
        this.power = power;
        this.typeOfCoffeeMachine = typeOfCoffeeMachine;
    }



    public String concatString (){
        return brand + ", " + weight + ", " + power + ", " + typeOfCoffeeMachine;
    }
}