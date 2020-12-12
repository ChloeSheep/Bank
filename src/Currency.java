import java.math.BigDecimal;
import java.util.*;

public class Currency {
    private HashMap<String, BigDecimal> money;

    //default
    public Currency() {
        HashMap<String, BigDecimal> initMoney = new HashMap<>();
        initMoney.put("Dollar",BigDecimal.ZERO);
        initMoney.put("RMB",BigDecimal.ZERO);
        initMoney.put("Pound",BigDecimal.ZERO);
        this.money = initMoney;
    }

    public Currency(HashMap<String, BigDecimal> money) {
        this.money = money;
    }

    public void print() {
        System.out.println(this.money);
    }

    public BigDecimal get(String key){
        return money.get(key);
    }
    public int check(String key ,double value){
        if (value <= 0){
            System.out.println("The value should > 0");
            return 0;
        }
        if (!this.money.containsKey(key)){
            System.out.println("The currency was not found");
            return 0;
        } else
            return 1;
    }

    public void add(String key ,double value){
        if (check(key,value)==0){
        } else {
            BigDecimal addNum = new BigDecimal(Double.toString(value));
            this.money.put(key,this.money.get(key).add(addNum));
        }
    }

    public boolean sub(String key ,double value){
        boolean success=false;
        if (check(key,value)==0){
        } else {
            BigDecimal subNum = new BigDecimal(Double.toString(value));
            subNum=subNum.multiply(new BigDecimal("1.02"));
            if (this.money.get(key).compareTo(subNum) == -1) {
                System.out.println("Your balance is not enough!");
                }
                else{
                this.money.put(key,this.money.get(key).subtract(subNum));
                System.out.println("Successfully withdraw "+key+" "+subNum+"!");
                System.out.println("Now your deposit: ");
                Account.currency.print();
                success=true;
                    }
               }
        return success;
    }
/*
    public static void main(String[] args) {
        HashMap m1 = new HashMap<String, BigDecimal>();
        BigDecimal zero = new BigDecimal("0");
        m1.put("Dollar",zero);
        System.out.println(m1);
        Currency m3 = new Currency();
        m3.print();
        m3.add("RMB",100);
        m3.print();
    }*/
}
