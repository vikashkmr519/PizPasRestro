public class OrderRequest {

    private String orderType;
    private int custId;

    private int quantity;
    public OrderRequest(String orderType){
        this.orderType = orderType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustId() {
        return custId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
