# 知识点回顾

* 高级流和低级流(节点流)
* 序列化和反序列化
* 字符流和转换流

# FAQ分析

* 高级流和低级流这里用到了什么设计模式？(装饰模式-例如高级流在低级流的基础上进行装饰)
* 序列化的应用场景？(内存对象的持久化，写入缓存，网络数据交互)  
* serialVersionUID作用？(保证序列化和反序列化的正确性)
* 如何进行序列化的粒度控制？(默认所有属性都序列化，transient描述的属性可以不序列化)
* 如何理解对象的深拷贝和浅拷贝？(深拷贝拷贝的是内容，浅拷贝拷贝的是对象地址)

# 今日课程目标和安排

* 掌握异常的定义及处理方式
* 熟悉网络编程的基本概念以及入门实现

# 异常

## 异常的定义

程序中异常是对特定问题的一个描述，通过异常可以终止程序继续执行。在Java中异常
类型为Throwable,它有两个子类分别Exception和Error,Exception是我们程序
可以处理的异常，例如下标越界异常，算数异常，空指针异常，IO异常等，Error一般
一种系统级的错误，例如内存溢出等。

## 程序中异常的作用？

* 终止程序执行。
* 实现与用户的交互。

## 入门案例分享

```
package exception;
public class NPEDemo{//NullPointerException->NPE

  public static void main(String[] args){
    doStringOper01(null);
  }
  public static void doStringOper01(String str){
     //如下语句可能会出现空指针异常
     String result=str.toUpperCase();
     //假如上面的语句出现了异常，下面输出语句是不会执行的。
     System.out.println(result);
  }
  public static void doStringOper02(String str){
     //假如希望如下语句出现了异常，后面的语句还要继续执行。
     //此时我们可以使用try{}catch(xxx){}...对可能出现异常的语句进行处理
     try{
      String result=str.toUpperCase();
     }catch(NullPointerExcetpion e){
      System.out.println("程序中的str的值不能null")
      result=null;
     }
     //假如上面的语句出现了异常，下面输出语句是不会执行的。
     System.out.println(result);
  }

}

```





