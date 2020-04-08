package exam;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */
/*
任务时长
现给定一个正整数数组 nums，其按照时间顺序记录了数个同类任务的完成时长（单位为周），为了更准确评估该类任务的工作量，现做如下分析，找出每个任务的前面、比当前任务完成时长短的邻近时长，如果无法找到则记为 -1。将这些邻近时长记录成一个新数组并返回。

示例 1：

输入： nums = [1,6,4,10,2,5]

输出：[-1,1,1,4,1,2]

解释：第一个任务时长记录（1）左边没有记录，返回-1。第二个任务时长记录（6）左边只有一个比该时长更短的任务时长（1），所以返回1。

第四个任务时长记录（10）左边有三个比该时长更短的时长记录（1，6，4），所以返回最邻近的4。

示例 2：

输入：nums =  [ 2, 4, 1, 3, 6]

输出：[ -1, 2, -1, 1, 3 ]

解释：第三个任务时长记录（1）左边没有比该时长更短的时长记录，（左边时长记录2，4均比1长），故返回-1。
 */

public class Main {

    public static int[] leftNum(int[] num)
    {
        int[] res=new int[num.length];
        res[0]=-1;
        int flag;
        boolean b;
        for(int i=1;i<num.length;i++)
        {
            flag=0;
            b=false;
            for(int j=0;j<i;j++)
            {
                if(num[j]<num[i])
                {
                    flag=flag > j?flag:j;
                    b=true;
                }
            }
            if(b)
            {
                res[i]=num[flag];
            }
            else
            {
                res[i]=-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,6,4,10,2,5,2,4,5,11,32,2,4,5,21};
        for(int i:leftNum(arr))
        {
            System.out.print(i+" ");
        }
    }
}

