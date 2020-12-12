import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {

  String accountType;
  ArrayList<Transaction> transactions=new ArrayList<>();
  static Currency currency = new Currency();
  Time time=new Time();
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
    Account.currency.add(type,Double.parseDouble(cash));
    System.out.println("Successfully save "+type+" "+cash+"!");
    System.out.println("Now your deposit: ");
    Account.currency.print();
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
    boolean success=Account.currency.sub(type,Double.parseDouble(cash));
    if (!success){
      return "";}else {
      return Double.toString(Double.parseDouble(cash));
    }
  }
  public abstract void createTransaction(String action);
}
