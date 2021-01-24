import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {
    // 找出前k个
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();

        // 先计数O(n)
        for (int i = 0; i < nums.length; i ++) {
            if (! map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        // 再将其放入最小堆（比较方式是比较的map的value）用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                // add超出界限会抛出异常，而offer则返回false
                heap.offer(key);
            } else {
                if (map.get(key) > map.get(heap.peek())) {
                    heap.poll();
                    heap.offer(key);
                }
            }

        }

        // 然后返回
        int[] res = new int[k];

        for (int i = 0; i < k; i ++) {
            res[i] = heap.poll();
        }

        return res;

    }
}