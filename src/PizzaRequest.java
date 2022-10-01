public class PizzaRequest extends OrderRequest {

    private String pizzaSize;
    private String crustType;
    private String pizzaFlavor ;
    private String toppings;


    public  PizzaRequest(String pizzaSize, String crustType,String pizzaFlavor,String toppings ){
        super(Constants.PIZZA_ORDER_TYPE);
        this.crustType=crustType;
        this.pizzaFlavor=pizzaFlavor;
        this.pizzaSize=pizzaSize;
        this.toppings=toppings;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public String getCrustType() {
        return crustType;
    }

    public String getPizzaFlavor() {
        return pizzaFlavor;
    }

    public String getToppings() {
        return toppings;
    }
}
