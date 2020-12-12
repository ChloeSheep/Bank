The class structure is following:
1. Bank
 2. User-Customer,Manager
  3. Account-Checking, Saving, Loan, Stock
   4. Transaction
Tool- assistant class for error checking
Time- get local time
Collateral- the collateral for loaning
Currency- currently there exists RMB, Dollar and Pound(a hashMap)

现在初步实现了savingAccount的save和withdraw功能，当然是一次性的程序，所以每次运行都要新建账户。
暂时不考虑利息问题，time类实现了获取当前时间