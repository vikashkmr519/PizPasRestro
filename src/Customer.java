import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Customer {
    private  String name;
    private int custId;
    private List<Integer> orderIdList;

    public Customer(String name) {
        this.name = name;
        this.custId = new Random().nextInt(10000000);
        orderIdList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public List<Integer> getOrderIdList() {
        return orderIdList;
    }

    public void setOrderIdList(List<Integer> orderIdList) {
        this.orderIdList = orderIdList;
    }

    public void addFoodToList(int foodId){
        orderIdList.add(foodId);
    }
}
