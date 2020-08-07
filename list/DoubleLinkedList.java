package list;

import java.util.Comparator;

public class DoubleLinkedList<E> {
    class Node<E> {
        E data;
        Node<E> prevNode;
        Node<E> nextNode;

        // 초기화
        Node() {
            data = null;
            prevNode = nextNode = this;
        }

        Node(E data, Node<E> prevNode, Node<E> nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    Node<E> headNode;
    Node<E> currentNode;

    // head, current, tail 에 더미 노드를 삽입
    public DoubleLinkedList() {
        headNode = currentNode = new Node<>();
    }

    public E search(E object, Comparator<? super E> comparator) {
        Node<E> pointer = headNode.nextNode; // head는 더미이므로, head의 다음부터 스캔

        while (pointer != headNode) {
            if (comparator.compare(object, pointer.data) == 0) {
                currentNode = pointer;
                return currentNode.data;
            }
            pointer = pointer.nextNode;
        }

        return null;
    }


    public void add(E object) {
        Node<E> node = new Node<>(object, currentNode, currentNode.nextNode);

        // 새로운 노드를 기존의 current 다음, current 다음의 앞으로 삽입
        currentNode.nextNode = currentNode.nextNode.prevNode = node;
        currentNode = node;
    }

    public void addFirst(E object) {
        currentNode = headNode;
        add(object);
    }

    public void addLast(E object) {
        currentNode = headNode.prevNode;
        add(object);
    }

    public void removeFirst() {
        currentNode = headNode.nextNode;
        removeCurrentNode();
    }

    public void removeLast() {
        currentNode = headNode.prevNode;
        removeCurrentNode();
    }

    public void remove(Node<E> target) {
        Node<E> pointer = headNode;
        while (pointer.nextNode != headNode) {
            if (pointer == target) {
                currentNode = pointer;
                removeCurrentNode();
                break;
            }
            pointer = pointer.nextNode;
        }
    }

    public void removeCurrentNode() {
        if(!isEmpty()) {
            currentNode.prevNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.prevNode = currentNode.prevNode;
            currentNode = (headNode == currentNode.prevNode) ? headNode.nextNode : currentNode.prevNode;
        }
    }

    public void clear() {
        while (!isEmpty()) {
            removeCurrentNode();
        }
    }

    public boolean isEmpty() {
        return headNode == currentNode;
    }

    public boolean next() {
        if (currentNode.nextNode != headNode) {
            currentNode = currentNode.nextNode;
            return true;
        }
        return false;
    }

    public boolean prev() {
        if (currentNode.prevNode != headNode) {
            currentNode = currentNode.prevNode;
            return true;
        }
        return false;
    }

    public void printCurrentNode() {
        if (isEmpty()) {
            System.out.println("선택 된 노드가 없습니다.");
        } else {
            System.out.println(currentNode.data);
        }
    }

    public void dump() {
        Node<E> pointer = headNode.nextNode;
        while (pointer != headNode) {
            System.out.println(pointer.data);
            pointer = pointer.nextNode;
        }
    }
}
