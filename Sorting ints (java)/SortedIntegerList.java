
public class SortedIntegerList 
{
	 /// <summary>
    /// private inner class 
    /// Nodes will not be accesible outside of the class LinkedList
    /// </summary>
    private class Node
    {
     //attributes with public properties
        public Integer value; 
        public Node next; 

        public Node(Integer v)
        {
            value = v;
            next = null;
        }

       

        public boolean insert(Node nNode)
        {
        	boolean success = false;
            if (next == null)
            {
                next = nNode;
                success = true;
            }
            else if (nNode.value.compareTo (next.value)==0)
            {
                //insert here
                success = false;
            }
            else if (nNode.value.compareTo(next.value) < 0)
            {
                //insert here
                nNode.next = next;
                next = nNode;
                success = true;
            }
            else
            {
                success = next.insert(nNode);
            }
            return success;
        }

        public boolean remove(int value)
        {
            boolean success = false;
            if (next == null)
            {
                //end of list so set to false
                success = false;
            }
            else if (next.value.compareTo(value)==0)
            {
                //remove node
                next = next.next;
                success = true;
            }
            else if (next.value.compareTo(value) > 0)
            {
                //value not in list so set to false         
                success = false;
            }
            else
            {
                success = next.remove(value);
            }
            return success;
        }
    }

    
    private Node start;
    private int count;
    public int getCount() { return count;  }
    

    public  SortedIntegerList ()
    {
        count = 0;
        start = null;
    }

    public boolean isEmpty()
    {
        return start==null;
    }
    

    public boolean insert(int value)
    {
        boolean success = false;
        Node nNode = new Node(value);
      
        if (start== null)
        {
            start = nNode;
            success = true;
        }
        else if (start.value.compareTo(value) == 0)
        {             
            success = false;
        }
        else if (start.value.compareTo(value)>0)
        {
            nNode.next = start;
            start = nNode;
            success = true;
        }
        else
        {
            success = start.insert(nNode);
        }
        if (success)
            count++;
        return success;
    }
    public boolean remove(int value)
    {
        boolean success = false;
        
        if (start == null)
        {
            
            success = false;
        }
        else if (start.value.compareTo(value) == 0)
        {
            start = start.next; 
            success = true;
        }
        else if (start.value.compareTo(value) > 0)
        {
           
            success = false;
        }
        else
        {
            success = start.remove(value);
        }
        if (success)
            count--;
        return success;
    }

    public String toString()
    {
        String strValues = "Count: " + getCount() + "\t";
        Node temp = start;
        while (temp!=null)
        {
            strValues = strValues + temp.value + ",";
            temp = temp.next;
        }
        return strValues;
    }
}
