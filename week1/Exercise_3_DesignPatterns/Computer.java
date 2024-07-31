package com.Bharani.week1.Ex3;
    public class Computer {
        // Attributes of the Computer
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String motherboard;
        private String powerSupply;
        private String coolingSystem;

        // Private constructor to prevent direct instantiation
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.GPU = builder.GPU;
            this.motherboard = builder.motherboard;
            this.powerSupply = builder.powerSupply;
            this.coolingSystem = builder.coolingSystem;
        }

        // Getters for the attributes
        public String getCPU() {
            return CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public String getStorage() {
            return storage;
        }

        public String getGPU() {
            return GPU;
        }

        public String getMotherboard() {
            return motherboard;
        }

        public String getPowerSupply() {
            return powerSupply;
        }

        public String getCoolingSystem() {
            return coolingSystem;
        }

        // Static nested Builder class
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String GPU;
            private String motherboard;
            private String powerSupply;
            private String coolingSystem;

            // Methods to set each attribute
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGPU(String GPU) {
                this.GPU = GPU;
                return this;
            }

            public Builder setMotherboard(String motherboard) {
                this.motherboard = motherboard;
                return this;
            }

            public Builder setPowerSupply(String powerSupply) {
                this.powerSupply = powerSupply;
                return this;
            }

            public Builder setCoolingSystem(String coolingSystem) {
                this.coolingSystem = coolingSystem;
                return this;
            }

            // Method to build the Computer object
            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU +
                    ", motherboard=" + motherboard + ", powerSupply=" + powerSupply + ", coolingSystem=" + coolingSystem + "]";
        }
    }
