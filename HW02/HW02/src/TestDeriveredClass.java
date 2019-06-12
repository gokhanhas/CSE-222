/*
 * Gokhan Has - 161044067
 */



import java.sql.Time;
import java.util.Iterator;


/**
 * This is the driver class to test the codes.
 *
 * @author GokhanHas
 */
public class TestDeriveredClass {


    public void TestMethods() throws Exception {

        Experiment x = (new Experiment("Exp1",2,new Time(1,2,3),true,140/100));
        Experiment x2 = (new Experiment("Exp2",1,new Time(1,23,3),false,-100/100));
        Experiment x3 = (new Experiment("Exp3",7,new Time(1,30,3),true,110/100));
        Experiment x4 = (new Experiment("Exp4",3,new Time(2,31,3),true,300/100));
        Experiment x5 = (new Experiment("Exp5",3,new Time(5,5,7),false,-100/100));
        Experiment x6 = (new Experiment("Exp6",8,new Time(12,131,93),false,-100/100));
        Experiment x7 = (new Experiment("Exp7",5,new Time(81,631,23),false,-100/100));
        Experiment x8 = (new Experiment("Exp8",3,new Time(72,39,31),true,960/100));
        Experiment x9 = (new Experiment("Exp9",1,new Time(9,39,31),true,741/100));
        Experiment x10 = (new Experiment("Ex10",8,new Time(8,9,10),true,200/100));
        Experiment changed = (new Experiment("Exp0",7,new Time(0,0,0),false,-100/100));
        Experiment changed2 = (new Experiment("Exp0",1,new Time(1,1,1),true,660/100));

        System.out.println("----> Testing addExpFunction <----");
        ExperimentList temp = new ExperimentList();
        temp.addExp(x);
        temp.addExp(x2);
        temp.addExp(x3);
        temp.addExp(x4);
        temp.addExp(x5);
        temp.addExp(x6);
        temp.addExp(x7);
        temp.addExp(x8);
        temp.addExp(x9);
        temp.addExp(x10);
        System.out.println("After addExp methods ...");
        System.out.println("Size --> " + temp.getSize());
        System.out.println(temp.toString());
        System.out.println("--------------------");
        System.out.println("Printing day list :");
        temp.printDayNode();
        System.out.println("**************************");

        System.out.println("\n----> Testing getExp method <----");
        System.out.print("Day : 1  Index : 0 --> " + temp.getExp(1,0));
        System.out.print("Day : 1  Index : 1 --> " + temp.getExp(1,1));
        System.out.println("Day : 1  Index : 2 --> " + temp.getExp(1,3));
        System.out.print("Day : 3  Index : 2 --> " + temp.getExp(3,2));
        System.out.print("Day : 8  Index : 0 --> " + temp.getExp(8,0));
        System.out.print("Day : 8  Index : 1 --> " + temp.getExp(8,1));
        System.out.println("Day : 20 Index : 4 --> " + temp.getExp(20,4));
        System.out.println("********** End Test **********");



        System.out.println("\n----> Testing setExp method <----");
        temp.setExp(10,0,changed);
        temp.setExp(7,0,changed);
        temp.setExp(1,1,changed2);
        System.out.println("Size --> " + temp.getSize());
        System.out.println(temp.toString());
        System.out.println("--------------------");
        System.out.println("Printing day list :");
        temp.printDayNode();
        System.out.println("********** End Test **********");


        System.out.println("\n----> Testing listExp method <----");
        ExperimentList listExpTest = new ExperimentList();
        System.out.println("Day 1 --> ");
        listExpTest = temp.listExp(1);
        System.out.println("Day 8 --> ");
        listExpTest = temp.listExp(8);
        System.out.println("Day 3 --> ");
        listExpTest = temp.listExp(3);
        System.out.println("Day 2 --> ");
        listExpTest = temp.listExp(2);
        // listExpTest = temp.listExp(7); // --> Day 7'de true olmadigi icin exception firlaticak ..
        System.out.println("********** End Test **********");


        System.out.println("\n----> Testing orderDay method <----");
        temp.orderDay(1);
        temp.orderDay(2);
        temp.orderDay(3);
        temp.orderDay(5);
        temp.orderDay(7);
        temp.orderDay(8);
        System.out.println("After orderDay all ...");
        System.out.println("Size --> " + temp.getSize());
        System.out.println(temp.toString());
        System.out.println("--------------------");
        System.out.println("Printing day list :");
        temp.printDayNode();
        System.out.println("********** End Test **********");


        System.out.println("\n----> Testing orderExperiments method <----");
        ExperimentList testOrderExperiments = new ExperimentList();
        testOrderExperiments = temp.orderExperiments();
        System.out.println("testOrderExperiments List --> \n" + testOrderExperiments.toString());
        System.out.println("Old List -> (Does NOT change) --> ");
        System.out.println(temp.toString());
        System.out.println("--------------------");
        System.out.println("Printing day list :");
        temp.printDayNode();
        System.out.println("********** End Test **********");


        System.out.println("\n----> Testing Remove Methods <----");
        System.out.println("\n--> Testing removeExp methods <--");
        System.out.println("RemoveExp(day:1,index:0)"); temp.removeExp(1,0);
        System.out.println("RemoveExp(day:8,index:1)"); temp.removeExp(8,1);
        //System.out.println("RemoveExp(day:2,index:1");temp.removeExp(1,0); // --> Day:2 Index:1 is not found, so Exception will be thorewed...
        System.out.println("RemoveExp(day:2,index:0)"); temp.removeExp(2,0);
        System.out.print(temp.toString());
        System.out.println("Size --> " + temp.getSize());
        System.out.println("--------------------");
        System.out.println("Printing day list :");
        temp.printDayNode();
        System.out.println("********** End Test **********");


        System.out.println("\n--> Testing removeDay methods <--");
        System.out.println("RemoveDay(Day:3)"); temp.removeDay(3);
        System.out.println("RemoveDay(Day:1)"); temp.removeDay(1);
        System.out.println("RemoveDay(Day:7)"); temp.removeDay(7);
        System.out.print(temp.toString());
        System.out.println("Size --> " + temp.getSize());
        System.out.println("--------------------");
        System.out.println("Printing day list :");
        temp.printDayNode();
        System.out.println("********** End Test **********");

        System.out.println("---> Test Ending Methods <----");
    }


    public void testIterators() {

        Experiment x = (new Experiment("Exp1",2,new Time(1,2,3),true,140/100));
        Experiment x2 = (new Experiment("Exp2",1,new Time(1,23,3),false,-100/100));
        Experiment x3 = (new Experiment("Exp3",7,new Time(1,30,3),true,110/100));
        Experiment x4 = (new Experiment("Exp4",3,new Time(2,31,3),true,300/100));
        Experiment x5 = (new Experiment("Exp5",3,new Time(5,5,7),false,-100/100));
        Experiment x6 = (new Experiment("Exp6",8,new Time(12,131,93),false,-100/100));
        Experiment x7 = (new Experiment("Exp7",5,new Time(81,631,23),false,-100/100));
        Experiment x8 = (new Experiment("Exp8",3,new Time(72,39,31),true,960/100));
        Experiment x9 = (new Experiment("Exp9",1,new Time(9,39,31),true,741/100));
        Experiment x10 = (new Experiment("Ex10",8,new Time(8,9,10),true,200/100));
        Experiment changed = (new Experiment("Exp0",7,new Time(0,0,0),false,-100/100));
        Experiment changed2 = (new Experiment("Exp0",1,new Time(1,1,1),true,660/100));

        ExperimentList temp = new ExperimentList();
        temp.addExp(x);
        temp.addExp(x2);
        temp.addExp(x3);
        temp.addExp(x4);
        temp.addExp(x5);
        temp.addExp(x6);
        temp.addExp(x7);
        temp.addExp(x8);
        temp.addExp(x9);
        temp.addExp(x10);

        System.out.println("\n\n----> Testing Iterator <----\n");

        System.out.print(temp.toString());
        System.out.println("Size --> " + temp.getSize());
        System.out.println("--------------------");


        Iterator<ExperimentList> iterator = temp.iterator();
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.println("Remove Methods --> (Day 7 will be remove )");
        iterator.remove();
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.println("hasNext Methods --> " + iterator.hasNext());
        System.out.print("Next Methods -->  " + iterator.next().getIteratorData());
        System.out.print("hasNext Methods --> " + iterator.hasNext());

        System.out.println("\n********** End Test **********");
    }
}