package 影碟租赁系统二测;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class lend {
    public static void main(String[] args) throws IOException { 
    	Scanner input = new Scanner(System.in);
		System.out.println("请输入你租借的碟片的序号:\r");
		int number1 = input.nextInt();
		System.out.println("请输入你租借的碟片的名称:\r");
		//接受String型
		String name = input.next();
		System.out.println("请输入你要租借的碟片的数量\r");
		//接受int型
		int number2 = input.nextInt();//什么类型next后面就接什么 注意大小写
		//输出结果
		System.out.println("请注意你要租借的碟片序号为："+number1+"   名字是："+name+"   数量为:"+number2);
	
      
     Scanner scanner = new Scanner(System.in);
     
     String a="D:\\\\电影库\\\\";
     String c=".txt";
     String b=a+number1+c;
     System.out.println("路径为"+b);
    
     
     Scanner sc = new Scanner(new File(""+b));
     String zifu = sc.nextLine();
     System.out.println(""+zifu);
     String[] gg=zifu.split(" ");
     int caozuo=Integer.parseInt(gg[2]);
     caozuo=caozuo-number2;
     int temp=number2;
     while(caozuo<0)
    	 {
    	 caozuo=caozuo+temp;
    	 System.out.println("不好意思碟片数量不够，请重新输入碟片数量");
    	  temp = input.nextInt();
    	 caozuo=caozuo-temp;
 		}
    
    	 
     System.out.println("剩余数量为：\r\n"+caozuo);
     String gengxin=gg[0]+" "+gg[1]+" "+caozuo;
     System.out.println("现在情况："+gengxin);
     File f = new File(""+b);
     FileWriter fw =  new FileWriter(f);
     fw.write(""+gengxin);
     fw.close();
     System.out.println("感谢使用本系统，祝您生活愉快");
     
 }
}
