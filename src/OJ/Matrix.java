package OJ;

import java.util.Scanner;

public class Matrix {
    static int n=0;
    static int m=0;
    public static int calc(int[][] arr,int x,int y ){
        if(x<0||y<0||x>n||y>m)
        {
            return;
        }

        if(x==(n-1) && y==(m-1))
        {
            return value;
        }

        int value=0;
        value=arr[x][y]+value;
        if(value > MaxValue)
        {
            MaxValue=value;
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n =sc.nextInt();
         m =sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        calc(arr,0,0);
    }
}
