package basics;

public class CopyByValue {

    public static void main(String[] args) {

        Long value = 1l;
        String str ="Hello";
        changeValue(value,str);
        System.out.println(value+" "+str);
    }


   static  void changeValue(Long  time , String str)
    {
        System.out.println("changing value of long field ...");
        time = 3l;
        str += "Shivam";

    }
}
