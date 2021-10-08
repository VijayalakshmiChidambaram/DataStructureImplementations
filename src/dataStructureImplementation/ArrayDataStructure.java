package dataStructureImplementation;

import java.util.*;
import java.util.List;

public class ArrayDataStructure {
    public static void main(String[] args) {
        ArrayDataStructure arr = new ArrayDataStructure();
        /*System.out.println(Arrays.toString(arr.traversal()));
        System.out.println(Arrays.toString(arr.arrayinsertmiddle()));
        System.out.println(Arrays.toString(arr.arrayInsertionEnd()));
        System.out.println(Arrays.toString(arr.arrayInsertBegin()));
        System.out.println(Arrays.toString(arr.unSortedArrayInsert()));
        System.out.println(Arrays.toString(arr.sortedArrayDeletemid()));
        System.out.println(Arrays.toString(arr.sortArray()));
        System.out.println(arr.searchElement());
        System.out.println(arr.searchElementInString());
        arr.isIsomorphic("bbbaaaba", "aaabbbba");
        arr.isHappy(68);
        String[] topK = {"ab", "ab", "bc", "cd"};
        arr.topKFrequent(topK, 2);
        arr.isValid("()");
        int[] nums1 = {11,22,88,90};
        int[] nums2 = {22,30,55,77};
        arr.kSmallestPairs(nums1, nums2, 2);
        int[] sampleArr = {1,2,3};
        arr.subArraySumBetterTime(sampleArr, 3);*/
        List<Integer> aa = Arrays.asList(7,6,5);
        List<Integer> bb = Arrays.asList(7,6,2);
        arr.comparatorValueTwoArrays(aa, bb, 1);
    }

    //Array Traversal
    public int[] traversal() {
        int[] arrayTraverse = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter a value : ");
            Scanner inputArray = new Scanner(System.in);
            arrayTraverse[i] = inputArray.nextInt();
        }
        return arrayTraverse;
    }

    //Insertion into Sorted Array
    //Insertion at the middle
    public int[] arrayinsertmiddle() {
        int[] arraymid = new int[10];
        arraymid[0] = 1;
        arraymid[1] = 2;
        arraymid[2] = 4;
        arraymid[3] = 5;
        arraymid[4] = 6;
        int size = arraymid.length;

        int insertionSize = 5;
        int position = 3;
        int insertionNumber = 3;
        for (int i = insertionSize - 1; i >= position - 1; i--) {
            arraymid[i + 1] = arraymid[i];
        }
        arraymid[position - 1] = insertionNumber;

        return arraymid;
    }

    //InsertionAtEnd
    public int[] arrayInsertionEnd() {
        int[] arrayEnd = new int[10];
        int insertionNumber = 6;
        for (int i = 0; i < insertionNumber; i++) {
            System.out.println("Enter the required sorted numbers: ");
            Scanner insertNumber = new Scanner(System.in);
            arrayEnd[i] = insertNumber.nextInt();
        }

        int insertEnd = 15;
        arrayEnd[insertionNumber] = insertEnd;

        return arrayEnd;
    }

    //InsertionAtBeginning
    public int[] arrayInsertBegin() {
        int[] arrayBegin = new int[5];
        int insertionSize = 3;
        int insertElement = 0;
        for (int i = 0; i < insertionSize; i++) {
            System.out.println("Enter the values ");
            Scanner insertNumbers = new Scanner(System.in);
            arrayBegin[i] = insertNumbers.nextInt();
        }
        for (int i = insertionSize - 1; i <= 0; i++) {
            arrayBegin[i + 1] = arrayBegin[i];
        }
        arrayBegin[0] = insertElement;
        return arrayBegin;
    }

    //Insertion into UnSorted Array
    //Insertion at the middle
    public int[] unSortedArrayInsert() {
        int[] unsortedarraymid = new int[10];
        unsortedarraymid[0] = 1;
        unsortedarraymid[1] = 2;
        unsortedarraymid[2] = 3;
        unsortedarraymid[3] = 5;
        unsortedarraymid[4] = 6;
        int size = unsortedarraymid.length;
        int position = 3;
        int insertNumber = 4;
        int sizeOfArray = 5;
        if (position <= 0 || position > size) {
            System.out.println("Array index out of bound exception");
        }
        unsortedarraymid[sizeOfArray - 1] = unsortedarraymid[position - 1];
        unsortedarraymid[position - 1] = insertNumber;

        return unsortedarraymid;
    }

    //Deletion into Sorted Array
    //Deletion from middle
    public char[] sortedArrayDeletemid() {
        char[] arraydelmid = {'a', 'b', 'c', 'd', 'e'};
        int position = 2;
        int size = arraydelmid.length;
        char[] newarraydelmid = new char[size - 1];

        for (int i = position; i < size; i++) {
            arraydelmid[i - 1] = arraydelmid[i];
        }
        System.arraycopy(arraydelmid, 0, newarraydelmid, 0, size - 1);
        return newarraydelmid;
    }

    //Array Sorting
    public int[] sortArray() {
        int[] unsortedArray = {11, 2, 3, 1, 6, 3, 5, 8, 9, 19, 23};
        int size = unsortedArray.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (unsortedArray[i] >= unsortedArray[j]) {
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }

            }
        }
        return unsortedArray;
    }

    //Search for an element in an character array
    public char searchElement() {
        char[] ch = {'a', 'b', 'd', 'e', 'f'};
        char newValue = 0;

        int size = ch.length;
        int position = 4;
        for (int i = 0; i < size; i++) {
            if (ch[i] == ch[position]) {
                newValue = ch[position];
            }
        }
        return newValue;
    }


    //Search a character in a string
    public char searchElementInString() {
        String value = "Hello";

        int position = 3;
        char finalVal = 0;
        int size = value.length();

        for (int i = 0; i < size; i++) {
            if (value.charAt(i) == value.charAt(position)) {
                finalVal = value.charAt(i);
                return finalVal;
            }
        }
        return finalVal;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { // egg, add
            return false;
        } else {
            HashMap<Character, Character> map = new HashMap<Character, Character>();
            char[] Strings = s.toCharArray();
            char[] Stringt = t.toCharArray();
            for (int i = 0; i < Strings.length; i++) { //0, 1, 2
                if (map.containsKey(Strings[i])) {
                    if (map.get(Strings[i]) != Stringt[i]) {
                        return false;
                    }
                } else if (map.containsValue(Stringt[i])) {
                    return false;
                }
                map.put(Strings[i], Stringt[i]);
            }
        }
            return true;
    }

    // Time - O(n), Space - O(n)
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        else {
            while(n != 1) {
                int carry = 0, temp = 0;
                while(n>=10) { // 68
                    carry = n % 10; // 8
                    n = n/10; // 6
                    temp += (carry*carry); // 64
                }
                if(n == 1 && carry == 0) {
                    break;
                }
                if(n<10) {
                    temp += (n*n); //36+64 = 100 , 1
                    n = temp; // n = 100 , 1
                }


            }

        }
        return true;
    }
    //Time - O(n)->Hashing + O(n) -> Build heap, O(k logn)-> k elements going to pop from n elements. So -> O(k logn)
    //Space - O(n) -> Map + O(n) -> heap = O(n)

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>(k);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
                map.put(words[i],map.getOrDefault(words[i], 0)+1);
            }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>( (a,b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b);
            }
            else {
                return (map.get(b)-map.get(a) );
            }
        });
        System.out.println("abc");
        priorityQueue.addAll(map.keySet()); // Higher top
        System.out.println("bcd");

        for(int i=0; i<k ;i++) {
            result.add(priorityQueue.poll());
        }
        return result;
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(!stack.empty() && map.get(stack.peek()) == curr) {
                stack.pop();
            }
            else if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if ((stack.empty()) || (stack.peek()!= curr)) {
                return false;
            }
        }

        return stack.empty();
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<> ();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return pairs;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<> ((arr1, arr2) -> arr1[0] + arr1[1] - arr2[0] - arr2[1]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer (new int[] {nums1[i], nums2[0], 0});
        }

        while (k-- != 0 && !minHeap.isEmpty ()) {
            int[] curr = minHeap.poll ();
            pairs.add (List.of (curr[0], curr[1]));
            if (curr[2] + 1 < nums2.length) {
                minHeap.offer (new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
            }
        }

        return pairs;
    }

    //Time - O(n^3)
    /*[1,2,3]
    [1] [1,2] [1,2,3]
    [2] [2,3]
    [3]
    for i=0,1,2
    for j= i , <=n 0,1, 2,3
    for k =i 0,1,2, k< j //0,1
    res +=a[0], a[0]+a[1], a[0]+a[1]+a[2]
    */
    public int subArraySum( int arr[] , int n )
    {
        int result = 0;
        for(int i =0; i<n; i++) {
            for(int j=i; j<n; j++) { //j=0, 1, 2
                for(int k=i; k<=j; k++) { //k=0,1
                    result +=arr[k]; //a[0], a[0]+a[1], a[0]+a[1]+a[2]
                }
            }
        }
        return result;
    }
    /*
    [1,2,3]
    [1], [1,2], [1,2,3] => 3 *1 =3 (n-i)=>(3-0 =>3) *1 =>3    res = 1 * 3 + 2*4 + 3*3 = 20
    [2], [2,3] =>2 *2 = 4 (3-1=>2) * 2 =>4
    [3] =>1 * 3 = 3 (3-2+>1) * 3 = 3
    for(i=0; <n)
    res = a[i] * ( (n-i) * (i+1)
     */
    //Time -O(n)
    public long subArraySumBetterTime( int arr[] , int n )
    {
        long result = 0;
        for(int i =0; i<n; i++) {
            result += arr[i] *((n-i) *(i+1));
        }
        return result;
    }
    /*
    a->[7,5,9] b->[13,1,14] diff = 3
    res[a.len], count = 0
    for(i=0; <a.len)
    for(j=0; j<b.le)
    if(Math.abs(a[i]-b[i])>diff)
    res[i] = count++

    int max = res[0];
    int maxind = 0;
    for(int i=1; i<res.len)
    {if (re[i] > max)
        max = res[i];
        maxind = i;
        }
        return a[maxind]
     */
    //Time - O(a*b), Space - O(1)
    public int comparatorValueTwoArrays(List<Integer>a, List<Integer>b, int diff) {
        //ArrayList<Integer> result = new ArrayList<>(a.size());
        int resultCount = 0;
        int comparatorValue = a.size();
        for (int i = 0; i < a.size(); i++) {
            int count = 0;
            for (int j = 0; j < b.size(); j++) {
                if ((Math.abs(a.get(i) - b.get(j))) <= diff) {
                    count = 1;
                }
            }
            resultCount += count;
        }
        comparatorValue = comparatorValue - resultCount;
        System.out.println("ans" + comparatorValue);
        return comparatorValue;
    }
    //Time - O(a), Space - O(b)-> Tree set
        public int comparatorValueUsingTreeSet(List<Integer>a, List<Integer>b, int diff) {
        int res = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int n : b)
            ts.add(n);

        for(int n : a){
            Integer higher = ts.ceiling(n);
            Integer lower = ts.floor(n);
            int difference = 0;
            if(higher == null){
                difference = Math.abs(lower - n);
            }else if(lower == null){
                difference = Math.abs(higher - n);
            }else{
                difference = Math.min(higher - n, n - lower);
            }
            if(difference > diff)
                res++;
        }
        return res;

    }
}