
public class easyinversioncount {
    public static void main(String args[]) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 2;
        A[2] = 1;
        A[3] = 10;
        A[4] = 9;

        int count = invCount(A, 0);
        System.out.println("There are " + count + " inversions in the matrix.");
        printArray(A);
    }

    public static int invCount(int[] A, int round){
        int count = 0;
        int temp;
        if(round >= A.length){
            return count;
        }
        else{
            for(int i = round+1; i < A.length; i++){
                if(A[round] > A[i]){
                    count++;
                    temp = A[round];
                    A[round] = A[i];
                    A[i] = temp;
                }
            }
            round++;
            return count + invCount(A, round);
        }
    }

    public static void printArray(int[] A){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + "   ");
        }
    }
}
