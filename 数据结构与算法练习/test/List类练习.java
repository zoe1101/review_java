package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class List����ϰ {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List<String> list1=new ArrayList<>();
		list1.add("I");
		list1.add("Love");
		list1.add("China");
		list1.add("!");
		list1.add("!");
		list1.add("!");
		list1.remove(4);
		list1.remove("!");
		String itString=list1.get(2);
		System.out.println(itString);
		System.out.println("list1���Ƿ����I��"+list1.contains("I"));  //�ж�list���Ƿ����ĳԪ��
		list1.set(2, "hate"); //Ԫ���滻
		printList(list1);
		list1.add(2, "like");   //��ԭ�л����ϲ���
		printList(list1); 
		//�鿴���жϣ�Ԫ�ص�����
		System.out.println(list1.indexOf("!"));  //��ǰ�����һ��
		System.out.println(list1.lastIndexOf("!")); //�Ӻ���ǰ��һ��
		//����list������λ����������һ���µ�list����ȡ���ϣ�
		List<String> list2=list1.subList(2, 4); //[2,4)
		printList(list2); 
		
		System.out.println(list1.isEmpty());  //�ж�list�Ƿ�Ϊ�գ�
		System.out.println(list1.toString());  //������ת��Ϊ�ַ�����
		System.out.println(list1.toArray());  //������ת��Ϊ���飻
		list1.add("T");
		list1.add("I");
		list1.add("T");
		printList(list1);
		//ȥ�ظ���
		List<String> list3= new ArrayList<String>();
		for(String s:list1) {
			if(Collections.frequency(list3, s)<1) { //���sδ��list3��
				list3.add(s); 
			}
		}
		printList(list3);
		
	}
	public static void printList(List<String> list1) {
		 for (int i = 0; i < list1.size(); i++) {
		        System.out.println(list1.get(i));  //.get(index)
	}
    }

}
