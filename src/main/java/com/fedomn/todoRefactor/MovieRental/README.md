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

KeyWords:
>1、最好不要在另一个对象的属性基础上运用switch语句(如Rental里的getCharge方法)，建议使用多态来取代。

>2、使用state模式

##Step 3
* 采取Form Template Method重构customer类里的statement()方法

KeyWords:
>1、有些子类，其中的函数以相同的顺序执行类似操作，但是各个操作细节不同。此时，将这些操作放到独立的函数中，并保持相同的签名。

>2、将原函数(statement)上移到超类中，在超类中将那些代表各种不同操作的函数定义为抽象函数。

