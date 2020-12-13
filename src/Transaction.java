public class Transaction {
     String info;
     String moneyChange;

     public String getMoneyChange() {
          return moneyChange;
     }

     public void setMoneyChange(String moneyChange) {
          this.moneyChange = moneyChange;
     }



     public int getCustomerID() {
          return customerID;
     }

     public void setCustomerID(int customerID) {
          this.customerID = customerID;
     }

     public String getAccountType() {
          return accountType;
     }

     public void setAccountType(String accountType) {
          this.accountType = accountType;
     }

     public String getCurrencyType() {
          return currencyType;
     }

     public void setCurrencyType(String currencyType) {
          this.currencyType = currencyType;
     }

     public Currency getCurrentCurrency() {
          return currentCurrency;
     }

     public void setCurrentCurrency(Currency currentCurrency) {
          this.currentCurrency = currentCurrency;
     }

     Currency currentCurrency;
     int customerID;
     String accountType;
     String currencyType;

     public Time getTime() {
          return time;
     }

     public void setTime(Time time) {
          this.time = time;
     }

     Time time;
     Transaction(){

     }
     public String toString(){
         return info;
     }
     public void setInfo(String str){info=str;}
}
