package com.stock;
import java.util.*;

public class SlidingWindow {

    public static List<Integer> maxInWindow(int[] prices, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && prices[deque.peekLast()] < prices[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result.add(prices[deque.peek()]);
            }
        }

        return result;
    }
}
