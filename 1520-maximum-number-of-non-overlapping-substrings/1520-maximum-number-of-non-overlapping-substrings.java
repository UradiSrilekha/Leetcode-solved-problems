class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1)
                first[ch] = i;

            last[ch] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        // Build the smallest valid interval
        // starting from each character's first occurrence
        for (int i = 0; i < 26; i++) {

            if (first[i] == -1)
                continue;

            int start = first[i];
            int end = last[i];

            boolean isValid = true;

            for (int j = start; j <= end; j++) {

                int currChar = s.charAt(j) - 'a';

                // This character appeared before our start,
                // so this interval can never be valid.
                if (first[currChar] < start) {
                    isValid = false;
                    break;
                }

                // We must include all occurrences
                // of every character inside the substring.
                end = Math.max(end, last[currChar]);
            }

            if (isValid) {
                validIntervals.add(
                    new int[]{start, end}
                );
            }
        }

        // Earliest finishing interval first
        validIntervals.sort(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        List<String> result = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : validIntervals) {

            // Non-overlapping with the previous choice
            if (interval[0] > prevEnd) {

                result.add(
                    s.substring(
                        interval[0],
                        interval[1] + 1
                    )
                );

                prevEnd = interval[1];
            }
        }

        return result;
    }
}