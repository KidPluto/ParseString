
Email from Thomas B, with his ideas for the code.

```java
public class Main {
    public static void main(String[] cheese){
        String input = "(id,created,employee(id,firstname,employeeType(id), lastname),location)";
        String indent = "";

    }
    class Element implements Comparable{
        public String name;
        public Element[] children;

//        Element(String input){
//            if (input.startsWith("(")){
//                name = "";
//            }
//        }
        
        public String toString(String indent){
            String result = indent + " " + name + "/n";
            Arrays.sort(children);
            for(Element child : children)
                result += child.toString(indent + "-");
            return result;
        }

        public int compareTo(Object o) {
            return ((Element)o).name.compareTo(name);
        }
    }
}
```