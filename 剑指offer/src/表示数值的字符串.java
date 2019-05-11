package src;
/*
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class 表示数值的字符串 {
	
//《剑指OFFER》一书的方法：将数字的形式总结为：(A.B E/e A) ,
//按顺序进行判断（A代表带符号整数，B代表不带符号整数）。
    public boolean isNumeric(char[] str) {
        if (str==null || str.length==0) {
			return false;
		}
        int[] index = new int[1];
        index[0] = 0; // 用于记录当前字符位置
       //先判断A
        boolean isNumeric; //用于记录是否满足条件
        isNumeric=isInteger(str, index);
       // 判断B
        if (index[0] < str.length && (str[index[0]] == '.')) {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B和A.和A.B形式均可以
        }
        // 判断e后面的A
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length)
            return true;
        else
            return false;
    }
    
//标记法：
/*设置三个标志符分别记录“+/-”、“e/E”和“.”是否出现过。
** 对于“+/-”： 正常来看它们第一次出现的话应该出现在字符串的第一个位置，
	如果它第一次出现在不是字符串首位，而且它的前面也不是“e/E”，那就不符合规则；
	如果是第二次出现，那么它就应该出现在“e/E”的后面，如果“+/-”的前面不是“e/E”，那也不符合规则。
** 对于“e/E”： 如果它的后面不接任何数字，就不符合规则；如果出现多个“e/E”也不符合规则。
** 对于“.”： 出现多个“.”是不符合规则的。还有“e/E”的字符串出现“.”也是不符合规则的。
同时，要保证其他字符均为 0-9 之间的数字。
 */
    public boolean isNumeric2(char[] str) {
    	int len = str.length;
    	boolean sign = false; //正负号出现次数标记
    	boolean decimal = false;  //“.”出现次数标记
    	boolean hasE = false;  //e/E出现次数标记
    	for (int i = 0; i < len; i++) {
			if (str[i]=='+' ||str[i]=='-') {
				if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E') {//第一次出现正负号
					return false;
				}
				if(sign && str[i-1]!='e' && str[i-1]!='E') { //第二次出现正负号
					return false;
				}
				sign=true;
			}else if (str[i] == 'e' || str[i] == 'E') {
				if(i==len-1) {
					return false;
				}
				if (hasE) {//前面已经出现过E了
					return false;
				}
				hasE=true;
			}else if (str[i]=='.') {
				if(hasE || decimal) { //e出现了或者已经有过“.”了
					return false;
				}
				decimal=true;
			}else if (str[i]<'0' || str[i]>'9') {
				return false;
			}
		}
    	return true;
    }
    
    private boolean isInteger(char[] str, int[] index) { // 用int[]才能传值，int的话需要定义index为全局变量
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        return isUnsignedInteger(str, index);
    }
 
    private boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index[0]++;
        if (index[0] > start)
            return true;
        else
            return false;
    }
}
