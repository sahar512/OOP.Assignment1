package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private List<Member> members;
    private UndoableStringBuilder stringBuilder;

    public GroupAdmin() {
        this.members = new ArrayList<>();
        this.stringBuilder = new UndoableStringBuilder();
    }

    /**
     * notifies all members that a change was made
     *
     */
    private void notifyMembers() {
        for (Member m : members) {
            m.update(stringBuilder);
        }
    }

    /**
     * register a member to the observers list
     * @param obj
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
        obj.update(stringBuilder);
    }

    /**
     * unregister a member from the observers list
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
        obj.update(null);
        members.remove(obj);
    }
    /**
     * insert the string into the character sequence
     * @param offset
     * @param obj
     *
     */
    @Override
    public void insert(int offset, String obj) {
        stringBuilder.insert(offset, obj);
        notifyMembers();
    }
    /**
     *
     *
     * Appends the specified string to this character sequence.
     * @param obj
     */
    @Override
    public void append(String obj) {
        stringBuilder.append(obj);
        notifyMembers();
    }
    /**
     * @param start
     * @param end
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     */
    @Override
    public void delete(int start, int end) {
        this.stringBuilder.delete(start, end);
        notifyMembers();
    }

    /**
     *
     *
     * The function undos the last change made to the object.
     */
    @Override
    public void undo() {
        this.stringBuilder.undo();
        notifyMembers();
    }
}
