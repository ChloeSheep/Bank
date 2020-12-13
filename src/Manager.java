import java.util.ArrayList;

public class Manager extends User {
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

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
        for (int i = 0; i < this.customers.size(); i++) {
//            判断是否欠钱
            if (customers.get(i).accounts.size()>0){
            for (int j=0;j<customers.get(i).accounts.size();j++){
                if (customers.get(i).accounts.get(j).accountType.equals("Loan")){
                    System.out.println(customers.get(i));
                    System.out.println((LoanAccount)customers.get(i).accounts.get(j));
                }
            }}
        }
    }

    public void checkCustomer(int id) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                System.out.println(customers.get(i));
                if (customers.get(i).accounts.size()==0){
                    ;
                }else {
                    System.out.println("This customer owns accounts:");
                    for (int j=0;j<customers.get(i).accounts.size();j++){
                        System.out.println((j+1)+" "+customers.get(i).accounts.get(j).accountType);
                    }
                }
                return;
            }
        }
        System.out.println("The customer does not exist!");
    }


    public void checkCustomer (String name){
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                System.out.println(customers.get(i));
                if (customers.get(i).accounts.size()==0){
                    ;
                }else {
                    System.out.println("This customer owns \n");
                    for (int j=0;j<customers.get(i).accounts.size();j++){
                        System.out.println((j+1)+" "+customers.get(i).accounts.get(j).accountType);
                    }
                }
                return;
            }
        }
        System.out.println("The customer does not exist!");
    }
}
