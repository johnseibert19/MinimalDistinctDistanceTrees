import java.io.IOException;

public class P3Forests{
   static public int minNodes=6; // minNodes is the minimum number of nodes in the forest
   static public int n=6; // n is the maximum number of nodes in the forest
   static public int paths=n/3; // paths is the total number of paths
   int e, v, w, maxDist ; // e=# of edges, v=# of vertices, w=weight of next edge, maxDist= maximum Distance in current forest
   CheckList found;  //  found keeps track of path lengths that have been achieved.
   TableList tree; // distance tables for each tree in the forest
static int count=0;
static boolean counting=false;

   public P3Forests(){
      e=0;
      v=0;
      w=1;
      maxDist=1;
      found= new CheckList(paths+1);
      tree= new TableList();
      append();
    }
  


   public P3Forests(int setE, int setV, int setW, int setm, CheckList setF, TableList setT){

      e=setE;
      v=setV;
      w=setW;
      maxDist=setm;
      found=new CheckList(setF);
      tree=new TableList(setT);
      add();

   }
   
  

   void add(){
 
         for(int t1=0; t1<tree.length()-1; t1++)
           for(int t2=t1+1; t2<tree.length(); t2++){
              int size1=tree.get(t1).m;
              int size2=tree.get(t2).m;
              if(size1==2 && size2==2)
                  connect(t1,t2,0,0);
           }
	   if(v<n){
             for(int t=0; t<tree.length(); t++){
                int size=tree.get(t).m;
                if(size==2) attach(t,0);
                if(size==3){
		  attach(t,1);
       	          attach(t,2);
                }

             if(v<n-1) append();             
           } 
      }      
   
   void check(int newE, int newV, CheckList newFound, TableList newTree){
       
       int newMaxDist=paths;
       while(!newFound.get(newMaxDist)) newMaxDist--; 
 
//      int newW;
//      for(newW=w; newW<= paths && newFound.get(newW); newW++);{}
//  	if(newV>= minNodes && newW==newMaxDist+1) {
//		boolean isolEdge=false;
//                for(int i=0; i<newTree.length(); i++) {
//			if(newTree.get(i).m==2) {
//				isolEdge=true; 
//				break;
//			}
//		}					
//		if(!isolEdge) {
//			if(newTree.length()==2) System.out.println("TWO COMPONENT");
			System.out.println("Perfect Forest: ");
             		for(int i=0; i<newTree.length(); i++) System.out.println(newTree.get(i).toString());
	}
counting=false;}

if(counting){ count++;
if(count % 100000==0){ 
System.out.println((float) count/1000000
+ " million forests checked. " +  
" Current forest:");
for(int i=0; i<newTree.length(); i++) 
System.out.println(newTree.get(i).toString());

}
} 
              if(newV<=n) {
		P3Forests newForest; 
              	newForest= new P3Forests(newE, newV, newW, newMaxDist, newFound, newTree);
              }
  
   } 
       
   void connect(int t1, int t2, int v1, int v2){
      connectBlock: 
      {
      TableList newTree=new TableList(tree, t2);
      CheckList newFound=new CheckList(found);
      Table newTable;
      int m1=tree.get(t1).m;
      int m2=tree.get(t2).m;
      newTable=new Table(m1+m2);
      int diam1=tree.get(t1).d;
	for(int i=0; i<m1; i++) newTable.setRow(i,tree.get(t1).getRow(i),diam1);
        for(int k=0; k<m2; k++){
            int i=m1+k;
            for(int j=0; j<m1; j++){
               int newDist=tree.get(t1).get(j,v1)+w+tree.get(t2).get(k,v2);
               if(newDist>paths || newFound.get(newDist)) 
                  break connectBlock;  
               newFound.set(newDist);
               newTable.set(i,j,newDist);
            }
            for(int l=0; l<k; l++){
               int j=m1+l;
               newTable.set(i,j,tree.get(t2).get(l,k));
            } 
         }
       newTree.set(t1, newTable);
       check(e+1, v, newFound, newTree); 
       }
    }
   


   void attach(int tr, int vert){
     attachBlock:
     {
     TableList newTree= new TableList(tree);
     CheckList newFound=new CheckList(found);
     int newM=tree.get(tr).m+1;
     int[] newRow= new int[newM];
     int rowMax=0;
     for(int j=0; j<newM-1; j++){
        int newDist=tree.get(tr).get(j,vert)+w;
        if(newDist>paths || newFound.get(newDist)) 
           break attachBlock;  
        newFound.set(newDist);
        newRow[j]=newDist;
        if(newDist>rowMax) rowMax=newDist;
     }   
     newTree.set(tr, tree.get(tr).addRow(newRow, rowMax));
     check(e+1, v+1, newFound, newTree); 
     }
  }

   void append(){

      Table newTable=new Table();
      CheckList newFound=new CheckList(found);
      newFound.set(w);
      int[] row={w};
      TableList newTree=new TableList(tree, newTable.addRow(row, w));
      check(e+1, v+2, newFound, newTree);
     }

   

    
   public static void main(String [] args) {
      
  	P3Forests myForest;
        myForest= new P3Forests();
        if(counting) System.out.println(count+" forests checked.");
        System.out.println("All done!");
   }
}