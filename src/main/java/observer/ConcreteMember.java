package observer;

import java.util.List;

public class ConcreteMember implements Member {
    private UndoableStringBuilder stringBuilder;

    /**
     * update the pointer of the UndoableStringBuilder to the same one in the groupAdmin
     * @param usb a pointer to the UndoableStringBuilder object that in the groupAdmin
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.stringBuilder = usb;
        System.out.println(usb.toString());
    }

    public UndoableStringBuilder getStringBuilder(){
        return stringBuilder;
    }
}
