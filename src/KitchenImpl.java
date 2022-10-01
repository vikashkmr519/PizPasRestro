import java.util.Queue;

public class KitchenImpl  implements  Kitchen{

    @Override
    public Food cookFood(OrderRequest orderRequest) {
        Prices prices = new Prices();
        if(orderRequest.getOrderType().equals(Constants.PIZZA_ORDER_TYPE)){
            return cookPizza(orderRequest, prices);
        }else{
         return  cookPasta(orderRequest,prices);
        }
    }

    private Pizza cookPizza(OrderRequest orderRequest,Prices prices){
        PizzaRequest req = (PizzaRequest)orderRequest;
        int totalPrice = prices.getPriceOf(req);
        totalPrice = totalPrice* req.getQuantity();
        Pizza pizza = new Pizza(req.getPizzaSize(), req.getCrustType(), req.getPizzaFlavor(), req.getToppings(), req.getCustId(),totalPrice );
        return pizza;
    }

    private  Pasta cookPasta(OrderRequest request, Prices prices){
        PastaRequest req = (PastaRequest) request;
        int totalPrice = prices.getPriceOf(req);
        totalPrice= totalPrice*req.getQuantity();
        Pasta pasta = new Pasta(totalPrice,req.getPastaType(),req.getPastaFlavour(),req.getCustId());
        return pasta;
    }
}
