package Ӱ������ϵͳ����;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
  
 
public class read {
    /**
     * ���ܣ�Java��ȡtxt�ļ�������
     * ���裺1���Ȼ���ļ����
     * 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
     * 3����ȡ������������Ҫ��ȡ�����ֽ���
     * 4��һ��һ�е������readline()��
     * ��ע����Ҫ���ǵ����쳣���
     * @param filePath
     */
    public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ������ʽ
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("�Ҳ���ָ�����ļ�");
        }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
      
    }
      
    public static void main(String argv[]){
        String filePath = "F:\\��Ƭ��.txt";
//      "res/";
        readTxtFile(filePath);
    }
      
      
  
}
      
      
  