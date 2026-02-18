/**
 * Thrown when trying to push onto a full stack.
 */
class StackEmptyException extends Exception {
  public StackEmptyException(String message) {
    super(message);
  }
  public StackEmptyException() {
    super("The Stack is Empty");
  }
}
