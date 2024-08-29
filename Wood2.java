public class Wood2{
   
    
   public static void main(String [] args) {
      
  	Forest myForest;
        Table t1=new Table(2), t2=new Table(3);
        Table t3=new Table(2);
        t1.set(0,1,1);
        t2.set(0,1,2);
	t2.set(0,2,4);
        t2.set(1,2,6);
        t3.set(0,1,3);
	TableList base=new TableList();
        base=new TableList(base, t1);
        base=new TableList(base, t2);
	base=new TableList(base, t3);
        int n=16;
        int paths=n*(n-1)/2;
        CheckList list=new CheckList(paths+1);
        list.set(1);
        list.set(2);
        list.set(3);
        list.set(4);
        list.set(6);
        myForest= new Forest(4,7,5,list,base);
        System.out.println("Case 2 done!");

        t2=new Table(2);
        t3=new Table(3);
        t2.set(0,1,2);
	t3.set(0,1,3);
	t3.set(0,2,4);
        t3.set(1,2,7);
	base=new TableList();
        base=new TableList(base, t1);
        base=new TableList(base, t2);
	base=new TableList(base, t3);
        list=new CheckList(paths+1);
        list.set(1);
        list.set(2);
        list.set(3);
        list.set(4);
        list.set(7);
        myForest= new Forest(4,7,5,list,base);
        System.out.println("Case 3 done!");

        t3=new Table(2); 
        Table t4=new Table(2);
	t3.set(0,1,3);
	t4.set(0,1,4);
    	base=new TableList();
        base=new TableList(base, t1);
        base=new TableList(base, t2);
	base=new TableList(base, t3);
	base=new TableList(base, t4);
        list=new CheckList(paths+1);
        list.set(1);
        list.set(2);
        list.set(3);
        list.set(4);
        myForest= new Forest(4,8,5,list,base);
        System.out.println("Case 4 done!");

        System.out.println("All done!");
   }
}