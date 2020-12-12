import java.util.Scanner;

public class SavingAccount extends Account {
    SavingAccount(){
         accountType="Saving";
         initAccount();
    }
    public void initAccount(){
        System.out.println("Welcome! You will save and withdraw money here, starting today.");
        System.out.println("Openning this count will charge you 5 dollars.");
        System.out.println("You can use 3 types of currency in our bank(Dollar, RMB and Pound).");
        System.out.println("To create a checking account, you will have to save at least 5 dollars in our account.");
        save("Dollar");
        System.out.println("Automatically charge you $5!");
        Account.currency.sub("Dollar",5);
        Account.currency.print();
    }
    public void Menu(){
        System.out.println("1. Save money 2. Withdraw money 3. Exit");
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
            System.out.println("1. Dollar 2. RMB 3. Pound");
            Scanner choice1=new Scanner(System.in);
            String num1=choice1.nextLine();
            while(!Tool.is_number(num1)){
                System.out.println("Invalid input. Input again.");
                num1=choice1.nextLine();
            }
            int number1=Integer.parseInt(num1);
            while (number1<1||number1>3){
                System.out.println("Invalid input. Input again.");
                num1=choice1.nextLine();
                number1=Integer.parseInt(num1);
            }
            if (number1==1){
                save("Dollar");
            }else if (number1==2){
                save("RMB");
            }else {
                save("Pound");
            }
        }else if (number==2){
            System.out.println("1. Dollar 2. RMB 3. Pound");
            Scanner choice1=new Scanner(System.in);
            String num1=choice1.nextLine();
            while(!Tool.is_number(num1)){
                System.out.println("Invalid input. Input again.");
                num1=choice1.nextLine();
            }
            int number1=Integer.parseInt(num1);
            while (number1<1||number1>3){
                System.out.println("Invalid input. Input again.");
                num1=choice1.nextLine();
                number1=Integer.parseInt(num1);
            }
            if (number1==1){
                withdraw("Dollar");
            }else if (number1==2){
                withdraw("RMB");
            }else {
                withdraw("Pound");
            }
        }else {
            return;
        }
    }

    public void createTransaction(){

    }
}
