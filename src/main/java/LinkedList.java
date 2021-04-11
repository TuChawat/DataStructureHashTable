public class LinkedList<K> {
    public INode head;
    public INode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public void insert(INode Node, INode newNode) {
        INode tempNode = Node.getNext();
        Node.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode pop() {
        INode tempNode = this.head;
        this.head = this.head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals((tail))) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    public static K search(K key) {
        INode tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                return key;
            }
            tempNode = tempNode.getNext();
        }
        return key;
    }

    public boolean serchAndInsertElement(K key, INode insertNode) {
        INode tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                insert(tempNode, insertNode);
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }

    public Integer size() {
        Integer size = 0;
        INode tempNode = this.head;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }

    public void searchAndDelete(K key) {
        INode tempNode = this.head;
        System.out.println("Linked List size before deleting element : " + size());
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                INode nextNode = tempNode.getNext();
                INode newNode = nextNode.getNext();
                if (nextNode != tail) {
                    tempNode.setNext(newNode);
                    System.out.println("Linked List size after deleting element : " + size());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "LinkedListNodes{" + head + "}";
    }
}
