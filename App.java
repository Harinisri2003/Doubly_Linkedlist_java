import java.util.*;
class Doubly<T>{
    Node head;
    Node tail;
    class Node{
        T data;
        Node next;
        Node prev;
        Node(T v)
        {
            data=v;
            next=null;
            prev=null;
        }
    }
    Doubly(){
        head=null;
    }
    void insertionAtBeg(T v)
    {
         Node newnode=new Node(v);
          newnode.next=head;
        //   newnode.next=head.next;
         if(head==null)
         {
           tail=newnode;
         }
         else{
            head.prev=newnode;
         }
         head=newnode;
    }
    void display()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    void displayRev()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        Node temp=tail;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println();
    }
    void insrtAtPos(int pos,T val)
    {
        
        if(pos==0)
		{
			insertionAtBeg(val);
			return;
		}
         Node newnode=new Node(val);
         Node temp=head;
        for(int i=1;i<pos;i++)
        {
            temp=temp.next;
            if(temp==null) 
				throw new IndexOutOfBoundsException("Invalid Pos " + pos);
        }
        newnode.next=temp.next;
        if(temp==tail)
        {
            tail=newnode;
        }
        else
         temp.next.prev=newnode;
        temp.next=newnode;
        newnode.prev=temp;  
    }
    void deleteAtPos(int pos)
    {
        if(pos==0)
        {
            head=head.next;
            if(head==null)
            {
                tail=null;
            }
            else
            head.prev=null;
            return;
        }
        Node temp=head;
        Node prev=null;
        for(int i=1;i<=pos;i++)
        {
            prev=temp;
            temp=temp.next;
            if(temp==null)
            {
                throw new IndexOutOfBoundsException("invalid pos");
            }
        }
        prev.next=temp.next;
        if(temp.next==null)
          tail=prev;
        else
         temp.next.prev=prev;
       

    }
}
public class App {
    public static void main(String[] args) throws Exception {
        Doubly list=new Doubly();
        Scanner sc=new Scanner(System.in);
        int value;
        list.display();
        System.out.println("Enter n: ");
        do
        {
           value=sc.nextInt();
            if(value>0)
            {
                list.insertionAtBeg(value);;
            }
        }while(value>-1);
        list.display();
        System.out.println();
        list.displayRev();
        System.out.println("insert position: ");
        int pos=sc.nextInt();
        int v=sc.nextInt();
        list.insrtAtPos(pos,v);
         list.display();
         System.out.println("Enter pos to delete: ");
         pos=sc.nextInt();
         list.deleteAtPos(pos);
         list.display();
        list.displayRev();
    }
}
