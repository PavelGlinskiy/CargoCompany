package train;

public class LinkList<E> {
    ListElement head = new ListElement();
    private int id;

    public LinkList(int id) {
        this.id = id;
    }

    public void insertHead(E val){
        ListElement element = new ListElement(val);
        if(head.next != null){
            element.next = head.next;
        }
        head.next = element;
    }

    public void insertTail(E val){
        ListElement element = new ListElement(val);
        ListElement walkPointer = head;
        while(walkPointer.next != null){
            walkPointer = walkPointer.next;
        }
        walkPointer.next = element;
    }

    public void insert(int pos, E val){
        int index = 0;
        if(pos >= 0 && pos <= this.getLength()){
            ListElement walkPointer = head;
            while(index != pos){
                walkPointer = walkPointer.next;
                index++;
            }
            ListElement element = new ListElement(val);
            element.next = walkPointer.next;
            walkPointer.next = element;
        }
    }

    public boolean delete(ListElement element){
        if(element == null || element.next == null){
            return false;
        }
        element = element.next;
        return true;
    }

    public int getLength(){
        int length=0;
        ListElement walkPointer=head;
        while(walkPointer.next!=null){
            walkPointer=walkPointer.next;
            length++;
        }
        return length;
    }

    public void print() {
        ListElement element = head;
        while(element.next != null){
            element = element.next;
            System.out.print(element.data.toString().replace("["," ")
                    .replace("]","")
                    .replace("{","")
                    .replace("}","") + " \n");
        }
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
