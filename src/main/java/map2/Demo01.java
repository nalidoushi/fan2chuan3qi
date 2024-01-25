package map2;

import java.util.HashMap;

/**
 * HashMap基础操作
 */
public class Demo01 {
    public static void main(String[] args) {
        //HashMap<String,Integer> map = new HashMap();
        HashMap map = new HashMap();
        //存数据
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        //取数据
        String k2 = (String) map.get("k2");
        System.out.println(k2);
        //获取存储的数量
        int size = map.size();
        System.out.println(size);
        //移除数据
        map.remove("k2");
        //判断是否包含键
        System.out.println(map.containsKey("k2"));
        //判断是否包含值
        System.out.println(map.containsValue("v3"));
        //判断是否为空
        System.out.println(map.isEmpty());
        //清空Map
        map.clear();
        System.out.println(map);
    }
}
