package Math;
/*
统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
//质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。
/*
 *** 厄拉多塞筛法
 具体操作：先将 2~n 的各个数放入表中，然后在2的上面画一个圆圈，然后划去2的其他倍数；
 第一个既未画圈又没有被划去的数是3，将它画圈，再划去3的其他倍数；
 现在既未画圈又没有被划去的第一个数 是5，将它画圈，并划去5的其他倍数……
 依次类推，一直到所有小于或等于 n 的各数都画了圈或划去为止。
 这时，表中画了圈的以及未划去的那些数正好就是小于 n 的素数。
 */
public class 计数质数 {
    public int countPrimes(int n) {
    	 boolean [] notPrim = new boolean[n]; //统计是否是质数，不是的话是true，是的话是false
    	 int count = 0;
    	 for (int i = 2; i < n; i++){
             if (notPrim[i] == false) { //是质数
                 count++;
                 for (int j = 2; j*i < n; j++) {
                     notPrim[j*i] = true;
                 }
             }
         }
         return count;
    	 
    }
}
