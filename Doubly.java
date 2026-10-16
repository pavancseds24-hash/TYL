
public class Doubly {
    class Node{
        Node prev;
        Object val;
        Node next;
        Node(Object d){
            this.prev = null;
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
            head.prev = n;
            head = n;
        }
    }

    void addl(Object d){
        Node n = new Node(d);
        if(head == null){
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
    }

    void addb(Object d,int pos){
        if(pos < 1){
            System.out.println("Invalid POS!!");
            return;
        }
        if(pos == 1){
            addf(d);
            return;
        }
        Node temp = head;
        for(int i=1;i<pos-1 && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Invalid POS!!");
            return;
        }
        Node n = new Node(d);
        n.next = temp.next;
        n.prev = temp;
        if(temp.next != null){
            temp.next.prev = n;
        }
        temp.next = n;
    }

    void delf(){
        if(head == null){
            System.out.println("LL is empty!!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        head.next.prev = null;
        head = head.next;
    }

    void dell(){
        if(head == null){
            System.out.println("LL is empty!!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
    }

    void delb(int pos){
        if(pos < 1){
            System.out.println("Invalid POS!!");
            return;
        }
        if(head == null){
            System.out.println("LL is empty!!");
            return;
        }
        if(pos == 1){
            delf();
            return;
        }
        Node temp = head;
        for(int i = 1; i < pos && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Invalid POS!!");
            return;
        }
        temp.prev.next = temp.next;
        if(temp.next != null){
            temp.next.prev = temp.prev;
        }
        temp.prev = null;
        temp.next = null;
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
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Doubly d = new Doubly();
        d.display();
        d.addf(10);
        d.addl("Hello");
        d.addb(20.5, 2);
        d.addl(true);
        d.display();
        System.out.println("Length: " + d.length());
        d.delb(2);
        d.display();
        d.delf();
        d.dell();
        d.display();
        System.out.println("Length: " + d.length());
    }
}
