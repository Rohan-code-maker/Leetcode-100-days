class Solution {
    private TreeSet<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    private void dfs(String exp) {
        int right = exp.indexOf('}');

        // No braces left
        if (right == -1) {
            set.add(exp);
            return;
        }

        // Find the matching opening brace
        int left = exp.lastIndexOf('{', right);

        String before = exp.substring(0, left);
        String inside = exp.substring(left + 1, right);
        String after = exp.substring(right + 1);

        // Try every option inside the braces
        for (String option : inside.split(",")) {
            dfs(before + option + after);
        }
    }
}