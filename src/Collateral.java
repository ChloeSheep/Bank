public class Collateral {
    private String item;
    private String price;

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    private String currencyType;

    public Collateral() {
    }

    public Collateral(String item, String price,String currencyType) {
        this.item = item;
        this.price = price;
        this.currencyType=currencyType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Collateral information:" + '\n' +
                "item = " + item + ' ' +
                "currencyType = "+currencyType+
                " price = " + price+'\n';
    }

//    public static void main(String[] args) {
//        Collateral myCar = new Collateral("car",10000);
//        System.out.println(myCar);
//    }
}
