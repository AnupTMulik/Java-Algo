package datastructuresalgo;

public class SinglyLinkedListImpl<T> {

	private Node<T> head;
	private Node<T> tail;
	int listSize = 0;

	/**
	 * @param element
	 */
	public void add(T element) {
		Node<T> nd = new Node<T>();
		nd.setValue(element);
		System.out.println("Adding: " + element);
		/** check if the list is empty **/
		if (head == null) {
			/**
			 * Since there is only one element, both head and tail points to the
			 * same object.
			 **/
			head = nd;
			tail = nd;
		} else {
			/** set current tail next link to new node **/
			tail.setNextRef(nd);
			/** set tail as newly created node **/
			tail = nd;
		}
		listSize++;
	}

	/**
	 * @param element
	 * @param after
	 */
	public void addAfter(T element, T after) {
		Node<T> tmpHead = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (tmpHead != null) {
			if (tmpHead.compareTo(after) == 0) {
				/** found the target node, add after this node **/
				refNode = tmpHead;
				break;
			}
			tmpHead = tmpHead.getNextRef();
		}

		if (refNode != null) {
			/** add element after the target node **/
			Node<T> nd = new Node<T>();
			nd.setValue(element);
			nd.setNextRef(tmpHead.getNextRef());
			if (tmpHead == tail) {
				tail = nd;
			}
			tmpHead.setNextRef(nd);
			listSize++;
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	/**
	 * @param element
	 * @param after
	 */
	public void addAtPosition(T element, int indexPos) {

		Node<T> tmpHead = head;
		Node<T> refNode = null;

		System.out.println("\nTraversing to node at indexPos = " + indexPos);

		int i = 0;
		while (tmpHead != null) {
			if (i == indexPos - 1) {
				/** Found the target indexPos-1 node, add after this node **/
				refNode = tmpHead;
				break;
			}
			tmpHead = tmpHead.getNextRef();
			i++;
		}

		if (refNode != null) {
			/** add element after the target node **/
			Node<T> nd = new Node<T>();
			nd.setValue(element);
			nd.setNextRef(tmpHead.getNextRef());
			if (tmpHead == tail) {
				tail = nd;
			}
			tmpHead.setNextRef(nd);
			listSize++;
		} else {
			System.out.println("\nUnable to find the given index " + +indexPos);
			System.out.println("Actual listSize = " + listSize);
		}

	}

	/**
	 * 
	 */
	public void deleteFront() {
		if (head == null) {
			System.out.println("Underflow...");
		}
		Node<T> tmpHead = head;
		head = tmpHead.getNextRef();
		if (head == null) {
			tail = null;
		}
		listSize--;
		System.out.println("Deleted: " + tmpHead.getValue());
	}

	/**
	 * @param after
	 */
	public void deleteAfter(T after) {
		Node<T> tmpHead = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");

		/**
		 * Traverse till given element
		 */
		while (tmpHead != null) {
			if (tmpHead.compareTo(after) == 0) {
				/** found the target node, add after this node **/
				refNode = tmpHead;
				break;
			}
			tmpHead = tmpHead.getNextRef();
		}

		if (refNode != null) {
			tmpHead = refNode.getNextRef();
			refNode.setNextRef(tmpHead.getNextRef());
			if (refNode.getNextRef() == null) {
				tail = refNode;
			}
			System.out.println("Deleted: " + tmpHead.getValue());
			listSize--;
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	/**
	 * @param after
	 */
	public void deleteAtPosition(int indexPos) {
		Node<T> tmpHead = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");

		/**
		 * Traverse till given element
		 */
		int i = 0;
		while (tmpHead != null) {
			if (i == indexPos - 1) {
				/** Found the target indexPos-1 node, add after this node **/
				refNode = tmpHead;
				break;
			}
			tmpHead = tmpHead.getNextRef();
			i++;
		}

		if (refNode != null) {
			tmpHead = refNode.getNextRef();
			refNode.setNextRef(tmpHead.getNextRef());
			if (refNode.getNextRef() == null) {
				tail = refNode;
			}
			System.out.println("Deleted: " + tmpHead.getValue());
			listSize--;
		} else {
			System.out.println("\nUnable to find the given index " + +indexPos);
			System.out.println("Actual listSize = " + listSize);
		}

	}

	/**
	 * 
	 */
	public void traverse() {
		Node<T> tmpHead = head;
		while (tmpHead != null) {
			System.out.println(tmpHead.getValue());
			tmpHead = tmpHead.getNextRef();
		}
	}

	public static void main(String a[]) {
		SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		sl.add(154);
		sl.add(289);
		sl.add(354);
		sl.add(489);
		sl.traverse();

		sl.addAtPosition(111, 3);
		sl.traverse();

		sl.deleteAtPosition(3);
		sl.traverse();

		// sl.addAfter(76, 54);
		// sl.deleteFront();
		// sl.deleteAfter(76);
		// sl.traverse();

	}
}

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
