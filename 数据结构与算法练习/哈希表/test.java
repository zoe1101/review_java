package ¹þÏ£±í;

public class test {
	public static void main(String[] args) {
		 
        HashTable table = new HashTable(20);
 
        table.put(5, "aaa");
        table.put(8, "bbb");
        table.put(3, "ccc");
        table.put(8, "bbb");
        table.put(2, "ddd");
        table.put(9, "eee");
 
        System.out.println(table);
        System.out.println(table.get_value(3));
        table.delete(3);
        System.out.println(table);
    }

}
