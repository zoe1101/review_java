package src;
/*
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

/*
 当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符，x*相当于只匹配一个字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class 正则表达式匹配 {
//	递归法
   public boolean match(char[] str, char[] pattern){
        if (str==null || pattern==null) {
			return false;
		}
        return patternmatch(str, pattern, 0, 0);

    }
   
   public boolean patternmatch(char[] s, char[] p, int sIndex, int pIndex) {
	   if(pIndex==p.length) {//p串已经用尽
		 //若s也已经用尽，则匹配成功，否则，匹配失败
		   return sIndex == s.length;
	   }
	 //pIndex是p最后一个字符，或者 pIndex下一个元素不是'*',则只考虑将s[sIndex]与 p[pIndex]匹配
	   if (pIndex + 1 == p.length || p[pIndex + 1] != '*') {
		   return 	sIndex != s.length && 
				   (s[sIndex] == p[pIndex] || p[pIndex] == '.') && 
				   patternmatch(s, p, sIndex + 1, pIndex + 1);
	   }
	 //若pIndex下一个元素为 *，则需要考虑多个s[sIndex]与 p[pIndex]匹配的情况：枚举
       //例如 a*bb 与 aaaaab这种情况，i会最终停留在b的位置处
       while (sIndex != s.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.')) {
           if (patternmatch(s, p, sIndex, pIndex + 2)) {
               return true;
           }
           sIndex++;
       }
       //patternmatch(s, p, sIndex, pIndex + 2) 表示 * 之前的元素为0个，比如 a*aaa 与 aaa 进行匹配
       return patternmatch(s, p, sIndex, pIndex + 2);
   }
   
   带完成，需要再次理解
}
