package ��̬�滮;

import java.util.ArrayList;
import java.util.List;

/*
n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
����һ������ n���������в�ͬ�� n �ʺ�����Ľ��������
ÿһ�ֽⷨ����һ����ȷ�� n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��

ʾ��:
����: 4
���: [
 [".Q..",  // �ⷨ 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // �ⷨ 2
  "Q...",
  "...Q",
  ".Q.."]
]
����: 4 �ʺ��������������ͬ�Ľⷨ��
 */
//�����㷨
public class N�ʺ� {
	List<List<String>>ans = new ArrayList<List<String>>();
	public List<List<String>> solveNQueens(int n) {
		if (n<1) {
			return ans;
		}
        backtrack(0,n,new boolean[n],new int[n]);
        return ans;
    }

    
    private void backtrack(int k,int n,boolean[]flag,int[]temp)
    {
        if(k == n)
        {
            List<String>list = new ArrayList<String>();
            for(int i = 0;i < n;i++)
            {
                String s = "";
                for(int j = 0;j < n;j++)
                    if(temp[i] == j)
                        s += "Q";
                    else
                        s += ".";
                list.add(s);
            }
            ans.add(list);
            return;
        }
        
        for(int i = 0;i < n;i++)
            if(!flag[i]){
                //�ж�����֮ǰ�Ļʺ��Ƿ�ɶԽ��ߡ�
                //���ɶԽ��ߣ���ô��Ȼ�ǲ��ܷŵġ�
                boolean tag = true;
                for(int last = k-1;last >= 0;last--)
                    if(temp[last] - i == k - last || i - temp[last] == k - last)
                    {
                        tag = false;
                        break;
                    }
                
            if(tag)
            {
                flag[i] = true;
                temp[k] = i;
                backtrack(k+1,n,flag,temp);
                flag[i] = false;
            }
                
            }
    }

}
