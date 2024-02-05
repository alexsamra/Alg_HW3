import java.util.*;

public class fastinversioncount {
    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 2;
        A[2] = 1;
        A[3] = 10;
        A[4] = 9;

        List<Integer> a = Arrays.stream(A).boxed().toList();

        printArray(a);
        a = mergeCount(a);
        printArray(a);
        
    }

    public static List<Integer> mergeCount(List<Integer> A){
        if(A.size() == 1){
            return A;
        }
        else{
            int length = A.size();
            int a1Length = length/2;

            List<Integer> a1 = new ArrayList<>();
            List<Integer> a2 = new ArrayList<>();

            for(int i = 0; i < a1Length; i++){
                a1.add(A.get(i));
            }

            for(int j = a1Length; j < A.size(); j++){
                a2.add(A.get(j));
            }
            
            a1 = mergeCount(a1);
            a2 = mergeCount(a2);

            return merge(a1, a2);
        }
    }

    public static List<Integer> merge(List<Integer> a1, List<Integer> a2){

        List<Integer> b = new ArrayList<>();

        while(!a1.isEmpty() && !a2.isEmpty()){
            if(a1.get(0) > a2.get(0)){
                b.add(a2.get(0));
                a2.remove(0);
            }
            else{
                System.out.println("Inversion");
                b.add(a1.get(0));
                a1.remove(0);
            }
        }
        while(!a1.isEmpty()){
            b.add(a1.get(0));
            a1.remove(0);
        }
        while(!a2.isEmpty()){
            b.add(a2.get(0));
            a2.remove(0);
        }
        return b;
    }

    public static void printArray(List<Integer> A){
        System.out.print("Array: ");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + "   ");
        }
        System.out.println("");
    }
}
