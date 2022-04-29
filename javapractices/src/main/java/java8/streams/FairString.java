package java8.streams;

public class FairString {


    public static void main(String[] args) {


        String str = "0001";

        int cost[] = {1, 1, 1, 1};

    }



    void checkCost(int cost[], int costNEw, String str) {

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                str = str.substring(0, i) + "0"
                        + str.substring(i + 1);



            }
        }
    }





    static boolean isValid(String str) {

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // 00110011
    static boolean isValidSecond(String str) {

        for (int i = 2; i < str.length() - 2; i = i + 2) {
            if (str.charAt(i - 2) == str.charAt(i)) {
                return false;
            }
        }

        return true;
    }


}
