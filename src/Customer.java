import java.util.ArrayList;

public class Customer extends User{
    private int id;
    ArrayList<Account> accounts=new ArrayList<>();
    Customer(){}
    public int createAccount(String str){
        System.out.println("Dear customer "+name+":");
        if (str.equals("Saving")){
        accounts.add(new SavingAccount()); }
        int accountID=accounts.size()-1;
        return accountID;

    }
    public void setId(int number){id=number;}
    public int getId(){return id;}


}
