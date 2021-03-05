class Alcohol extends Beverage {

    boolean offeredOnWeekend;
    final double additionalWeekendCost = 0.6;

    public Alcohol(String name, SIZE size, boolean weekend) {
        super(name, TYPE.ALCOHOL, size);
        offeredOnWeekend = weekend;
    }

    @Override
    public String toString() {
        String bev = "";
        double price = calcPrice();
        bev += "Alcohol name: " + this.beverageName + ", size: " + this.beverageSize + ", offered on weekend: " + this.offeredOnWeekend + ", price: " + price;
        return bev;
    }

    public boolean equals(Alcohol other) {
        if (this.equals(other) && (this.offeredOnWeekend == other.offeredOnWeekend)) {
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

        if (this.offeredOnWeekend) {
            price += additionalWeekendCost;
        }

        return price;
    }

    public TYPE getType() {
        return this.beverageType;
    }

}