import java.util.*;

public class graycodesarefun {
    public static void main(String[] args) {
       int input; 
       Scanner myObj = new Scanner(System.in);

       System.out.println("Enter a value for n: ");
       input = myObj.nextInt();

       List<String> L =  BRGC(input);

       printArray(L);

       myObj.close();
    }

    public static List<String> BRGC(int n){
        List<String> L = new ArrayList<>(); 
        if(n == 1){
            L.add("0");
            L.add("1");
        }
        else{ 
            List<String> L1 = BRGC(n-1);
            List<String> L2 = reverse(L1);
            L1 = add(L1, "0");
            L2 = add(L2, "1");
            L = listAppend(L1, L2);
        }
        return L;
    }

    public static List<String> reverse(List<String> L){
        List<String> L2 = new ArrayList<>(); 
        for(int i = L.size()-1; i >= 0; i--){
            L2.add(L.get(i));
        }
        return L2;
    }

    public static List<String> add(List<String> L, String num){
        List<String> newL = new ArrayList<>();
        for(int i = 0; i < L.size(); i++){
            newL.add(num.concat(L.get(i)));
        }
        return newL;
    }

    public static List<String> listAppend(List<String> L1, List<String> L2){
        List<String> L = new ArrayList<>();
        for(int i = 0; i < L1.size(); i++){
            L.add(L1.get(i));
        }
        for(int i = 0; i < L2.size(); i++){
            L.add(L2.get(i));
        }
        return L;
    }

    public static void printArray(List<String> A){
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
            printNames(A.get(i));
        }
    }

    public static void printNames(String gc){
        String present = "1";
        
        if(gc.subSequence(0,1).equals(present)){
            System.out.print(" Dylan ");
        }
        if(gc.subSequence(1,2).equals(present)){
            System.out.print("Chris ");
        }
        if(gc.subSequence(2,3).equals(present)){
            System.out.print("Bob ");
        }
        if(gc.subSequence(3,4).equals(present)){
            System.out.print("Alice");
        }
        System.out.println("");
    }

}
