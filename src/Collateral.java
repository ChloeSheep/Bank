import java.math.BigDecimal;

public class Collateral {
    private String item;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private BigDecimal price;

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    private String currencyType;

    public Collateral() {
    }

    public Collateral(String item, BigDecimal price,String currencyType) {
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
