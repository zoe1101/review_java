package src;
/*
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 */
public class �ԳƵĶ����� {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
/*
������Ӧ��ֵ��ȣ�ԭ������Root�����������侵�������Root'����������ͬ��
��ԭ������Root�����������侵�������Root'����������ͬ����˵ݹ���ȥ��ֱ��
�� ���Root��Root'��Ϊ�գ��򷵻�true��
�� ���RootΪ�ջ���Root'Ϊ�գ��򷵻�false��
�� ���Root��Ӧ��ֵ��Root'��Ӧ��ֵ����ȣ��򷵻�false��

*/

    boolean isSymmetrical(TreeNode pRoot)
    {
        return judge(pRoot,pRoot);
    }
    
    public boolean judge(TreeNode pRoot,TreeNode root){
        if(pRoot== null && root == null){
            return true;
        }
        if(pRoot==null || root == null){
            return false;
        }
        if(pRoot.val != root.val)
            return false;
        return judge(pRoot.left,root.right) && judge(pRoot.right,root.left);
    }
}
