package �ݹ��붯̬�滮;
/*
��ʿ�����Ͻǳ�����ÿ��ֻ�����һ������ߣ���󵽴����½Ǽ���������
��ͼ��ÿ��λ�õ�ֵ������ʿҪ���������顣����Ǹ�����˵���˴��й��ޣ�Ҫ����ʿ��ʧѪ����
����ǷǸ���������˴���Ѫƿ��������ʿ��Ѫ��
��ʿ�����Ͻǵ����½ǵĹ����У��ߵ��κ�һ��λ��ʱ��Ѫ������������1.

Ϊ�˱�֤��ʿ�ܼ�����������ʼѪ�������Ƕ��٣�����map�����س�ʼѪ����
 */
//��Ҫ���������·����Ȼ��������ʼѪ��dp[0][0]
public class ������³���Ϸ���� {
	public static int minHP1(int[][] map) {
		if (map==null || map.length==0 || map[0]==null || map[0].length==0) {
			return 1;
		}
		int row=map.length;
		int col=map[0].length;
		//dp[i][j]:���i,j��λ�ã���������Ҫ���½�������Ҫ��Ѫ��
		int[][] dp=new int[row][col];
		
		//dp[row-1][col-1]:Ҫ�������½�������Ҫ��Ѫ��
		dp[row-1][col-1]=map[row-1][col-1]>0?1:-map[row-1][col-1]+1; 
		for (int j = col-2; j >=0; j--) { //���һ�У�ֻ�������ߵĿ���
			dp[row-1][j]=Math.max(dp[row-1][j+1]-map[row-1][j+1], 1);
		}
		
		int right=0;
		int dowm=0;
		//dp[i][j+1]:�ӣ�i��j��λ��������
		//dp[i+1][j]:�ӣ�i��j��λ��������
		for (int i = row-2; i>=0; i--) {
			dp[i][col-1]=Math.max(dp[i+1][col-1]-map[i][col-1], 1);
			for (int j = col-2; j>=0; j--) {
				right=Math.max(dp[i][j+1]-map[i][j], 1);
				dowm=Math.max(dp[i+1][j]-map[i][j], 1);
				dp[i][j]=Math.min(right, dowm); //�������ߺ���������ѡһ�����ҵ�
			}
		}
		return dp[0][0];
	}
	//�Ż���̬�滮
	public static int minHP2(int[][] map) {
		if (map==null || map.length==0 || map[0]==null || map[0].length==0) {
			return 1;
		}
		int more=Math.max(map.length, map[0].length);
		int less=Math.min(map.length, map[0].length);
		boolean rowmore=more==map.length; //�������Ƿ���ж�
		int[] dp=new int[less];
		int tmp=map[map.length-1][map[0].length-1];
		dp[less-1]=tmp>0?1:-tmp+1;
		int row=0;
		int col=0;
		for (int j = less-2; j >=0; j--) {
			//�������Ƿ���жࡣ�ǵĻ����л����У��л����С��������л�����
			row=rowmore?more-1:j;
			col=rowmore?j:more-1;
			dp[j]=Math.max(dp[j+1]-map[row][col], 1);
		}
		int choosen1=0;
		int choosen2=0;
		for (int i = more-2; i>=0; i--) {
			row=rowmore?i:less-1;
			col=rowmore?less-1:i;
			dp[less-1]=Math.max(dp[less-1]-map[row][col], 1);
			for (int j= less-2; j >=0; j--) {
				row=rowmore?i:j;
				col=rowmore?j:i;
				choosen1=Math.max(dp[j]-map[row][col], 1);
				choosen1=Math.max(dp[j+1]-map[row][col], 1);
				dp[j]=Math.min(choosen1, choosen2);
			}
		}
		return dp[0];
	}

}
