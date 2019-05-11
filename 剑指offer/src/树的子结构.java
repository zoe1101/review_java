package src;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * @author zoe
 *
 */
public class �����ӽṹ {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
1���������ǵ�˼·Ӧ���ǴӶ�����A�ĸ���㿪ʼ�ݹ������������ÿ���ʵ�һ����㣬��Ҫ��鵱ǰ����Ƿ��Ѿ��������Ŀ�ʼ��㣬������ý������Һ��Ӽ������
2�����жϵ�ǰ����Ƿ��Ѿ��������Ŀ�ʼ���ʱ�������жϽ��ֵ�Ƿ���ȣ���ȵĻ����жϸ��Ե����Һ����Ƿ�Ҳ��Ӧ��ȣ���ʱҪע�⣬����������Ϊ�գ���������A������Ϊ�գ�
	 * @param root1
	 * @param root2
	 * @return
	 */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) {
        	return false;
        }
      //Ҫô��ǰ����Ѿ������� Ҫô��ǰ�������ӻ��Һ��Ӵ�������;
        return IsSubtree(root1, root2) || IsSubtree(root1.left, root2) || IsSubtree(root1.right, root2); 
    }
    public boolean IsSubtree(TreeNode root1,TreeNode root2){
    	if(root2==null) {//˵���Ѿ���ȫƥ��
    		return true;
    	}
    	if(root1==null) { //root1�����˻�û��ƥ����root2
    		return false;
    	}
    	if(root1.val==root2.val) {
    		return IsSubtree(root1.left, root2.left) &&IsSubtree(root1.right, root2.right);
    	}else {
    		return false;
    	}
    }
}
