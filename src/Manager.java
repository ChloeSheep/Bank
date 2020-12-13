import java.util.ArrayList;

public class Manager extends User {
    private ArrayList<Customer>customers = new ArrayList<>();

    Manager() {
    }
    Manager(String name,String pwd){
        super(name,pwd);
    }

    Manager(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void printAll(){
        for (int i = 0; i < this.customers.size(); i++){
            System.out.println(customers.get(i));
        }
    }

    public void printLoan(){
        for (int i = 0; i < this.customers.size(); i++){
//            判断是否欠钱
//            if (customers.get(i).){
//                System.out.println(customers.get(i));
//            }
        }
    }

    public void checkCustomer(int id) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                System.out.println(customers.get(i));
                return;
            }
        }
        System.out.println("The customer does not exist!");
    }


    public void checkCustomer (String name){
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                System.out.println(customers.get(i));
                return;
            }
        }
        System.out.println("The customer does not exist!");
    }
}
