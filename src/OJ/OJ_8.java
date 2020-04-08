package OJ;

/*
题目描述
solo发现他参加Online Judge的比赛表现很不稳定，于是他翻开历史记录，发现他在每一轮的比赛中他的排名R都能整除参赛人数N(包括solo)，于是他每次参赛都会先预测他的排名情况，以给自己更大的自信。

解答要求
时间限制：15000ms, 内存限制：64MB
输入
输入只有一个整数N(0<N<109)，代表参赛人数。

输出
在一行输出solo参赛可能的获得的排名数S以及由小到大输出各个排名Ri (0<i ≤ S)，用空格隔开。
 */
import java.util.*;
import java.lang.*;
public class OJ_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        StringBuffer sb=new StringBuffer();
        int count=0;
        for(int i=1;i<=N;i++)
        {
            if(N%i==0)
            {
                sb.append(i+" ");
                count++;
            }
        }
        System.out.println(count+" "+sb);
    }
}



