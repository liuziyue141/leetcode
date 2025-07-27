class Solution {
    public int maxDifference(String s, int k) {
        long globalMaxDiff = Long.MIN_VALUE;

        // Determine the unique characters present in the string.
        boolean[] seen = new boolean[128];
        for (char c : s.toCharArray()) {
            seen[c] = true;
        }

        // Iterate through all distinct pairs of characters (a, b).
        for (char a = '0'; a <= '4'; a++) {
            if (!seen[a]) continue;
            for (char b = '0'; b <= '4'; b++) {
                if (!seen[b] || a == b) continue;
                
                long currentMax = solveForPair(s, k, a, b);
                globalMaxDiff = Math.max(globalMaxDiff, currentMax);
            }
        }

        return (globalMaxDiff == Long.MIN_VALUE) ? -1 : (int) globalMaxDiff;
    }

    /**
     * Solves the problem for a fixed pair of characters (a, b).
     */
    private long solveForPair(String s, int k, char a, char b) {
        int n = s.length();
        int[] countA = new int[n + 1];
        int[] countB = new int[n + 1];

        // Precompute prefix counts.
        for (int i = 0; i < n; ++i) {
            countA[i + 1] = countA[i] + (s.charAt(i) == a ? 1 : 0);
            countB[i + 1] = countB[i] + (s.charAt(i) == b ? 1 : 0);
        }
        
        // state[parA][parB] stores {v1, cb1, v2, cb2} for a given prefix parity state.
        // v = countA - countB. We store the two best (v, countB) pairs.
        long[][][] state = new long[2][2][4];
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                state[i][j][0] = Long.MAX_VALUE; // v1
                state[i][j][1] = -1;             // cb1
                state[i][j][2] = Long.MAX_VALUE; // v2
                state[i][j][3] = -1;             // cb2
            }
        }
        
        long maxDiff = Long.MIN_VALUE;

        // j_idx corresponds to prefix s[0...j_idx-1].
        for (int j_idx = k; j_idx <= n; ++j_idx) {
            // Update state with info from the start-prefix p_idx = j_idx - k.
            // This is the earliest valid starting prefix for a substring of length k ending at j_idx-1.
            int p_idx = j_idx - k;
            int pa_p = countA[p_idx] % 2;
            int pb_p = countB[p_idx] % 2;
            long v_p = (long)countA[p_idx] - countB[p_idx];
            long cb_p = countB[p_idx];
            updateState(state[pa_p][pb_p], v_p, cb_p);

            // Query using the end-prefix j_idx.
            int pa_j = countA[j_idx] % 2;
            int pb_j = countB[j_idx] % 2;
            long v_j = (long)countA[j_idx] - countB[j_idx];
            long cb_j = countB[j_idx];

            // Determine required parity for the starting prefix.
            int req_pa = (pa_j == 0) ? 1 : 0; // freq_a must be odd
            int req_pb = pb_j;               // freq_b must be even

            long[] bests = state[req_pa][req_pb];
            long v1 = bests[0];
            long cb1 = bests[1];
            long v2 = bests[2];

            if (v1 != Long.MAX_VALUE) {
                // Check if the best candidate is valid (freq_b is non-zero).
                if (cb1 != cb_j) {
                    maxDiff = Math.max(maxDiff, v_j - v1);
                } else if (v2 != Long.MAX_VALUE) {
                    // If best is invalid, try the second-best.
                    maxDiff = Math.max(maxDiff, v_j - v2);
                }
            }
        }
        return maxDiff;
    }

        /**
        * Updates the state with a new (v, countB) pair, maintaining the two best pairs
        * with distinct countB values.
        */
        private void updateState(long[] currentState, long v_new, long cb_new) {
            long v1 = currentState[0], cb1 = currentState[1];
            long v2 = currentState[2], cb2 = currentState[3];

            if (cb_new == cb1) {
                currentState[0] = Math.min(v1, v_new);
            } else if (cb_new == cb2) {
                currentState[2] = Math.min(v2, v_new);
            } else if (v_new < v1) {
                currentState[2] = v1;
                currentState[3] = cb1;
                currentState[0] = v_new;
                currentState[1] = cb_new;
            } else if (v_new < v2) {
                currentState[2] = v_new;
                currentState[3] = cb_new;
            }

            // Ensure v1 is always the smaller one.
            if (currentState[0] > currentState[2]) {
                long temp_v = currentState[0];
                long temp_cb = currentState[1];
                currentState[0] = currentState[2];
                currentState[1] = currentState[3];
                currentState[2] = temp_v;
                currentState[3] = temp_cb;
            }
        }

}