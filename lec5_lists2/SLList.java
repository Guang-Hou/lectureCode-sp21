//package lists2;

/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
            // System.out.println(size);
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    private static void lectureQuestion() {
        SLList L = new SLList();
        IntNode n = new IntNode(5, null);
    }

    /**
     * Creates an empty SLList.
     */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] x) {
        sentinel = new IntNode(63, null);
        IntNode p = sentinel;
        for (int i : x) {
            p.next = new IntNode(i, null);
            p = p.next;
            size += 1;
        }
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /**
     * Returns the first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Delete the first element in the SLList.
     */
    public void deleteFirst() {
        //IntNode first = sentinel.next;
        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    /**
     * Adds x to the end of the list.
     */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }


    /**
     * Adds x to the end of the list. Square all previous elements.
     */
    public void addLastSquare(int x) {
        IntNode cur = sentinel;

        /* Advance p to the end of the list. */
        while (cur.next != null) {
            cur.next.next = new IntNode((int) Math.pow(cur.next.item, 2), cur.next.next);
            size += 1;
            cur = cur.next.next;
        }

        cur.next = new IntNode(x, null);
        size += 1;
    }


    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }


    /**
     * add adjacent nodes with same value into one node. The process applies to newly formed node.
     */
    public void addAdjacent() {
        IntNode left = sentinel.next;
        IntNode right = left.next;
        while (right != null) {
            if (left.item == right.item) {
                left.item *= 2;
                left.next = right.next;
                right = left.next;
                size -= 1;
            } else {
                left = left.next;
                right = right.next;
            }

        }
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
//        SLList L = new SLList();
//        L.addLast(20);
//        L.addFirst(10);
        int[] x = {1, 2};
        SLList L2 = new SLList(x);
        L2.addLastSquare(5);
        L2.addLastSquare(7);
        System.out.println(L2.size());
    }
}