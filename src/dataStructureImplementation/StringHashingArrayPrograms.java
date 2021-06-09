package dataStructureImplementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class StringHashingArrayPrograms {

    public static void main(String args[]) {
        StringHashingArrayPrograms sha = new StringHashingArrayPrograms();
        /*sha.practise1("viiimmal");
        sha.practise2();
        System.out.println(sha.UniqueCharactersArray("Hello"));
        System.out.println(sha.UniqueCharactersHashSet("Vvampire"));
        System.out.println(sha.UniqueCharactersHashTable("Wworld"));*/
        System.out.println(sha.UniqueCharactersBoolArray("victory"));
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
            System.out.println("Put " + table);
        }
        return true;
    }

    //Ascii value range - 128
    public boolean UniqueCharactersBoolArray(String s) {
        int size = s.length();
        Boolean[] b = new Boolean[128];
        //Arrays.fill(b,false);
        if(size>128) {
            return false;
        }
        for (int i=0; i<128; i++) {
            b[i]=false;
        }
        for (int i =0; i<size; i++) {
            int value = s.charAt(i);
            if(b[value]==true) {
                return false;
            }
            b[value]=true;
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
