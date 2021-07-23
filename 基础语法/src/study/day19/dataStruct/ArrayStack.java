package study.day19.dataStruct;

import org.hamcrest.internal.ArrayIterator;

import java.util.Iterator;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 用数组实现的栈结构
 * @date 2021/4/3 14:21
 */
public class ArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];//栈元素
    private int N = 0;//元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            System.out.println("数组为空");
            return null;
        }
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    //重置数组长度
    private void resize(int i) {
        Item[] temp = (Item[]) new Object[i];
        for (int j = 0; j < N; j++) {
            temp[j] = a[j];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new reArrayIterator();
    }

    private class reArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
