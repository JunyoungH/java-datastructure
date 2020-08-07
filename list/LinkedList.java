package list;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E data; // 데이터
        private Node<E> nextNode; // 뒤쪽 포인터 (다음 노드 참조)

        public Node(E data, Node<E> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    private Node<E> headNode; // 머리 노드
    private Node<E> currentNode; // 현재 선택한 노드 (검색, 삭제에 사용)
    private Node<E> tailNode; // 꼬리 노드

    public LinkedList() {
        headNode = currentNode = null;
    }

    public E search(E object, Comparator<? super E> comparator) {
        Node<E> pointer = headNode;

        while(pointer != null) {
            if (comparator.compare(object, pointer.data) == 0) {
                currentNode = pointer;
                return pointer.data;
            }

            pointer = pointer.nextNode;
        }
        return null;
    }

    public E retrieve(int index) {
        Node <E> pointer = headNode;
        while (index >= 0 && pointer.nextNode != null) {
            if(index-- == 0) {
                currentNode = pointer;
                return pointer.data;
            }
            pointer = pointer.nextNode;
        }

        return null;
    }

    public void addFirst(E object) {
        Node<E> pointer = headNode; // 삽입 전의 머리 노드
        // 삽입 전의 머리 노드를 nextNode로 할당하여 노드 객체 생성
        headNode = currentNode = new Node<E>(object, pointer);
        if (tailNode == null) {
            tailNode = currentNode;
        }
    }

    public void addLast(E object) {
        //리스트가 비어 있으면 헤드에 삽입
        if (headNode == null) {
            addFirst(object);
        } else {
            tailNode.nextNode = currentNode = new Node<E>(object, null);
            tailNode = currentNode;

           /* Node<E> pointer = headNode;
            //리스트의 끝까지 검색
            while (pointer.nextNode != null) {
                pointer = pointer.nextNode;
            }
            //마지막 노드의 다음 노드로 추가
            pointer.nextNode = currentNode = new Node<E>(object, null);*/
        }
    }

    public void removeFirst() {
        if (headNode != null) {
            headNode = currentNode = headNode.nextNode;
            if (headNode == null) {
                tailNode = null;
            }
        }
    }

    public void removeLast() {
        if (headNode != null) {
            if (headNode.nextNode == null) {
                removeFirst();
            } else {
                Node<E> previousNode = headNode;
                Node<E> targetNode = headNode;

                while (targetNode.nextNode == null) {
                    previousNode = targetNode;
                    targetNode = targetNode.nextNode;
                }
                previousNode.nextNode = null;
                tailNode = currentNode = previousNode;
            }
        }
    }

    public void remove(Node target) {
        if (headNode != null) {
            if (target == headNode) {
                removeFirst();
            } else {
                Node<E> pointer = headNode;

                while (pointer.nextNode != target) {
                    pointer = pointer.nextNode;
                    if (pointer == null) {
                        return;
                    }
                }

                pointer.nextNode = target.nextNode;
                currentNode = pointer;
            }
        }
    }

    public void removeCurrentNode() {
        remove(currentNode);
    }

    public void purge(Comparator<? super E> c) {
        Node<E> pointer = headNode;

        while (pointer != null) {
            int count = 0;
            Node<E> nextPointer;
            Node<E> prevPointer = pointer;

            while (prevPointer.nextNode != null) {
                nextPointer = prevPointer.nextNode;

                if (c.compare(pointer.data, nextPointer.data) == 0) {
                    prevPointer.nextNode = nextPointer.nextNode; // 다음 노드가 중복 되면, prevPoint = prevePoint.nextNode.nextNode;
                    count++;
                } else {
                    prevPointer = nextPointer;
                }
            }

            if (count == 0) { // 중복된 노드가 없음. 다음 노드를 검색
                pointer = pointer.nextNode;
            } else {
                Node<E> temp = pointer;
                remove(pointer);
                pointer = temp.nextNode;
            }
        }
        currentNode = headNode;
    }

    public void clear() {
        while (headNode != null) {
            removeFirst();
        }
        currentNode = null;
    }

    public boolean next() {
        if(currentNode == null || currentNode.nextNode == null) {
            return false;
        }

        currentNode = currentNode.nextNode;
        return  true;
    }

    public void printCurrentNode() {
        if (currentNode == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(currentNode.data);
        }
    }

    public void dump() {
        Node<E> pointer = headNode;

        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.nextNode;
        }
    }

}
