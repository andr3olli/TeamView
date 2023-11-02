package model;

public class Contract {
    private String contractType;
    private int contractDuration; // in months
    private double salary;

    // Constructor
    public Contract(String contractType, int contractDuration, double salary) {
        this.contractType = contractType;
        this.contractDuration = contractDuration;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractType='" + contractType + '\'' +
                ", contractDuration=" + contractDuration +
                ", salary=" + salary +
                '}';
    }
}
