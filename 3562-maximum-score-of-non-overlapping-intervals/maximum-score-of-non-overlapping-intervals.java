class Solution {

    static class State {
        long score;
        ArrayList<Integer> indices;

        State(long score, ArrayList<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);
            arr.add(new int[]{x.get(0), x.get(1), x.get(2), i});
        }

        // Sort by starting position
        arr.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[3], b[3]);
        });

        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = arr.get(i)[0];
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new ArrayList<>());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {

                // Skip current interval
                State best = dp[i + 1][k];

                int right = arr.get(i)[1];
                int weight = arr.get(i)[2];
                int index = arr.get(i)[3];

                // Find first interval with start > right
                int next = upperBound(starts, right);

                State nextState = dp[next][k - 1];

                ArrayList<Integer> selected =
                    new ArrayList<>(nextState.indices);

                selected.add(index);
                Collections.sort(selected);

                State take = new State(
                    (long) weight + nextState.score,
                    selected
                );

                if (take.score > best.score ||
                    (take.score == best.score &&
                     lexicographicallySmaller(take.indices, best.indices))) {
                    best = take;
                }

                dp[i][k] = best;
            }
        }

        ArrayList<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean lexicographicallySmaller(
            ArrayList<Integer> a,
            ArrayList<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}