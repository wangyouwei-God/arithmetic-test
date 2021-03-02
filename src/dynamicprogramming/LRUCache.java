package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class DLinkedListNode {
        int key;
        int val;
        DLinkedListNode pre;
        DLinkedListNode next;
        public DLinkedListNode() {
        }
        public DLinkedListNode( int key, int val ) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer,DLinkedListNode> map = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkedListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedListNode();
        this.tail = new DLinkedListNode();
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if ( !map.containsKey( key ) ) {
            return -1;
        } else {
            DLinkedListNode node = map.get( key );
            moToFresh( node);
            return node.val;
        }
    }

    private void moToFresh( DLinkedListNode node ) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addTail( node);
    }

    public void put(int key, int val) {
        if ( map.containsKey(key) ) {
            DLinkedListNode node = map.get( key );
            node.val = val;
            moToFresh( node);
            return ;
        }
        if ( size == capacity ) {
            removeHead();
            this.size--;
        }
        DLinkedListNode node = new DLinkedListNode( key, val );
        addTail( node);
        map.put( key, node);
        this.size++;
    }

    private void removeHead() {
        DLinkedListNode node = head.next;
        head.next.next.pre = head;
        head.next = head.next.next;
        map.remove( node.key );
    }

    private void addTail( DLinkedListNode node ) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
    }
}
