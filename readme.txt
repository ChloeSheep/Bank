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
主要进展：实现customer的saving，checking,loan功能。
新功能：
Transaction-新增分割开的各部分信息的数据成员
Account-新增accountID(未初始化和赋值），每个account对应一个customerID
LoanAccount-可以1.申请以collateral换取90%的金额（先选择货币种类，RMB至少2000，Pound至少200，Dollar至少250才能兑换）
2.查看当前抵押物列表
3.还款换回抵押物（还原款）
Customer-新增注销account函数，saving会先check是否将所有钱取出，loan会check是否赎回所有collateral
Manager-可以查看所有customer（粗略信息），根据ID或者姓名查询某个customer（详细信息），查看所有欠钱的customer（打印loan账户）
缺陷：
一次性的程序，所以每次运行都要新建账户。现在只能建立新用户。
暂时不考虑利息和日期问题，故没有实现interest和daily report

12-14
loanaccount修改成只能用美元这一种货币，不过currency本身作为拥有三种货币的hashmap没有变，只是在loanaccount里只能选择其中的美元进行操作
collateral类里的price数据成员更改为BigDecimal类型

基本设定：account中，check和save开通要5美元，loan要8美元，注销账户各要5美元，每次取钱要2%手续费，抵押贷款给90%的抵押物价钱，
每次check钱1美元，check交易记录2美元