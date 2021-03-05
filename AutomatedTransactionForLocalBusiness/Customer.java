class Customer {
    String customerName;
    int customerAge;

    public Customer(String name, int age) {
        customerName = name;
        customerAge = age;
    }

    // copy constructor
    Customer(Customer other) {
        customerName = other.customerName;
        customerAge = other.customerAge;
    }

    @Override
    public String toString() {
        String customer = "";
        customer += "Customer name: " + this.customerName + ", customer age: " + this.customerAge;
        return customer;
    }

    public String getName() {
        return customerName;
    }

    public int getAge() {
        return customerAge;
    }

    public void setAge(int age) {
        customerAge = age;
    }

    public void setName(String name) {
        customerName = name;
    }

}