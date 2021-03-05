import java.util.*;

class BevShop {

    int numAlcoholDrinks;
    final int maxAlcoholDrinks = 3;
    ArrayList<Order> orders;
    final int minAge = 21;
    Order currentOrder;
    int orderCount;
    int MIN_TIME= 8;				//earliest time for the order
    int MAX_TIME= 23;				//latest  time for the order
    int MAX_FRUIT = 5;


    public BevShop() {
        orders = new ArrayList<Order>();
        orderCount = 0;
    }

    // return true if times is within the range of 8 to 23 , false otherwise
    public boolean validTime(int time) {
        if ((time <= MAX_TIME) && (time >= MIN_TIME)) {
            return true;
        }

        return false;
    }


        //checks if the number of alcohol beverages for the current order has reached the maximum
        public boolean eligibleForMore() {
            if (numAlcoholDrinks < maxAlcoholDrinks) {
                return true; }

            return false;
        }

        // check the valid age for the alcohol drink
        public  boolean validAge(int age) {
            if (age > minAge) {
                return true;
            }
            return false;
        }

        //Creates a new order ,  NO BEVERAGE is added to the order yet
        public void startNewOrder(int time,
                                  DAY day,
                                  String customerName,
                                  int customerAge) {
            orderCount++;
            currentOrder = new Order(orderCount, day, new Customer(customerName, customerAge));
            currentOrder.setOrderTime(time);
            orders.add(currentOrder);
            numAlcoholDrinks = 0;
        }

        // process the Coffee order for the current order by adding it to the current order
        public void processCoffeeOrder( String bevName,
                                        SIZE size,
                                        boolean extraShot,
                                        boolean extraSyrup ) {

            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
        }

        // process the Alcohol order for the current order by adding it to the current order
        public void  processAlcoholOrder( String bevName, SIZE size ) {
            currentOrder.addNewBeverage(bevName, size);
            numAlcoholDrinks++;
        }

        //process the Smoothie order for the current order  by adding it to the current order
        public void processSmoothieOrder( String bevName,
                                          SIZE size,
                                          int numOfFruits,
                                          boolean addProtien) {

            currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
        }

        //locate an order based on  the order number. return the index of the order in the list of Orders  if found or -1 if not found
        public int findOrder(int orderNo) {

            for (int i = 0; i < orders.size(); i++) {
                Order currOrder = orders.get(i);
                if (currOrder.getOrderNo() == orderNo) {
                    return i;
                }
            }

            return -1;
        }

        // locates an order in the list of orders and returns the total value on the order.
        public double totalOrderPrice(int orderNo) {
            int index = findOrder(orderNo);
            Order order = orders.get(index);
            return order.calcOrderTotal();
        }

        // Calculates the total sale of all the orders for this beverage shop
        public double totalMonthlySale() {
            double totalSale = 0;

            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                totalSale += order.calcOrderTotal();
            }

            return totalSale;
        }

        // sorts the orders within this bevShop using the Selection Sort Algorithm
        public void sortOrders() {
        	for (int i = 0; i < orders.size() - 1; i++)
        	{
        	int index = i;
        	for (int j = i + 1; j < orders.size(); j++) {
        	Order order1 = orders.get(j);
        	Order order2 = orders.get(index);
        	if (order1.compareTo(order2) == -1) {
        	index = j;
        	}
        	}
        	Order earlierOrder = orders.get(index);
        	orders.set(index, orders.get(i));
        	orders.set(i, earlierOrder);
        	}
        	}
    //returns Order in the list of orders at the index
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            str += order.toString();
        }

        str += "\n Total sales: " + totalMonthlySale();
        return str;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public int getMaxOrderForAlcohol() {
        return maxAlcoholDrinks;
    }

    public int getMinAgeForAlcohol() {
        return minAge;
    }

    public int getNumOfAlcoholDrink() {
        return numAlcoholDrinks;
    }

    public boolean isMaxFruit(int fruit) {
        if (fruit > MAX_FRUIT) {
            return true;
        }

        return false;
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }
}