package tree;

import java.util.Comparator;

public class BinarySearchTree<K, V> {
    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void print() {
            System.out.println(value);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int compare(K keyA, K keyB) {
        return (comparator == null) ? ((Comparable<K>)keyA).compareTo(keyB)
                                    : comparator.compare(keyA, keyB);
    }

    public V search(K key) {
        Node<K, V> targetNode= root;

        while (true) {
            if (targetNode == null) {
                return null;
            }

            int condition = compare(key, targetNode.getKey());
            if (condition == 0) {
                return targetNode.getValue();
            } else if (condition < 0) {
                targetNode = targetNode.left;
            } else {
                targetNode = targetNode.right;
            }
        }
    }

    private void addNode(Node<K, V> node, K key, V value) {
        int condition = compare(key, node.getKey());
        if (condition == 0) {
            return;
        } else if (condition < 0) { // 삽입할 key 가 비교 상대 노드의 key 보다 작으면
            if (node.left == null) { // 왼쪽 자식 노드가 없는 경우 노드를 삽입
                node.left = new Node<>(key, value, null, null);
            } else {
                addNode(node.left, key, value); // 왼쪽 노드가 있는 경우, 선택한 노드를 왼쪽 노드로 옮김
            }
        } else {
            if (node.right == null) { // 삽입할 key 가 비교 상대 노드의 key 보다 크면
                node.right = new Node<>(key, value, null, null); // 오른쪽 자식 노드가 없는 경우 노드를 삽입
            } else {
                addNode(node.right, key, value); // 오른쪽 노드가 있는 경우, 선택한 노드를 오른쪽 노드로 옮김
            }
        }
    }

    public void add(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value, null, null);
        } else {
            addNode(root, key, value);
        }
    }

    /*
    * 1. 자식 노드가 없는 노드를 삭제하는 경우 : 해당 노드를 삭제
    * 2. 자식 노드가 1개인 노드를 삭제하는 경우 : 자식 노드를 해당 노드로 옮김
    * 3. 자식 노드가 2개인 노드를 삭제하는 경우우 : 서브 트리에서 키 값을 찾아 해당 노드로 옮긴 후, 기존 값을 삭제 (1, 2번 적용)
   * */
    public boolean remove(K key) {
       Node<K, V> targetNode = root;
       Node<K, V> parent = null;
       boolean isLeftChild = true;

       while (true) {
           if (targetNode == null) {
               return false;
           }

           // 삭제할 키를 검색
           int condition = compare(key, targetNode.getKey());
           if (condition == 0) {                    // 같으면 검색 성공
               break;
           } else {
               parent = targetNode;                 // 가지로 내려가기 전에 부모를 설정

               if (condition < 0) {                 // key가 더 작으면
                   isLeftChild = true;              // 왼쪽 자식으로 내려감
                   targetNode = targetNode.left;    // 왼쪽 서브 트리에서 검색
               } else {                             // key가 더 크면
                   isLeftChild = false;             // 오른쪽 자식으로 내려감
                   targetNode = targetNode.right;   // 오른쪽 서브 트리에서 검색
               }
           }
       }

       if (targetNode.left == null) {               // 해당 노드에 왼쪽 자식이 없을 때 ( 자식 노드가 1개 )
           if (targetNode == root) {                // 해당 노드가 루트일 경우
               root = targetNode.right;             // 해당 노드의 오른쪽 자식을 루트로 ( 해당 노드 삭제 )
           } else if (isLeftChild) {                // 해당 노드가 왼쪽 자식이면
               parent.left = targetNode.right;      // 부모의 왼쪽 노드를 해당 노드의 오른쪽 자식으로 ( 해당 노드 삭제 )
           } else {
               parent.right = targetNode.right;     // 부모의 오른쪽 노드를 해당 노드의 오른쪽 자식으로 ( 해당 노드 삭제 )
           }
       } else if (targetNode.right == null) {       // 해당 노드에 오른족 자식이 없을 때 ( 자식 노드가 1개 )
           if (targetNode == root) {
               root = targetNode.left;
           } else if (isLeftChild) {
               parent.left = targetNode.left;
           } else {
               parent.right = targetNode.left;
           }
       } else {                                     // 해당 노드의 자식이 2개 일 때
           parent = targetNode;
           Node<K, V> leftNode = targetNode.left;   // 해당 노드의 왼쪽 서브 트리에서 가장 큰 노드
           isLeftChild = true;

           while (leftNode.right != null) {         // 왼쪽 서브 트리에서 가장 큰 노드 검색 ( 오른쪽 노드 )
               parent = leftNode;                   // 찾은 노드의 부모를 설정
               leftNode = leftNode.right;           // 큰 값을 찾음
               isLeftChild = false;
           }

           targetNode.key = leftNode.key;           // 가장 큰 왼쪽 노드를 해당 노드의 위치로 옮긴
           targetNode.value = leftNode.value;

           if (isLeftChild) {                       // 옮긴 노드의 자식 노드를 기존의 위치로 옮김
               parent.left = leftNode.left;
           } else {
               parent.right = leftNode.left;
           }
       }

       return true;
    }

    /*private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }

        return getMinNode(node.left);
    }*/

    private Node getMinNode(Node<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public K getMinKey() {
        if (root == null) {
            return null;
        }
        return ((Node<K, V>)getMinNode(root)).getKey();
    }

/*    private Node getMaxNode(Node node) {
        if (node.right == null) {
            return node;
        }

        return getMaxNode(node.right);
    }*/

    private Node getMaxNode(Node<K, V> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public K getMaxKey() {
        if (root == null) {
            return null;
        }
        return ((Node<K, V>)getMaxNode(root)).getKey();
    }

    private void printSubTreeASC(Node node) {
        if (node != null) {
            printSubTreeASC(node.left);
            System.out.println(node.key + " " + node.value);
            printSubTreeASC(node.right);
        }
    }

    private void printSubTreeDESC(Node node) {
        if (node != null) {
            printSubTreeDESC(node.right);
            System.out.println(node.key + " " + node.value);
            printSubTreeDESC(node.left);
        }
    }

    public void printOrderByASC() {
        printSubTreeASC(root);
    }

    public void printOrderByDESC() {
        printSubTreeDESC(root);
    }
}
