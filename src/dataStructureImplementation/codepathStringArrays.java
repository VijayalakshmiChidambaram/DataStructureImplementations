package dataStructureImplementation;

public class codepathStringArrays {
    public static void main(String[] args) {
        codepathStringArrays stringArrays = new codepathStringArrays();
        stringArrays.permutate("abc");
    }
    public static void permutate(String str) {
        permutation("", str);
    }

    private static void permutation(String ans, String remain) {
        int n = remain.length();
        // ans serves as an accumulator variable
        // base case: we print out ans since there are no more letters to be added
        if (n == 0) {
            System.out.println(ans);
        }
        // recursive case
        else {
            for (int i = 0; i < n; i++) {
                // we call permutation, each time combining prefix with the individual letters in str
                // we also remove these letters from str
                permutation(ans + remain.charAt(i), remain.substring(0,i) + remain.substring(i+1, n));
            }
        }
    }
}
