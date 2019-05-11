package src;

import java.util.ArrayList;
import java.util.Stack;


/*
 * ��ʵ��һ����������֮���δ�ӡ��������
 * ����һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ��
 * �������Դ����ơ�
 */
public class ��֮����˳���ӡ������ {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//�ڲ�α����Ļ����Ͻ���z���ʹ�ӡ
//	�����д����ң���BFS�ı���˳��һ������ż���д��ҵ��󣬸�BFS�ı���˳���෴��
//	������ǲ���ֱ�Ӳ��ö��У�����ͨ������ջ��ʵ�֣�
//	һ��ʵ���Ƚ��ȳ�������ջ˳��Ϊ���ӽڵ㡢���ӽڵ㣻
//	һ��ʵ�ֺ���ȳ�������ջ˳��Ϊ���ӽڵ㡢���ӽڵ㡣
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	if (pRoot==null) {
			return result;
		}
    	Stack<TreeNode> stack1=new Stack<TreeNode>(); //������
    	Stack<TreeNode> stack2=new Stack<TreeNode>(); //���ҵ���
    	
    	ArrayList<Integer> list = new ArrayList<Integer>(); //ÿһ��Ľ��
    	list.add(pRoot.val);
    	result.add(list);
    	
    	stack1.push(pRoot);
    	
    	while (stack1.isEmpty() || stack2.isEmpty()) { 
			if (stack1.isEmpty() && stack2.isEmpty()) { //��������
				break;
			}
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					if (stack1.peek().right!=null) {
						temp.add(stack1.peek().right.val);
						stack2.push(stack1.peek().right);
					}
					if (stack1.peek().left != null) {
						temp.add(stack1.peek().left.val);
                        stack2.push(stack1.peek().left);
					}
					stack1.pop();
				}
			}else {
                while (!stack2.isEmpty()) {
                    if (stack2.peek().left != null) {
                        temp.add(stack2.peek().left.val);
                        stack1.push(stack2.peek().left);
                    }
                    if (stack2.peek().right != null) {
                        temp.add(stack2.peek().right.val);
                        stack1.push(stack2.peek().right);
                    }
                    stack2.pop();
                }
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }
        return result;
    }
}
