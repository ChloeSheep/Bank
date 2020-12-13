import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {

  String accountType;
  int accountID;
  ArrayList<Transaction> transactions=new ArrayList<>();
  static Currency currency = new Currency();
  int customerID;
  Account(int id){
    customerID=id;
  }
  public String toString(){
      return accountType;
  }
  public String save(String type){
    System.out.println("How much would you save this time?");
    Scanner money=new Scanner(System.in);
    String cash=money.nextLine();
    while (!Tool.is_number(cash)){
      System.out.println("Invalid input. Please input a number.");
      cash=money.nextLine();
    }
    Account.currency.add(type,Double.parseDouble(cash),"1");
    return cash;
  }
  public String withdraw(String type){
    System.out.println("How much cash would you take this time?");
    System.out.println("Please take care that we will charge you 2% service charges.");
    Scanner money=new Scanner(System.in);
    String cash=money.nextLine();
    while (!Tool.is_number(cash)){
      System.out.println("Invalid input. Please input a number.");
      cash=money.nextLine();
    }
    boolean success=Account.currency.sub(type,Double.parseDouble(cash),"1.02");
    if (!success){
      return "";}else {
      return Double.toString(Double.parseDouble(cash));
    }
  }
  public abstract void createTransaction(String moneychange,String type,String action);
}
