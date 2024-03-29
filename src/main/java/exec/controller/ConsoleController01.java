package exec.controller;

import exec.domain.Score;
import exec.domain.User;
import exec.exception.MsgException;
import exec.service.ScoreService;
import exec.service.ScoreServiceImpl;
import exec.service.UserService;
import exec.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * create database exec66;
 * use exec66;
 * create table user (id int,name varchar(40),psw varchar(40),role int); #0老师1学生
 * create table score(id int primary key auto_increment,math int,chinese int,english int,uid int);
 */
public class ConsoleController01 {

    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserServiceImpl();
    private static ScoreService scoreService = new ScoreServiceImpl();

    public static void main(String[] args) {
        System.out.println("======学生成绩管理系统======");
        String line = null;
        while(true){
            System.out.println("##请选择您要进行的操作:[1]登录 [2]注册 [3]退出");
            line = scanner.nextLine();
            if("1".equals(line)){
                //登录
                User user = doLogin();
                //登录失败
                if(user==null){
                    continue;
                }
                //登录成功
                if(user.getRole() == 0){
                    //处理老师
                    handleTeacher(user);
                }else{
                    //处理学生
                    handleStu(user);
                }
            } else if("2".equals(line)) {
                //注册
                doRegist();
            }else if("3".equals(line)){
                //退出
                break;
            }else{
                //错误输入
                System.out.println("输入的操作码错误!请重新数据");
                continue;
            }
        }
        System.out.println("=========退出成功!=========");
    }

    public static void handleTeacher(User user){
        while(true){
            System.out.println(user.getName()+"老师，您好，请选择要执行的操作");
            System.out.println("[1]查询所有成绩 [2]新增成绩 [3]修改成绩 [4]删除成绩 [5]退出登录");
            String line = scanner.nextLine();
            if("1".equals(line)){
                List<Score> list = scoreService.getScores();
                System.out.println("查询结果:");
                System.out.println("++++++++++++++++++++++++++++++");
                for(Score score : list){
                    System.out.println(score);
                }
                System.out.println("++++++++++++++++++++++++++++++");
                continue;
            }else if("2".equals(line)){
                System.out.println("请输入要新增的成绩信息，格式：math,chinese,english,uid");
                line = scanner.nextLine();
                //--校验格式
                if(!line.matches("([0-9]|[1-9][0-9]|100),([0-9]|[1-9][0-9]|100),([0-9]|[1-9][0-9]|100),\\d+")){
                    System.out.println("输入的成绩格式不正确，请重新输入!");
                    continue;
                }
                int math = Integer.parseInt(line.split(",")[0]);
                int chinese = Integer.parseInt(line.split(",")[1]);
                int english = Integer.parseInt(line.split(",")[2]);
                int uid = Integer.parseInt(line.split(",")[3]);
                //--新增成绩
                try {
                    scoreService.addScore(new Score(0,math,chinese,english,uid));
                    //--成功，提示成功
                    System.out.println("新增成绩成功!");
                    continue;
                } catch (MsgException e) {
                    //--失败，提示失败
                    System.out.println("新增成绩失败!原因:"+e.getMessage());
                    continue;
                }
            }else if("3".equals(line)){
                System.out.println("根据用户编号修改学生成绩，请输入修改信息，格式：math,chinese,english,uid");
                line = scanner.nextLine();
                //--校验格式
                if(!line.matches("([0-9]|[1-9][0-9]|100),([0-9]|[1-9][0-9]|100),([0-9]|[1-9][0-9]|100),\\d+")){
                    System.out.println("输入的成绩格式不正确，请重新输入!");
                    continue;
                }
                int math = Integer.parseInt(line.split(",")[0]);
                int chinese = Integer.parseInt(line.split(",")[1]);
                int english = Integer.parseInt(line.split(",")[2]);
                int uid = Integer.parseInt(line.split(",")[3]);
                //--修改成绩
                try {
                    scoreService.updateScore(new Score(0,math,chinese,english,uid));
                    System.out.println("修改成绩成功!");
                    continue;
                } catch (MsgException e) {
                    System.out.println("修改成绩失败,原因:"+e.getMessage());
                    continue;
                }
            }else if("4".equals(line)){
                System.out.println("请输入要删除的成绩编号:");
                line = scanner.nextLine();
                if(!line.matches("^\\d+$")){
                    System.out.println("输入的成绩编号格式不正确，请重新输入!");
                    continue;
                }
                int id = Integer.parseInt(line);
                scoreService.rmScore(id);
                System.out.println("删除成功!");
                continue;
            }else if("5".equals(line)){
                System.out.println("退出登录成功!");
                return;
            }else{
                System.out.println("错误的操作码，请重新选择！");
                continue;
            }
        }
    }

    public static void handleStu(User user){
        while(true){
            System.out.println(user.getName()+"同学，你好，请选择要执行的操作");
            System.out.println("[1]查询成绩 [2]退出登录");
            String line = scanner.nextLine();
            if("1".equals(line)){
                Score score = scoreService.getScore(user.getId());
                if(score==null){
                    System.out.println("未找到您的成绩!");
                }else{
                    System.out.println("您的成绩为:"+score);
                }
                continue;
            }else if("2".equals(line)){
                System.out.println("退出登录！");
                return;
            }else{
                System.out.println("错误的操作码，请重新选择!");
                continue;
            }
        }
    }

    public static User doLogin(){
        System.out.println("请输入用户名密码,格式:用户名#密码");
        String line = scanner.nextLine();
        if(!line.matches("^\\w+#\\w+$")){
            System.out.println("输入登录信息格式错误,请重新登录!");
            return null;
        }
        String name = line.split("#")[0];
        String psw = line.split("#")[1];
        User user = null;
        try {
            user = userService.login(name,psw);
        } catch (MsgException e) {
            System.out.println("登录失败!失败原因:"+e.getMessage()+",请重新登录！");
            return null;
        }
        System.out.println("登录成功!");
        return user;
    }

    public static void doRegist(){
        System.out.println("输入要注册的用户信息,格式:id,name,psw,role");
        String line = scanner.nextLine();
        if(!line.matches("^[1-9]\\d*,\\w+,\\w+,(0|1)$")){
            //输入格式不正确,则要求重新输入
            System.out.println("输入的注册信息格式不正确!请重新注册!");
            return;
        }
        //进行注册
        int id = Integer.parseInt(line.split(",")[0]);
        String name = line.split(",")[1];
        String psw = line.split(",")[2];
        int role = Integer.parseInt(line.split(",")[3]);
        try {
            userService.regist(new User(id,name,psw,role));
            System.out.println("恭喜您,注册成功!");
            return;
        } catch (MsgException e) {
            System.out.println("注册失败,原因:"+e.getMessage()+",请重新注册!");
            return;
        }
    }

}
