package dataStructureImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class codepathStringArrays {
    public static void main(String[] args) {
        codepathStringArrays stringArrays = new codepathStringArrays();
        //stringArrays.permutate("abc");
        //stringArrays.reverseSentence("coding for interviews");
        //stringArrays.reverseSentenceQuick("coding for interviews");
        //String[] words = {"bb", "aa", "dd", "cc", "ee", "aa"};
        //char[] wo = {'a', 'b', 'c'};
       // stringArrays.shortestDistance(words,"aa", "cc");
        //String[] words = {"prac","makes","per","code","makes"};
        //stringArrays.createMap(words);
        //stringArrays.shortestDistance2("code", "code");
        //stringArrays.shortestDistance3(words,"makes","makes");
        int[] array = {1,-1,2,4,5,2,-3};
       // stringArrays.maxSubArray(array);
        //stringArrays.maxSubArraydp(array);
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(1);
        mainList.add(l1);
        mainList.add(l2);
        mainList.add(l3);
        //solution.maxSubArraydp(mainList);
        int[] arr = {1,2,3,4,5};
        stringArrays.searchRotatedSortedArray(arr, 5);
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

    //Shortest Word Distance1
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here [b,a,d,c,e,a], a - c op = 3-1 = 2
        int minDis = Integer.MAX_VALUE;
        int wordsSize = words.length; //6
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0; i<wordsSize; i++) {
            if(words[i] == word1 || words[i] == word2) { //a(1) , c,a
                map.put(words[i], i); //a-5 , c-3
            }
            if(map.size() == 2) {
                int temp1 = map.get(word1); //5
                int temp2 = map.get(word2); //3
                minDis = Math.min(minDis, Math.abs(temp1-temp2)); //2
            }
        }

        return minDis;

    }
    public int shortestDistanceTwoPointers(String[] words, String word1, String word2) {
        int pointer1 = Integer.MAX_VALUE;
        int pointer2 = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<words.length; i++) {
            if(words[i].equals(word1)) {
                pointer1 = i;
            }
            if(words[i].equals(word2)) {
                pointer2 = i;
            }
            if(pointer1!= Integer.MAX_VALUE && pointer2 != Integer.MAX_VALUE) {
                minDistance = Math.min(minDistance, Math.abs(pointer1-pointer2));
            }
        }
        return minDistance;
    }
/*
Input : List of words, 2 words(provided as a list)
return List of shortest distance between 2 words given as a list
input: ["wordDis","shortest","shortest"]
[[["prac","makes","per","code","makes"]],["code","prac"],["makes","code"]]
op:
[null,3,1]
 */
HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public void createMap(String[] words) {
        int wordLen = words.length;
        for(int i=0; i<wordLen; i++) {
            if(map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        System.out.println(map);

    }

    public int shortestDistance2(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        ArrayList<Integer> list1 = map.get(word1); // 0, 3,4
        ArrayList<Integer> list2 = map.get(word2); //2
        int i=0, j=0;
        while(i<list1.size() && j<list2.size()) {
            minDistance = Math.min(minDistance, Math.abs(list1.get(i) - list2.get(j)));
            if(list1.get(i) < list2.get(j)) {
                i++;
            }
            else {
                j++;
            }
        }
        System.out.println(minDistance);
        return minDistance;
    }
// word1 and word2 can be same/cannot be same. Word1 and word2 are individual words in the list
    public int shortestDistance3(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int w1p = -1, w2p = -1;
        for(int i=0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                w1p = i;
            }
            if(words[i].equals(word2)) {
                if(word1.equals(word2)) {
                    w1p = w2p;
                }
                w2p = i;
            }
            if(w1p!= -1 && w2p!= -1) {
                minDistance = Math.min(minDistance, Math.abs(w1p-w2p));
            }
        }
        System.out.println(minDistance);
        return minDistance;
    }
/* Find max sub array sum. Time- O(n), Space- O(1)
[1,-1,2,4,5,2,-3], Max = 13 [1,-1,2,4,5,2]
[1] , Max = 1
[-2,-1,-3,-4], Max = -1
[5,4,-1,7,8], Max = 7+8 = 15
 */
    public int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int arrSize = arr.length;
        for(int i =0; i<arrSize; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }
/* Time - O(n), Space - O(n)
[1,-1,2,4,5,2,-3], Max = 13
[1] , Max = 1
[-2,-1,-3,-4], Max = -1
[5,4,-1,7,8], Max = 7+8 = 15
Algo:
int[] dp = new int[arr.size];
int max
dp[0] = arr[0];
for(i=1)
  dp[i] = Math.max(num[i],num[i]+dp[i-1]);
  max = Math.max(max, dp[i]);
 */
    public int maxSubArraydp(int[] arr) {
        int[] dp = new int[arr.length];
        int maxSum = Integer.MIN_VALUE;
        dp[0] = arr[0];
        int arrSize = arr.length;
        for(int i=1; i<arrSize; i++) {
            dp[i] = Math.max(arr[i],arr[i]+dp[i-1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
        return maxSum;
    }
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        int sum = 0;
        if (nestedList.size() == 0 || nestedList == null) {
            return 0;
        }

        for(NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += depth * i.getInteger();
            } else {
                depth++;
                depthSum(i.getList());
                depth--;
            }
        }

        return sum;
    }
    //Time - O(log n), Space - O(1)
    public int searchRotatedSortedArray(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[start])
                    end = mid-1;
                else
                    start = mid+1;
            }
            if(nums[mid] <= nums[end]) {
                if(target > nums[mid] && target <= nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
}
