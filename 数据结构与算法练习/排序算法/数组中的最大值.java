/**
 * 
 */
package �����㷨;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

import javax.naming.InitialContext;
/**
 * @author zoe
 *
 */
public class �����е����ֵ {

	/**
	 * @param args
	 */
	// ��ӡ��������Ԫ��
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//һά����Ԫ��ת��
	public static int[] reverse(int[] arr) {  //������Ϊ�����ķ���ֵ
		int[] result=new int[arr.length];
		for (int i=0,j=result.length-1;i<result.length;i++,j--) {
			result[j]=arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner stdinScanner=new Scanner(System.in);
		
		int n=stdinScanner.nextInt();
		
		int[] arr=new int[n];
		
		//���������
		for(int i=0;i<arr.length;i++) { 
			arr[i]=stdinScanner.nextInt();
		}
		
		
		//// ��ӡ��������Ԫ��
		printArray(arr);
		
		reverse(arr);
		printArray(arr);

	}

}
