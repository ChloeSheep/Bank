import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{

    ArrayList<Account> accounts=new ArrayList<>();
    ArrayList<Transaction> transactions=new ArrayList<>();
    Customer(){}
    Customer(String name,String pwd){
        super(name,pwd);
    }
    public String toString(){
        String str="ID: "+id+" Name: "+name;
        return str;
    }
    public void printRecords(){
        transactions.clear();
        if (accounts.size()==0){
            System.out.println("No accounts have been made.");
        }else {
        for(int i=0;i<accounts.size();i++){
            transactions.addAll(accounts.get(i).transactions);
        }
        if (transactions.size()==0){
            System.out.println("No transactions have been made.");
        }else {
            for (int i=0;i<transactions.size();i++){
                System.out.println(transactions.get(i));
            }
        }
    }}
    public int removeAccount(){
        System.out.println("Dear customer "+name+":");
        System.out.println("Deleting an account will charge you 5 dollars.");
        if (accounts.size()==0){
            System.out.println("You have not created any account.");
            return -1;
        }else {
        for (int i=0;i<accounts.size();i++){
            System.out.print((i+1)+" ");
            System.out.println(accounts.get(i).accountType);
        } }
        System.out.println("Input the ID of the account you want to delete.");
        Scanner choice=new Scanner(System.in);
        String num=choice.nextLine();
        while(!Tool.is_number(num)){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
        }
        int number=Integer.parseInt(num);
        while (number<1||number>accounts.size()){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
            number=Integer.parseInt(num);
        }
        if (accounts.get(number-1).accountType.equals("Saving")){
            boolean isempty=Account.currency.is_empty();
            if (isempty){
            boolean success=Account.currency.sub("Dollar",5,"1");
            if (success){
            System.out.println("Successfully delete your saving account!");
            accounts.get(number-1).createTransaction("5","Dollar","Delete account.");
            accounts.remove(number-1);}else {
                System.out.println("You don't have enough money.");
                accounts.get(number-1).createTransaction("0","Dollar","Failed to delete account.");
            }
            }else {
                System.out.println("You have to withdraw all your money first. (Leave 5 dollars for deleting account)");
                accounts.get(number-1).createTransaction("0","Dollar","Failed to delete account.");}
        }
        else if (accounts.get(number-1).accountType.equals("Checking")){
            boolean success=Account.currency.sub("Dollar",5,"1");
            if (success){
                System.out.println("Successfully delete your checking account!");
                accounts.get(number-1).createTransaction("5","Dollar","Delete account.");
                accounts.remove(number-1);}else {
                System.out.println("You don't have enough money.");
                accounts.get(number-1).createTransaction("0","Dollar","Failed to delete account.");
            }

        }else if (accounts.get(number-1).accountType.equals("Loan")){
            LoanAccount loanAccount= (LoanAccount) accounts.get(number-1);
            if (loanAccount.is_empty()){
                boolean success=Account.currency.sub("Dollar",5,"1");
                if (success){
                    System.out.println("Successfully delete your loan account!");
                    accounts.get(number-1).createTransaction("5","Dollar","Delete account.");
                    accounts.remove(number-1);}else {
                    System.out.println("You don't have enough money.");
                    accounts.get(number-1).createTransaction("0","Dollar","Failed to delete account.");
                }
            }else {
                System.out.println("You have to pay for your loans first.");
                accounts.get(number-1).createTransaction("0","Dollar","Failed to delete account.");}
        }
        return 1;
    }
    public int createAccount(String str){
        System.out.println("Dear customer "+name+":");
        if (str.equals("Saving")){
        accounts.add(new SavingAccount(id)); }
        else if (str.equals("Checking")){
            CheckingAccount checkingAccount=new CheckingAccount(id);
            boolean success=checkingAccount.initAccount();
            if (!success){
                return -1;
            }else {
                accounts.add(checkingAccount);
            }
        }else if (str.equals("Loan")){
            LoanAccount loanAccount=new LoanAccount(id);
            boolean success=loanAccount.initAccount();
            if (!success){
                return -1;
            }else{
                accounts.add(loanAccount);
            }
        }
        return accounts.size()-1;
    }




}
