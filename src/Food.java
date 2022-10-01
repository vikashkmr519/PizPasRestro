import java.util.Random;

public class Food {

    private int foodId;
    private int totalPrice;

    private String foodType;

    private boolean orderStatus;

    public Food(int totalPrice, String foodType) {
        this.totalPrice = totalPrice;
        this.foodId = new Random().nextInt(100000);
        this.orderStatus = false;
        this.foodType = foodType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", totalPrice=" + totalPrice +
                ", foodType='" + foodType + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
