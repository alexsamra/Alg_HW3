import java.util.Scanner;

public class palindromecheck {

    public static void main(String args[]) {

        Scanner myObj = new Scanner(System.in);
        String check;

        System.out.println("Please enter the word/phrase you would like to check:");

        check = myObj.nextLine();

        Boolean result = palindrome(check, 0);

        if(result){
            System.out.println(check + " is a palindrome!");
        }
        else{
            System.out.println(check + " is not a palindrome!");
        }
        myObj.close();
    }

    public static boolean palindrome(String check, int count){
        int end = check.length() - count - 1;
        char first = check.charAt(count);
        char last = check.charAt(end);
        if(end-count <= 0){
            return true;
        }
        else if(Character.compare(first, last) == 0){
            count++;
            return palindrome(check, count);
        }
        else{
            return false;
        }
    }
}
