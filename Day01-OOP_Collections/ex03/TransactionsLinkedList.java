import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{

    private class Node {
        Node        next;
        Node        prev;
        Transaction element;

        Node(Node prev, Node next, Transaction element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    Integer size;
    Node    first;
    Node    last;

    public TransactionsLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public void addTransaction(Transaction elementNew) {
        Node tmp;
        if (size == 0) {
            tmp = new Node(null, null, elementNew);
            first = tmp;
        } else {
            tmp = new Node(last, null, elementNew);
            last.next = tmp;
        }
        last = tmp;
        ++size;
    }

    @Override
    public void removeTransactionById(UUID id) {
        Node tmp = first;
        Integer flag = 0;

        while (tmp != null) {
            if (tmp.element.getIdentifier() == id) {
                if (tmp.prev != null) {
                    tmp.prev.next = tmp.next;
                } else {
                    first = tmp.next;
                }
                if (tmp.next != null) {
                    tmp.next.prev = tmp.prev;
                } else {
                    last = tmp.prev;
                }
                flag = 1;
                --size;
                break;
            }
            tmp = tmp.next;
        }
        if (flag == 0) {
            throw new TransactionNotFoundException("Transaction not found!");
        }

    }

    @Override
    public Transaction[] transformToArray() {
        Transaction[] arr = new Transaction[size];

        Node tmp = first;

        for (Integer i = 0; i < size && tmp != null; ++i) {
            arr[i] = new Transaction(tmp.element);
            tmp = tmp.next;
        }
        return arr;
    }
}
