package homework.day03.answer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		Random random = new Random();
		while(set.size()<10){
			set.add(random.nextInt(100));
		}
		System.out.println(set);
	}
}
