package observer;

import java.util.Stack;

/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {
    private StringBuilder st1;
    private Stack<StringBuilder> stack;

    public UndoableStringBuilder() {
        this.st1 = new StringBuilder();
        this.stack = new Stack<>();
    }


    /**
     * The function undos the last change made to the object.
     */
    public void undo() {
        if (!(stack.isEmpty()))
            st1 = stack.pop();
    }

    /**
     * @param str Appends the specified string to this character sequence.
     */
    public UndoableStringBuilder append(String str) {
        stack.push(new StringBuilder(st1.toString()));
        st1.append(str);
        return this;
    }

    @Override
    public String toString() {
        return this.st1.toString();
    }

    /**
     * @param start
     * @param end   Removes the characters in a substring of this sequence. The substring begins
     *              at the specified start and extends to the character at index
     *              end - 1 or to the end of the sequence if no such character exists.
     *              If start is equal to end, no changes are made.
     * @return
     */
    public UndoableStringBuilder delete(int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            throw new StringIndexOutOfBoundsException("the index is out of order !");
        } else {
            stack.push(new StringBuilder(st1.toString()));
            st1.delete(start, end);
            return this;
        }
    }


    public UndoableStringBuilder insert(int offset, String str) throws StringIndexOutOfBoundsException {
        if (offset < 0)
            throw new StringIndexOutOfBoundsException("the index is out of order !");
        stack.push(new StringBuilder(st1.toString()));
        st1.insert(offset, str);
        return this;
    }

    /**
     * @param start
     * @param end
     * @param str   Replaces the characters in a substring of this sequence with characters in
     *              the specified String. The substring begins at the specified start and
     *              extends to the character at index end - 1 or to the end of the sequence if
     *              no such character exists. First the characters in the substring are removed
     *              and then the specified String is inserted at start. (This sequence will be
     *              lengthened to accommodate the specified String if necessary).
     * @return
     * @throws StringIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public UndoableStringBuilder replace(int start, int end, String str) throws StringIndexOutOfBoundsException, NullPointerException {
        if (str != null) {
            if (start > end || start < 0 || end < 0) {
                throw new StringIndexOutOfBoundsException("the index is out of order !");
            } else {
                stack.push(new StringBuilder(st1.toString()));
                st1.replace(start, end, str);
                return this;
            }
        } else {
            throw new NullPointerException("the index is out of order !");
        }
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     *
     * @return
     */
    public UndoableStringBuilder reverse() {
        stack.push(new StringBuilder(st1.toString()));
        st1.reverse();
        return this;
    }
}
