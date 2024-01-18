package homework.day03.answer;

//import java.awt.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 改错题
 *
 * 程序需求:向一个List集合中添加10个数字1-10，并将它们
 * 遍历出来并输出到控制台。
 *
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		//1:泛型只能是引用类型
		//2:List是一个接口，不能实例化
		//3:List导包错误，不能导入java.awt.List,应当用java.util.List
//		List<int> list = new List<int>();
		List<Integer> list = new ArrayList<>();
		//缺少向集合中添加元素的操作
		for(int i=1;i<=10;i++){
			list.add(i);
		}

		//迭代器最好也指定泛型
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int i = it.next();
			//不能在一次循环中连续调用两次next
//			System.out.println(it.next());
			System.out.println(i);
		}
	}
}





