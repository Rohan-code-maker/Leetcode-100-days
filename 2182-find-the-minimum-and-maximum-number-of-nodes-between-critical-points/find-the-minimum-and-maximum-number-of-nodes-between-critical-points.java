class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = 0;

        int firstCritical = -1;
        int lastCritical = -1;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

            // Check whether curr is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {

                    // Distance from previous critical point
                    minDistance = Math.min(
                            minDistance,
                            index - lastCritical
                    );

                    // Distance from first critical point
                    maxDistance = Math.max(
                            maxDistance,
                            index - firstCritical
                    );
                }

                lastCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than two critical points
        if (firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}