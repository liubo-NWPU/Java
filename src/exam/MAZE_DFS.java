package exam;
/*
题目描述
小华玩走迷宫的游戏.在一个n*m格子状的迷宫中,有一个入口S和多个出口E(一个迷宫中可能有多个出口,都用E表示).0表示这个格子可以走,
1表示这个格子不可以走.小华希望可以最快的走出迷宫.每次只能走一步(在格子可以走的情况下,向上下左右移动一个格子),
他想让你计算最少的步数.

解答要求
时间限制：1000ms, 内存限制：64MB
输入
第一行输入n,m( 0 < n <= 100,0 < m <= 100).
后面给出一个n*m的迷宫.S只有一个,E最少一个.
例如
2 2
1E
S0

输出
输出一行,从入口到最近出口需要走的步数.如果无法到达出口输出”No way”.

样例
输入样例 1 复制

3 3
101
0S1
00E
输出样例 1

2
 */

import java.util.Scanner;

public class MAZE_DFS {
    private static int n,m;

    private static char[][] maze ;
    private static boolean[][] visited;

    public static int sx,sy;

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();
        maze =new char[n][m];
        visited=new boolean[n][m];
        for(int i=0; i < n; i++){
            String line = in.nextLine();
            for(int j=0; j < m; j++){
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }

        //入口是确定的，且只有一个
        if (dfs(maze, sx, sy, 0, visited)) {
            System.out.println(min);
            return;
        }
        System.out.println("No way");

    }

    public static boolean dfs(char[][] maze, int i, int j, int step, boolean[][] visited){

        if(i<0||j<0||i>=n||j>=m||visited[i][j])   //判断边界,必须当做第一个判断条件
            return false;

        if(maze[i][j]=='E')
        {
            if(step<min)
            {
                min=step;
            }
            return true;
        }

        if(maze[i][j]=='1')
            return false;

        visited[i][j] = true;     //匹配到了。标记此节点不可达

        boolean res = dfs(maze, i+1, j, step + 1, visited) ||
                dfs(maze, i, j+1, step + 1, visited) ||
                dfs(maze, i-1, j, step + 1, visited) ||
                dfs(maze, i, j-1, step + 1, visited);

        visited[i][j] = false;    //取消标记

        return res;
    }
}
