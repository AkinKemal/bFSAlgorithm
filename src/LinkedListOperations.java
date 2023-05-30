public class LinkedListOperations {

    public LinkedListNode head;

    public LinkedListOperations() {
        head = null;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void add(int from, int to) {
        LinkedListNode newNode = new LinkedListNode(from, to);
        if (comparison(from, to)) {
            if (head == null) {
                head = newNode;
                head.setNext(null);
            } else {
                LinkedListNode walk = head;

                while (walk.getNext() != null) {
                    walk = walk.getNext();
                }

                walk.setNext(newNode);
                newNode.setNext(null);
            }
        }
    }

    private boolean comparison(int from, int to) {
        LinkedListNode walk = head;
        boolean control = true;
        while (walk != null) {

            if (walk.getFrom() == from && walk.getTo() == to) {
                control = false;
                break;
            }
            walk = walk.getNext();
        }
        return control;
    }

}