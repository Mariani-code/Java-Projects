class Coffee extends Beverage {

    boolean extraShot;
    boolean extraSyrup;
    final double shotPrice = 0.5;
    final double syrupPrice = 0.5;

    public Coffee(String name, SIZE size, boolean shot, boolean syrup) {
        super(name, TYPE.COFFEE, size);
        extraShot = shot;
        extraSyrup = syrup;
    }

    @Override
    public String toString() {
        String bev = "";
        double price = calcPrice();
        bev += "Coffee name: " + this.beverageName + ", size: " + this.beverageSize + ", extra shot: " + extraShot + ", extra syrup: " + extraSyrup + ", price: " + price;
        return bev;
    }

    
    public boolean equals(Coffee other) {
        if (this.equals(other) && (extraShot == other.extraShot) && (extraSyrup == other.extraSyrup)){
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

        if (this.extraShot) {
            price += shotPrice;
        }

        if (this.extraSyrup) {
            price += syrupPrice;
        }

        return price;
    }

    
    public TYPE getType() {
        return this.beverageType;
    }

    public boolean getExtraShot() {return extraShot;}

    public boolean getExtraSyrup() {return extraSyrup;}
}