#Refactor exercise

##MovieRental
* 计算每一位顾客消费金额并打印详单
* 计算常客积分，积分根据影片种类而不同
* 影片分为：普通片、儿童片和新片

###需求
* 1、希望以HTML格式输出
* 2、改变影片分类规则

####Step 1
* 分解并重组statement
* 实现htmlStatement

KeyWords:
>1、绝大多数情况下，函数应该放在它所使用的数据的所属对象内(如amountFor()搬移到Rental里，customer里委托调用rental函数即可)

>2、除去临时变量，运用Replace Temp with Query(如thisAmount)

>3、提炼函数，放到函数功能对应的责任类里(如getFrequentRenterPoints())


###Step 2
* 运用多态取代与价格相关的条件逻辑




