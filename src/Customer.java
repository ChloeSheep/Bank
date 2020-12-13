import java.util.ArrayList;

public class Customer extends User{

    ArrayList<Account> accounts=new ArrayList<>();
    ArrayList<Transaction> transactions=new ArrayList<>();
    Customer(){}
    Customer(String name,String pwd){
        super(name,pwd);
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
        }
        int accountID=accounts.size()-1;
        return accountID;

    }



}
