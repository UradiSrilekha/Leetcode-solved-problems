class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int n = s.length;
        int m = t.length;

        // suffix[i] = max number of characters of word2 that can be matched
        // using s[i..n-1] as a subsequence.
        int[] suffix = new int[n + 1];
        int j = m - 1;
        int matched = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && s[i] == t[j]) {
                matched++;
                j--;
            }
            suffix[i] = matched;
        }

        int[] ans = new int[m];
        int i = 0;
        int k = 0; // pointer in word2
        boolean skipped = false;

        while (i < n && k < m) {
            if (s[i] == t[k]) {
                ans[k] = i;
                i++;
                k++;
            } else {
                // try to skip this character in word1 (only once)
                if (!skipped && suffix[i + 1] >= m - k - 1) {
                    // use this position as the "skipped" match
                    ans[k] = i;
                    skipped = true;
                    i++;
                    k++;
                } else {
                    i++;
                }
            }
        }

        if (k != m) {
            return new int[0];
        }

        return ans;
    }
}