package homework.day02.answer;

import java.util.Scanner;

/**
 * 正则表达式练习:
 * 1:编写匹配数字的正则表达式,数字至少一位以上.
 *   [0-9]+
 *
 * 2:匹配字符串,要求输入3-15位,内容只能是数字,字母下,划线
 *   [a-zA-Z0-9_]{3,15}
 *
 * 完成下面编程题:
 * 程序启动后,要求用户输入用户名,用户名出现内容要求上述正则表达式2的要求.不匹配则直接
 * 提示用户名有误.
 * 如果无误,则要求用户继续输入年龄,规则为上述正则表达式1的要求,不匹配则提示年龄有误
 * 以上两个输入获取是都要求以字符串形式接受(Scanner的nextLine方法获取)
 *
 * 最后验证年龄在1-100岁之间(包含1和100)
 * 提示:这里可以不用正则表达式验证范围,是否转换为数字判定更方便?
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = scanner.nextLine();
		if(username.matches("[a-zA-Z0-9_]{3,15}")){
			System.out.println("请输入年龄:");
			String ageStr = scanner.nextLine();
			if(ageStr.matches("[0-9]+")){
				int age = Integer.parseInt(ageStr);
				if(age>=1&&age<=100){
					System.out.println("注册成功:"+username+","+age);
				}else{
					System.out.println("年龄范围有误");
				}
			}else{
				System.out.println("年龄输入有误");
			}
		}else{
			System.out.println("用户名输入有误");
		}
	}
}





