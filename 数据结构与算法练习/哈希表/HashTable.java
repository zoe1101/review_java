package 哈希表;

import java.util.LinkedList;

public class HashTable{

	  private String[] key;    //关键字
	  private int max_size;    //哈希表的容量
	  public HashTable(){             //初始化，初始容量是10个
	      key = new String[10];
	      max_size = 0;
	  }

	  public int hash1(String s){ //哈希函数, 除留余数法
	        return Math.abs(s.hashCode())%key.length;
	  }

	  public int hash2(String s){ //处理冲突的哈希函数
	      int result = Math.abs(s.hashCode())%(key.length-1);
	      System.out.println(s+"--"+result);
	      if(result%2==0){
	          return result + 1;
	      }
	   return result;
	  }

	  public boolean contains(String s){  //判断哈希表里面是否包含字符串s
	      int start = hash1(s);
	      int i = start;
	      while (key[i] != null){
	           if(key[i].equals(s)){
	               return true;
	           }
	        i = (i + hash2(s))%key.length;
	        if(i == start){
	             return false;
	        }
	      }
	      return false;
	  }


	  public void add(String s){ //添加键值对
	       if(max_size>=key.length/2){
	            this.rehash();
	       }
	      int start = hash1(s);
	      int i = start;
	      while(key[i] != null){
	         if(s.equals(key[i])){
	              return;
	         }
	       i = (i + hash2(s))%key.length;
	      if(i == start){
	          return;
	       }
	     }
	    key[i] = s;
	    max_size ++;
	  }

   public void rehash(){ //扩建一个哈希表为原表的两倍,把原来的哈希表添加到新表中
       HashTable ht = new HashTable();
       ht.key = new String[this.key.length * 2];
       for(int i = 0; i < this.key.length; i ++){
           if((this.key[i] != null)){
               ht.add(this.key[i]);
          }
       }
       this.key = ht.key;
       this.max_size = ht.max_size;
    }

   public void remove(String s){   //删除某个元素
      if(this.contains(s)){
          int i = this.getValue(s);
          this.key[i] = null;
      }
   }


  public int getValue(String s){ //得到s在哈希表中的位置
    int start = this.hash1(s);
    int i = start;
     while(this.key[i] != null){
       if(this.key[i].equals(s)){
           return i;
       }
     i = (i + this.hash2(s))%this.key.length;
     if(i == start){
      return -1;
      }
    }
    return -1;
  }

  public void print(){                       //输出哈希表中所有元素
     for(int i = 0; i < key.length; i ++){
        System.out.println(i+":"+key[i]);
    }
  }

  public int size(){          //哈希表存储元素的个数
	   return this.max_size;
  }

   public int length(){            //哈希表的长度
	  return this.key.length;
   }

   public static void main(String[] args){    //测试
        HashTable ht = new HashTable();
        ht.add("chenhaitao");
        ht.add("zhongcheng");
        ht.add("baiyudong");
        ht.add("huangshiyao");
        ht.add("djflkd");
        ht.add("gg");
        System.out.println(ht.contains("baiyudong"));
        ht.remove("huangshiyao");
        System.out.println(ht.contains("huangshiyao"));
        ht.print();
   }
}
