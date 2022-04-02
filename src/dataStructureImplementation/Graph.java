package dataStructureImplementation;

import javax.swing.*;
import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Graph graphProb = new Graph();
        int arr[][] = {{0, 1}, {0, 2}, {1, 2}};
        int n = 3;
        // graphProb.GraphvalidTreeDFSRec(n,arr);
        //graphProb.graphValidTreeBFS(n, arr);
        int logs[][] = {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};
        int edges = 4;
        graphProb.earliestAcq(logs, edges);

    }

    // Prob 1 : Time - O(E+V), Space - O(V)
    public boolean GraphvalidTreeDFSRec(int n, int[][] grap) {
        boolean isTree = true;
        boolean notTree = false;
        if (n < 1 || grap.length == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        //Create graph
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        //Put the neighbors together
        for (int[] edge : grap) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        //Check cycle
        HashSet<Integer> visited = new HashSet<>();
        if (hasCycle(adjList, visited, 0, -1)) {
            System.out.println(notTree);
            return false;
        }
        // check connectivity
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                System.out.println(notTree);
                return false;
            }
        }
        System.out.println(isTree);
        return true;
    }

    public boolean hasCycle(List<List<Integer>> adjList, HashSet<Integer> visited, int currNode, int parent) {
        if (visited.contains(currNode)) {
            return false;
        }
        visited.add(currNode);
        List<Integer> n = adjList.get(currNode);
        for (int node : n) {
            if (node != parent && hasCycle(adjList, visited, node, currNode)) {
                return true;
            }
        }
        return false;
    }

    public boolean graphValidTreeBFS(int n, int[][] grap) {
        if (n == 0 || grap.length == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        for (int edg[] : grap) {
            adjList.get(edg[0]).add(edg[1]);
            adjList.get(edg[1]).add(edg[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        if (hasACycle(adjList, visited, 0)) {
            System.out.println("false");
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    public boolean hasACycle(List<Set<Integer>> adjList, HashSet<Integer> visited, int currNode) {
        Queue<Integer> bfsqueue = new ArrayDeque<>();
        bfsqueue.add(currNode);
        while (!bfsqueue.isEmpty()) {
            int queueRemove = bfsqueue.poll();
            if (visited.contains(queueRemove)) {
                return true;
            }
            Set<Integer> n = adjList.get(queueRemove);
            for (int i : n) {
                bfsqueue.add(i);
                adjList.get(i).remove(queueRemove);
            }
            visited.add(queueRemove);
        }
        return false;
    }

    /* public boolean ask(List<int[]> g)
     {
         int n = 5;
         List<List<Integer>> adjList = new ArrayList<>();
         for(int i=0; i<n; i++)
         {
             adjList.add(new ArrayList<>());
         }
         for(int[] edg: g)
         {
             adjList.get(edg[0]).add(edg[1]);
             adjList.get(edg[1]).add(edg[0]);
         }

         return true;
     }*/
    // 2)The Earliest Moment When Everyone Become Friends
    //Time - O(mlogm)+O(n), Space - O(n)
    public int findParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[parent[i]];
        }
        return i;
    }

    public int earliestAcq(int[][] logs, int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) // O(n) , Space - O(n)
        {
            parent[i] = i;
        }
        Arrays.sort(logs, (a, b) -> a[0] - b[0]); //Size of logs=m, O(m logm)
        for (int[] log : logs) // O(logm)
        {
            int parenta = findParent(parent, log[1]);
            int parentb = findParent(parent, log[2]);
            if (parenta != parentb) {
                parent[parenta] = parentb;
                n--;
            }
            if (n == 1) {
                System.out.println("timestamp: " + log[0]);
                return log[0];
            }
        }
        System.out.println(-1);
        return -1;
    }
}