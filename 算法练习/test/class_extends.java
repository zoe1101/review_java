package test;
class Animal {
  private int n;
  Animal(){  ////����Ҫд������캯������Ȼ����Ĵ�����������������������캯��ʱ�������б�����Ĭ�Ϲ��캯��
    System.out.println("Animal()");
  }
  Animal(int n) {
    System.out.println("Animal(int n)");
    this.n = n;
  }
  void go() {
	  System.out.println("animal go");
  }
}
// SubClass ��̳�
class Dog extends Animal{
  private int n;
    //�����ǲ��̳и���Ĺ����������췽�����߹��캯�����ģ���ֻ�ǵ��ã���ʽ����ʽ����
	//  �������Ĺ��������в����������������Ĺ���������ʽ��ͨ�� super �ؼ��ֵ��ø���Ĺ������������ʵ��Ĳ����б�
	//������๹����û�в�������������Ĺ������в���Ҫʹ�� super �ؼ��ֵ��ø��๹������ϵͳ���Զ����ø�����޲ι�������
  Dog(){ // �Զ����ø�����޲���������
    System.out.println("Dog");
  }  
  
  public Dog(int n){ 
    super(300);  // ���ø����д��в����Ĺ�����
    System.out.println("Dog(int n):"+n);
    this.n = n;
  }
  void go() {
	  super.go(); //��Ҫ��������ø���ķ�������ʹ�ùؼ���super��
  }

}
// SubClas2 ��̳�
class Duck extends Animal{
  private int n;
  
  Duck(){
    super(300);  // ���ø����д��в����Ĺ�����
    System.out.println("Duck");
  }  
  
  public Duck(int n){ // �Զ����ø�����޲���������
    System.out.println("Duck(int n):"+n);
    this.n = n;
  }
}
public class class_extends{
  public static void main (String args[]){
    System.out.println("------Dog ��̳�------");
    Dog sc1 = new Dog();
    Dog sc2 = new Dog(100); 
    sc1.go();
    System.out.println("------Duck ��̳�------");
    Duck sc3 = new Duck();
    Duck sc4 = new Duck(200); 
  }
}