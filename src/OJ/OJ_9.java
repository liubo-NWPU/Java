package OJ;
/*
题目描述
2005年的百度之星初赛有这么一道题，一个正整数有可能可以被表示为 m(m>1) 个连续正整数之和，如：

15=1+2+3+4+5
15=4+5+6
15=7+8
但现在你的任务是判断给定的整数n能否表示成连续的m(m>1)个正整数之和。

解答要求
时间限制：1000ms, 内存限制：64MB
输入
输入只有一个整数n (1<n<230 +1)。

输出
若n能表示成连续的m(m>1)个正整数之和则输出“YES”，否则输出“NO”。
 */
import java.util.Scanner;

public class OJ_9 {
    public static void main(String[] args) {
        //第一种解法
        /*
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long temp_n;
        for(int i=1;i<n;i++) {
            temp_n=n;
            for (int j = i; j <=n; j++) {
                temp_n=temp_n-j;
                if(temp_n==0)
                {
                    System.out.println("YES");
                    return;
                }
                if(temp_n<=j)
                    break;
            }
        }
        System.out.println("NO");
        */

        //第二种解法 精妙，转换二进制后1的数量大于1的都是YES
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        while (n != 0){
            if((n & 1) == 1){
                count++;
            }
            if(count > 1){
                System.out.println("YES");
                return;
            }
            n = n >> 1;
        }
        System.out.println("NO");
    }


}
