//NodeEs.java
public class NodeEs { 
  private int elem; 
  private NodeEs next;

  public NodeEs(int elem, NodeEs next){this.elem=elem; this.next=next;}

  public int getElem(){return elem;}
  public NodeEs getNext(){return next;}
  public void setElem(int elem){this.elem=elem;}
  public void setNext(NodeEs next){this.next=next;}
    
  /* Nel file NodeUtil.java abbiamo il metodo:

       public static void scriviOutput(Node p){
         while (p!=null){
          System.out.println(p.getElem());
          p=p.getNext();
       }
      }
      
    Ora scriviamo il metodo dinamico analogo direttamente nella classe NodeEs. Si noti che non si può chiamare su un nodo null, ovvero
    sarà il codice client a dover gestire il caso di nodo = null e NON chiamare il metodo, per evitare una NullPointerException.
    
    Per evitare di dover gestire a parte il caso del nodo null, occorrerebbe agire come nel caso del DynamicStack, ovvero creare una classe List con un campo 'first' di tipo Node, per cui un oggetto di tipo List non sarà mai null, al massimo lo sarà first (e in questo caso la lista sarà vuota).
  */
    public void scriviOutput(){
         NodeEs p = this;
         // serve p perché this non è modificabile
         while (p!=null){
          System.out.println(p.getElem());
          p=p.getNext();
       }
    }
   
   public static void main(String[] args){
       NodeEs n = new NodeEs(4, new NodeEs(6, null));

       n.scriviOutput();
       
       NodeEs m = null;
       // m.scriviOutput(); // NullPointerException!
   }
  
}
