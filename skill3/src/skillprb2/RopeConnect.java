package skillprb2;

import java.util.PriorityQueue;

public class RopeConnect {
    public static int minimumCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.offer(rope);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            cost += first + second;
            minHeap.offer(first + second);
        }
        return cost;
    }

 
public static void main(String[] args) {
    int[] ropes = {5, 4, 2, 8};
    int cost = minimumCost(ropes);
    System.out.println("The minimum cost is " + cost);
}
}
