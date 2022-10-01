import java.util.HashMap;

public class Prices {

    private  HashMap<String,HashMap<String,Integer>> pizzaFlavour;
     private  HashMap<String,Integer> pastaFlavour;

    public Prices(){
        pizzaFlavour = new HashMap<>();
        fillPizzaFlavour();
        pastaFlavour = new HashMap<>();
        fillPastaFlavour();
    }

    public int getPriceOf(OrderRequest request){

        if(request.getOrderType().equals(Constants.PIZZA_ORDER_TYPE)) {
           PizzaRequest req = (PizzaRequest)request;
            int cost = 0;
            cost += pizzaFlavour.get(req.getPizzaFlavor()).get(req.getPizzaSize());
            if (req.getToppings() != null) {
                cost += 1;
            }
            return cost;
        }else {
            PastaRequest req = (PastaRequest) request;
            int  cost = 0;
            cost += pastaFlavour.get(req.getPastaFlavour());
            return cost;
        }
    }




   private  void fillPizzaFlavour(){

        HashMap<String,Integer> veg = fillVegPizza();
        pizzaFlavour.put(Constants.PIZZA_VEG_FLAVOUR,veg);
        HashMap<String,Integer> nonveg = fillNonVegPizza();
        pizzaFlavour.put(Constants.PIZZA_NON_VEG_FLAVOUR,nonveg);
        HashMap<String,Integer> vegan = fillVeganPizza();
        pizzaFlavour.put(Constants.PIZZA_VEGAN_FLAVOUR,vegan);
    }

    private  void fillPastaFlavour(){
        //sauces
        pastaFlavour.put(Constants.PASTA_WHITE_SAUCE_FLAVOUR,10);
        pastaFlavour.put(Constants.PASTA_RED_SAUCE_FLAVOUR, 20);
    }

    private  HashMap<String,Integer> fillVegPizza(){
       HashMap<String,Integer> map = new HashMap<>();
       map.put(Constants.PIZZA_SMALL_SIZE,20);
       map.put(Constants.PIZZA_MEDIUM_SIZE,40);
       map.put(Constants.PIZZA_LARGE_SIZE,60);
       return map;
    }

    private  HashMap<String,Integer> fillNonVegPizza(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put(Constants.PIZZA_SMALL_SIZE,15);
        map.put(Constants.PIZZA_MEDIUM_SIZE,30);
        map.put(Constants.PIZZA_LARGE_SIZE,45);
        return map;
    }

    private  HashMap<String,Integer> fillVeganPizza(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put(Constants.PIZZA_SMALL_SIZE,20);
        map.put(Constants.PIZZA_MEDIUM_SIZE,40);
        map.put(Constants.PIZZA_LARGE_SIZE,60);
        return map;
    }

}
