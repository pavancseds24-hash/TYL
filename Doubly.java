public class Doubly {
    class Node{
        Node prev;
        int val;
        Node next;
        Node(int d){
            this.prev = null;
            this.val = d;
            this.next = null;
        }
    }
    Node head = null;
    void addf(int d){
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

    void addl(int d){
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

    void addb(int d,int pos){
        Node n = new Node(d);
        if(pos < 1){
            System.out.println("Invalid POS!!");
            return;
        }
        if(pos == 1){
            addf(d);
        }
        else{
            Node temp = head;
            for(int i=1;i<pos-1 && temp != null; i++){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Invalid POS!!");
                return;
            }
            n.next = temp.next;
            n.prev = temp;
            if(temp.next != null){
                temp.next.prev = n;
            }
            temp.next = n;
        }
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
        d.addl(30);
        d.addb(20, 2);
        d.display();
        d.delb(2);
        d.delf();
        d.dell();
        d.display();
    }
}
