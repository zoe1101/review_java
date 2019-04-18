package ��;

//����javaʵ��һ�¶ѵ����ݽṹ

import java.util.ArrayList;

public class MaxHeap1 {
  
  
  ArrayList<Integer> heapList = new ArrayList<>();
  
  /*
   *�������е�����Ԫ�� 
   */
  private void swap(int srcIndex,int dstIndex)
  {
      int tmp = heapList.get(srcIndex);
      
      heapList.set(srcIndex,heapList.get(dstIndex));
      heapList.set(dstIndex, tmp);
      
  }
  
  /*
   *��ָ��Ԫ�ص�λ�ý������Ʋ��� 
   */
  private void HeapUp(int index)
  {
              
      if(index > 1)
      {
          int parent = index / 2;
          int parentVal = heapList.get(parent).intValue();
          int indexVal =  heapList.get(index).intValue();
          
          if(indexVal > parentVal)
          {
              swap(parent,index);
              HeapUp(parent);
          }
          
      }
  }
  
  /*
   *��ָ��Ԫ�ص�λ�ý������Ʋ��� 
   */
  private void HeapDown(int index)
  {
      int heapSize = heapList.size(); //����������ظ��ļ���,���Խ���Ϊ�βδ��룬���߽��ú�����д�ɷǵݹ���ʽ
      
      if(index > heapSize - 1)
      {//�ڵ㲻����
          return;
      }
      
      int child = index * 2; //���ӽڵ�
      
      if(child > (heapSize - 2))
      {//��ǰ�ڵ�ΪҶ�ӽڵ㣬���ܽ������Ʋ�����ֱ�ӷ���
       //-2���������һ��Ԫ���Ѿ���Ҫɾ���Ľڵ㣬���ڼ��㷶Χ֮��
          return;
      }
      else if(child < heapSize - 2) 
      {//���������ӽڵ�
           if((Integer)heapList.get(child) < (Integer)heapList.get(child + 1))
           {
               child++; //�Һ��ӽ��ֵ����Ϊ�µĸ��ڵ�
           }
      }
      
      if(heapList.get(child).intValue() > heapList.get(index).intValue())
      {//���ӽڵ��ֵ�󣬽�������
          swap(child, index);
          HeapDown(child);//�����������Ʋ���
      }
      
  }
  
  /*
   *��󶥶��в���һ��Ԫ��
   */
  public void HeapInsert(int value)
  {
      int heapSize = heapList.size();
      
      if(heapSize == 0)
      {//��һ��Ԫ�ز�Ϊ���е�Ԫ�أ�����
          heapList.add(-100);
      }
      
      heapList.add(value);
      heapSize++; //�����Ԫ�غ󣬸ı�ѵĴ�С
      
      HeapUp(heapSize - 1);
  }
  
  /*
   *�Ӵ󶥶���ɾ��һ��Ԫ�� 
   */
  public void HeapDelete(int value)
  {
      int index = 1,heapSize = heapList.size();
      for(; index < heapSize; index++)
      {
          if(heapList.get(index).intValue() == value)
          {
              break;
          }
      }
      
      if (index >= heapSize)
      {//Ԫ�ز�����
          return;
      }
      
      heapList.set(index, heapList.get(heapSize-1)); //�����һ��Ҷ�ӽڵ�ֵ��ֵ����ǰ�ڵ�
      HeapDown(index); 
      
      int parent = index / 2;
      
      if(parent > 0 && ( heapList.get(index).intValue() > (Integer)heapList.get(parent).intValue() ))
      {//������Ʋ������Ԫ�ش��ڸ��ڵ㻹Ҫ��������
          HeapUp(index);
      }
      
      heapList.remove(heapSize - 1);
  }
  
  /*
   * ��ӡ��Ԫ��
   */
  public void PrintHeap()
  {
      for(int i = 1; i < heapList.size(); i++)
      {
          System.out.print(heapList.get(i) + " ");
      }
      
      System.out.println();
  }
  
  public static void main(String args[])
  {
	  MaxHeap1 bigHeap = new MaxHeap1();
      
      bigHeap.HeapInsert(1);
      bigHeap.HeapInsert(3);
      bigHeap.HeapInsert(4);
      bigHeap.HeapInsert(5);
      bigHeap.HeapInsert(8);
      bigHeap.HeapInsert(2);
      bigHeap.HeapInsert(7);
      bigHeap.HeapInsert(6);
      
      bigHeap.PrintHeap();
      
      bigHeap.HeapDelete(2);
      bigHeap.PrintHeap();
      bigHeap.HeapDelete(8);
      bigHeap.PrintHeap();
  }
}
