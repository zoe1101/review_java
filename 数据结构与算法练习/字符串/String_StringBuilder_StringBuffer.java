package �ַ���;

public class String_StringBuilder_StringBuffer {
	private static int time = 50000;
//	����java.lang.String����ʹ�õ�ʱ��Ϊ��3694����
	public static void testString () {
        String s="";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            s += "java";
        }
        long over = System.currentTimeMillis();
        System.out.println("����"+s.getClass().getName()+"����ʹ�õ�ʱ��Ϊ��"+(over-begin)+"����");
    }
//	����java.lang.StringBuffer����ʹ�õ�ʱ��Ϊ��2����
	public static void testStringBuffer () {
        StringBuffer sb = new StringBuffer();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("����"+sb.getClass().getName()+"����ʹ�õ�ʱ��Ϊ��"+(over-begin)+"����");
    }
//	����java.lang.StringBuilder����ʹ�õ�ʱ��Ϊ��1����
    public static void testStringBuilder () {
        StringBuilder sb = new StringBuilder();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("����"+sb.getClass().getName()+"����ʹ�õ�ʱ��Ϊ��"+(over-begin)+"����");
    }
    
//  �ַ���ֱ����Ӳ�����0����
    public static void test1String () {
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            String s = "I"+"love"+"java";
        }
        long over = System.currentTimeMillis();
        System.out.println("�ַ���ֱ����Ӳ�����"+(over-begin)+"����");
    }

//    �ַ��������Ӳ�����4����
    public static void test2String () {
        String s1 ="I";
        String s2 = "love";
        String s3 = "java";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            String s = s1+s2+s3;
        }
        long over = System.currentTimeMillis();
        System.out.println("�ַ��������Ӳ�����"+(over-begin)+"����");
    }

	public static void main(String[] args) {
        testString();
        testStringBuffer();
        testStringBuilder();
        test1String();
        test2String();
	}

}
