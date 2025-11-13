import java.util.LinkedList;
import java.util.List;

/**
 * 實現一個可以置入任意類別物件的 Stack。
 * 底層使用 JCF 中的 LinkedList 來模擬 Stack 的行為（後進先出 LIFO）。
 * 不直接使用 java.util.Stack。
 */
class MyStack<T> {

    // 使用 JCF 中的 LinkedList 作為底層資料結構。
    // LinkedList 實現了 List 和 Deque 介面，非常適合 Stack 操作。
    private final LinkedList<T> stack;

    public MyStack() {
        this.stack = new LinkedList<>();
    }

    /**
     * 將一個元素推入棧的頂部 (Push)。
     * 在 LinkedList 中，使用 addFirst 來模擬推入操作。
     */
    public void push(T item) {
        // 等同於 stack.addFirst(item)
        stack.push(item); 
    }

    /**
     * 移除並返回棧頂的元素 (Pop)。
     * 在 LinkedList 中，我們使用 removeFirst 來模擬彈出操作。
     * 如果棧為空，此方法會拋出 NoSuchElementException。
     */
    public T pop() {
        // 等同於 stack.removeFirst()
        // 由於原先的程式碼是 return stack.top(); 
        // 這裡需要修改為 LinkedList 提供的 removeFirst() 或 pop() 
        return stack.pop(); 
    }

    /**
     * 返回棧頂的元素，但不將其移除 (Peek)。
     */
    public T peek() {
        // 等同於 stack.getFirst()
        return stack.peek();
    }
    
    // 檢查棧是否為空
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // 返回棧中的元素數量
    public int size() {
        return stack.size();
    }
}

public class StackExample{
    public static void main(String[] args) {
        // 測試 Integer Stack
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Integer Stack Pop: " + intStack.pop()); // 輸出 20

        // 測試自定義 Person Object Stack
        MyStack<Person> personStack = new MyStack<>();
        personStack.push(new Person("Alice", 30));
        personStack.push(new Person("Bob", 25));
        System.out.println("Person Stack Pop: " + personStack.pop()); // 輸出 Bob
    }
}


//我的Junit測試會測這個Object，這邊以下請不要修改
//---------------------------------------------------------------------------------
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
//---------------------------------------------------------------------------------