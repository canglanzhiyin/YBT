package Ӱ������ϵͳ����;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class input {
String fileName="F:\\��Ƭ��.txt";
public static void main(String[] args) throws IOException {
input aa=new input();
BufferedReader in1=new BufferedReader(new InputStreamReader(System.in));
//������̨���������д��.txt�ļ�
aa.writeTxt(in1.readLine());
//��ȡ.txt�ļ������ݴ�ӡ������̨
System.out.println("���ո������ˣ�"+aa.readTxt());
}
/*��txt�ļ���д����*/
public void writeTxt(String str){
File f = new File(fileName);
try {
if(!f.exists()||!f.isFile()){
    f.createNewFile();
}
 OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");  
     outputStream.write(str);
 outputStream.close();
} catch (Exception e) {
e.printStackTrace();
} 
}
/*��ȡtxt�ļ�������*/
public String readTxt(){
File file = new File(fileName);
String prompt="";
try{
BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
    String str=null;
    while((str=br.readLine())!=null){
     prompt=prompt+str;
    }
br.close();
    }catch(Exception e) {
e.printStackTrace();
}
return prompt; 
}
}