package string;

/**
 * char charAt(int index)
 * 获取当前字符串中指定位置上的字符
 */
public class CharAtDemo {
    public static void main(String[] args) {
        //            01234567890
        String str = "www.tedu.cn";
        char c = str.charAt(4);
        System.out.println(c);//t


        String line = "上海自来水自来海上";
        /*int flag=line.length()/2;
        for(int i=0;i<line.length()/2;i++){
            char c1 = line.charAt(i);
            char c2 = line.charAt(line.length()-1-i);
            if(c1!=c2){
                System.out.println("不是回文");
                break;
            }
            if(i==flag-1){
                System.out.println("是回文");
            }
        }*/

        /*boolean check = true;//默认认为是回文
        for(int i=0;i<line.length()/2;i++){
            char c1 = line.charAt(i);
            char c2 = line.charAt(line.length()-1-i);
            if(c1!=c2){
                System.out.println("不是回文");
                check=false;
                break;
            }
        }
        if(check){
            System.out.println("是回文");
        }*/


       /* for(int i=0;i<line.length()/2;i++){
            char c1 = line.charAt(i);
            char c2 = line.charAt(line.length()-1-i);
            if(c1!=c2){
                System.out.println("不是回文");
                return;
            }
        }
        System.out.println("是回文");*/


        for(int i=0;i<line.length()/2;i++){
            char c1 = line.charAt(i);
            char c2 = line.charAt(line.length()-1-i);
            if(c1!=c2){
                System.out.print("不");
                break;
            }
        }
        System.out.println("是回文");


       /* //1
        char c1 = line.charAt(0);
        char c2 = line.charAt(line.length()-1);
        //2
        c1 = line.charAt(1);
        c2 = line.charAt(line.length()-2);
        //3
        c1 = line.charAt(2);
        c2 = line.charAt(line.length()-3);
        //4
        c1 = line.charAt(3);
        c2 = line.charAt(line.length()-4);*/

    }
}



