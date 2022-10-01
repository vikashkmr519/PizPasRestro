public class Pasta extends Food{

    private String pastaType;
    private String pastaFlavour;
    private int customerId;

    public Pasta(int totalPrice, String pastaType, String pastaFlavour, int customerId) {

        super(totalPrice,Constants.PASTA_ORDER_TYPE);
        this.pastaType = pastaType;
        this.pastaFlavour = pastaFlavour;
        this.customerId = customerId;
    }

    public String getPastaType() {
        return pastaType;
    }

    public void setPastaType(String pastaType) {
        this.pastaType = pastaType;
    }

    public String getPastaFlavour() {
        return pastaFlavour;
    }

    public void setPastaFlavour(String pastaFlavour) {
        this.pastaFlavour = pastaFlavour;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Pasta{" +
                "pastaType='" + pastaType + '\'' +
                ", pastaFlavour='" + pastaFlavour + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}

