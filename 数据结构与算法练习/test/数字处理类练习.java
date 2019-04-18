package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;

//���ָ�ʽ����Math�ࡢ���������
public class ���ִ�������ϰ {

	public static void main(String[] args) {
		DecimalFormat myFormat1=new DecimalFormat("###,###,###"); //�������ָ�ʽ����ʽ
		DecimalFormat myFormat2=new DecimalFormat("#.###%"); //�������ָ�ʽ����ʽ
		DecimalFormat myFormat3=new DecimalFormat("0.00\u2030"); //ǧ������ʽ
		System.out.println(myFormat1.format(123456789));
		System.out.println(myFormat2.format(0.1234));
		System.out.println(myFormat3.format(0.1234));
		myFormat1.setGroupingSize(4);//�������ַ���ֵΪ4
		System.out.println(myFormat1.format(123456789));
		myFormat1.setGroupingUsed(false); //���������
		System.out.println(myFormat1.format(123456789));
		
//		Math��
		System.out.println(Math.PI+" "+Math.E);
		System.out.println(Math.log10(100));
		System.out.println(Math.cbrt(3)); //������
		System.out.println(Math.pow(2, 3));//2��3�η�
		System.out.println(Math.round(3.4)); //��������,����long
		System.out.println(Math.rint(3.5)); //Ҳ���������룬�����صĻ���double
		
		
//	�����
		System.out.println(Math.random()); //Ĭ��[0,1)����
		System.out.println(Math.random()*5); 
		System.out.println((char)('a'+Math.random()*('z'-'a'+1)));  //����ַ�����
		
		Random random=new Random();
		System.out.println(random.nextInt(10)); //����һ��10���ڵ�int�͵���
		System.out.println(random.nextGaussian()); //����һ�����Ӹ�˹�ֲ�����
		
//		������Ԥ��
		BigInteger bigInteger=new BigInteger("5"); //������һString��ʽ���ڵ�
		System.out.println(bigInteger); 
		System.out.println(bigInteger.add(new BigInteger("4"))); //�ӷ�
		System.out.println(bigInteger.divideAndRemainder(new BigInteger("4"))[0]); //����ȡ��
		System.out.println(bigInteger.divideAndRemainder(new BigInteger("4"))[1]); //����ȡ����
		System.out.println(bigInteger.negate()); //ȡ��
		
		BigDecimal bigDecimal=new BigDecimal(4.22);//������double��ʽ���ڵ�
	}

}
