import java.util.*;

class AVL{
	class Node{
	int key, height;
	Node left;  
    Node right; 

	Node(int data){
		key = data;
		height = 1;
	}
}
	Node root;

	int height(Node N) {
		if (N == null)
			return 0;

		return N.height;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left),height(y.right)) + 1;
		x.height = max(height(x.left),height(x.right)) + 1;

		return x;
	}

	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left),height(x.right)) + 1;
		y.height = max(height(y.left),height(y.right)) + 1;

		return y;
	}

	int getBalance(Node N) {
		if (N == null)
			return 0;
		return height(N.left)-height(N.right);
	}

	Node insert(Node node, int key) {
		if (node == null)
			return (new Node(key));
		if (key < node.key)
			node.left = insert(node.left,key);
		else if (key > node.key)
			node.right = insert(node.right,key);
		else 
			return node;
		
		node.height = 1 + max(height(node.left),height(node.right));
		int balance = getBalance(node);
		System.out.println("Balance Factor of "+node.key+" is "+balance);
		
		//Left Left Case
		if (balance > 1 && key < node.left.key){
			System.out.println("Left Left Rotation");
			return rightRotate(node);
		}
		// Right Right Case
		if (balance < -1 && key > node.right.key){
			System.out.println("Right Right Rotation");
			return leftRotate(node);
		}
		// Left Right Case
		if (balance > 1 && key > node.left.key){
			System.out.println("Left Right Rotation");
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key){
			System.out.println("Right Left Rotation");
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

    Node minValueNode(Node node)  
    {  
        Node current = node;  
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }
	
    Node delete(Node root, int key)  
    {  
        if (root == null)  
            return root;  
        if (key < root.key)  
            root.left = delete(root.left, key);  
        else if (key > root.key)  
            root.right = delete(root.right, key);  
        else{  
            if ((root.left == null) || (root.right == null)){  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
                if (temp == null){  
                    temp = root;  
                    root = null;  
                }  
                else  
                    root = temp; 
            } 
            else
            {  
                Node temp = minValueNode(root.right);  
                root.key = temp.key;  
                root.right = delete(root.right, temp.key);  
            }			
        }  
        if (root == null)  
            return root;  
        root.height = max(height(root.left), height(root.right)) + 1;  
        int balance = getBalance(root);  
		System.out.println("Balance Factor of "+root.key+" is "+balance);
        
		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0){
			System.out.println("Left Left Rotation");
            return rightRotate(root);  
		}
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0){  
			System.out.println("Right Right Rotation");
			return leftRotate(root);  
		}
        // Left Right Case  
        if (balance > 1 && getBalance(root.left) < 0){ 
			System.out.println("Left Right Rotation");
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0){  
            System.out.println("Right Left Rotation");
			root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
        return root;  
    } 	
	
	public void inorderTraversal(Node node){     
		if (node != null) {
            inorderTraversal(node.left);
			System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
	}

	public static void main(String[] args) {
		AVL tree = new AVL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes to be added: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++){ 
			System.out.println("Enter the node value: ");
			int value = sc.nextInt();
			tree.root = tree.insert(tree.root,value);  
		}
		System.out.println("Inorder traversal of AVL tree is: ");
		tree.inorderTraversal(tree.root);
		System.out.println();
		for(int i=0;i<4;i++){ 
			System.out.println("Enter the node to be deleted: ");
			int del = sc.nextInt();
			tree.root = tree.delete(tree.root,del);
			System.out.println("Inorder traversal of AVL tree after deleting "+del+" is: ");
			tree.inorderTraversal(tree.root);
			System.out.println("");
		}
	}
}

