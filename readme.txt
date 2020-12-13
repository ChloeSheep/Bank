The class structure is following:
1. Bank
 2. User-Customer,Manager
  3. Account-Checking, Saving, Loan, Stock
   4. Transaction
Tool- assistant class for error checking
Time- get local time
Collateral- the collateral for loaning
Currency- currently there exists RMB, Dollar and Pound(a hashMap)

12-12
现在初步实现了savingAccount和checkingAccount功能，当然是一次性的程序，所以每次运行都要新建账户。现在只能建立新用户，
因为现在考虑进入老用户的account没有意义，毕竟只是单纯的不连数据库的程序。
暂时不考虑利息问题，time类实现了获取当前时间
可以记录每个用户的transaction，看transaction和withdraw money都要收钱
bank manager的模块写了基本的查找customer信息的函数，还未测验

12-13