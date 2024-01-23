# 今日目标及课程安排

* 网络编程中的Socket以及ServerSocket应用
* 网络通讯的基本过程及原理

# Socket入门

## 何为Socket?

java中用于网络通讯的一个对象,用于实现客户端与服务端的通讯.

## Socket 入门案例?

* 需求:客户端向服务端写一句话,服务端进行输出.
* 实现步骤:
- 编写服务器类Server (创建服务对象,启动服务,接收客户端的连接,处理连接请求)
- 编写客户端类Client (创建客户端对象,建立连接,向服务器发送请求)
- 运行Server和Client对象(要注意先后顺序,先启动Server,再启动Client)

* 代码实现:

- 服务端代码实现:SimpleServer

```java

  package net;
  public class SimpleServer{
      public static void main(String[] args)throws Exception{
          //1.创建Server对象,并申请8088端口,然后在此端口上进行服务监听
          ServerSocket server=new ServerSocket(8088);
          System.out.println("服务启动成功");
          //2.接收客户端的连接,并为客户端分配socket对象
          Socket socket=server.accept();
          System.out.println("有新客户端连接到了服务器");
          //3.创建流对象,读取Client端发送的数据
          ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
          String content=in.readUTF();
          System.out.println(content);
      }
  }

```
- 客户端代码实现:SimpleClient

```java

package net;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class SimpleClient {

    public static void main(String[] args) throws IOException {
        //1.创建Socket对象并与服务器建立连接
        Socket socket = new Socket("127.0.0.1", 8088);
        //2.向服务端发送数据
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeUTF("hello 8088");
        out.close();
        //3.释放资源
        socket.close();
    }

}
```

## Socket 案例增强

* 需求: 
  
- 客户端从键盘输入数据,然后向服务端写数据,这个过程可以反复执行
- 服务端可以从客户端不断地接收数据,然后将数据输出.

* 代码实现:

- 服务端代码实现:SimpleServer

```java

  package net;
  public class SimpleServerPlus{
      public static void main(String[] args)throws Exception{
          //1.创建Server对象,并申请8088端口,然后在此端口上进行服务监听
          ServerSocket server=new ServerSocket(8088);
          System.out.println("服务启动成功");
          //2.接收客户端的连接,并为客户端分配socket对象
          Socket socket=server.accept();
          System.out.println("有新客户端连接到了服务器");
          //3.创建流对象,读取Client端发送的数据
          ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
          while(true) {
              String content = in.readUTF();
              System.out.println(content);
              if("exit".equals(content))break;
          }
      }
  }

```
- 客户端代码实现:SimpleClientPlus

```java

package net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SimpleClientPlus {

    public static void main(String[] args) throws IOException {
        //1.创建Socket对象并与服务器建立连接
        Socket socket = new Socket("127.0.0.1", 8088);
        //2.向服务端发送数据
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        Scanner scanner=new Scanner(System.in);
        while(true) {
            String content = scanner.nextLine();
            out.writeUTF(content);
            out.flush();
            if("exit".equals(content))break;
        }
        out.close();
        //3.释放资源
        socket.close();
    }

}
```






