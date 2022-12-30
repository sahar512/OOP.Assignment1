package observer;

public class MM {

    public static void main(String[] args) {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember concreteMember1 = new ConcreteMember();
        ConcreteMember concreteMember2 = new ConcreteMember();

        g.register(concreteMember1);
        g.register(concreteMember2);


        g.insert(0, "hello world");
//        g.undo();
        g.delete(0, 2);
    }

}
