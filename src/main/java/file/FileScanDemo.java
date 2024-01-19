package file;

import java.io.File;

public class FileScanDemo {
    //无限递归,会出现内存溢出(栈内存溢出-StackOverflowError)
    static void doScan(){
        doScan();
    }

    /**
     * 获取指定目录以及此目录下所有子目录中的xml文件
     * @param file
     */
    static void doScanXml(File file){
        File files[]=file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                doScanXml(f);
            }else{
                if(f.getName().endsWith(".xml"))
                System.out.println(f.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args) {
        //doScan();
        doScanXml(new File("."));
    }
}
