import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private HashMap<Integer, Customer> customerInvetory;

    private HashMap<Integer,Food> foodInvetory;

    public Inventory(){
        customerInvetory = new HashMap<>();
        foodInvetory = new HashMap<>();
    }

    public void addCustomer(Customer customer){
        customerInvetory.put(customer.getCustId(),customer);
    }

    public void addFood(Food food){
        foodInvetory.put(food.getFoodId(), food);
    }

    public boolean doesCustomerExists(int custId){
        if(customerInvetory.containsKey(custId)){
            return true;
        }else {
            return false;
        }
    }

    public List<Food> getAllOrderOfCustomer(int custId){
        List<Integer> orderList = customerInvetory.get(custId).getOrderIdList();

        List<Food> foodList = orderList.stream().map((id) -> (Food)foodInvetory.get(id)).collect(Collectors.toList());
        return foodList;
    }

    public void addFoodToCustomer(int foodId, int custId){
        customerInvetory.get(custId).addFoodToList(foodId);
    }

    public Customer getCustomerById(int custId){
        return customerInvetory.get(custId);
    }
}
