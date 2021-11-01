package dataStructureImplementation;

public class codepathStringArrays {
    public static void main(String[] args) {
        codepathStringArrays stringArrays = new codepathStringArrays();
        //stringArrays.permutate("abc");
        //stringArrays.reverseSentence("coding for interviews");
        stringArrays.reverseSentenceQuick("coding for interviews");
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

    //coding for interviews - sweivretni rof gnidoc
    public String reverseCorrect(String x) {
        // convert x into an arrayj
        char[] string = x.toCharArray();
        // create the StringBuffer object
        StringBuffer buffer = new StringBuffer();
// iterate from the back of the array, each time adding a character to buffer
        for(int i = string.length - 1; i >= 0; i--) {
            buffer.append(string[i]);
        }
        return buffer.toString();
    }

    //coding for interviews - sweivretni rof gnidoc
    //interviews for coding
    public String reverseSentence (String x) {
        // first reverse the string x using the previous function
        x = reverseCorrect(x);
        // split x, effectively extracting the individual words
        String[] words = x.split(" ");
        // create a StringBuffer
        StringBuffer buffer = new StringBuffer();
        // reverse and add the entries in words to buffer
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            buffer.append(reverseCorrect(words[i]) + " ");
        }
        return buffer.toString();
    }
    //coding for interviews - interviews for coding
    public String reverseSentenceQuick (String x) {
        // use the split method
        String[] words = x.split(" ");
        // create a StringBuffer
        StringBuffer buffer = new StringBuffer();
        // we append starting from the end of words
        for(int i = words.length - 1; i >= 0 ; i--)
        {
            buffer.append(words[i]);
            if(i > 0) {
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }
}
