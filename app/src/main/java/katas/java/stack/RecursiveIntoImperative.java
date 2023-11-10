package katas.java.stack;

public class RecursiveIntoImperative {

    private MyStack<Integer> stack = new MyStack<>();


    public int fibonacciStack(int i) throws EmptystackException {
        int result = 0;
        stack.push(i);
        stack.push(i - 1);

        while (!stack.isEmpty()) {
            Integer item = stack.pop();
            if (item > 3) {
                stack.push(item - 1);
                stack.push(item - 2);
            } else if (item == 2) {
                stack.push(1);
            } else {
                result += 1;
            }
        }

        return result;
    }
}
