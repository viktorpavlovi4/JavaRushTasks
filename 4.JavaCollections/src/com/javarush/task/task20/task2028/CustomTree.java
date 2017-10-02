package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(4)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }

    Entry<String> root = new Entry<>("root");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
//        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
//        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public boolean add(String s) {
        if (s == null) return false;
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            /*нужно брать элемент из очереди, проверять его потомков, и если какого-то нет, то ставить на его место новый элемент. Если все потомки есть, то добавлять их в очередь и делать тоже самое с ними*/
            Entry<String> entry = queue.poll();
            entry.checkChildren();
            if (entry.availableToAddLeftChildren) {
                Entry<String> entry1 = new Entry<>(s);
                entry.leftChild = entry1;
                entry1.parent = entry;
                return false;
            }
            else if (entry.availableToAddRightChildren) {
                Entry<String> entry1 = new Entry<>(s);
                entry.rightChild = entry1;
                entry1.parent = entry;
                return false;
            }
            else {
                queue.add(entry.leftChild);
                queue.add(entry.rightChild);
            }
        }
        return false;
    }

    @Override
    public int size() {
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        if (root.leftChild != null) queue.offer(root.leftChild);
        if (root.rightChild != null) queue.offer(root.rightChild);
        int count = 0;
        while (!queue.isEmpty()) {
            //берём элемент из очереди, считаем его, потом добавляем в очередь существующих потомков, и всё по новой
            Entry<String> entry = queue.poll();
            count++;
            if (entry.leftChild != null)
                queue.add(entry.leftChild);
            if (entry.rightChild != null)
                queue.add(entry.rightChild);
        }
        return count;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;
        String s = (String) o;
        /*if (s.equals(root.elementName)) {
            root = null;
            return true;
        }*/
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            /*Удаление элемента похоже на добавление, надо проверять потомков у текущего элемента из очереди и обнулять потомска с искомым именем*/
            Entry<String> entry = queue.poll();
            if (entry.leftChild != null && s.equals(entry.leftChild.elementName)) {
                entry.leftChild = null;
                return false;
            }
            if (entry.rightChild != null && s.equals(entry.rightChild.elementName)) {
                entry.rightChild = null;
                return false;
            }
            else {
                queue.add(entry.leftChild);
                queue.add(entry.rightChild);
            }
        }
        return false;
    }

    public String getParent(String s) {
        if (root == null || s == null)
            return null;
        if (s.equals(root.elementName))
            return null;
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //тоже берём первый элемент с очереди, если это искомый элемент, то возвращаем имя его родителя, иначе проверяем его детей, и если они есть, то добавляем их в очередь. И всё по новой
            Entry<String> entry = queue.poll();
            if (s.equals(entry.elementName))
                return entry.parent.elementName;
            else {
                if (entry.leftChild != null)
                    queue.add(entry.leftChild);
                if (entry.rightChild != null)
                    queue.add(entry.rightChild);
            }
        }
        return null;
    }

    @Override
    public String get(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
