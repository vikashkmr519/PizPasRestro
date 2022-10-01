public class Pizza extends Food{
    private String pizzaSize;
    private String crustType;
    private String pizzaFlavor ;
    private String toppings;
    private int customerId;

    public Pizza(String pizzaSize, String crustType, String pizzaFlavor, String toppings, int customerId, int totalPrice) {
       super(totalPrice,Constants.PIZZA_ORDER_TYPE);
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.pizzaFlavor = pizzaFlavor;
        this.toppings = toppings;
        this.customerId = customerId;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public String getPizzaFlavor() {
        return pizzaFlavor;
    }

    public void setPizzaFlavor(String pizzaFlavor) {
        this.pizzaFlavor = pizzaFlavor;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


}
