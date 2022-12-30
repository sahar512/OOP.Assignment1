import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void test() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember concreteMember1 = new ConcreteMember();
        ConcreteMember concreteMember2 = new ConcreteMember();

        g.register(concreteMember1);
        g.register(concreteMember2);
        g.append("hh");

        assertEquals(concreteMember1.getStringBuilder().toString(), "hh");
        assertEquals(concreteMember2.getStringBuilder().toString(), "hh");

    }


    @Test
    public void test2() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember concreteMember1 = new ConcreteMember();
        ConcreteMember concreteMember2 = new ConcreteMember();

        g.register(concreteMember1);
        g.register(concreteMember2);


        g.append("hh");
        System.out.println("---------------------");
        g.undo();
        System.out.println("---------------------");


        assertEquals(concreteMember1.getStringBuilder().toString(), "");
        assertEquals(concreteMember2.getStringBuilder().toString(), "");

    }
}

