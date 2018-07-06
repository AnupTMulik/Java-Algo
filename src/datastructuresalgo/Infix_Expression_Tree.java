package datastructuresalgo;

//This is a java program to construct Expression Tree using Infix Expression

/**
 * This is a java program to construct an expression tree using infix expression and perform the 
 * infix, prefix and postfix traversal of the expression tree. The leaves of a binary expression 
 * tree are operands, such as constants or variable names, and the other ExpTreeNodes contain operators. 
 * These particular trees happen to be binary, because all of the operations are binary, and 
 * although this is the simplest case, it is possible for ExpTreeNodes to have more than two children. 
 * It is also possible for a ExpTreeNode to have only one child, as is the case with the unary minus 
 * operator. An expression tree, T, can be evaluated by applying the operator at the root to the 
 * values obtained by recursively evaluating the left and right sub-trees.
*  Here is the source code of the Java Program to Construct an Expression Tree for an Infix Expression. The Java program is successfully compiled and run on a Windows system. The program output is also shown below
 * **/
import java.io.DataInputStream;
import java.io.IOException;

class ExpTreeNode {
	public char data;
	public ExpTreeNode leftChild;
	public ExpTreeNode rightChild;

	public ExpTreeNode(char x) {
		data = x;
	}

	public void displayExpTreeNode() {
		System.out.print(data);
	}
}

class Stack1 {
	private ExpTreeNode[] a;
	private int top, m;

	public Stack1(int max) {
		m = max;
		a = new ExpTreeNode[m];
		top = -1;
	}

	public void push(ExpTreeNode key) {
		a[++top] = key;
	}

	public ExpTreeNode pop() {
		return (a[top--]);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

class Stack2 {
	private char[] a;
	private int top, m;

	public Stack2(int max) {
		m = max;
		a = new char[m];
		top = -1;
	}

	public void push(char key) {
		a[++top] = key;
	}

	public char pop() {
		return (a[top--]);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

class Conversion {
	private Stack2 s;
	private String input;
	private String output = "";

	public Conversion(String str) {
		input = str;
		s = new Stack2(str.length());
	}

	public String inToPost() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '+':
			case '-':
				gotOperator(ch, 1);
				break;
			case '*':
			case '/':
				gotOperator(ch, 2);
				break;
			case '(':
				s.push(ch);
				break;
			case ')':
				gotParenthesis();
				break;
			default:
				output = output + ch;
			}
		}
		while (!s.isEmpty())
			output = output + s.pop();
		return output;
	}

	private void gotOperator(char opThis, int prec1) {
		while (!s.isEmpty()) {
			char opTop = s.pop();
			if (opTop == '(') {
				s.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					s.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		s.push(opThis);
	}

	private void gotParenthesis() {
		while (!s.isEmpty()) {
			char ch = s.pop();
			if (ch == '(')
				break;
			else
				output = output + ch;
		}
	}
}

class Tree {
	private ExpTreeNode root;

	public Tree() {
		root = null;
	}

	public void insert(String s) {
		Conversion c = new Conversion(s);
		s = c.inToPost();
		Stack1 stk = new Stack1(s.length());
		s = s + "#";
		System.out.print("\ns : " + s);
		int i = 0;
		char symbol = s.charAt(i);
		ExpTreeNode newExpTreeNode;
		while (symbol != '#') {
			if (symbol >= '0' && symbol <= '9' || symbol >= 'A' && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') {
				newExpTreeNode = new ExpTreeNode(symbol);
				System.out.print("\nOperand newExpTreeNode : " + newExpTreeNode.data);
				stk.push(newExpTreeNode);
			} else if (symbol == '+' || symbol == '-' || symbol == '/' || symbol == '*') {
				ExpTreeNode ptr1 = stk.pop();
				ExpTreeNode ptr2 = stk.pop();
				newExpTreeNode = new ExpTreeNode(symbol);
				newExpTreeNode.leftChild = ptr2;
				newExpTreeNode.rightChild = ptr1;
				System.out.print("\nOperator newExpTreeNode data : " + newExpTreeNode.data);
				System.out.print("\nnewExpTreeNode leftChild : " + newExpTreeNode.leftChild.data);
				System.out.print("\nnewExpTreeNode rightChild : " + newExpTreeNode.rightChild.data);
				stk.push(newExpTreeNode);
			}
			symbol = s.charAt(++i);
		}
		root = stk.pop();
	}

	public void traverse(int type) {
		switch (type) {
		case 1:
			System.out.print("\n\nPreorder Traversal:-    ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder Traversal:-     ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostorder Traversal:-   ");
			postOrder(root);
			break;
		default:
			System.out.println("\nInvalid Choice");
		}
	}

	private void preOrder(ExpTreeNode localRoot) {
		if (localRoot != null) {
			localRoot.displayExpTreeNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(ExpTreeNode localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			localRoot.displayExpTreeNode();
			inOrder(localRoot.rightChild);
		}
	}

	private void postOrder(ExpTreeNode localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.displayExpTreeNode();
		}
	}
}

public class Infix_Expression_Tree {
	public static void main(String args[]) throws IOException {
		String ch = "y";
		DataInputStream inp = new DataInputStream(System.in);
		while (ch.equals("y")) {
			Tree t1 = new Tree();
			System.out.println("\nEnter the Expression");
			String a = inp.readLine();
			t1.insert(a);
			t1.traverse(1);
			System.out.println("");
			t1.traverse(2);
			System.out.println("");
			t1.traverse(3);
			System.out.println("");
			System.out.print("\nEnter y to continue ");
			ch = inp.readLine();
		}
	}
}
