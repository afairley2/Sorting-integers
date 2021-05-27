using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedList
{
    class SortedIntegerList
    {
        /// <summary>
        /// private inner class 
        /// Nodes will not be accesible outside of the class LinkedList
        /// </summary>
        private class Node
        {
         //attributes with public properties
            public int value { get; set; }
            public Node next { get; set; }

            public Node(int v)
            {
                value = v;
                next = null;
            }

           

            public bool insert(Node nNode)
            {
                bool success = false;
                if (next == null)
                {
                    next = nNode;
                    success = true;
                }
                else if (nNode.value.CompareTo (next.value)==0)
                {
                    //insert here
                    success = false;
                }
                else if (nNode.value.CompareTo(next.value) < 0)
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

            public bool remove(int value)
            {
                bool success = false;
                if (next == null)
                {
                    //end of list so set to false
                    success = false;
                }
                else if (next.value.CompareTo(value)==0)
                {
                    //remove node
                    next = next.next;
                    success = true;
                }
                else if (next.value.CompareTo(value) > 0)
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
        public int Count { get { return count; } }
        

        public  SortedIntegerList()
        {
            count = 0;
            start = null;
        }

        public bool isEmpty()
        {
            return start==null;
        }
        

        public bool insert(int value)
        {
            bool success = false;
            Node nNode = new Node(value);
          
            if (start== null)
            {
                start = nNode;
                success = true;
            }
            else if (start.value.CompareTo(value) == 0)
            {             
                success = false;
            }
            else if (start.value.CompareTo(value)>0)
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
        public bool remove(int value)
        {
            bool success = false;
            
            if (start == null)
            {
                
                success = false;
            }
            else if (start.value.CompareTo(value) == 0)
            {
                start = start.next; 
                success = true;
            }
            else if (start.value.CompareTo(value) > 0)
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

        public override string ToString()
        {
            string strValues = "Count: " + Count + "\t";
            Node temp = start;
            while (temp!=null)
            {
                strValues = strValues + temp.value + ",";
                temp = temp.next;
            }
            return strValues;
        }
    }
}
