import java.util.HashMap;

public class Prices {

    static HashMap<String,HashMap<String,Integer>> pizzaFlavour;
    static HashMap<String,Integer> pastaFlavour;

    public Prices(){
        pizzaFlavour = new HashMap<>();
        fillPizzaFlavour();
        pastaFlavour = new HashMap<>();
        fillPastaFlavour();
    }

//    public static int getPriceOf(int foodType,OrderRequest order){
//
//    }


   private static void fillPizzaFlavour(){

        HashMap<String,Integer> veg = fillVegPizza();
        pizzaFlavour.put(Constants.PIZZA_VEG_FLAVOUR,veg);
        HashMap<String,Integer> nonveg = fillNonVegPizza();
        pizzaFlavour.put(Constants.PIZZA_NON_VEG_FLAVOUR,nonveg);
        HashMap<String,Integer> vegan = fillVeganPizza();
        pizzaFlavour.put(Constants.PIZZA_VEGAN_FLAVOUR,vegan);
    }

    private static void fillPastaFlavour(){
        //sauces
        pastaFlavour.put("WHITE",10);
        pastaFlavour.put("RED", 20);
    }

    private static HashMap<String,Integer> fillVegPizza(){
       HashMap<String,Integer> map = new HashMap<>();
       map.put(Constants.PIZZA_SMALL_SIZE,20);
       map.put(Constants.PIZZA_MEDIUM_SIZE,40);
       map.put(Constants.PIZZA_LARGE_SIZE,60);
       return map;
    }

    private static HashMap<String,Integer> fillNonVegPizza(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put(Constants.PIZZA_SMALL_SIZE,15);
        map.put(Constants.PIZZA_MEDIUM_SIZE,30);
        map.put(Constants.PIZZA_LARGE_SIZE,45);
        return map;
    }

    private static HashMap<String,Integer> fillVeganPizza(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put(Constants.PIZZA_SMALL_SIZE,20);
        map.put(Constants.PIZZA_MEDIUM_SIZE,40);
        map.put(Constants.PIZZA_LARGE_SIZE,60);
        return map;
    }

}
