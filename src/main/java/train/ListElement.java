package train;

public class ListElement<E> {
    E data;
    ListElement next=null;

    public ListElement(E data){
        this.data=data;
    }
    public ListElement(){}
}
