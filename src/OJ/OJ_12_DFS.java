package OJ;

import java.util.HashSet;
import java.util.Scanner;
/*
    题目描述
Word Maze 是一个网络小游戏，你需要找到以字母标注的食物，但要求以给定单词字母的顺序吃掉。假设给定单词if，你必须先吃掉i然后才能吃掉f。
但现在你的任务可没有这么简单，你现在处于一个迷宫Maze（n×m的矩阵）当中，里面到处都是以字母标注的食物，但你只能吃掉能连成给定单词W的食物。

注意区分英文字母大小写,并且你只能上下左右行走。

解答要求
时间限制：1000ms, 内存限制：64MB
输入
输入第一行包含两个整数n、m(0<n,m<21)分别表示n行m列的矩阵，第二行是长度不超过100的单词W，从第3行到第n+2行是只包含大小写英文字母的长度为m的字符串。

输出
如果能在地图中连成给定的单词，则输出“YES”，否则输出“NO”。注意：每个字母只能用一次。

样例
输入样例 1 复制

5 5
SOLO
CPUCY
EKLQH
CRSOL
EKLQO
PGRBC
输出样例 1

YES
 */

public class OJ_12_DFS {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        in.nextLine();
        char[] word=in.nextLine().toCharArray();
        char[][] maze = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            String line = in.nextLine();
            for(int j=0; j<n; j++){
                maze[i][j] = line.charAt(j);
            }
        }

        //可以从任意口进去匹配，没有限制必须从（0,0）点开始，所以要双重循环
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(maze, word, i, j, 0, visited)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    private static boolean dfs(char[][] maze, char[] word, int i, int j, int start, boolean[][] visited){

        if(start == word.length)   //匹配成功完毕
            return true;

        if(i<0||j<0||i>=maze.length||j>=maze[0].length||visited[i][j])   //判断边界
            return false;

        if(maze[i][j] != word[start])    //如果匹配到第一个单词就从此节点开始上下左右探测
            return false;

        visited[i][j] = true;     //匹配到了。标记此节点不可达

        boolean res = dfs(maze, word, i+1, j, start + 1, visited) ||
                dfs(maze, word, i, j+1, start + 1, visited) ||
                dfs(maze, word, i-1, j, start + 1, visited) ||
                dfs(maze, word, i, j-1, start + 1, visited);

        visited[i][j] = false;    //取消标记

        return res;
    }
}

