package 影碟租赁系统二测;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class input {
String fileName="F:\\碟片库.txt";
public static void main(String[] args) throws IOException {
input aa=new input();
BufferedReader in1=new BufferedReader(new InputStreamReader(System.in));
//将控制台输入的内容写入.txt文件
aa.writeTxt(in1.readLine());
//读取.txt文件的内容打印到控制台
System.out.println("您刚刚输入了；"+aa.readTxt());
}
/*向txt文件中写内容*/
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
/*读取txt文件的内容*/
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