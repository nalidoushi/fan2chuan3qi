package exec.controller;

import exec.domain.User;
import exec.service.UserService;

import java.util.Scanner;

public class Starter01 {

    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("===学生成绩管理系统===");
        String line = null;
        while(true){
            System.out.println("请选择您要进行的操作:[1]登录 [2]注册 [3]退出");
            line = scanner.nextLine();
            if("1".equals(line)){
                //TODO 登录
                System.out.println("登录..");
            }else if("2".equals(line)){
                System.out.println("输入要注册的用户信息,格式:id,name,role");
                line = scanner.nextLine();
                if(!line.matches("^[1-9]\\d*,\\w+,(0|1)$")){
                    //输入格式不正确,则要求重新输入
                    System.out.println("输入的注册信息格式不正确!请重新注册!");
                    continue;
                }
                //进行注册
                int id = Integer.parseInt(line.split(",")[0]);
                String name = line.split(",")[1];
                int role = Integer.parseInt(line.split(",")[2]);
                userService.regist(new User(id,name,role));
            }else if("3".equals(line)){
                break;
            }else{
                System.out.println("输入的操作码错误!请重新数据");
                continue;
            }
        }
        System.out.println("======退出成功!======");
    }
}
