package Ӱ������ϵͳ����;

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
		System.out.println("�����������ĵ�Ƭ�����:\r");
		int number1 = input.nextInt();
		System.out.println("�����������ĵ�Ƭ������:\r");
		//����String��
		String name = input.next();
		System.out.println("��������Ҫ���ĵ�Ƭ������\r");
		//����int��
		int number2 = input.nextInt();//ʲô����next����ͽ�ʲô ע���Сд
		//������
		System.out.println("��ע����Ҫ���ĵ�Ƭ���Ϊ��"+number1+"   �����ǣ�"+name+"   ����Ϊ:"+number2);
	
      
     Scanner scanner = new Scanner(System.in);
     
     String a="D:\\\\��Ӱ��\\\\";
     String c=".txt";
     String b=a+number1+c;
     System.out.println("·��Ϊ"+b);
    
     
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
    	 System.out.println("������˼��Ƭ���������������������Ƭ����");
    	  temp = input.nextInt();
    	 caozuo=caozuo-temp;
 		}
    
    	 
     System.out.println("ʣ������Ϊ��\r\n"+caozuo);
     String gengxin=gg[0]+" "+gg[1]+" "+caozuo;
     System.out.println("���������"+gengxin);
     File f = new File(""+b);
     FileWriter fw =  new FileWriter(f);
     fw.write(""+gengxin);
     fw.close();
     System.out.println("��лʹ�ñ�ϵͳ��ף���������");
     
 }
}
