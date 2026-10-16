
class Singly{
    class Node{
        Node next;
        Object val;
        Node(Object d){
            this.val = d;
            this.next = null;
        }
    }
    Node head = null;

    void addf(Object d){
        Node n = new Node(d);
        if(head == null){
            head = n;
        }
        else{
            n.next = head;
            head = n;
        }
    }

    void addl(Object d){
        Node n = new Node(d);
        if(head == null){
            head = n;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    void addb(Object d, int pos) {
        if (pos < 1) {
            System.out.println("Invalid Position!!");
            return;
        }
        if (pos == 1) {
            addf(d);
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Pos Not Found!!");
            return;
        }
        Node n = new Node(d);
        n.next = temp.next;
        temp.next = n;
    }

    void delf(){
        if(head == null){
            System.out.println("No elements in Linked List!!");
            return;
        }
        head = head.next;
    }

    void dell(){
        if(head == null){
            System.out.println("No elements in Linked List!!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        Node prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    void delb(int pos) {
        if (head == null) {
            System.out.println("No elements in Linked List!!");
            return;
        }
        if (pos < 1) {
            System.out.println("Invalid Position!!");
            return;
        }
        if (pos == 1) {
            delf();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Pos Not Found!!");
            return;
        }
        temp.next = temp.next.next;
    }

    int length(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    void display(){
        if(head == null){
            System.out.println("LL is Empty!!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Singly s = new Singly();
        s.display();
        s.addf(10);
        s.addl("Hello");
        s.addb(20.5, 2);
        s.addl(true);
        s.display();
        System.out.println("Length: " + s.length());
        s.delb(2);
        s.display();
        s.delf();
        s.display();
        s.dell();
        s.display();
        System.out.println("Length: " + s.length());
    }
}
