public class PastaRequest extends OrderRequest {
    private String pastaType;
    private String pastaFlavour;

    public PastaRequest(String pastaType, String pastaFlavour){
        super(Constants.PASTA_ORDER_TYPE);
        this.pastaFlavour= pastaFlavour;
        this.pastaType = pastaType;
    }

    public String getPastaType() {
        return pastaType;
    }
    public String getPastaFlavour() {
        return pastaFlavour;
    }

}
