package src;

import java.util.HashMap;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
 * ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * 
 * ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿ�
 * @author zoe
 *
 */
public class ��������ĸ��� {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	/**
 * ��һ����Ȼ�Ǹ���ԭʼ�����ϵ�ÿ�����N����N'��Ȼ�����Щ���������Ľ����m_pNext����������ͬʱ���ǰ�<N, N'>�������Ϣ�ŵ�һ����ϣ���С�
 * �ڶ����������ø��������ϵ�ÿ������m_pSibling�������ԭʼ�����н��N��m_pSiblingָ����S����ô�ڸ��������У���Ӧ��N'Ӧ��ָ��S'��
 * �������˹�ϣ�����ǿ�����O(1)��ʱ�����S�ҵ�S������������O(n)�Ŀռ任����O��n����ʱ�临�Ӷȡ�

	 * @param pHead
	 * @return
	 */
    public RandomListNode Clone(RandomListNode pHead){
    	if(pHead==null) {
    		return null;
    	}
    	HashMap<RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode pClonedHead =new RandomListNode(pHead.label);//���������ͷ���
    	RandomListNode pNode=pHead,pClonedNode =pClonedHead;
    	map.put(pNode, pClonedNode);
    	//��һ����hashMap���棬ԭ����ڵ�ӳ�临������ڵ�
    	while (pNode.next!=null) {
			pClonedNode.next=new RandomListNode(pNode.next.label);
			pNode=pNode.next;
			pClonedNode=pClonedNode.next;
			map.put(pNode, pClonedNode);
		}
    	
    	//�ڶ������ҵ���Ӧ������ָ��
    	pNode=pHead;
    	pClonedNode=pClonedHead;
    	while (pClonedNode!=null) {
			pClonedNode.random=map.get(pNode.random);
			pNode=pNode.next;
			pClonedNode=pClonedNode.next;
		}		
    	
        return pClonedHead;
    }
    /**
     * �Ż�����
     * ��һ��������Ȼ�Ǹ���ԭʼ�����ÿ�����N������Ӧ��N'���������ǰ�N��������N�ĺ��档
     * �ڶ��������ø��Ƴ����Ľ���m_pSibling��ԭʼ�����ϵ�A��m_pSiblingָ����C��
     * ��ô���Ӧ���Ƴ�����A����A��m_pNextָ��Ľ�㣬ͬ��C��Ҳ��C��m_pNextָ��Ľ�㡣
     * ��A' = A.next��A'.m_pSibling = A.m_pSibling.next��
     * ���������Ϳ��԰�ÿ������m_pSibling������ϡ�
     * ��������������������ֳ���������������λ�õĽ����m_pNext������������ԭʼ����
     * ��ż��λ�õĽ����m_pNext�����������Ǹ��Ƴ���������

     * @param pHead
     * @return
     */
    public RandomListNode Clone2(RandomListNode pHead){
    	RandomListNode pNode=pHead;
    	while (pNode!=null) {
    		//����pClonedNode��㼴A'���ʹ��ָ��ԭʼ������A������һ���B,����A'��m_pSibling����Ϊnull
			RandomListNode pClonedNode=new RandomListNode(pNode.label);
			pClonedNode.next=pNode.next;
			pClonedNode.random=null;
			//��A���ָ��A�����
			pNode.next=pClonedNode;
			//ʹpNodeָ��A����һ���B���Դ�ѭ���޸�(��ʱ�м��ѽ���¡���A��������ԭʼ�б�)
			pNode=pClonedNode.next;
			
		}
    	

    	//����ÿ������m_pSibling(ע��m_pSiblingΪ�ս�㲻���޸�)
    	pNode=pHead;
    	while (pNode!=null) {
			RandomListNode pClonedNode=pNode.next;
			if(pNode.random!=null) {
				pClonedNode.random=pNode.random.next;
			}
			pNode=pClonedNode.next;
		}
    	

    	//�������
    	pNode=pHead;
    	RandomListNode pClonedHead =null;
    	RandomListNode pClonednNode =null;
    	if(pNode!=null) {
    		pClonedHead=pClonednNode=pNode.next;
    		pNode.next=pClonednNode.next;
    		pNode=pNode.next;
    	}
    	while (pNode!=null) {
    		pClonednNode.next=pNode.next;
    		pClonednNode=pClonednNode.next;
    		pNode.next=pClonednNode.next;
    		pNode=pNode.next;
			
		}
    	return pClonedHead;

    }
}
