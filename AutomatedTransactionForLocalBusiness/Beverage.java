abstract class Beverage {

    String beverageName;
    TYPE beverageType;
    SIZE beverageSize;
    final double basePrice = 2.0;
    final double sizePrice = 1.0;

    public Beverage(String name, TYPE type, SIZE size) {
        beverageName = name;
        beverageType = type;
        beverageSize = size;
    }

    abstract double calcPrice();

    @Override
    public String toString() {
        String bev = "";
        bev += "Beverage name: " + beverageName + ", size: " + beverageSize;
        return bev;
    }

    public boolean equals(Beverage other) {
        if ((other.beverageName == beverageName) && (other.beverageType == beverageType) && (other.beverageSize == beverageSize)){
            return true;
        }

        return false;
    }

    public TYPE getType() {
        return beverageType;
    }


    public double getBasePrice() {
        return this.basePrice;
    }

    public String getBevName() {
        return this.beverageName;
    }

    public SIZE getSize() {
        return this.beverageSize;
    }

}
