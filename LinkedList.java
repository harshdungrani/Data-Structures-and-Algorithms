import java.util.*;

class LinkedList{
    class Node{
        int data;
        Node next;
        Node(int item){
            this.data=item;
            next=null;
        }
    }
    Node head;
     void addbeg(int data){
        Node new_node=new Node(data);
        new_node.next=head;
        head=new_node;
        return;
    }
	
	void addlast(int data){
        Node new_node=new Node(data);
        if(head==null){
            head=new Node(data);
            return;
        }
        Node last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=new_node;
        return;
    }
	
    void add(int pos,int data){
        Node new_node=new Node(data);
        Node temp=head;
        Node prev=head;
        int i=0;
        if(pos==0){
            addbeg(data);
            return;
        }
        while(i<pos && temp!=null && prev.next!=null){
            prev=temp;
            temp=temp.next;
            i++;
        }
        new_node.next=prev.next;
        prev.next=new_node;
        return ;
    }

    void delbeg(){
        Node temp=head;
        head=temp.next;
        return;
    }

    void delpos(int pos){
        if(head==null)
            return;
        Node curr=head;
        if(pos==0){
            delbeg();
            return;
        }
        for(int i=0;i<pos-1 && curr!=null;i++){
            curr=curr.next;
        }
        if(curr==null || curr.next==null)
            return;
        
        Node temp=curr.next.next;
        curr.next=temp;
        return;
    }

    void dellast(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return;
    }   
    
    void print(){
        Node temp=head;
        System.out.print("LinkedList: ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        LinkedList ll =new LinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n=sc.nextInt();
        System.out.println("Adding "+n+" elements at the start");
        while(n>0){
            int data=sc.nextInt();
            ll.addbeg(data);
            n--;
        }
        ll.print();
        
        int nn=1;
        while(nn==1){
		System.out.println("1.Add a node at beg");
        System.out.println("2.Add a node at a position");
        System.out.println("3.Add a node at last");
        System.out.println("4.Delete the node at beg");
        System.out.println("5.Delete the node at a position");
        System.out.println("6.Delete the last node");
		System.out.println("Operation to perform: ");
		int op=sc.nextInt();
        switch(op){
            case 1:
            System.out.print("Enter data to be added at beg: ");
            int data=sc.nextInt();
            ll.addbeg(data);
            ll.print();
            break;

            case 2:
            System.out.print("Position to insert new node: ");
            int pos=sc.nextInt();
            System.out.print("Data to be inserted in the node: ");
            int y=sc.nextInt();
            ll.add(pos,y);
            ll.print();
            break;

            case 3:
            System.out.print("Data to be inserted in the last node: ");
            data=sc.nextInt();
            ll.addlast(data);
            ll.print();
            break;

            case 4:
            ll.delbeg();
            ll.print();
            break;

            case 5:
            System.out.print("Enter the position you want to delete: ");
            int dpos=sc.nextInt();
            ll.delpos(dpos);
            ll.print();
            break;

            case 6:
            ll.dellast();
            ll.print();
            break;
			
			default:
			System.out.print("Error");
			break;
			
        }
        System.out.println("Enter 1 to perform further operations: ");
        nn=sc.nextInt();
    }
    }
}
