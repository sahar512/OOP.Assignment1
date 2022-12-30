import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import observer.JvmUtilities;
import org.junit.jupiter.api.*;
public class MyTests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    static GroupAdmin tester;
    static ConcreteMember m1, m2 ;
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
        assertEquals("name=Alice\n String=aseel", m1.toString());
        assertEquals("name=Bob\n String=aseel", m2.toString());

        printfunc();
    }
    @Test
    void checkUnRegister(){
        System.out.println("GroupAdmin,UnRegister");
        tester.register(m1);
        tester.register(m2);
        tester.append("aseel");
        assertEquals("name=Alice\n String=aseel" , m1.toString());
        assertEquals("name=Bob\n String=aseel" , m2.toString());
        tester.unregister(m1);
        tester.unregister(m2);
    }
    @Test
    void checkappend(){
        System.out.println("GroupAdmin,Append");
        tester.register(m1);
        tester.register(m2);
        tester.append("sahar");
        printfunc();

        System.out.println("------" + m1.toString());
        assertEquals("name=Alice\n String=sahar", m1.toString());
        assertEquals("name=Bob\n String=sahar", m2.toString());

        tester.append("123");
        printfunc();
        tester.append("");

        assertEquals("name=Alice\n String=sahar123", m1.toString());
        assertEquals("name=Bob\n String=sahar123", m2.toString());
        printfunc();
    }
    @Test
    void checkdelete(){
        System.out.println("check Delete");
        tester.register(m1);
        tester.register(m2);
        tester.append("test");
        tester.delete(0,1);
        assertEquals("name=Alice\n String=est",m1.toString());
        assertEquals("name=Bob\n String=est",m2.toString());

    }



        @Test
        void checkinsert(){
            System.out.println("check insert");
            tester.register(m1);
            tester.register(m2);
            tester.insert(0,"test");
            assertEquals("name=Alice\n String=test",m1.toString());
            assertEquals("name=Bob\n String=test",m2.toString());

            printfunc();
            tester.insert(2,"num");
            assertEquals("name=Alice\n String=tenumst",m1.toString());
            assertEquals("name=Bob\n String=tenumst",m2.toString());

            printfunc();

            assertEquals("name=Alice\n String=tenumst",m1.toString());
            assertEquals("name=Bob\n String=tenumst",m2.toString());

            printfunc();
        }
        @Test
        void checkundo() {
            System.out.println("check insert");
            tester.register(m1);
            tester.register(m2);
            tester.append("test");
            tester.undo();
            assertEquals("name=Alice\n String=",m1.toString());
            assertEquals("name=Bob\n String=",m2.toString());

            printfunc();
            tester.undo();
            assertEquals("name=Alice\n String=",m1.toString());
            assertEquals("name=Bob\n String=",m2.toString());

            printfunc();
            tester.insert(0,"test");
            assertEquals("name=Alice\n String=test",m1.toString());
            assertEquals("name=Bob\n String=test",m2.toString());
            printfunc();
            tester.undo();
            assertEquals("name=Alice\n String=",m1.toString());
            assertEquals("name=Bob\n String=",m2.toString());
            printfunc();
            tester.insert(0,"test");
            assertEquals("name=Alice\n String=test",m1.toString());
            assertEquals("name=Bob\n String=test",m2.toString());
            printfunc();
            tester.delete(0,4);
            tester.undo();
            assertEquals("name=Alice\n String=test",m1.toString());
            assertEquals("name=Bob\n String=test",m2.toString());
            printfunc();
        }

        @Test
        public void checkTests(){
            GroupAdmin groupA=new GroupAdmin();
            ConcreteMember m1=new ConcreteMember("Alice");
            ConcreteMember m2=new ConcreteMember("Bob");
            logger.info(()->JvmUtilities.objectFootprint(tester,m1,m2));
            logger.info(()->JvmUtilities.objectTotalSize(tester,m1,m2));
            tester.register(m1);
            tester.register(m2);
            logger.info(()->JvmUtilities.objectFootprint(tester));
            logger.info(()->JvmUtilities.objectTotalSize(tester));
            tester.append("-------");
            logger.info(()->JvmUtilities.objectFootprint(tester));
            logger.info(()->JvmUtilities.objectTotalSize(tester));
            tester.unregister(m2);
            logger.info(()->JvmUtilities.objectFootprint(tester));
            logger.info(()->JvmUtilities.objectTotalSize(tester));
            logger.info(JvmUtilities::jvmInfo);
            tester.insert(0,"test");
            logger.info(()->JvmUtilities.memoryStats(tester));
        }
    }

