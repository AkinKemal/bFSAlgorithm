public class QueueNode {

    private int number;
    private int distance;
    private boolean bool;
    private QueueNode next;

    public QueueNode(int number) {
        this.setNumber(number);
        setDistance(0);
        setBool(false);
        setNext(null);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

}