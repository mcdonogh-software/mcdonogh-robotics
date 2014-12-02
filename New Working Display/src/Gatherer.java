
import java.util.*;


public class Gatherer<T> implements List<T>{

    //fields
    private T[] items; //private array of object T
    private int nbrRef; //number of items in array
    
    //inner class for ListIterator and Iterator
    private class MyListIterator<T> implements ListIterator<T> {

        //fields
        private int currIndex; //value of current index
        
        //methods
        //args constructor set currIndex to param index
        public MyListIterator (int currIndex) {
            this.currIndex = currIndex;
        }
        
        //check to see if there is another reference at n+1
        @Override
        public boolean hasNext() {
            return currIndex < size(); //if less than size return true
        }

        //return reference at n moves index to n+1
        @Override
        public T next() throws NoSuchElementException{
            if(!hasNext()) //check if there is a value to return
                throw new NoSuchElementException(); //throw exception
            return (T) items[currIndex++]; //return reference and increments by 1
        }

        //check to see if there is another reference at n-1
        @Override
        public boolean hasPrevious() {
            return currIndex > 0; //if greater than 0 return true
        }

        //return reference at n moves index to n-1;
        @Override
        public T previous() throws NoSuchElementException{
            if(!hasPrevious()) //check if there is a value to return
                throw new NoSuchElementException(); //throw exception
            return (T) items[--currIndex]; //return reference and decrements by 1
        }

        // ignore methods below line
        
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    //methods
    //constructor with no arguments; inits items with a value of 4
    public Gatherer() {
        this(4);
        nbrRef = 0; //sets number of items to 0
    }
    
    //cunstuctor inits items with size of initSize
    public Gatherer(int initSize) {
        items = (T[])(new Object[initSize]);
        nbrRef = 0; //sets number of items to 0
    }
    
    //doubles array and copies old values into new array
    private void doubleArrayCopy() {
        T[] temp = (T[])(new Object[items.length]); //create temp array
        System.arraycopy(items, 0, temp, 0, items.length); //copy items to temp
        items = (T[])(new Object[items.length*2]); //create new doubled array
        System.arraycopy(temp, 0, items, 0, temp.length); //copy temp to items
    }
    
    //updates nbrRef to new number of items
    private void updateNbrRef() {
        int counter = 0;
        for(T temp: items) //loop through all values of items
            if(temp != null) //for every none null element add to counter
                counter++; 
        nbrRef = counter;
    }
    
    //returns number of elements in array
    @Override
    public int size() {
        return nbrRef;
    }

    //returns an iterator at starting at zero index
    @Override
    public Iterator iterator() {
        return new MyListIterator(0);
    }

    //inserts element to end of list
    @Override
    public boolean add(T e) {
        int temp = size(); //copy initial size into temp
        add (size(), e); //perform add at final index of size
        return temp != size(); //check temp against new size if != change occured
    }
    
    //insertes element at specified index
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size()+1)
            throw new IndexOutOfBoundsException();
        if(!contains(element)){ //if item not already there
            if (size() == items.length) //is size = length need more space
                doubleArrayCopy(); //double array
            for(int i = size();i > index;i--) //loop backwards through array
                    items[i] = items[i-1];
                    //set(i, items[i-1]); //set n to n-1
                items[index] = element;
                //set(index, element); //insert final element
                updateNbrRef(); //update nbrRef to new value
        }
    }
    
    //returns a ListIterator at zero index
    @Override
    public ListIterator listIterator() {
        return listIterator(0);
    }

    //returns ListIterator at index param
    @Override
    public ListIterator listIterator(int index) {
        return new MyListIterator(index);
    }

    //returns true if list is empty
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // iterate through items and return true if reference is found
    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1; //calls indexOf method which returns -1 if not found
    }

    //clears all references in items by creating new array of same length
    @Override
    public void clear() {
        items = (T[])(new Object[items.length]); //create new array of same length and init
        updateNbrRef();
    }

    //returns reference at specified index
    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return items[index];
    }

    //replaces element at index with element and returns previous element
    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException{
        T temp = get(index); //copy current element into temp
        items[index] = element; //set new value
        return temp; //return previous value
    }
    
    //removes element at index and collapses list
    @Override
    public T remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        T temp = items[index]; //temp of original value
        for(;index < size();index++){ //loop through from index to size
            items[index] = items[index+1];
            //set(index, items[index+1]); //set n to n+1
        }
        items[size()] = null; //null final value at size()
        updateNbrRef(); //update nbrRef
        return temp; //return previous value at index
    }

    //removes first instance of the object o
     @Override
    public boolean remove(Object o) {
        if(indexOf(o) == -1)
            return false;
        return !contains(remove(indexOf(o)));
    }
    
     //returns index of object; if none return -1
    @Override
    public int indexOf(Object o) {    
        for(int i = 0; i < size(); i++) //loop through array until size
            if(items[i] == o) //if reference at index = to object o return index
                return i; //stops array at first instance
        return -1; //else return -1
    }

    //returns index of last ocurrance of an object
    @Override
    public int lastIndexOf(Object o) {
        int index = -1; //init index to -1 value if not found
        for(int i = 0; i < size(); i++) //loop through array until size
            if(items[i] == o) //if reference at index = object o set index to i
                index = i;
        return index; //return index
    }

     //Ignore below line
    
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
    public static void main(String[] args) {
        
        List<String> myList = new Gatherer();
        myList.add("Steve");
        myList.add("Abhi");
        myList.add("Tanner");
        myList.add("Sam");
        myList.add("Prakash");
        
        for(String charlie: myList){
            System.out.println(charlie);
        }
                
        myList.add(4, "Ryan");
        
        for(String charlie: myList){
            System.out.println(charlie);
        }
        
        myList.remove(5);
        myList.remove("Q");
        System.out.println(myList.get(2));
        
        for(String charlie: myList)
            System.out.println(charlie);
        
    }
    
}
