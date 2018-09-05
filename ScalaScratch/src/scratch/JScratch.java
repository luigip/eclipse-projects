package scratch;

import java.util.Arrays;
import java.util.List;

import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.JavaConversions;
import scala.Tuple2;
import static scratch.Scratch.seqFromList;

public class JScratch {
  public static void main(String[] args) {
    
    Tuple2<String, String> t = new Tuple2<String, String>("ab", "cd");
    String[] xs = {"abc", "def"};
//    String y = "def";
    
    List<Tuple2<String, String>> list = Arrays.asList(t, t, t);
//    Buffer<String> buf = new JavaConversions.JListWrapper(list); 
    
    
//    scala.collection.Seq<String> seq = Scratch.getSeq(xs);
//    scala.collection.Seq<Tuple2<String, String>> seq = seqFromList(list);
//    scala.collection.Seq<String> seq = Scratch.seqFromList(Arrays.asList(xs));
//    scala.collection.Seq<String> seq = 
//      scala.collection.JavaConverters.collectionAsScalaIterableConverter(Arrays.asList(xs));
    
    
//    ArrayBuffer<String> a = new ArrayBuffer<String>();
    ArrayBuffer<Tuple2<String, String>> a = new ArrayBuffer<Tuple2<String, String>>();
    a.append(seqFromList(list));
    
//    Scratch.doit(a);
     System.out.println("hi");
     for(int i = 0; i < a.length(); i++) {
       System.out.println(a.apply(i));
     }
  }
}
