import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Manager bankManager;
    static boolean end=true;
    static boolean userend=true;
    public static void main(String[] args){
        System.out.println("Welcome to the Bank!");
        while (end){
            userMenu();}
    }

    public static void userMenu(){
        userend=true;
        System.out.println("You are 1. new customer 2. old customer 3. new manager 4. old manager 5. exit");
        Scanner choice=new Scanner(System.in);
        String num=choice.nextLine();

        while(!Tool.is_number(num)){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
        }
        int number=Integer.parseInt(num);
        while (number<1||number>5){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
            number=Integer.parseInt(num);
        }
        if (number==1){
            int id=createNewCustomer();
            while (userend){
            bankMenu(id);}
        }else if (number==5){
            end=false;
        }else if (number==3){
            createNewManager();
            while (userend){
                managerMenu();
            }
        }
    }
    public static void bankMenu(int id){
        System.out.println("Choose an action you wanna take: ");
        System.out.println("1. check 2. save/withdraw 3. loan 4. delete accounts 5. exit");
        Scanner choice=new Scanner(System.in);
        String num=choice.nextLine();
        while(!Tool.is_number(num)){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
        }
        int number=Integer.parseInt(num);
        while (number<1||number>5){
            System.out.println("Invalid input. Input again.");
            num=choice.nextLine();
            number=Integer.parseInt(num);
        }
        int exist;
        switch (number) {
            case 1 -> {
                exist = isthereAccount(id, "Checking");
                if (exist < 0) {
                    int accountID = customers.get(id).createAccount("Checking");
                    if (accountID >= 0) {
                        System.out.println("You can check your money and your transaction records now.");
                        ((CheckingAccount) customers.get(id).accounts.get(accountID)).Menu(customers.get(id));
                    }
                } else {
                    ((CheckingAccount) customers.get(id).accounts.get(exist)).Menu(customers.get(id));
                }
            }
            case 2 -> {
                exist = isthereAccount(id, "Saving");
                if (exist < 0) {
                    int accountID = customers.get(id).createAccount("Saving");
                    System.out.println("You can make savings and withdrawals now.");
                    ((SavingAccount) customers.get(id).accounts.get(accountID)).Menu();
                } else {
                    ((SavingAccount) customers.get(id).accounts.get(exist)).Menu();
                }
            }
            case 3 -> {
                exist = isthereAccount(id, "Loan");
                if (exist < 0) {
                    int accountID = customers.get(id).createAccount("Loan");
                    ((LoanAccount) customers.get(id).accounts.get(accountID)).Menu();
                } else {
                    ((LoanAccount) customers.get(id).accounts.get(exist)).Menu();
                }
            }
            case 4->{
                customers.get(id).removeAccount();
            }
            case 5 -> {
                System.out.println("Bye bye!");
                userend = false;
            }
        }
    }
    public static void managerMenu(){
        System.out.println("Choose an action you wanna take: ");
        System.out.println("1. check all the customers 2. search for one customer 3. check for debtors 4. exit");
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
        switch (number){
            case 1:
                bankManager.printAll();
                break;
            case 2:
                System.out.println("1. search by name 2. search by ID");
                Scanner choice1=new Scanner(System.in);
                String num1=choice1.nextLine();
                while(!Tool.is_number(num1)){
                    System.out.println("Invalid input. Input again.");
                    num1=choice1.nextLine();
                }
                int number1=Integer.parseInt(num1);
                while (number1<1||number1>2){
                    System.out.println("Invalid input. Input again.");
                    num1=choice1.nextLine();
                    number1=Integer.parseInt(num1);
                }
                if (number1==1){
                    System.out.println("Input the name:");
                    Scanner username=new Scanner(System.in);
                    String name=username.nextLine();
                    while (!Tool.is_alpha(name)){
                        System.out.println("Invalid name. A name should consist of letters.");
                        name=username.nextLine();
                    }
                    bankManager.checkCustomer(name);
                }else {
                    System.out.println("Input the ID:(start from 0)");
                    Scanner id=new Scanner(System.in);
                    String cid=id.nextLine();
                    while (!Tool.is_number(cid)){
                        System.out.println("Invalid input. Input again.");
                        cid=id.nextLine();
                    }
                    int ccid=Integer.parseInt(cid);
                    bankManager.checkCustomer(ccid);
                }
                break;
            case 3:
                bankManager.printLoan();
                break;
            case 4:
                System.out.println("Bye bye!");
                userend = false;
                break;

        }
    }
    public static int isthereAccount(int id,String str){
        Customer customer=customers.get(id);
        int accountID=-1;
        for (int i=0;i<customer.accounts.size();i++){
            if (customer.accounts.get(i).accountType.equals(str)){
                accountID=i;
                break;
            }
        }
        if (accountID<0){
            System.out.println("You don't have "+str+" account it. You can create one now.");
        }
        return accountID;
    }
    public static Customer initCustomerInfo(){
        String name=initUserName();
        String pwd=initUserPwd();
        Customer customer=new Customer(name,pwd);
        return customer;
    }
    public static Manager initManagerInfo(){
        String name=initUserName();
        String pwd=initUserPwd();
        Manager manager=new Manager(name,pwd);
        return manager;
    }
    public static String initUserName(){
        Scanner username=new Scanner(System.in);
        System.out.println("Dear new user, please enter your name: ");
        String name=username.nextLine();
        while (!Tool.is_alpha(name)){
            System.out.println("Invalid name. A name should consist of letters.");
            name=username.nextLine();
        }
        return name;

    }
    public static String initUserPwd(){
        Scanner password=new Scanner(System.in);
        System.out.println("Dear user, please enter your password(It should be between 6-16): ");
        String pwd=password.nextLine();

        while (!Tool.in_range(pwd,6,16)){
            System.out.println("Invalid length of password. Construct again.");
            pwd=password.nextLine();
        }
        System.out.println("Please enter your password again: ");
        String pwd1=password.nextLine();
        while (!pwd.equals(pwd1)){
            System.out.println("This input doesn't match last one. Construct your password again: ");
            while (!Tool.in_range(pwd,6,16)){
                System.out.println("Invalid length of password. Construct again.");
                pwd=password.nextLine();
            }
            System.out.println("Please enter your password again: ");
            pwd1=password.nextLine();
            while (!Tool.in_range(pwd1,6,16)){
                System.out.println("Invalid length of password. Construct again.");
                pwd1=password.nextLine();
            }
        }
        return pwd;
    }
    public static int createNewCustomer(){
        //Customer customer= (Customer) initUserInfo();
        Customer customer= initCustomerInfo();
        customers.add(customer);
        customer.setId(customers.size()-1);
        return customer.getId();
    }
    public static void createNewManager(){
        bankManager=initManagerInfo();
        bankManager.setId(0);
        bankManager.setCustomers(customers);
    }

}
