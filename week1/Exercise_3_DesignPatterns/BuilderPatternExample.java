package com.Bharani.week1.Ex3;

    public class BuilderPatternExample {
        public static void main(String[] args) {
            // Create a high-end gaming computer
            Computer gamingComputer = new Computer.Builder()
                    .setCPU("Intel Core i9")
                    .setRAM("32GB")
                    .setStorage("1TB SSD")
                    .setGPU("NVIDIA GeForce RTX 3090")
                    .setMotherboard("ASUS ROG")
                    .setPowerSupply("850W")
                    .setCoolingSystem("Liquid Cooling")
                    .build();

            // Create a budget office computer
            Computer officeComputer = new Computer.Builder()
                    .setCPU("Intel Core i5")
                    .setRAM("16GB")
                    .setStorage("512GB SSD")
                    .build();

            // Print the configurations
            System.out.println("Gaming Computer: " + gamingComputer);
            System.out.println("Office Computer: " + officeComputer);
        }
    }
