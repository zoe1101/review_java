package �ַ���;

public class �����򵫺��пյ������в����ַ��� {
	public static int getIndex(String[] strs,String str) {
		if(str==null || strs.length==0 ||strs==null) {
			return -1;
		}
		int res=-1;
		int left=0;
		int right=strs.length-1;
		int i=0;
		while (left<=right) {
			int mid=(right+left)/2;
			if(strs[mid]!=null && strs[mid].equals(str)) {//strs[mid]=str,��ôstr������0-mid��Χ��
				res=mid;
				right=mid-1;
			}else if(strs[mid]!=null){
				if(strs[mid].compareTo(str)<0) { //strs[mid]С��str������str��mid�ұ�
					left=mid+1;
				}else {//����str��mid���
					right=mid-1;
				}
			}else {//strs[mid]==null�Ҳ�����str������str��=null , ��ʱ��ȷ��str��mid����߻����ұ�
				i=mid;
				while (strs[i]==null && --i>=left) ;//���ҵ���mid��ʼ����߲�Ϊnull��λ��
				if(i<left ||strs[i].compareTo(str)<0) { //���ȫ��null����strs[mid]С��str������str��mid�ұ�
					left=mid+1;
				}else { //��߲�ȫ��null
					res=strs[i].equals(str)?i:res;
					right=i-1;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs= {"a",null,"b",null,null,"c"};
		String str="b";
		System.out.println(getIndex(strs, str));
		
	}
}
