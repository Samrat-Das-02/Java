package Array_list;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Array_list_student_file {
    public static void main(String[] args) throws Exception {
     
        String filename;
        filename="Student.txt";
        ArrayList<String> list=new ArrayList<String>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filename)))
        {
            String line;
            line=reader.readLine();
            while(line!=null){
                list.add(line);
            }
        }
        catch(IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        for(String name : list){
            System.out.println(name);
        }
}
}
