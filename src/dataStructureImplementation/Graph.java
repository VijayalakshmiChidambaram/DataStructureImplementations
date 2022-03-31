package dataStructureImplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public static void main(String[] args)
    {
        Graph graphProb = new Graph();
        int arr[][] = {{0,1}, {0,2},{3,4}};
        int n = 5;
        graphProb.GraphvalidTreeDFSRec(n,arr);

    }
    // Prob 1 : Time - O(E+V), Space - O(V)
    public boolean GraphvalidTreeDFSRec(int n, int[][] grap)
    {
        boolean isTree = true;
        boolean notTree = false;
        if(n<1 || grap.length == 0)
        {
            return false;
        }
        if(n==1)
        {
            return true;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        //Create graph
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        //Put the neighbors together
        for(int[] edge:grap)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        //Check cycle
        HashSet<Integer> visited = new HashSet<>();
        if(hasCycle(adjList, visited, 0, -1)){
            System.out.println(notTree);
            return false;
        }
        // check connectivity
        for(int i=0; i<n; i++)
        {
            if(!visited.contains(i))
            {
                System.out.println(notTree);
                return false;
            }
        }
        System.out.println(isTree);
        return true;
    }
    public boolean hasCycle(List<List<Integer>> adjList, HashSet<Integer> visited, int currNode, int parent)
    {
        if(visited.contains(currNode))
        {
            return false;
        }
        visited.add(currNode);
        List<Integer> n = adjList.get(currNode);
        for(int node: n)
        {
            if(node != parent && hasCycle(adjList, visited, node, currNode))
            {
                return true;
            }
        }
        return false;
    }

    public boolean graphValidTreeBFS(int n, int[][] grap)
    {
        if(n == 0 || grap.length == 0)
        {
            return false;
        }
        if(n == 1)
        {
            return true;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int edge[]:grap)
        {

        }

        return true;
    }
    public boolean ask(List<int[]> g)
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
    }
}
