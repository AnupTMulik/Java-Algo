package datastructuresalgo;

import java.util.Scanner;

public class CicularSinglyLinkedListImpl<T> {

	class Node<T> implements Comparable<T> {

		private T value;
		private Node<T> nextRef;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNextRef() {
			return nextRef;
		}

		public void setNextRef(Node<T> ref) {
			this.nextRef = ref;
		}

		@Override
		public int compareTo(T arg) {
			if (arg == this.value) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	private Node<T> head;
	private Node<T> tail;
	int listSize = 0;

	/**
	 * @param element
	 */
	public void addElement(T element) {
		Node<T> nd = new Node();
		nd.setValue(element);
		System.out.println("Adding: " + element);
		if (head == null) {
			/** For First Element head and tail will point to each other **/
			head = nd;
			tail = nd;
			tail.setNextRef(null);
		} else {
			tail.setNextRef(nd);
			tail = nd;
			/** Every time point tail ref to head for consecutive elements **/
			tail.setNextRef(head);
		}
		listSize++;
	}

	/**
	 * @param element
	 * @param indexPos
	 */
	public void addElementAtPosition(T element, int indexPos) {
		Node<T> tmpHead = head;
		Node<T> tmpTail = tail;
		Node<T> refNode = null;

		if (indexPos == 0) {
			if (head == null && tail == null) {
				/** First Fresh Element of List **/
				addElement(element);
			} else {
				/** Add Head Node **/
				Node<T> nd = new Node();
				nd.setValue(element);
				nd.setNextRef(tmpHead);
				head = nd;
				tmpTail.setNextRef(nd);
			}
			return;
		}

		int i = 0;
		while (true) {
			if (i == indexPos - 1) {
				/** Found the target indexPos-1 node, add after this node **/
				refNode = tmpHead;
				break;
			}
			tmpHead = tmpHead.getNextRef();
			i++;
		}

		if (refNode != null) {
			Node<T> nd = new Node();
			nd.setValue(element);
			nd.setNextRef(refNode.getNextRef());
			refNode.setNextRef(nd);
			if (refNode == tmpTail) {
				tail = refNode;
			}
			listSize++;
		} else {
			System.out.println("\nUnable to find the given index " + +indexPos);
			System.out.println("listSize = " + listSize);
		}

	}

	/**
	 * 
	 */
	public void deleteElement() {
		Node<T> tmpHead = head;
		Node<T> tmpTail = tail;
		Node<T> refNode = null;

		if (listSize == 0) {
			System.out.println("\nList is Empty");
			System.out.println("listSize = " + listSize);
			return;
		}
		
		while (true) {
			if (tmpHead.getNextRef() == tmpTail) {
				/** Found the target n-1 node, delete after this node **/
				refNode = tmpHead;
				System.out.println("refNode = : " + refNode.getValue());
				break;
			}
			tmpHead = tmpHead.getNextRef();
		}

		if (refNode != null) {
			if (refNode == head && refNode == tail) {
				/** Last Node Left **/
				refNode.setNextRef(null);
				System.out.println("Deleted: " + refNode.getValue());
				listSize--;
				head = null;
				tail = null;
			} else {
				tmpHead = refNode.getNextRef();
				refNode.setNextRef(tmpHead.getNextRef());
				if (tmpHead == tmpTail) {
					tail = refNode;
				}
				System.out.println("Deleted: " + tmpHead.getValue());
				listSize--;
			}
		} else {
			System.out.println("\nList is Empty");
			System.out.println("listSize = " + listSize);
		}

	}

	/**
	 * @param indexPos
	 */
	public void deleteElementAtPosition(int indexPos) {
		Node<T> tmpHead = head;
		Node<T> tmpTail = tail;
		Node<T> refNode = null;

		if (listSize == 0) {
			System.out.println("\nList is Empty");
			System.out.println("listSize = " + listSize);
			return;
		}
		
		if (indexPos == 0) {
			/** Delete Head Node **/
			tmpHead = tmpHead.getNextRef();
			tmpTail.setNextRef(head.getNextRef());
			head.setNextRef(null);
			System.out.println("Deleted: " + head.getValue());
			head = tmpHead;
			listSize--;
			return;
		}

		int i = 0;
		while (true) {
			if (i == indexPos - 1) {
				/** Found the target indexPos-1 node, delete after this node **/
				refNode = tmpHead;
				break;
			}
			tmpHead = tmpHead.getNextRef();
			i++;
		}

		if (refNode != null) {
			tmpHead = refNode.getNextRef();
			refNode.setNextRef(tmpHead.getNextRef());
			if (tmpHead == tmpTail) {
				tail = refNode;
			}
			System.out.println("Deleted: " + tmpHead.getValue());
			listSize--;
		} else {
			System.out.println("\nUnable to find the given index " + +indexPos);
			System.out.println("listSize = " + listSize);
		}

	}

	public void traverse() {
		Node<T> tmpHead = head;
		System.out.println("\n*****************Printing Linked List*****************");
		while (tmpHead != null) {
			System.out.println(tmpHead.getValue());
			tmpHead = tmpHead.getNextRef();
			if (tmpHead == head) {
				System.out.println(tmpHead.getValue());
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		CicularSinglyLinkedListImpl list = new CicularSinglyLinkedListImpl();
		System.out.println("Circular Singly Linked List Test\n");
		char ch;

		do {
			System.out.println("\nCircular Singly Linked List Operations\n");
			System.out.println("1. insert");
			System.out.println("2. insert at position(zero based)");
			System.out.println("3. delete");
			System.out.println("4. delete at position(zero based)");
			System.out.println("5. size\n");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("\nEnter element to insert");
				list.addElement(scan.nextInt());
				break;
			case 2:
				System.out.println("\nEnter index position(zero based) to insert");
				int insertIndex = Integer.valueOf(scan.next());
				if (insertIndex != 0 && insertIndex > (list.listSize - 1)) {
					System.out.println("Invalid insert index position : " + insertIndex);
					System.out.println("\nlistSize = " + list.listSize);
				} else {
					System.out.println("\nEnter element to insert");
					list.addElementAtPosition(Integer.valueOf(scan.next()), insertIndex);
				}
				break;
			case 3:
				list.deleteElement();
				break;
			case 4:
				System.out.println("\nEnter index position(zero based) to delete an Element");
				int deleteIndex = Integer.valueOf(scan.next());
				if (deleteIndex > list.listSize - 1) {
					System.out.println("Invalid delete index position : " + deleteIndex);
					System.out.println("\nlistSize = " + list.listSize);
				} else {
					list.deleteElementAtPosition(deleteIndex);
				}
				break;
			case 5:
				System.out.println("\nlistSize = " + list.listSize);
				break;
			default:
				System.out.println("\nWrong Entry \n ");
				break;
			}
			list.traverse();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

}
