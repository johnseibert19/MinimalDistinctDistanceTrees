public class CheckList{

boolean [] list;

  public CheckList(int size){
    list= new boolean[size];
    for(int i=0; i<size; i++) 
      list[i]=false;
  }

  public CheckList(CheckList cl){
    int k=cl.length();
    list=new boolean[k];
    for(int i=0; i<k; i++)
       list[i]=cl.get(i);
  }

  int length(){
    return list.length;
  }

  boolean get(int i){
     return list[i];
  }

  void set(int i){
     list[i]=true;
  }
} 