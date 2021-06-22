package dataStructureImplementation;

import java.util.*;

import static java.util.Arrays.sort;

public class StringHashingArrayPrograms {

    public static void main(String args[]) {
        StringHashingArrayPrograms sha = new StringHashingArrayPrograms();
        /*sha.practise1("viiimmal");
        sha.practise2();

        System.out.println(sha.UniqueCharactersArray("Hello"));
        System.out.println(sha.UniqueCharactersHashSet("Vvampire"));
        System.out.println(sha.UniqueCharactersHashTable("Wworld"));
        System.out.println(sha.UniqueCharactersBoolArray("victory"));
        System.out.println(sha.UniqueCharactersBitVector("nearing"));
        System.out.println(sha.permutationUsingSort("abcd", "dcba"));
        System.out.println(sha.permutationCaseSensitiveAndSpace("   Do  g", "God "));
        System.out.println(sha.permutationHashSet("dog","god"));
        System.out.println(sha.permutationHashMap(" filter", "retlif "));
        System.out.println(sha.permutationArray("run1", "1nur"));
        System.out.println(sha.urlifyArray("Mr John Smith    ", 13));
        System.out.println(sha.urlifyArrayList("Mr John Smith    ", 13));
        System.out.println(sha.urlifystringbuilder("United States of America !!"));
        System.out.println(sha.palindromePermutation("Tacocattt"));
        System.out.println(sha.oneawayArray("pale", "bale"));
        System.out.println(sha.oneawayArray("aple", "apple"));
        System.out.println(sha.oneawayArray("apple","aple"));
        System.out.println(sha.stringCompressionsb("aabccccaaa"));*/
        //System.out.println(sha.stringCompressionUsingNewString("aabbba"));
        //System.out.println(sha.oneawayHashMap("peno", "pero"));
        //System.out.println(sha.oneawayHashMap("xeroxx", "xerox"));
        //sha.inputDataRotateMatrixUsingSwap(4);
        int [][] input = {{0, 50, 100, 20}, {50, 0, 70, 110}, {100, 70, 0, 200}, {20, 110, 200, 0}};
        System.out.println(Arrays.deepToString(sha.rotateMatrixUsingSwapPassValues(input)));

    }

    //Time - O(n^2)
    public boolean UniqueCharactersArray(String s) {
        int size = s.length();
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Time - O(n)
    public boolean UniqueCharactersHashSet(String s) {
        int size = s.length();
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<size; i++) {
            if(set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    //Time - O(n)
    public boolean UniqueCharactersHashTable(String s) {
        int size = s.length();
        Hashtable<Character,Integer> table = new Hashtable<Character,Integer>();
        for(int i=0; i<size; i++) {
            int count=0;
            if(table.containsKey(s.charAt(i))) {
                    System.out.println("Contains " + table);
                    return false;
            }
            table.put(s.charAt(i),count+1);
            System.out.println("Put " + table.put(s.charAt(i),count+1));
            System.out.println(" final " + table);
        }
        return true;
    }

    //Ascii value range - 128
    //Time - O(n) , Space O(n)
    public boolean UniqueCharactersBoolArray(String s) {
        int size = s.length();
        Boolean[] b = new Boolean[128];

        if (size > 128) {
            return false;
        }
        //Arrays.fill(b,false);
        for (int i = 0; i < 128; i++) {
            b[i] = false;
        }
        for (int i = 0; i < size; i++) {
            int value = s.charAt(i);
            if (b[value] == true) {
                return false;
            }
            b[value] = true;
        }
        return true;
    }

    //Time - O(n), Space - O(1)
    public boolean UniqueCharactersBitVector(String s) {
        int count = 0;
        int size = s.length();
        for(int i=0; i<size; i++) {
            int val = s.charAt(i)- 'a';
            if((count & (1 << val)) > 0) {
                return false;
            }
            count = count | (1 << val);
        }
        return true;
    }

    // 2) Permutation of a given two strings - case insensitive and whitespace significant
    //Time - O(n logn) - Because of sorting
    private String sorting(String s) {
        char[] ch = s.toCharArray();
        sort(ch);
        return String.valueOf(ch);
       // return Arrays.toString(ch);
    }

    public boolean permutationUsingSort(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String sortedS1 = sorting(s1);
        String sortedS2 = sorting(s2);
        return sortedS1.equals(sortedS2);
        }

    public boolean permutationCaseSensitiveAndSpace(String s1, String s2) {
        String newS1 = s1.toLowerCase().replace(" ","");
        String newS2 = s2.toLowerCase().replace(" ","");
        if(newS1.length()!=newS2.length()) {
            return false;
        }
        return sorting(newS1).equals(sorting(newS2));
    }

    // Permutation of a given two strings Hash set- case insensitive and whitespace significant
    // Time - O(n)

    public boolean permutationHashSet(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        HashSet<Character> set = new HashSet<>(s1.length());
        int count = 0;
        for(int i=0; i<s1.length(); i++) {
            set.add(s1.charAt(i));
            count++;
        }
        for(int j=0; j<s2.length(); j++) {
            if (set.contains(s2.charAt(j))) {
                count--;
            }
        }
        if(count!=0) {
            return false;
        }

        return true;
    }

    // Permutation of a given two strings Hash Map - case insensitive and whitespace significant
    // Time - O(n)
    public boolean permutationHashMap(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>(s1.length());
        int count=0;
        for(int i=0; i<s1.length(); i++) {
            map.put(s1.charAt(i),count++);
        }
        for (int j=0; j<s2.length(); j++) {
            if(map.containsKey(s2.charAt(j))); {
                count--;
            }
        }
        if (count!=0) {
            return false;
        }
        return true;
    }

    // Permutation of a given two strings Array - case insensitive and whitespace significant
    // Time - O(n)
    public boolean permutationArray(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] b = new int[128];
        Arrays.fill(b, 0);
        for (int i = 0; i < s1.length(); i++) {
            b[s1.charAt(i)]++;
        }
        for (int j = 0; j < s2.length(); j++) {
            b[s2.charAt(j)]--;
            if (b[s2.charAt(j)] != 0) {
                return false;
            }
        }
            return true;
        }

    //3) URLify Replace all spaces in a string with %20 - Using char array - O(n)
    public String urlifyArray(String s1, int truelength) {
        char[] s = s1.toCharArray();
        int space =0;

        for(int i = truelength; i<s.length; i++) {
                s[i] = '\0';
            }

        for(int i=0; i<s1.length(); i++) {
            if(s[i]== ' ') {
                space++;
            }
        }
        int n =3;
        int finallength = truelength + space*(n-1);
        for(int i =truelength-1; i>=0; i--) {
            if(s[i] == ' ') {
                s[finallength-1] = '0';
                s[finallength-2] = '2';
                s[finallength-3] = '%';
                finallength = finallength-3;
            }
            else {
                s[finallength - 1] = s[i];
                finallength--;
            }
        }
        return String.valueOf(s);
    }

    //3) URLify Replace all spaces in a string with %20 - Using ArrayList - O(n)
    public String urlifyArrayList(String s1, int truelength) {
        ArrayList<Character> list = new ArrayList<Character>(s1.length());
        String str = new String();
        for(int i=0; i<s1.length(); i++) {
            list.add(s1.charAt(i));
        }
        int space=0;
        for(int i=truelength; i<s1.length(); i++) {
            list.set(i, '\0');
        }
        for(int i =0; i<s1.length(); i++) {
            if(list.get(i).equals(' ')) {
                space++;
            }
        }
        int finallength = truelength + space * 2;
        for (int i=truelength-1; i>=0; i--) {
            if (list.get(i).equals(' ')) {
                list.set(finallength-1, '0');
                list.set(finallength-2, '2');
                list.set(finallength-3, '%');
                finallength = finallength-3;
            }
            else {
                list.set(finallength - 1, list.get(i));
                finallength--;
            }
            str = list.toString().replaceAll(", ", "").replaceAll("\\[|\\]","");
        }
        return str;
    }

    //3) URLify Replace all spaces in a string with %20 - Using Stringbuilder - O(n)
    public StringBuilder urlifystringbuilder (String s1) {
        char[] s = s1.toCharArray();
        StringBuilder modifiedString = new StringBuilder();
        for(int i=0; i<s.length; i++) {
            if(s[i] == ' ') {
                modifiedString.append("%20");
            }
            else {
                modifiedString.append(s[i]);
            }
        }
        return modifiedString;
    }

    //4) Palindrome Permutation Array - O(n)
    public boolean palindromePermutation(String s1) {
        int valz = Character.getNumericValue('z');
        int vala = Character.getNumericValue('a');
        int[] table = new int[(valz - vala) + 1];
        char[] ch1 = s1.toLowerCase(Locale.ROOT).toCharArray();
        char[] ch = s1.toCharArray();

        for(int i=0; i<ch.length; i++) {
            int val = Character.getNumericValue(ch[i]) - vala;
            if (val>valz && val<vala) {
                return false;
            }
                table[val]++;
        }
        boolean found = false;
        for(int i=0; i<table.length; i++) {

            if(table[i]%2 ==1) {
                if(found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }

    //5) One Away: Three types of edits performed on
    // strings: insert a character, remove a character, or replace a character - O(n)
    public boolean oneawayArray(String s1, String s2) {
        if(s1.length()==s2.length()) {
            return replace(s1,s2);
        }
        else if(s1.length() < s2.length()) {
            return insertAndremove(s1, s2);
        }
        else if (s1.length() > s2.length()) {
            return insertAndremove(s2, s1);
        }
        return false;
    }
    public boolean replace(String s1, String s2) {
        boolean found = false;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                if(found) {
                    return false;
                }
                found=true;
            }
        }
        return true;
    }
    //aple -> apple
    public boolean insertAndremove(String s1, String s2) {
        int i=0, j=0;
        boolean found = false;
        while (i<s1.length() & j<s2.length()) {
            if (s1.charAt(i)!=s2.charAt(j)) {
                if(found) {
                    return false;
                }
                    found = true;
                    j++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    //5) One Away: Three types of edits performed on
    // strings: insert a character, remove a character, or replace a character
    public boolean oneawayHashMap(String s1, String s2) {
        if(s1.length()==s2.length()) {
            return replaceHM(s1,s2);
        }
        else if(s1.length()+1 == s2.length()) {
            return insertRemoveHT(s1, s2);
        }
        else if (s1.length()-1 == s2.length()) {
            return insertRemoveHT(s2, s1);
        }
        return false;
    }
    public boolean replaceHM(String s1, String s2) {
        //HashMap<Character,Integer> map = new HashMap<>(s1.length());
        HashSet<Character> set = new HashSet<>(s1.length());
        int count =0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                set.add(s1.charAt(i));
                count++;
            }
        }
        if(count>1) {
            return false;
        }
        return true;
    }
    public boolean insertRemoveHT(String s1, String s2) {
        Hashtable<Character,Integer> table = new Hashtable<>(s2.length());
        int count =0, i = 0, j=0;
        boolean found = false;
        while (i<s1.length() && j<s2.length()) {
            if(s1.charAt(i)!=s2.charAt(j)) {
                if(found == false) {
                    found = true;
                    table.put(s2.charAt(i), count++);
                    j++;
                }
                else if(found == true) {
                    return false;
                }
            }
            i++;
            j++;
        }
        if (count>1) {
            return false;
        }
        return true;
    }

    //6) String Compression - Using new string O(n^2) - aabbb = a2b3
    //Using a new string will copy the contents of older string into the new new string every time. So time complexity is - x+2x+3X+.. = x(x+1)/2 (G.P)
    //Hence time complexity is O(n^2)
    public String stringCompressionUsingNewString(String s) {
        String newString = "";
        int count=0;
        for(int i=0; i<s.length(); i++) {
            count++;

            if(i+1>=s.length()) {
                newString = newString + s.charAt(i) + count;
            }
            else if (s.charAt(i)!= s.charAt(i+1)) {
                newString = newString + s.charAt(i) + count;
                count=0;
            }
        }
        return newString.length() < s.length() ? newString : s;
    }


    //6) String compression - stringbuilder - O(n)
    public String stringCompressionsb(String s) {
        StringBuilder builder = new StringBuilder(s.length());

        int count = 0;
        for(int i=0; i<s.length(); i++) {
            count++;
            if ((i+1>=s.length()) || (s.charAt(i) != s.charAt(i+1))) {
                builder.append(s.charAt(i));
                builder.append(count);
                count = 0;
            }
        }
        if(builder.length() < s.length()) {
            return builder.toString();
        }
            return s;
    }

//7) Rotate Matrix- Using swap - Time : O(n^2), Space is O(1) - Done within the same space
    public void inputDataRotateMatrixUsingSwap(int n) {
        int[][] matrix = new int[n][n];
        Scanner input = new Scanner(System.in);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        rotateMatrixUsingSwap(matrix);
    }
    public int[][] rotateMatrixUsingSwap(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n/2; i++) {
            for (int j=i; j<n; j++) {
                int top = matrix[i][j];
               matrix[i][j] = matrix[n-1-j][i];
               matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
               matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
               matrix[j][n-1-i] = top;
            }
        }
        return matrix;
    }
    //7) Rotate Matrix- Using swap - Time : O(n^2), Space is O(1) - Done within the same space
    public int[][] rotateMatrixUsingSwapPassValues(int[][] matrix) {
        int n = matrix.length;
        int i =0, j =0;
        for (i = 0; i < n / 2; i++) {
            for (j = i; j < n; j++) {
                int top = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = top;
            }
        }
                System.out.println("Final matrix" + Arrays.deepToString(matrix));
        return matrix;
    }

    //Hashset values adding
    public void practise1 (String s) {
        int size = s.length();
        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<size; i++) {
            set.add(s.charAt(i));
            System.out.println(set);
        }
        System.out.println("Set " + set);
        int ch = Character.getNumericValue('d');
        System.out.println(" try " + ch);
    }

    //HashTable values adding
    public void practise2() {
        Hashtable<Integer, String> tab = new Hashtable<>();
            tab.put(1, "Vimal");
            tab.put(1, "Vijayalakshmi");
            tab.put(2, "Vimal");
            tab.put(2, "A");
            tab.put(3, "P");
            tab.put(2, "P");
        System.out.println("Table " + tab);
        }

    public void check() {
        String s = "Mr Vimal  ";
        char[] ch = s.toCharArray();
        System.out.println(" ch content " + Arrays.toString(ch));
        int len = ch.length;
        System.out.println("Len " + len);
    }
}