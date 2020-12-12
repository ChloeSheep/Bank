import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {

  String accountType;
  ArrayList<Transaction> transactions=new ArrayList<>();
  static Currency currency = new Currency();
  Time time;


  Account(){
  }
  public String toString(){
      return accountType;
  }
  public void save(String type){
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
  }
  public void withdraw(String type){
    System.out.println("How much cash(dollar) would you take this time?");
    System.out.println("Please take care that we will charge you 2% service charges.");
    Scanner money=new Scanner(System.in);
    String cash=money.nextLine();
    while (!Tool.is_number(cash)){
      System.out.println("Invalid input. Please input a number.");
      cash=money.nextLine();
    }
    Account.currency.sub(type,Double.parseDouble(cash)*1.02);

  }
  public void addRecord(Transaction transaction){
      transactions.add(transaction);
  }
  public abstract void createTransaction();
}
