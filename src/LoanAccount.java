import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class LoanAccount extends Account {
    public static final String loanRate="0.8";
    ArrayList<Collateral> collaterals=new ArrayList<>();
    LoanAccount(int id){
        super(id);
        accountType="Loan";
    }
    public String toString(){
        String str="Collaterals: "+printCollaterals();
        return str;
    }
    public boolean initAccount(){
        System.out.println("Welcome! You will be applying loans and pay for collterals here, starting today.");
        System.out.println("Opening this count will charge you 8 dollars. Make sure you have created the saving count and save at least 8 dollars in it.");
        System.out.println("Although you can use 3 types of currency in our bank(Dollar, RMB and Pound), you need to pay dollars this time.");
        if (Account.currency.get("Dollar").compareTo(new BigDecimal(8)) < 0){
            System.out.println("You don't have 8 dollars!");
            System.out.println("Fail to open a loan account.");
            createTransaction("0","Dollar","Failed to open loan account.");
            return false;
        }else {
            //withdraw
            Account.currency.sub("Dollar",8,"1");
            createTransaction("-8","Dollar","Open loan account.");
            return true;
        }
    }
    public boolean is_empty(){
        if (collaterals.size()==0){
            return true;
        }else return false;
    }
    public String printCollaterals(){
        String str="\n";
        for(int i=0;i<collaterals.size();i++){
            str+=collaterals.get(i);
        }
        return str;
    }
    public void Menu(){
        System.out.println("1. apply for a loan 2. check loans 3. pay for loans 4. Exit");
        Scanner choice=new Scanner(System.in);
        String num=choice.nextLine();
        while(!Tool.is_number(num)){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
        }
        int number=Integer.parseInt(num);
        while (number<1||number>4){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
            number=Integer.parseInt(num);
        }
        if (number==1){
            applyLoan();
        }else if (number==2){
            checkLoans();
        }else if (number==3){
            payLoan();

        }else return;
    }
    public void payLoan(){
        System.out.println("Please enter the name of the collteral you wanna redeem.");
        Scanner item=new Scanner(System.in);
        String name=item.nextLine();
        int id=-1;
        if (collaterals.size()==0){
            System.out.println("You don't have any loans yet.");
        }else {
            for (int i=0;i<collaterals.size();i++){
                if (collaterals.get(i).getItem().equals(name)){
                    id=i;
                    break;
                }
            }
        }
        if (id>=0){
            String price=collaterals.get(id).getPrice();
            boolean success=Account.currency.sub(collaterals.get(id).getCurrencyType(),Double.parseDouble(price),"1");
            if (success){
                System.out.println("Now you have your "+collaterals.get(id).getItem()+" again!");
                System.out.println("Thank you for using our bank！");
                createTransaction("-"+collaterals.get(id).getPrice(),collaterals.get(id).getCurrencyType(),"Pay for the chosen collateral. "+collaterals.get(id));
                collaterals.remove(id);
            }else {
                createTransaction("0",collaterals.get(id).getCurrencyType(),"Failed to pay for the chosen collateral. "+collaterals.get(id));
            }
        }
    }

    public void applyLoan(){
        System.out.println("Input the name and price you have assessed here, we will loan you 80% of your collateral.");
        Scanner colla=new Scanner(System.in);
        System.out.println("The name of your collateral:");
        String item=colla.nextLine();
        String name=item;
        boolean alreadyExist=true;
        if (collaterals.size()>0){
            while(alreadyExist){
            for (int i=0;i<collaterals.size();i++){
                if (collaterals.get(i).getItem().equals(name)){
                    System.out.println("You cannot have items with the same name, please input again.");
                    System.out.println("For example, you already pledged a 'car'. You want to pledge a car now, you can name it 'car1'.");
                    name=colla.nextLine();
                    break;
                }alreadyExist=false;} }}
        System.out.println("Which currency do you want to get?");
        System.out.println("1. Dollar 2. RMB 3. Pound");
        item=colla.nextLine();
        while(!Tool.is_number(item)){
            System.out.println("Invalid input. Input again.");
            item=colla.nextLine();
        }
        int number=Integer.parseInt(item);
        while (number<1||number>3){
            System.out.println("Invalid input. Input again.");
            item=colla.nextLine();
            number=Integer.parseInt(item);
        }
        switch (number) {
            case 1 -> {
                System.out.println("Please make sure that your collateral is over $250 or we won't make a loan for you.");
                System.out.println("The price of your collateral($):");
                item = colla.nextLine();
                while (!Tool.is_number(item)) {
                    System.out.println("Invalid input. Input again.");
                    item = colla.nextLine();
                }
                double priceD = Double.parseDouble(item);
                if (priceD < 250) {
                    System.out.println("Your item is too cheap and cannot be a collateral in our bank, sorry.");
                    createTransaction("0","Dollar","Failed to loan cause the collateral is too cheap.");
                } else {
                    System.out.println("Ok! We will loan you 80% of this collateral.");
                    Account.currency.add("Dollar", priceD, loanRate);
                    Collateral collateral = new Collateral(name, item,"Dollar");
                    collaterals.add(collateral);
                    BigDecimal addNum = new BigDecimal(Double.toString(priceD));
                    addNum=addNum.multiply(new BigDecimal(loanRate));
                    String money=addNum.toString();
                    createTransaction(money,"Dollar","Apply for a loan. " + collateral);
                }
            }
            case 2 -> {
                System.out.println("Please make sure that your collateral is over ¥2000 or we won't make a loan for you.");
                System.out.println("The price of your collateral(¥):");
                item = colla.nextLine();
                while (!Tool.is_number(item)) {
                    System.out.println("Invalid input. Input again.");
                    item = colla.nextLine();
                }
                double priceR = Double.parseDouble(item);
                if (priceR < 2000) {
                    System.out.println("Your item is too cheap and cannot be a collateral in our bank, sorry.");
                    createTransaction("0","RMB","Failed to loan cause the collateral is too cheap.");
                } else {
                    System.out.println("Ok! We will loan you 80% of this collateral.");
                    Account.currency.add("RMB", priceR, loanRate);
                    Collateral collateral = new Collateral(name, item,"RMB");
                    collaterals.add(collateral);
                    BigDecimal addNum = new BigDecimal(Double.toString(priceR));
                    addNum=addNum.multiply(new BigDecimal(loanRate));
                    String money=addNum.toString();
                    createTransaction(money,"RMB","Apply for a loan. " + collateral);
                }
            }
            case 3 -> {
                System.out.println("Please make sure that your collateral is over ￡200 or we won't make a loan for you.");
                System.out.println("The price of your collateral(￡):");
                item = colla.nextLine();
                while (!Tool.is_number(item)) {
                    System.out.println("Invalid input. Input again.");
                    item = colla.nextLine();
                }
                double price = Double.parseDouble(item);
                if (price < 200) {
                    System.out.println("Your item is too cheap and cannot be a collateral in our bank, sorry.");
                    createTransaction("0","Pound","Failed to loan cause the collateral is too cheap.");
                } else {
                    System.out.println("Ok! We will loan you 80% of this collateral.");
                    Account.currency.add("Pound", price, loanRate);
                    Collateral collateral = new Collateral(name, item,"Pound");
                    collaterals.add(collateral);
                    BigDecimal addNum = new BigDecimal(Double.toString(price));
                    addNum=addNum.multiply(new BigDecimal(loanRate));
                    String money=addNum.toString();
                    createTransaction(money,"Pound","Apply for a loan. " + collateral);
                }
            }
        }
    }
    public void checkLoans(){
          if (collaterals.size()==0){
              System.out.println("You don't have any loans yet.");
          }else {
              createTransaction("0","Dollar","Check all the collterals.");
              for (Collateral collateral : collaterals) {
                  System.out.println(collateral);
              }
          }
    }
    public void createTransaction(String moneychange,String currencyType,String action){
        Time time=new Time();
        String str=time+ " Customer "+(customerID+1)+" in Loan account: "+action;
        Transaction transaction=new Transaction();
        transaction.setInfo(str);
        transaction.setAccountType(accountType);
        transaction.setCurrencyType(currencyType);
        transaction.setCurrentCurrency(Account.currency);
        transaction.setCustomerID(customerID);
        transaction.setTime(time);
        transaction.setMoneyChange(moneychange);
        transactions.add(transaction);
    }
}
