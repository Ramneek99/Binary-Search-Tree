import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
  public static void main(String[] args) {
    Bst<Student> myTree= new Bst<Student>();
    System.out.println(myTree);
    Student A= new Student("Amanda", 700000005);
    myTree.add(A);
    System.out.println("now adding: "+A+" and printing tree\n");
    System.out.println(myTree);
    
   /* Student B= new Student("Beyonce", 700000003);
    System.out.println("Now adding: "+B+" and printing tree\n");
    myTree.add(B);
    System.out.println(myTree);
    
    Student C= new Student("Charles", 700000007);
    System.out.println("Now adding" +C+" and printing tree\n");
    myTree.add(C);
    System.out.println(myTree);
    
    Student D= new Student("Derek", 700000002);
    System.out.println("Now adding"+D+" and printing tree\n");
    myTree.add(D);
    System.out.println(myTree);
    
    Student E= new Student("Erica", 700000004);
    System.out.println("Now adding"+E+" and printing tree\n");
    myTree.add(E);
    System.out.println(myTree);
    
    Student F= new Student("Frida", 700000006);
    System.out.println("Now adding"+F+" and printing tree\n");
    myTree.add(F);
    System.out.println(myTree);
    
    Student G= new Student("Geraldo", 700000008);
    System.out.println("Now adding"+G+" and printing tree\n");
    myTree.add(G);
    System.out.println(myTree);
    
    System.out.println("Now getting the student associated with ID 700000008: ");
    System.out.println(myTree.getObject(700000008));
    
     System.out.println("Now getting the student associated with ID 700000002: ");
    System.out.println(myTree.getObject(700000002));
    
     System.out.println("Now getting the student associated with ID 900000008, should be null: ");
    System.out.println(myTree.getObject(900000008));
    
    System.out.println("Now removing 700000008");
    System.out.println("Item removed: "+myTree.remove(700000008));
    System.out.println("printing the tree now post item removed: ");
    System.out.println(myTree);
    
    System.out.println("Now Removing 700000007");
    System.out.println("Item removed: "+myTree.remove(700000007));
    System.out.println("printing the tree now post item removed: ");
    System.out.println(myTree);
    
    System.out.println("Now Removing 700000005");
    System.out.println("Item removed: "+myTree.remove(700000005));
    System.out.println("printing the tree now post item removed: ");
    System.out.println(myTree);
    */
  }
}


