public class QueueOperations {

    public QueueNode front;
    public QueueNode rear;

    public QueueOperations() {
        front = null;
        rear = null;
    }

    public QueueNode getFront() {
        return front;
    }

    public void enQueue(int number) {
        QueueNode node = new QueueNode(number);
        if (front == null) {
            front = node;
        } else {
            QueueNode walk = front;

            while (walk.getNext() != null) {
                walk = walk.getNext();
            }

            walk.setNext(node);
        }
        rear = node;
    }

    public int deQueue() {
        if (!isEmpty()) {
            return -1;
        } else {
            int box = front.getNumber();
            front = front.getNext();
            return box;
        }
    }

    private boolean isEmpty() {
        return front != null;
    }

}