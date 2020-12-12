public class Collateral {
    private String item;
    private int price;

    public Collateral() {
    }

    public Collateral(String item, int price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Your collateral information:" + '\n' +
                "item= " + item + ' ' +
                "price= " + price;
    }

    public static void main(String[] args) {
        Collateral myCar = new Collateral("car",10000);
        System.out.println(myCar);
    }
}
