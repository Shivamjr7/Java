package basics;

public class Strings {

    public static void main(String[] args) {

        /**
         * String Interning
         */
        String first = "first"; // creates STring on pool which is in metaspace
        String second = new String ("second");// creates String on heap
        String third = new String("first").intern(); // checks if there was similar string in pool


        /**
         * Equals and hashcode
         */
        String a =  "Shivam";
        String b  = "Shivam";
        String c = new String ("Shivam");
        String d = new String ("Shivam").intern();


        System.out.println("a==b : "+ (a==b)); // true
        System.out.println("b==c : " + (b==c)); // false
        System.out.println("b==d : " + (b==d)); // true

        System.out.println("a.equals(c) : "+(a.equals(c)));

    }

}
