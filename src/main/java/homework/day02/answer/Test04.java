package homework.day02.answer;
/**
 * 执行程序，分析并解决问题
 *
 * NumberFormatException出现的情况通常是由包装类将字符串解析为基本类型时,由于字符串内容不能正确描述基本类型导致该异常.
 * 数字    格式      异常
 *
 *
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		/*
		 * 原因:字符串中出现了非法字符，这里是空格
		 */
//		String num = "123 ";
		String num = "123";
		int d = Integer.parseInt(num);
		System.out.println(d);

		/*
		 * 原因:若解析为整数，那么字符串内容必须表示的是一个整数
		 */
//		num = "123.456";
		num = "123";
		d = Integer.parseInt(num);
		System.out.println(num);

		/*
		 * 原因:
		 */
		num = "123";
		//分号不能是中文的!
//		d = Integer.parseInt(num)；
		d = Integer.parseInt(num);
		System.out.println(d);
	}
}
