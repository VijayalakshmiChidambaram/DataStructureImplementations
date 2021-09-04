package dataStructureImplementation;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Recursion_DP {
    public static void main(String[] args) {
        Recursion_DP rec = new Recursion_DP();
        /*boolean[][] maze = {{true,true,true}, {true,true,true}, {true,true,true}};
        rec.getPath1(maze);*/
        int[] in = {1,2,3};
        rec.poweSet(in);
    }

    /**
     * Method 1: Duplicate work
     * <p>
     * Time Complexity: O(2(r + c)). each path has r + c steps and there are two
     * choices we can make at each step.
     */

    public ArrayList<Point> getPath1(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> res = new ArrayList<>();
        if (getPath1(maze, maze.length - 1, maze[0].length - 1, res)) {
            return res;
        }
        return null;
    }

    private boolean getPath1(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        // out of bounds or not available
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        //boolean isAtOrigin = (row == 0) && (col == 0);
        if(row == 0 && col == 0) {
            return true;
        }
        if (getPath1(maze, row, col - 1, path) || getPath1(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            System.out.println(path);
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> poweSet(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums.length == 0) {
            return res;
        }
        bt(0, new ArrayList<Integer>(), nums, res);
        return res;
    }
    public void bt(int start, ArrayList<Integer> curr, int[] nums, ArrayList<ArrayList<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for(int i=start; i<nums.length; i++) {
            curr.add(nums[i]);
            bt(start+1, curr, nums, res);
            curr.remove(curr.size() - 1);
        }
    }
}

