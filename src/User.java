import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String name;
    String pwd;

    User(){}
    public void initUserInfo(){
        initUserName();
        initUserPwd();
    }
    public void initUserName(){
        Scanner username=new Scanner(System.in);
        System.out.println("Dear new user, please enter your name: ");
        String name=username.nextLine();
        while (!Tool.is_alpha(name)){
            System.out.println("Invalid name. A name should consist of letters.");
            name=username.nextLine();
        }
        this.name=name;

    }
    public void initUserPwd(){
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
        this.pwd=pwd;
    }
    public String getName(){return name;}
}
