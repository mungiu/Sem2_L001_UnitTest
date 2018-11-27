package Stacks;

/**
 * StackADT defines the interface to a stack collection - the abstract data
 * type: Stack. The Stack should allow duplicate elements and could allow
 * <code>null</code> elements.
 *
 * @author Steffen Vissing Andersen
 * @version 1.3, 9/2/2017
 * @version (Version 1.0, 8/12/2008 by Lewis and Chase)
 * @param <T>
 *           the data type of elements in the collection
 */
public interface StackADT<T>
{
   /**
    * Adds one element to the top of this stack.
    * 
    * @param element
    *           the element to be pushed to this stack
    * @exception IllegalStateException
    *               if the element cannot be added i.e. if the stack is full
    * @exception IllegalArgumentException
    *               if there is a mismatch in the input, e.g. if a
    *               <code>null</code> element is not allowed
    */
   public void push(T element);

   /**
    * Removes and returns the top element from this stack.
    * 
    * @return a reference to the element removed from the top of the stack
    * @exception IllegalStateException
    *               if the stack is empty
    */
   public T pop();

   /**
    * Returns without removing the top element of this stack.
    * 
    * @exception IllegalStateException
    *               if the stack is empty
    * @return a reference to the element at the top of the stack
    */
   public T peek();

   /**
    * The index of the first occurrence of the element specified, i.e. the
    * number of elements to pop until the next one is the element specified. If
    * the element is not in the stack then -1 is returned.
    * 
    * @param element
    *           the element to be found
    * @return the number of elements to pop until the next one is the element
    *         specified. If the element is not in the stack then -1 is returned.
    */
   public int indexOf(T element);

   /**
    * Returns <code>true</code> if this stack contains no elements.
    * 
    * @return boolean whether or not this stack is empty
    */
   public boolean isEmpty();

   /**
    * Returns <code>true</code> if this stack is full.
    * 
    * @return boolean whether or not this stack is full
    */
   public boolean isFull();

   /**
    * Returns the number of elements in this stack.
    * 
    * @return the number of elements in this stack
    */
   public int size();
}
