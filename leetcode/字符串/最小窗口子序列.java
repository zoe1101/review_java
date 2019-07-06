package �ַ���;
/*
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
If there is no such window in S that covers all characters in T, return the empty string "". 
If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:
All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
 */
public class ��С���������� {
	/*
 �����ҵ�����������T�е�һ���ַ�T[0]��S�е��ַ��±����dp[0][j]��Ҳ���������һ���ַ�Ҫ��һ���Ǵ���Щ�ҵ���
 �ַ���ʼ�ġ�Ȼ���ڿ�ʼ�ҵڶ����ַ�T[1]��ɨ�����ַ�dp[j]����index��˵�����Դ������¼��index��ʼ��
 �ҵ�����T[1]��S[j]�Ͱ�֮ǰ�Ǹ�index�������˵�������index��j����T[0..1]��һֱѭ����ֱ��T�е�i���ַ����ꡣ
 �����ʱdp[i][j]����index��˵��S[index, j]�������������ж����������ҵ��ġ�
	 */
	public String minWindow(String S, String T) {
		// ��ά����dp[i][j]��ʾT[0...i]��S���ҵ��������ʼ�±�index��Ҳ����S[index, j]����ĿǰT[0...i]
        int[][] dp = new int[T.length()][S.length()];
        for(int i = 0; i < T.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                dp[i][j] = -1;
            }
        }
        
        for(int j = 0; j < S.length(); j++) {
            dp[0][j] = (S.charAt(j) == T.charAt(0)) ? j : -1;
        }
        
        for(int i = 1; i < T.length(); i++) {
            int last = -1;
            for(int j = 0; j < S.length(); j++) {
                if(last >= 0 && S.charAt(j) == T.charAt(i)) {
                    dp[i][j] = last;
                }
                if(dp[i - 1][j] >= 0) {
                    last = dp[i - 1][j];
                }
            }
        }
        
        int start = -1;
        int length = Integer.MAX_VALUE;
        
        for(int j = 0; j < S.length(); j++) {
            if(dp[T.length() - 1][j] >= 0 && (j - dp[T.length() - 1][j] + 1 < length)) {
                start = dp[T.length() - 1][j];
                length = j - dp[T.length() - 1][j] + 1;
            }
        }
        
        return (start == -1) ? "" : S.substring(start, start + length);
    }
}
