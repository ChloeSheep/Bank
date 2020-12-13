import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String name;
    String pwd;
    int id;

    User(){}
    User(String name, String pwd){
        this.name=name;
        this.pwd=pwd;
    }
    public void setId(int number){id=number;}
    public int getId(){return id;}

    public String getName(){return name;}
}
