package datastructuresalgo;

/*
 *  Java Program to Implement Binary Search Tree
 */

import java.util.Scanner;

/* Class BSTNode */
class TreeNode {

	TreeNode left, right;

	int data;

	/* Constructor */
	public TreeNode() {
		left = null;
		right = null;
		data = 0;
	}

	/* Constructor */
	public TreeNode(int n) {
		left = null;
		right = null;
		data = n;
	}

	/* Function to set left node */
	public void setLeft(TreeNode n) {
		left = n;
	}

	/* Function to set right node */
	public void setRight(TreeNode n) {
		right = n;
	}

	/* Function to get left node */
	public TreeNode getLeft() {
		return left;
	}

	/* Function to get right node */
	public TreeNode getRight() {
		return right;
	}

	/* Function to set data to node */
	public void setData(int d) {
		data = d;
	}

	/* Function to get data from node */
	public int getData() {
		return data;
	}
}

/* Class BST */
class BinaryTree {
	private TreeNode root;

	/* Constructor */
	public BinaryTree() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private TreeNode insert(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data);
		} else {
			if (data <= node.getData()) {
				node.left = insert(node.left, data);
				System.out.println("node.left = " + node.left);
			} else {
				node.right = insert(node.right, data);
				System.out.println("node.right = " + node.right);
			}
		}
		return node;
	}
	
	public void preorder() {
		preorder(root);
	}

	/**
	 * @param r
	 */
	private void preorder(TreeNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	
}

/* Class BinarySearchTree */
public class BinarySearchTree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of BST */
		BinaryTree bst = new BinaryTree();
		System.out.println("Binary Search Tree Test\n");
		char ch;
		/* Perform tree operations */
		do {
			System.out.println("\nBinary Search Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. delete");
			System.out.println("3. search");
			System.out.println("4. count nodes");
			System.out.println("5. check empty");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				bst.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to delete");
				//bst.delete(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter integer element to search");
				//System.out.println("Search result : " + bst.search(scan.nextInt()));
				break;
			case 4:
				//System.out.println("Nodes = " + bst.countNodes());
				break;
			case 5:
				//System.out.println("Empty status = " + bst.isEmpty());
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display tree */
			System.out.print("\nPost order : ");
			//bst.postorder();
			System.out.print("\nPre order : ");
			bst.preorder();
			System.out.print("\nIn order : ");
			//bst.inorder();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
