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
        System.out.println(sha.permutationHashSet("dog","god"));*/
        System.out.println(sha.permutationHashMap(" filter", "retlif "));

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

    // Permutation of a given two strings - case insensitive and whitespace significant
    // Time - O(n) - Because of sorting

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

    //Hashset values adding
    public void practise1(String s) {
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
