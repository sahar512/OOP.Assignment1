import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import observer.ConcreteMember;
import observer.JvmUtilities;
import observer.GroupAdmin;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;  
public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    static GroupAdmin tester;
    static ConcreteMember m1, m2 ;
    static final String nullstr = null;
    static final String str1 ="";
    void printfunc () {
        System.out.println("ConcreteMembers (1,2):");
        System.out.println(JvmUtilities.objectTotalSize(m1,m2));
        System.out.println("objects of the memory");
        System.out.println("GroupAdmin");
        System.out.println(JvmUtilities.objectTotalSize(tester));
        System.out.println("objects of footprint");
        System.out.println(JvmUtilities.objectFootprint(tester,m1,m2));
    }
    @BeforeAll
    public static void Before(){
        System.out.println("JVM: ");
        logger.info(JvmUtilities::jvmInfo);
    }
    @BeforeEach
    public void BeforeEach (){
        tester=new GroupAdmin();
        m1=new ConcreteMember("Alice");
        m2= new ConcreteMember("Bob");
        printfunc();
    }
       @Test
       void checkRegister(){
        System.out.println("GroupAdmin,Register");
        tester.register(m1);
        tester.register(m2);
        printfunc();
        tester.append("aseel");
        assertEquals("friends:\nName:Alice; String:aseel\nName:Bob;", tester.toString());
       }



    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
