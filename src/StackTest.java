/**
 * Test class for the generic Stack.
 * This class demonstrates the stack functionality using an Integer stack and a String stack.
 *
 * NOTE: This is a simple test runner using a main() method (no JUnit),
 * so it works everywhere without extra setup.
 */
public class StackTest {

    public static void main(String[] args) {

        // =========================
        // Test 1: Number stack (Integer)
        // =========================
        Stack<Integer> numberStack = new Stack<>(3);

        try {
            // Push some numbers onto the stack
            numberStack.push(10);
            numberStack.push(20);
            numberStack.push(30);

            // List should show elements from bottom to top
            // Expected: "10;20;30"
            System.out.println("Number list: " + numberStack.list());

            // Peek should return the top element without removing it
            // Expected: 30, stack unchanged
            System.out.println("Number peek: " + numberStack.peek());
            System.out.println("Number list after peek: " + numberStack.list());

            // Pop should return the top element and remove it
            // Expected pop: 30, stack becomes "10;20"
            System.out.println("Number pop: " + numberStack.pop());
            System.out.println("Number list after pop: " + numberStack.list());

            // Now the stack is not full anymore, pushing should work again
            numberStack.push(99);
            // Expected: "10;20;99"
            System.out.println("Number list after pushing 99: " + numberStack.list());

            // Force a StackFullException by pushing into a full stack
            // Stack capacity is 3, currently it has 3 elements
            System.out.println("Trying to push into a full number stack...");
            numberStack.push(111); // should throw StackFullException
            System.out.println("ERROR: This line should never be reached!");

        } catch (StackFullException e) {
            // Expected when stack is full
            System.out.println("Caught expected StackFullException: " + e.getMessage());
        } catch (StackEmptyException e) {
            // Not expected here
            System.out.println("ERROR: Unexpected StackEmptyException: " + e.getMessage());
        }

        // Empty the number stack and test StackEmptyException
        try {
            System.out.println("Popping all numbers...");
            while (!numberStack.isEmpty()) {
                System.out.println("Pop: " + numberStack.pop());
            }

            // Now it is empty -> pop should throw StackEmptyException
            System.out.println("Trying to pop from an empty number stack...");
            numberStack.pop(); // should throw StackEmptyException
            System.out.println("ERROR: This line should never be reached!");

        } catch (StackEmptyException e) {
            // Expected when stack is empty
            System.out.println("Caught expected StackEmptyException: " + e.getMessage());
        }

        System.out.println("\n----------------------------------\n");

        // =========================
        // Test 2: Text stack (String)
        // =========================
        Stack<String> textStack = new Stack<>(4);

        try {
            // Push some texts
            textStack.push("A");
            textStack.push("B");
            textStack.push("C");

            // Expected: "A;B;C"
            System.out.println("Text list: " + textStack.list());

            // Peek should return "C" and not remove it
            System.out.println("Text peek: " + textStack.peek());
            // Expected still: "A;B;C"
            System.out.println("Text list after peek: " + textStack.list());

            // Pop should remove "C"
            System.out.println("Text pop: " + textStack.pop());
            // Expected: "A;B"
            System.out.println("Text list after pop: " + textStack.list());

            // Push more to fill it
            textStack.push("D");
            textStack.push("E");
            // Expected: "A;B;D;E"
            System.out.println("Text list after pushing D and E: " + textStack.list());

            // Now full -> pushing should throw StackFullException
            System.out.println("Trying to push into a full text stack...");
            textStack.push("F"); // should throw
            System.out.println("ERROR: This line should never be reached!");

        } catch (StackFullException e) {
            // Expected when stack is full
            System.out.println("Caught expected StackFullException: " + e.getMessage());
        } catch (StackEmptyException e) {
            // Not expected here
            System.out.println("ERROR: Unexpected StackEmptyException: " + e.getMessage());
        }

        // Test peek on empty stack (separate scenario)
        Stack<String> emptyTextStack = new Stack<>(2);
        try {
            // This should throw StackEmptyException because it is empty
            System.out.println("Trying to peek from an empty text stack...");
            emptyTextStack.peek();
            System.out.println("ERROR: This line should never be reached!");
        } catch (StackEmptyException e) {
            System.out.println("Caught expected StackEmptyException: " + e.getMessage());
        }

        System.out.println("\nAll tests done.");
    }
}
