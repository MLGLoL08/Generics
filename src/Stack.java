/**
 * A generic LIFO stack implementation based on an array (no collections).
 * Uses an Object array internally because generic arrays cannot be created in Java.
 *
 * @param <T> the element type of the stack
 */
public class Stack<T> {

    private Object[] data;
    private int size;

    /**
     * Creates a stack with default capacity (10).
     */
    public Stack() {
        this(10);
    }

    /**
     * Creates a stack with a specific capacity.
     *
     * @param capacity the maximum number of elements the stack can hold
     * @throws IllegalArgumentException if capacity is less than 1
     */
    public Stack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1.");
        }
        this.data = new Object[capacity];
        this.size = 0;
    }

    /**
     * Creates a stack with given internal array and size.
     * Useful for testing or restoring a stack state.
     *
     * @param data the internal array (will be used directly)
     * @param size the current size (number of valid elements from index 0..size-1)
     * @throws IllegalArgumentException if data is null or size is invalid
     */
    public Stack(Object[] data, int size) {
        if (data == null) {
            throw new IllegalArgumentException("Data array must not be null.");
        }
        if (size < 0 || size > data.length) {
            throw new IllegalArgumentException("Invalid size for given array.");
        }
        this.data = data;
        this.size = size;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param value the element to push
     * @throws StackFullException if the stack is full
     */
    public void push(T value) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("Stack is full. Cannot push new element.");
        }
        data[size] = value;
        size++;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the removed top element
     * @throws StackEmptyException if the stack is empty
     */
    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. Cannot pop.");
        }
        int topIndex = size - 1;

        T value = (T) data[topIndex];

        data[topIndex] = null;
        size--;
        return value;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element
     * @throws StackEmptyException if the stack is empty
     */
    public T peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. Cannot peek.");
        }
        int topIndex = size - 1;

        T value = (T) data[topIndex];

        return value;
    }

    /**
     * Lists all elements currently in the stack as a single string separated by ';'.
     * The order is from bottom (oldest) to top (newest).
     *
     * @return a semicolon-separated list of elements
     */
    public String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(';');
            sb.append(data[i]);
        }
        return sb.toString();
    }

    /**
     * @return the current number of elements in the stack
     */
    public int size() {
        return size;
    }

    /**
     * @return the maximum number of elements the stack can hold
     */
    public int capacity() {
        return data.length;
    }

    /**
     * @return true if the stack has no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return true if no more elements can be pushed
     */
    public boolean isFull() {
        return size == data.length;
    }
}
