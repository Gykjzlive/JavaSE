package study.day19.dataStruct;

import java.util.Iterator;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 链表实现栈
 * @date 2021/4/3 15:32
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;//栈顶
    private int N;//元素数量

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new stackIterator();
    }

    private class stackIterator implements Iterator<Item> {
        private int i = N;
        private Node current = first;

        @Override
        public void remove() {

        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
}
