/**
 * Thrown when trying to pop/peek from an empty stack.
 */
class StackFullException extends Exception {
    public StackFullException(String message) {
        super(message);
    }
    public StackFullException() {
        super("The Stack is full");
    }
}