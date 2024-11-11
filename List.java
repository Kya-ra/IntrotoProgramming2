//
// ListNode implements a doubly linked list and should not be modified
//
class ListNode<E>
{ 
    E data; 
    ListNode<E> prevNode;
    ListNode<E> nextNode;

    public ListNode(E object)
    {
	data = object;
	prevNode = null;
	nextNode = null;
    }

    public ListNode(E object, ListNode<E> prevNode, ListNode<E> nextNode)
    {
        data = object;
	this.prevNode = prevNode;
        this.nextNode = nextNode;
    }
}

public class List<E>
{ 
    private String name;
    private ListNode<E> firstNode; 
    private ListNode<E> lastNode;

//
// You are not allowed to modify the constructors, isEmpty() and getData() methods
//
    public List()
    {
        this("list");
    }

    public List(String listName)
    {
        name = listName;
        firstNode = lastNode = null;
    }

    public boolean isEmpty()
    {
	return firstNode == null;
    }

    public E getData(int index)
    {
	int i = 1;
	ListNode<E> current = firstNode;

        if (isEmpty())
	    return (null);
	else
	{
	    while  (current.nextNode != null)
	    {
		current = current.nextNode;
		i++;
	    }

	    int j;
	    for (j = i; j > index; j--)
	        current = current.prevNode;
 
	    return (current.data);
	}
    }

//
// You are required to modify the following methods which work for a singly
// linked list, such that they are able to manipulate a doubly linked list.
// Remove the comments once you have updated the methods.
//


    public void insertAtFront(E insertItem)
    {
        if (isEmpty())
	        firstNode = lastNode = new ListNode<E>(insertItem);
	    else {
            firstNode.prevNode = new ListNode<E>(insertItem, firstNode, lastNode);
            ListNode<E> temp = firstNode;
            firstNode = firstNode.prevNode;
            firstNode.nextNode = temp;
            firstNode.prevNode = null;
        }
    }

    public void insertAtBack(E insertItem)
    {
        if (isEmpty())
	        firstNode = lastNode = new ListNode<E>(insertItem);
	    else {
            lastNode.nextNode = new ListNode<E>(insertItem);
            ListNode<E> temp = lastNode;
            lastNode = lastNode.nextNode;
            lastNode.prevNode = temp;
        }
    }

    public void print()
    {
	if (isEmpty())
	{
	    System.out.printf("Empty %s%n", name);
	    return;
	}

	System.out.printf("The %s in reverse order is: ", name);
	ListNode<E> current = lastNode;

	while (current != null)
	{
	    System.out.printf("%s ", current.data);
	    current = current.prevNode;
	}
	
	System.out.println();
    }


//
// You are not allowed to modify the main() method
//
    public static void main(String[] args)
    {
        List<Integer> list = new List<>();

        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(0);
        list.print();
        list.insertAtBack(1);
        list.print();
        list.insertAtBack(5);
        list.print();
    }
}
