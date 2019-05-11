package ��;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ���������� {
    private static class AVLNode{
        private AVLNode lchild = null;
        private AVLNode rchild = null;
        private int data;
        private int height; // ��¼�ýڵ����ڵĸ߶�

        public AVLNode(int data){
            this.data = data;
        }
    }

    public static AVLNode insert(AVLNode root, int data) {
        if (root == null) {
            root = new AVLNode(data);
            return root;
        }
        if (data <= root.data) { // ���뵽����������
            root.lchild = insert(root.lchild, data);
            if (getHeight(root.lchild) - getHeight(root.rchild) > 1) { // ��������ǰroot������߲��룬�����������߶ȱض���С���������߶�(����>1ʵ���ϵȼ���==2)
                if (data <= root.lchild.data) { // �������Ҷ�ӽ���ڸ�root�������ӵ����
                    root = LLRotate(root); // ���������root���ظ��丸�ڵ����������
                }else{ // �������Ҷ�ӽ���ڸ�root�������ӵ��ұ�
                    root = LRRotate(root);
                }
            }
        }else{ // ���뵽����������
            root.rchild = insert(root.rchild, data);
            if(getHeight(root.rchild) - getHeight(root.lchild) > 1){
                if(data <= root.rchild.data){
                    root = RLRotate(root);
                }else{
                    root = RRRotate(root);
                }
            }
        }
        // �������µĽڵ�󣬴�����ڵ㵽���ڵ�����·���ϵĽڵ�ĸ߶�ֵһ���ᷢ���ı䣬���⵱����ʧ���ʱ�����ʧ�����������Ƚڵ�ĸ߶�ֵҲ���ܻᷢ���ı�
        root.height = Math.max(getHeight(root.lchild), getHeight(root.rchild)) + 1; // ���µ���root�ڵ�ĸ߶�ֵ
        return root;
    }

    public static AVLNode remove(AVLNode root, int data){
        if(root == null){ // û���ҵ�ɾ���Ľڵ�
            return null;
        }
        if(data < root.data){ // ����������ɾ��
            root.lchild = remove(root.lchild, data);
            if(getHeight(root.rchild) - getHeight(root.lchild) > 1){ // ����������ɾ�����������߶�һ����С���������߶�
                if(getHeight(root.rchild.lchild) > getHeight(root.rchild.rchild)){
                    root = RLRotate(root);
                }else{
                    root = RRRotate(root);
                }
            }
        }else if(data == root.data){ // �ҵ�ɾ���Ľڵ�
            if(root.lchild != null && root.rchild != null){ // ɾ���Ľڵ��������������������
                root.data = findNextNode(root).data; // ��ʧ����data�����Ϊ��ֱ�Ӻ�̽ڵ��data��
                root.rchild = remove(root.rchild, root.data); // ������ת��Ϊɾ����ֱ�Ӻ�̽ڵ�
            }else{ // ֻ������������ֻ������������ΪҶ�ӽ������
                root = (root.lchild == null) ? root.rchild : root.lchild;
            }
        }else{ // ��root���������ϲ���ɾ���ڵ�
            root.rchild = remove(root.rchild, data);
            if(getHeight(root.lchild) - getHeight(root.rchild) > 1){
                if(getHeight(root.lchild.lchild) > getHeight(root.lchild.rchild)){
                    root = LLRotate(root);
                }else{
                    root = LRRotate(root);
                }
            }
        }
        if(root != null){ // ����root�ĸ߶�ֵ
            root.height = Math.max(getHeight(root.lchild), getHeight(root.rchild)) + 1;
        }
        return root;
    }

    // LLƽ����ת(�ҵ���ת)
    public static AVLNode LLRotate(AVLNode p){ // pΪʧ���
        AVLNode lsubtree = p.lchild;
        p.lchild = lsubtree.rchild; // ��ʧ���p������lsubtree����������Ϊʧ���p��������
        lsubtree.rchild = p; // ��ʧ�����Ϊlsubtree��������
        // ���µ���ʧ��㼰�����ӽڵ�ĸ߶�ֵ(ֻ���������ڵ�ĸ߶�ֵ���ܷ����ı�)
        p.height = Math.max(getHeight(p.lchild), getHeight(p.rchild)) + 1;
        lsubtree.height = Math.max(getHeight(lsubtree.lchild), p.height) + 1;
        return lsubtree; // ʧ���p�����ӳ�Ϊ�µĸ��ڵ�(ȡ��ԭʧ����λ��)
    }

    // RRƽ����ת(����ת)
    public static AVLNode RRRotate(AVLNode p){
        AVLNode rsubtree = p.rchild;
        p.rchild = rsubtree.lchild; // ��ʧ���p���Һ���rsubtree����������Ϊʧ���p��������
        rsubtree.lchild = p; // ��ʧ���p��Ϊrsubtree������
        // ���µ���ʧ��㼰���Һ��ӽڵ�ĸ߶�ֵ
        p.height = Math.max(getHeight(p.lchild), getHeight(p.rchild)) + 1;
        rsubtree.height = Math.max(getHeight(rsubtree.lchild), getHeight(rsubtree.rchild)) + 1;
        return rsubtree; //  ʧ���p���Һ��ӳ�Ϊ�µĸ��ڵ�(ȡ��ԭʧ����λ��)
    }

    // LRƽ����ת(�������˫��ת)
    public static AVLNode LRRotate(AVLNode p){
        p.lchild = RRRotate(p.lchild); // �Ƚ�ʧ���p������������RRƽ����ת
        return LLRotate(p); // �ٽ�ʧ���p����LLƽ����ת�������½ڵ����ԭʧ���p

    }

    // RLƽ����ת(���Һ���˫��ת)
    public static AVLNode RLRotate(AVLNode p){
        p.rchild = LLRotate(p.rchild); // �Ƚ�ʧ���p������������LLƽ����ת 
        return RRRotate(p); // �ٽ�ʧ���p����RRƽ����ת�������½ڵ����ԭʧ���p
    }


    public static int getHeight(AVLNode p){
        return p == null ? -1 : p.height; // �����ĸ߶�Ϊ-1
    }

    public static void inOrder(AVLNode root){
        if(root != null){
            inOrder(root.lchild);
            System.out.print(root.data + " ");
            inOrder(root.rchild);
        }
    }

    // �õ�p�ڵ�ĺ�̽ڵ�(�������),ʵ����Ҳ��p�ڵ���������ϵĹؼ���ֵ��С�Ľڵ�
    public static AVLNode findNextNode(AVLNode p){
        if(p == null){
            return null;
        }
        AVLNode r = p.rchild;
        while(r != null && r.lchild != null){
            r = r.lchild;
        }
        return r;
    }

    // �õ�p�ڵ��ֱ��ǰ���ڵ�(�������),ʵ����Ҳ��p�ڵ���������ϵĹؼ���ֵ���Ľڵ�
    public static AVLNode findPreviousNode(AVLNode p){
        if(p == null){
            return null;
        }
        AVLNode l = p.lchild;
        while(l != null && l.rchild != null){
            l = l.rchild;
        }
        return l;
    }
    
    public static void main(String[] args) {
        AVLNode root = null;
        for(int i = 1; i <= 10; i++){
            root = insert(root, i);
        }
        insert(root, 2);
        inOrder(root);
        System.out.println();
//	      System.out.println("height: " + (root.height + 1) + " " + (int)Math.ceil(Math.log(10)/ Math.log(2))); // ���ĸ߶�ΪҶ�ӽڵ�������ȼ���1(���ڵ�Ϊ��һ��)
        remove(root, 4);
        inOrder(root);
    }
	}
