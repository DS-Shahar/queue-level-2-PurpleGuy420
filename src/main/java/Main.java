public class Main {
    public static void main(String[] args) {

    }

    public static Queue<Integer> countSequences(Queue<Integer> q) {
        Queue<Integer> result = new Queue<>();

        if (q.isEmpty())
            return result;

        int current = q.remove();
        int count = 1;

        while (!q.isEmpty()) {
            int next = q.remove();

            if (next == current) {
                count++;
            } else {
                result.insert(count);
                current = next;
                count = 1;
            }
        }

        result.insert(count);

        return result;
    }

    public static Queue<Integer> mergeQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new Queue<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.head() <= q2.head()) {
                result.insert(q1.remove());
            } else {
                result.insert(q2.remove());
            }
        }

        while (!q1.isEmpty()) {
            result.insert(q1.remove());
        }
        
        while (!q2.isEmpty()) {
            result.insert(q2.remove());
        }

        return result;
    }

    public static int sumLongestEvenSequence(Queue<Integer> q) {
        int maxLength = 0;
        int maxSum = 0;

        int currentLength = 0;
        int currentSum = 0;

        while (!q.isEmpty()) {
            int num = q.remove();

            if (num % 2 == 0) {
                currentLength++;
                currentSum += num;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxSum = currentSum;
                }
                currentLength = 0;
                currentSum = 0;
            }
        }
        
        if (currentLength > maxLength) {
            maxSum = currentSum;
        }

        return maxSum;
    }
}
