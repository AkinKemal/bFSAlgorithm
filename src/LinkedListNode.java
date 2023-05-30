public class LinkedListNode {
    private int from;
    private int to;
    private LinkedListNode next;

    public LinkedListNode(int from, int to) {
        this.setFrom(from);
        this.setTo(to);
        setNext(null);
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

}