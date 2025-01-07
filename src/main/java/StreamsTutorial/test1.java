package StreamsTutorial;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class test1 {

    //Count the number of names starting with alphabet A in list
//    @Test
//  public void regular(){
//    ArrayList<String> names = new ArrayList<String>();
//    names.add("Abc");
//    names.add("bcd");
//    names.add("cde");
//    names.add("def");
//    names.add("Abg");
//    names.add("Aefgh");
//    int count=0;
//
//    for(int i=0; i<names.size(); i++)
//    {
//       String actual = names.get(i);
//       if(actual.startsWith("A"))
//        {
//            count++;
//        }
//    }
//
//    System.out.println(count);
//   }

   // applying java streams
   @Test
    public void streamFilter(){
       ArrayList<String> names = new ArrayList<String>();
       names.add("Abc");
       names.add("bcd");
       names.add("cde");
       names.add("def");
       names.add("Abg");


       //There is no life for intermediate op if there is no terminal op
       // terminal operation will execute only if inter op (filter) returns true
       //We can create stream
       //how to use filter in stream API

      Long c = names.stream().filter(s ->s.startsWith("A")).count();
       System.out.println(c);


       long d = Stream.of("Abc","bcd","cde","def","Abg").filter(s ->
       {
           s.startsWith("A");
           return true;
       }).count();

       System.out.println(d);
       //print all the names of the ArrayList
       names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
   }

}
