package observer;

import java.util.List;

public class ConcreteMember implements Member {
    private UndoableStringBuilder stringBuilder;
    private String name;
public ConcreteMember(String name){
    this.name=name;
    this.stringBuilder=null;

}
    /**
     * update the pointer of the UndoableStringBuilder to the same one in the groupAdmin
     * @param usb a pointer to the UndoableStringBuilder object that in the groupAdmin
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.stringBuilder = usb;
        if(usb  != null)
            System.out.println(usb.toString());
        System.out.println(this.name+"notified...");
    }

    public String toString(){
        if(stringBuilder == null)
            return "";
        return ("name="+ this.name +"\n String="+ this.stringBuilder);
    }
}
