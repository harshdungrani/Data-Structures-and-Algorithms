import java.util.*;
class BST {  
    public static class Node{  
        int data;  
        Node left;  
        Node right;  
  
        public Node(int data){  
            this.data = data;  
            this.left = null;  
            this.right = null;  
        }  
    }  
   
      public Node root;  
  
    public BST(){  
        root = null;  
    }  
	  
    public void insert(int data){  
        Node newNode = new Node(data);
        if(root == null){  
            root = newNode;  
            return;  
        }  
		else{  
            Node current = root, parent = null;  
            while(true){  
				parent = current;  
                if(data < current.data){  
                    current = current.left;  
					if(current == null){  
                        parent.left = newNode;  
                        return;  
                    }  
                }    
                else{  
                    current = current.right;  
                    if(current == null){  
                        parent.right = newNode;  
                        return;  
                    }  
                }  
            }  
        }  
    }  
 
	public void preorderTraversal(Node node){  
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
        }  
        else{  
			System.out.print(node.data + " ");
            if(node.left!= null)  
                preorderTraversal(node.left);  
            if(node.right!= null)  
                preorderTraversal(node.right);  
        }  
    } 
    public void inorderTraversal(Node node){    
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
        }  
        else{  
			if(node.left!= null)  
                inorderTraversal(node.left);  
            System.out.print(node.data + " ");  
            if(node.right!= null)  
                inorderTraversal(node.right);  
        } 
	}  
		
	public void postorderTraversal(Node node){   
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
        }  
        else{  
            if(node.left!= null)  
                postorderTraversal(node.left);  
            if(node.right!= null)  
                postorderTraversal(node.right);  
        	System.out.print(node.data + " ");
        }  
    }  
	  
    public static void main(String[] args){  
		BST bt = new BST();  
        Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of nodes to be added: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++){ 
			System.out.println("Enter the node value: ");
			int value = sc.nextInt();
			bt.insert(value);  
		}
		System.out.println("Binary search tree preorder traversal:");  
        bt.preorderTraversal(bt.root);
        System.out.println("\nBinary search tree inorder traversal:");  
        bt.inorderTraversal(bt.root);  
		System.out.println("\nBinary search tree postorder traversal:");  
        bt.postorderTraversal(bt.root);
		System.out.println();
    }  
}  