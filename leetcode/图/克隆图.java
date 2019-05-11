package ͼ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ��¡ͼ {
	// Definition for a Node.
	public static class Node {
	    public int val;
	    public ArrayList<Node> neighbors;

	    public Node() {}

	    public Node(int _val,ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	//������ȱ���
    public static Node cloneGraph(Node node) {
    	HashMap<Node, Node> hashMap=new HashMap<Node, Node>(); //��ϣ�������洢�Ѿ����ʹ��Ľڵ�
    	return dfs(node, hashMap);
    }
    
    public static Node dfs(Node node, HashMap<Node, Node> map){
    	if (node == null) return null;
    	
    	ArrayList<Node> list = new ArrayList<Node>();
        Node clone_node = new Node(node.val, list);
    	map.put(node, clone_node);
    	
		for(Node neighborNode:node.neighbors) {
			if(!map.containsKey(neighborNode)) { // ���û�еĻ���Ҫ�����ҵ�����neighborNode���ټӽ�ȥ
				Node clone_neighborNode=dfs(neighborNode, map);
				clone_node.neighbors.add(clone_neighborNode);
				
			}else {// ���map���Ѿ���������ڽ����Ϣ��ֱ�Ӽӽ�ȥnode��neighborNode
				Node tmp = map.get(neighborNode);
                clone_node.neighbors.add(tmp);
			}
		}
		return clone_node;
    }
    
}
