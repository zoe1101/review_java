package src;

/*
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */

public class �ؽ������� {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value) {
			this.val =value;
		}
		
	}
	
    /**
     * @param pre  ǰ�����
     * @param in    �������
     * @return        ���������ڵ�
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in==null || pre.length!=in.length) return null;
        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    /**
      * @param pre    ǰ�����
      * @param ps    ǰ������Ŀ�ʼλ��
      * @param pe    ǰ������Ľ���λ��
      * @param in    �������
      * @param is    ��������Ŀ�ʼλ��
      * @param ie    ��������Ľ���λ��
      * @return        ���ĸ��ڵ�
     */
    public static TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
    	if(ps > pe) return null;
        
        // ȡǰ������ĵ�һ�����־��Ǹ��ڵ�
        int value = pre[ps];
        // �������������Ѱ�Ҹ��ڵ�
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣 
        if(index > ie) 
            throw new RuntimeException("Invalid Iuput!");
        
        // ������ǰ���ڵ㣬��Ϊ���ڵ㸳ֵ
        TreeNode node = new TreeNode(value);
        // �ݹ���ù�����ǰ�ڵ�������� 
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // �ݹ���ù�����ǰ�ڵ��������
        node.right = construct(pre, ps+index-is+1, pe, in, index+1, ie);
        
        return node;
    	
    }

	public static void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.val + " ");
            printTree(root.right);
        }
    }
    
    public static void main(String[] args) {
       int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
       int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
       TreeNode node = reConstructBinaryTree(pre, in);
       printTree(node);
       
   }
}
