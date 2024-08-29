public class Table{
   int m, d ; // m=# of rows, d=maximum entry
   int [] [] entry; // entries in the table

      public Table(int setM){
       m=setM;
       d=0;
       entry= new int[m] [];
       for(int i=0; i<m; i++)
          entry[i]= new int[i];
      }
       
      public Table(){
         this(1);
      }

      int get(int i, int j){
          if(i>j) return entry[i][j];
          else if (j>i) return entry[j][i];
          else return 0;
      }

      void set(int i, int j, int v){
          if(i!=j){
             if(v>d) d=v;
             if(i>j) entry[i][j]=v;
                else entry[j][i]=v;
          }
      }
      
      int [] getRow(int i){
          return entry[i];
       } 

      void setRow(int i, int [] row, int max){
           if(max>d) d=max;
           entry[i]=row;
       }

      Table addRow(int [] row, int max){
          Table t;
          t=new Table(m+1);
          for(int i=0; i<m; i++) t.entry[i]=entry[i];
          t.entry[m]=row;
          if(max>d) t.d=max;
            else t.d=d;
          return t;
      }

      public String toString(){
         String result="(";
         for(int i=0; i<m; i++){
            for(int j=0; j<i; j++)
               result=result+entry[i][j]+" ";
            result= result+"; ";
         }
         result=result+"diameter="+d+")";  
         return result;
      } 
} 
          