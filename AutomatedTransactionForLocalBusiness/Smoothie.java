class Smoothie extends Beverage {

    int fruits;
    boolean proteinPowder;
    final double proteinCost = 1.5;
    final double fruitCost = 0.5;

    public Smoothie(String name, SIZE size, int fruitNum, boolean protein) {
        super(name, TYPE.SMOOTHIE, size);
        fruits = fruitNum;
        proteinPowder = protein;
    }

    @Override
    public String toString() {
        String bev = "";
        double price = calcPrice();
        bev += "Smoothie name: " + this.beverageName + ", size: " + this.beverageSize + ", protein added: " + proteinPowder + ", number of fruits: " + fruits + ", price: " + price;
        return bev;
    }

    
    public boolean equals(Smoothie other) {
        if (this.equals(other) && (fruits == other.fruits) && (proteinPowder == other.proteinPowder)){
            return true;
        }

        return false;
    }

    @Override
    public double calcPrice() {
        double price = this.basePrice;

        if (this.beverageSize == SIZE.MEDIUM) {
            price += this.sizePrice;
        }

        if (this.beverageSize == SIZE.LARGE) {
            price += this.sizePrice + this.sizePrice;
        }

        if (this.proteinPowder) {
            price += proteinCost;
        }

        for (int i = 0; i < fruits; i++) {
            price += fruitCost;
        }

        return price;
    }

    
    public TYPE getType() {
        return this.beverageType;
    }

    public int getNumOfFruits() {
        return fruits;
    }

    public boolean getAddProtien() {
        return proteinPowder;
    }
}
