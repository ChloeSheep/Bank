import java.math.BigDecimal;
import java.util.Scanner;

public class CheckingAccount extends Account{
    CheckingAccount(int id){
        super(id);
        accountType="Checking";
    }
    public boolean initAccount(){
        System.out.println("Welcome! You will start checking your current deposit and transaction records here, starting today.");
        System.out.println("Openning this count will charge you 5 dollars. Make sure you have created the saving count and save at least 5 dollars in it.");
        System.out.println("Although you can use 3 types of currency in our bank(Dollar, RMB and Pound), you need to pay dollars this time.");
        if (Account.currency.get("Dollar").compareTo(new BigDecimal(5)) < 0){
            System.out.println("You don't have 5 dollars!");
            System.out.println("Fail to open a checking account.");
            createTransaction("Failed to open checking account.");
            return false;
        }else {
            //withdraw
            Account.currency.sub("Dollar",5);
            createTransaction("Open checking account.");
            return true;
        }
    }
    public void Menu(Customer customer){
        System.out.println("1. Check money 2. Check transactions 3. Exit");
        Scanner choice=new Scanner(System.in);
        String num=choice.nextLine();
        while(!Tool.is_number(num)){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
        }
        int number=Integer.parseInt(num);
        while (number<1||number>3){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
            number=Integer.parseInt(num);
         }
        if (number==1){
            checkMoney();
        }else if (number==2){
            checkRecords(customer);
        }else return;
    }
    public void checkMoney(){
        Account.currency.print();
        createTransaction("Checking money.");
    }
    public void checkRecords(Customer customer){
        System.out.println("This costs you 2 dollars.");
        boolean success=Account.currency.sub("Dollar",(double)2);
        if (success){
            customer.printRecords();
        createTransaction("Checking transactions.");}
        else {
            System.out.println("Failed to check records due to lack of dollars.");
            createTransaction("Failed checking transactions.");
        }
    }
    public void createTransaction(String action){
         String str=time+ " Customer "+(customerID+1)+" in Checking account: "+action;
         Transaction transaction=new Transaction();
         transaction.setInfo(str);
         transactions.add(transaction);

    }
}
