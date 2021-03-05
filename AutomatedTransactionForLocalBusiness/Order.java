import java.util.*;

class Order {
    int orderNumber;
    int orderTime;
    DAY orderDay;
    Customer customer;
    ArrayList<Beverage> beverages;


    public Order(int number, DAY day, Customer c) {
        orderNumber = number;
        orderDay = day;
        customer = c;
        beverages = new ArrayList<Beverage>();
    }

    public int randomNumber() {
        int maximum = 90000;
        int minimum = 10000;
        Random rand = new Random();
        int randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
        return randomNum;
    }

    //return true if the day is a weekend day (Saturday or Sunday)
    public boolean isWeekend() {
        if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
            return true;
        }
        return false;
    }

    // return the beverage listed in the itemNo of the order or null if not there
    public Beverage getBeverage(int itemNo) {
        if (itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }

        return null;
        }

    // add a coffee to this order
    public void  addNewBeverage(
                String bevName,
                SIZE size,
                boolean extraShot,
                boolean extraSyrup) {

        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        beverages.add(coffee);

    }

    // Add alcohol to the order
    public void  addNewBeverage( String bevName, SIZE size) {

        Alcohol alc = new Alcohol(bevName, size, isWeekend());
        beverages.add(alc);
    }

    // add smoothie to the order
    public void  addNewBeverage( String bevName,
                SIZE size,
                int numOfFruits,
                boolean addPRotien) {

        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addPRotien);
        beverages.add(smoothie);

    }


        //return total amount for this order
    public double calcOrderTotal() {

        double price = 0.0;

        for (int i = 0; i < beverages.size(); i++) {
            price += beverages.get(i).calcPrice();
        }

        return price;
    }
    // returns the number of beverages of same type in an order
    public int findNumOfBeveType(TYPE type) {
        int count = 0;

        for (int i = 0; i < beverages.size(); i++) {
            Beverage bev = beverages.get(i);
            if (bev.getType() == type) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        String beverageInfo = "";

        for (int i = 0; i < beverages.size(); i++) {
            beverageInfo += beverages.get(i).toString();
            beverageInfo += "\n";
        }

        return "Order number: " + this.orderNumber + ", time: " + this.orderTime + ", day: " + this.orderDay  + customer.toString() + "\nBeverage Info\n" + beverageInfo + "Order Total: $" + calcOrderTotal();
    }

    public Customer getCustomer() {
        Customer deepcopyCustomer = new Customer(this.customer);
        return deepcopyCustomer;
    }

    public void setOrderTime(int time) {
        orderTime = time;
    }

    public int compareTo(Order other) {
        if (orderNumber == other.orderNumber) {
            return 0;
        }

        else if (orderNumber < other.orderNumber) {
            return -1;
        }

        return 1;
    }
    public int getOrderNo() {
        return orderNumber;
    }

    public int getTotalItems() {
        return beverages.size();
    }

    public int getOrderTime() {return orderTime;}

    public DAY getOrderDay() {return orderDay;}
}