
public class Circular {
    class Node{
        Object val;
        Node next;
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
            n.next = head;
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            n.next = head;
            temp.next = n;
            head = n;
        }
    }

    void addl(Object d){
        Node n = new Node(d);
        if(head == null){
            head = n;
            n.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = n;
        n.next = head;
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
        if(head == null){
            System.out.println("Invalid POS!!");
            return;
        }
        Node temp = head;
        for(int i=1;i<pos-1 && temp.next != head; i++){
            temp = temp.next;
        }
        if(temp.next == head && pos > length()){
            System.out.println("Invalid POS!!");
            return;
        }
        Node n = new Node(d);
        n.next = temp.next;
        temp.next = n;
    }

    void delf(){
        if(head == null){
            System.out.println("LL is empty!!");
            return;
        }
        if(head.next == head){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    void dell(){
        if(head == null){
            System.out.println("LL is empty!!");
            return;
        }
        if(head.next == head){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        temp.next = head;
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
        for(int i=1;i<pos-1 && temp.next != head; i++){
            temp = temp.next;
        }
        if(temp.next == head){
            System.out.println("Invalid POS!!");
            return;
        }
        temp.next = temp.next.next;
    }

    int length(){
        if(head == null){
            return 0;
        }
        int count = 0;
        Node temp = head;
        do{
            count++;
            temp = temp.next;
        }while(temp != head);
        return count;
    }

    void display(){
        if(head == null){
            System.out.println("LL is Empty!!");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.val+" ");
            temp = temp.next;
        }while(temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Circular c = new Circular();
        c.display();
        c.addf(10);
        c.addl("Hello");
        c.addb(20.5, 2);
        c.addl(true);
        c.display();
        System.out.println("Length: " + c.length());
        c.delb(2);
        c.display();
        c.delf();
        c.display();
        c.dell();
        c.display();
        System.out.println("Length: " + c.length());
    }
}
