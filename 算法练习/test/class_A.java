package test;

public class class_A {
	int age;
	public class_A (String name) {
		 //�������������һ��������name
	      System.out.println("С���������� : " + name ); 
	}
	public void setage(int a) {
		age=a;
		
	}
	public int getage() {
		System.out.println("С���������� : " + age ); 
		return age;
	}
   public static void main(String[] args){
	     
	   class_A myclass = new class_A( "tommy" );  //��������,ʵ��������
	   myclass.setage(4);  //�趨age
	   myclass.getage();  //��ȡage
	   System.out.println("����ֵ : " + myclass.age );  //Ҳ�����������ʳ�Ա���� 
	   }
}
