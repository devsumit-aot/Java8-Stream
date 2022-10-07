import java.util.*;
import java.util.stream.Collectors;

public class Test {
  public static void main(String[] arg) {

    List<Student> students = new ArrayList<>();
    students.add(new Student(101, "Sumit", "CSE", 88.5));
    students.add(new Student(102, "Tumit", "CSE", 80.5));
    students.add(new Student(103, "Uumit", "CSE", 98.5));
    students.add(new Student(104, "Vumit", "IT", 70.5));
    students.add(new Student(105, "Wumit", "IT", 55.5));
    students.add(new Student(106, "Xumit", "CSE", 48.5));
    students.add(new Student(107, "Yumit", "IT", 56.5));
    students.add(new Student(108, "Zumit", "ME", 69.5));
    students.add(new Student(109, "Aumit", "ME", 85.5));
    students.add(new Student(110, "Bumit", "ECE", 63.5));

    /* Intermediate */

    /*
    Filter Operation
    --> filtering only CSE students and transferring them into map<int:id,value:Student>
     */
    Map<Integer, Student> cseStudentMap =
        students.stream()
            .filter(e -> e.getBranch().equalsIgnoreCase("CSE"))
            .collect(Collectors.toMap(Student::getId, v -> v));
    for (Map.Entry<Integer, Student> entry : cseStudentMap.entrySet()) {
      System.out.println("Key " + entry.getKey() + "value " + entry.getValue());
    }

    /*
       Map Operation
       --> converting name into Caps and storing It into List
    */
    List<String> nameInCapsList =
        students.stream().map(e -> e.getName().toUpperCase()).collect(Collectors.toList());
    for (String str : nameInCapsList) {
      System.out.println(str);
    }

    /*
       Distinct Operation
       --> Extracting all the Branch
    */
    Set<String> branchList =
        students.stream().map(e -> e.getBranch()).distinct().collect(Collectors.toSet());
    for (String str : branchList) {
      System.out.println(str);
    }
    /*
       Sorted Operation
       1. Sorting primitive data type
    */

    List<String> nameSortedList =
        students.stream()
            .map(e -> e.getName())
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    for (String str : nameSortedList) {
      System.out.println(str);
    }
    /*
       Sorted Operation
       2. Sorting non-primitive data type
    */
    List<Student> studentSortedList =
        students.stream()
            .sorted(Comparator.comparing(Student::getBranch).reversed())
            .collect(Collectors.toList());

    for (Student str : studentSortedList) {
      System.out.println(str);
    }

    /*
     limit and skip
    */

    List<String> limitAndSKip =
        students.stream()
            .skip(3)
            .map(e -> e.getName())
            .sorted(Comparator.reverseOrder())
            .limit(5)
            .collect(Collectors.toList());
    System.out.println("LIimit 5 and skip 3");
    for (String str : limitAndSKip) {
      System.out.println(str);
    }
    /*  Terminal Operator */

    // count
    long k = students.stream().map(e -> e.getBranch()).distinct().count();
    System.out.println("k " + k);

    // max/min

    Student max = students.stream().max(Comparator.comparing(Student::getMarks)).get();
    System.out.println("max " + max);

    // foreach
    System.out.println("for each");
    students.stream()
        .filter(e -> e.getBranch().equalsIgnoreCase("CSE"))
        .forEach(
            e -> {
              System.out.println(e.getName().toUpperCase());
            });

    /*  Collect - ADVANCE Concept
    collect(Collectors.toList())
    collect(Collectors.toSet())
    collect(Collectors.toMap())
   */


  }

}
