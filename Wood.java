public class Wood{
   
    
   public static void main(String [] args) {
      
  	Forest myForest;
        Table t1=new Table(2), t2=new Table(2);
        Table t3=new Table(2), t4=new Table(2); 
        Table t5=new Table(2); //, t6=new Table(2);  
        t1.set(0,1,1);
        t2.set(0,1,2);
        t3.set(0,1,3);
        t4.set(0,1,4);
 	t5.set(0,1,5);
        TableList base=new TableList();
        base=new TableList(base, t1);
        base=new TableList(base, t2);
	base=new TableList(base, t3);
	base=new TableList(base, t4);
	base=new TableList(base, t5);
        //base=new TableList(base, t6);
        int n=16;
        int paths=n*(n-1)/2;
        CheckList list=new CheckList(paths+1);
        list.set(1);
        list.set(2);
        list.set(3);
        list.set(4);
        list.set(5);
        myForest= new Forest(5,10,6,list,base);
        System.out.println("All done!");
   }
}