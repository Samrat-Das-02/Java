package Array_list;
import java.util.*;
public class Array_list_1 {
    public static void main(String[] args){
        String str=new String();
        System.out.println("Insert the number of strings into Array_list :");
        int count;
        Scanner s = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        count = s.nextInt();
        ArrayList<String> list = new ArrayList<String>();  //create arraylist
        for (int i = 0; i <count; i++) {
            System.out.println("Enter string ");
            str=sc.nextLine();
            list.add(str);
        }
        System.out.println("The List ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
    }
    s.close();
}
}
