import java.math.BigDecimal;

public class CheckingAccount extends Account{
    CheckingAccount(){
        accountType="Checking";
    }
    public boolean initAccount(){
        System.out.println("Welcome! You will start checking your current deposit and transaction records here, starting today.");
        System.out.println("Openning this count will charge you 5 dollars. Make sure you have created the saving count and save at least 5 dollars in it.");
        System.out.println("Although you can use 3 types of currency in our bank(Dollar, RMB and Pound), you need to pay dollars this time.");
        if (Account.currency.get("Dollar").compareTo(new BigDecimal(5)) < 0){
            System.out.println("You don't have 5 dollars!");
            System.out.println("Fail to open a checking account.");
            return false;
        }else {
            //withdraw
            Account.currency.sub("Dollar",5);
            return true;
        }
    }
    public void checkMoney(){
        Account.currency.print();
        createTransaction();
    }
    public void checkRecords(){

    }
    public void createTransaction(){
        String str=time+"";
    }
}
