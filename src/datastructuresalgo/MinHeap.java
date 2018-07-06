package datastructuresalgo;

public class MinHeap {
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void minHeapify(int pos) {
		System.out.println("\nminHeapify : " + pos);
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					System.out.println("1 leftChild : " + Heap[leftChild(pos)]);
					System.out.println("1 rightChild : " + Heap[leftChild(pos)]);
					swap(pos, leftChild(pos));
					System.out.println("2 leftChild : " + Heap[leftChild(pos)]);
					System.out.println("2 rightChild : " + Heap[leftChild(pos)]);
					minHeapify(leftChild(pos));
				} else {
					System.out.println("3 leftChild : " + Heap[leftChild(pos)]);
					System.out.println("3 rightChild : " + Heap[leftChild(pos)]);
					swap(pos, rightChild(pos));
					System.out.println("4 leftChild : " + Heap[leftChild(pos)]);
					System.out.println("4 rightChild : " + Heap[leftChild(pos)]);
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(int element) {
		Heap[++size] = element;
		int current = size;

		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		System.out.println("\nPRINTING HEAP ARRAY\n");
		for (int i = 1; i <= size; i++) {
			System.out.println(Heap[i]);
		}

		System.out.println("\nPRINTING HEAP PARENT NODES\n");
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}

	public static void main(String... arg) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(10);
		minHeap.print();
		minHeap.insert(84);
		minHeap.print();
		minHeap.insert(19);
		minHeap.print();
		minHeap.insert(6);
		minHeap.print();
		minHeap.insert(22);
		minHeap.print();
		minHeap.insert(5);
		minHeap.print();
		minHeap.insert(3);
		minHeap.print();
		minHeap.insert(17);
		minHeap.print();
		minHeap.insert(9);
		minHeap.minHeap();
		minHeap.print();

		System.out.println("\nThe Min val is " + minHeap.remove());
	}
}