package list;

import java.util.Comparator;

public class ArrayLinkedList<E> {

    class  Node<E> {
        private E data;
        private int next;
        private int deleteNext; // 삭제된 데이터의 다음 노드

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] node;
    private int capacity;
    private int dataNumber;
    private int head;
    private int current;
    private int tail;
    private int deleted; // 마지막으로 삭제된 데이터의 포인터
    private static final int NULL = -1;

    public ArrayLinkedList(int capacity) {
        head = current = tail = dataNumber = deleted = NULL;
        try {
            node = new Node[capacity];
            for (int i = 0; i < capacity; i++) {
                node[i] = new Node<>();
            }
            capacity = capacity;
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구함
    private int getInsertIndex() {
        if (deleted == NULL) {
            if (dataNumber < capacity) {
                return ++dataNumber;
            } else {
                return NULL; // 용량이 넘침
            }
        } else { // 삭제 된 데이터가 있을 경우
            deleted = node[deleted].deleteNext;
            return deleted;
        }
    }

    // 삭제 할 데이터의 인덱스를 등록
    private void deleteIndex(int index) {
        if (deleted == NULL) {
            deleted = index;
            node[deleted].deleteNext = NULL;
        } else {
            int prevDeleted = deleted;
            deleted = index;
            node[deleted].deleteNext = prevDeleted;
        }
    }

   /* 꼬리가 NULL 일 경우
     public E search(E object, Comparator<? super E> c) {
        int pointer = head;

        while (pointer != NULL) {
            if (c.compare(object, node[pointer].data) == 0) {
                current = pointer;
                return node[pointer].data;
            }
            pointer = node[pointer].next;
        }
        return null;
    }*/

    public E search(E object, Comparator<? super E> c) {
        int pointer = head;
        while (head != NULL) {
            if(c.compare(object, node[pointer].data) == 0) {
                current = pointer;
                return node[pointer].data;
            }
            pointer = node[pointer].next;
            if (pointer == head) break;
        }

        return null;
    }

    public void addFirst(E object) {
        if (head == NULL) { // 리스트가 비어 있으면 head, current, tail, head.next 에 삽입
            int insertIndex = getInsertIndex();
            if (insertIndex != NULL) {
                head = current = tail = insertIndex;
                node[head].set(object, insertIndex);
            }
        } else {
            int pointer = head;
            int insertIndex = getInsertIndex();
            if (insertIndex != NULL) {
                head = current = insertIndex;
                node[head].set(object, pointer);
                node[tail].next = head; // 꼬리의 다음은 헤드
            }
        }
    }

   /* 꼬리가 NULL일 경우
      public void addLast(E object) {
        if (head == NULL) {
            addFirst(object);
        } else {
            int pointer = head;
            while (node[pointer].next != NULL) {
                pointer = node[pointer].next;
            }

            int insertIndex = getInsertIndex();
            if (insertIndex != NULL) {
                node[pointer].next = current = insertIndex;
                node[insertIndex].set(object, NULL);
            }
        }
    }*/

    public void addLast(E object) {
        if (head == NULL) {
            addFirst(object);
        } else {
            int insertIndex = getInsertIndex();
            if (insertIndex != NULL) {
                node[tail].next = current = insertIndex;
                tail = insertIndex;
                node[tail].set(object, head);
            }
        }
    }

    public void removeFirst() {
        if (head != NULL) {
            deleteIndex(head);
            if(head == tail) {
                head = current = tail = NULL;
            } else {
                head = current = node[head].next;
                node[tail].next = head;
            }
        }
    }

/*    꼬리가 NULL일 경우
      public void removeLast() {
        if (head != NULL) {
            if (node[head].next == NULL) {
                removeFirst();
            } else {
                int pointer = head;
                int prevPointer = head;

                while (node[pointer].next != NULL) {
                    prevPointer = pointer;
                    pointer = node[pointer].next;
                }

                node[prevPointer].next = NULL;
                deleteIndex(pointer);
                current = prevPointer;
            }
        }
    }*/

    public void removeLast() {
        if (head != NULL) {
            if (head == tail) {
                removeFirst();
            } else {
                int pointer = head;
                int prevPointer = head;

                while (node[pointer].next != tail) {
                    prevPointer = pointer;
                    pointer = node[pointer].next;
                }

                deleteIndex(tail);
                current = tail = prevPointer;
                node[tail].next = head;
            }
        }
    }

    public void remove(int target) {
        if (head != NULL) {
            if (target == head) {
                removeFirst();
            } else {
                int pointer = head;

                while (node[pointer].next != target) {
                    pointer = node[pointer].next;
                    if (pointer == NULL) {
                        return;
                    }
                }

                deleteIndex(target);
                node[pointer].next = node[target].next;
                current = pointer;
            }
        }
    }

    public void removeCurrentNode() {
        remove(current);
    }

    public void clear() {
        while (head != NULL) {
            removeFirst();
        }
        current = NULL;
    }

    public boolean next() {
        if (current == NULL || node[current].next == NULL) {
            return false;
        }

        current = node[current].next;
        return true;
    }

    public void printCurrentNode() {
        if (current == NULL) {
            System.out.println("선택 노드가 없습니다.");
        } else {
            System.out.println(node[current].data);
        }
    }

    public void dump() {
        int pointer = head;

        while (pointer != NULL) {
            System.out.println(node[pointer].data);
            pointer = node[pointer].next;
        }
    }
}
