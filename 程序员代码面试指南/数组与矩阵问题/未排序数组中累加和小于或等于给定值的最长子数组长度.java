package �������������;

public class δ�����������ۼӺ�С�ڻ���ڸ���ֵ��������鳤�� {
	public static int maxLength(int[] arr ,int k) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int sum=0;
		int[] helpArr=new int[arr.length+1]; //��¼sum��������ֵ
		helpArr[0]=sum;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			helpArr[i+1]=Math.max(sum, helpArr[i]);
		}
		sum=0;
		int res=0;
		int pre=0;
		int len=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			pre=getLessIndex(helpArr, sum-k); //�ҵ�sum-k�ĸ��������������ֵ�λ��
			len=pre==-1?0:i-pre+1;
			res=Math.max(res, len);
		}
		return res;
	}
	//���ö��ֲ���ʵ��
	public static int getLessIndex(int[] arr,int num) {
		int low=0;
		int high=arr.length-1;
		int mid=0;
		int res=-1;
		while (low<=high) {
			mid=(high+low)/2;
			if (arr[mid]>=num) { //�����
				res=mid;
				high=mid-1;
			}else {//���ұ�
				low=mid+1;
			}
		}
		return res;
	}
	
	
	//����2
	public static int maxLength2(int[] arr ,int k) {
		if (arr==null ||arr.length==0) {
			return 0;
		}
		int[] minSums=new int[arr.length]; //��arr[i]Ϊ��ʼλ�õ���С��
		int[] minSumEnds=new int[arr.length]; //��arr[i]Ϊ��ʼλ�õ���С�Ͷ�Ӧ���ұ߽�
		//�����������
		minSums[arr.length-1]=arr[arr.length-1];
		minSumEnds[arr.length-1]=arr.length-1;
		for (int i = arr.length-2; i >=0; i--) {
			if (minSums[i+1]<=0) {
				minSums[i]=arr[i]+minSums[i+1];
				minSumEnds[i]=minSumEnds[i+1];
			}else {
				minSums[i]=arr[i];
				minSumEnds[i]=i;
			}
		}
		int end=0; //end�Ǵ������ұ�λ�õ���һ��λ��
		int sum=0; //��ǰ�����еĺ�,arr[i:end-1]�ĺ�
		int res=0;
		
		for (int i = 0; i < arr.length; i++) { //��������ߵ�λ��
			while (end<arr.length && sum+minSums[end]<=k) {
				sum+=minSums[end];
				end=minSumEnds[end]+1;
			}
			res=Math.max(res, end-i);
			if (end>i) { //�����ڻ�����
				sum-=arr[i];
			}else { //�����������Ѿ�û�����ˣ���С����Ϊarr[i:i]
				end=i+1;
			}
		}
		return res;
	}
	
	// for test
	public static int[] generateRandomArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 3, -2, -4, 0, 6 };
		int k = -2;
		System.out.println(maxLength(arr, k));
		System.out.println(maxLength2(arr, k));

	}

}
