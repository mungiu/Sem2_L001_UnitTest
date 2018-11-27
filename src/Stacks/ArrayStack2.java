package Stacks;

public class ArrayStack2<T> implements Stacks.StackADT<T>
{
   private static final int DEFAULT_CAPACITYS = 100;
   private int top;
   private T[] stack;

   public ArrayStack2()
   {
      this(DEFAULT_CAPACITYS);
   }

   public ArrayStack2(int capacity)
   {
      if (capacity < 1)
      {
         capacity = 1;
      }
       stack = (T[]) new Object[capacity];
      top = 0;
   }

   @Override
   public void push(T element)
   {
      if (top >= stack.length)
      {
         expandCapacity();
      }
      stack[top] = element;
      top++;
   }

   @Override
   public T pop() throws IllegalStateException
   {
      T temp = peek();
      stack[top - 1] = null;
      top--;
      return temp;
   }

   @Override
   public T peek() throws IllegalStateException
   {
      if (top == 0)
         throw new IllegalStateException();
      return stack[top - 1];
   }

   @Override
   public int indexOf(T element)
   {
      if (element != null)
      {
         for (int i = top - 1; i >= 0; i--)
         {
            if (element.equals(stack[i]))
            {
               return top - 1 - i;
            }
         }
      }
      else
      {
         for (int i = top - 1; i >= 0; i--)
         {
            if (null == stack[i])
            {
               return top - 1 - i;
            }
         }
      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      return top == 0;
   }

   // ERROR:
   @Override
   public boolean isFull()
   {
      return false; 
   }

   @Override
   public int size()
   {
      return top;
   }

   @Override
   public String toString()
   {
      String str = "{";
      for (int i = top - 1; i >= 0; i--)
      {
         str += stack[i].toString();
         if (i > 0)
         {
            str += ", ";
         }
      }
      str += "}";
      return str;
   }

   private void expandCapacity()
   {
      T[] temp = (T[]) new Object[stack.length * 2]; 
      for (int i = 0; i < stack.length; i++)
      {
         temp[i] = stack[i];
      }
      stack = temp;
   }

}