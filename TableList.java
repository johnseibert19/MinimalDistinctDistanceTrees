public class TableList{

  Table [] list;

  public TableList(){
    list=new Table[0];
  }

  public TableList(TableList tl){
    int k=tl.length();
    list=new Table[k];
    for(int i=0; i<k; i++)
      list[i]=tl.get(i);
  }

  public TableList(TableList tl, int j){
     int k=tl.length()-1;
     list=new Table[k];
     for(int i=0; i<j; i++) 
        list[i]=tl.get(i);
     for(int i=j; i<k; i++)
        list[i]=tl.get(i+1);
   }

  public TableList(TableList tl, Table t){
     int k=tl.length()+1;
     list=new Table[k];
     for(int i=0; i<k-1; i++)
        list[i]=tl.get(i);
     list[k-1]=t;
   }

   int length(){
      return list.length;
   }

   Table get(int i){
       return list[i];
   }
   
   void set(int i, Table t){
       list[i]=t;
    }
}    