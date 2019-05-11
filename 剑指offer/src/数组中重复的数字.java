package src;

import java.util.HashMap;

/*
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� 
 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 * ���ҳ�����������һ���ظ������֡�
 *  ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */
public class �������ظ������� {
	
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	//��Java�ķ����У�������duplication[0]����C/C++�е�ָ��*duplication��
	//�Ӷ��ڷ���boolean��ͬʱ��Ҳ���Ի����Ҫ�����֡�
	
	
	
	//����hashmap���ÿ��Ԫ��
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    if(numbers==null || numbers.length==0) {
	    	return false;
	    }
	    HashMap<Integer , Integer> map=new HashMap<Integer, Integer>();
	    for(int i=0;i<numbers.length;i++) {
	    	if(map.containsKey(numbers[i])) {
	    		duplication[0]=numbers[i];
	    		return true;
	    	}
	    	map.put(numbers[i], 0);
	    }
	    return false;
    }
	
//��������:
//��ɨ���ÿ�����֣�������m���ŵ����Ӧ�±꣨m�±꣩��λ���ϣ���ͬһλ�����ظ�����˵���������ظ���
	public boolean duplicate2(int numbers[],int length,int [] duplication) {
		if(numbers==null||length<=0)
            return false;
        for(int a:numbers){
            if(a<0||a>=length)
                return false;
        }
        int temp;
        for(int i=0;i<length;i++){
        	 while(numbers[i]!=i){
                 if(numbers[numbers[i]]==numbers[i]){
                     duplication[0]=numbers[i];
                     return true;
                 }
                 //// ����numbers[numbers[i]]��numbers[i]
                 temp=numbers[i];
                 numbers[i]=numbers[temp];
                 numbers[temp]=temp;
             }
         }
         return false;
	}
}
