package datastructures;

public class Heap {

	public static void maxHeapify(int node, int [] heap, int heapSize) {
		int lc = 2*node + 1;
		int rc = 2*node + 2;
		int greatest = node;
		
		if(lc < heapSize && heap[lc] > heap[node]) {
			greatest = lc;
		}
		if(rc < heapSize && heap[rc] > heap[greatest]) {
			greatest = rc;
		}
		if(greatest != node) {
			int temp = heap[node];
			heap[node] = heap[greatest];
			heap[greatest] = temp;
			
			maxHeapify(greatest, heap, heapSize);
		}
	}
	
	public static void buildHeap(int [] heap) {
		for(int i=heap.length-1; i>=0; i--) {
			maxHeapify(i, heap, heap.length);
		}
	}
	
	// heap sort
	// insert
	// remove
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] heap = {3, 10, 1, 15, 9, 17, 8, 6};
		buildHeap(heap);
		for(int i=0; i<heap.length; i++) {
			System.out.println(heap[i]);
		}
	}

}
