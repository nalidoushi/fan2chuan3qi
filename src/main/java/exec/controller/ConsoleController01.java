package exec.controller;

import exec.domain.User;
import exec.exception.MsgException;
import exec.service.UserService;
import exec.service.UserServiceImpl;

import java.util.Scanner;

public class ConsoleController01 {

    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        System.out.println("======学生成绩管理系统======");
        String line = null;
        while(true){
            System.out.println("##请选择您要进行的操作:[1]登录 [2]注册 [3]退出");
            line = scanner.nextLine();
            if("1".equals(line)){//登录
                System.out.println("登录..");
            }else if("2".equals(line)){//注册
                System.out.println("输入要注册的用户信息,格式:id,name,psw,role");
                line = scanner.nextLine();
                if(!line.matches("^[1-9]\\d*,\\w+,\\w+,(0|1)$")){
                    //输入格式不正确,则要求重新输入
                    System.out.println("输入的注册信息格式不正确!请重新注册!");
                    continue;
                }
                //进行注册
                int id = Integer.parseInt(line.split(",")[0]);
                String name = line.split(",")[1];
                String psw = line.split(",")[2];
                int role = Integer.parseInt(line.split(",")[3]);
                try {
                    userService.regist(new User(id,name,psw,role));
                    System.out.println("恭喜您,注册成功!");
                    continue;
                } catch (MsgException e) {
                    System.out.println("注册失败,原因:"+e.getMessage()+",请重新注册!");
                    continue;
                }
            }else if("3".equals(line)){//退出
                break;
            }else{//错误输入
                System.out.println("输入的操作码错误!请重新数据");
                continue;
            }
        }
        System.out.println("=========退出成功!=========");
    }
}
