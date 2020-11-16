
public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] prerequisites = new int[n];
        int[] masks = new int[1 << n];  // for example, if n == 4, masks = [(1000) base 2] == new int [16];
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        // generate all prerequisites in binary form and store them in an array. For example, if dependencies = [[2,1],[3,1],[1,4]], prerequisites[0] will be 0110 in binary form. because
        // second and third course are prerequisites for the first course. dest - 1 is the index of prerequisites array. prerequisites = [[0110], [0000], [0000], [0001]] in binary form
        // prerequisites = [6, 0, 0, 1] if you print it out in decimal form. But we use binary form to store the prerequisites, so it is easier to represent it as binary form
        for (int i = 0; i < dependencies.length; i++) {
            int source = dependencies[i][0];
            int dest = dependencies[i][1];
            prerequisites[dest - 1] |= (1 << (source  - 1));
        }
        // iterate all prerequisites and generate masks
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
            // if i == 0001 in binary form, which is 1 in decimal. i & (1 << j) is checking whether ith bit is 1 or not.
            // if i & 1 << j is greater than 0 that means ith bit is 1. For example, 0001 & (1 << 0) == 1. 0011 & (1 << 1) == 0010 which is 2. This means the from right to left, the 2nd bit is 1
            // Same for 8 & (1 << 3), which is 8, the third bit from right to left is set to 1. if (9 & (1 << 3) > 0) is also true because 9 in binary form is 0101 and 9 & (1 << 3) will be 0100
            // in binary form which is greater than 0. When this condition match, we generate a bit mask for current ith prerequisites
            // |= operator sets all 1's bit to current mask, masks[i];
                if ((i & (1 << j)) > 0) {
                    masks[i] |= prerequisites[j];
                }
            }
        }

        for (int i = 1; i < (1 << n); i++) {
        // iterate all submask of masks[i]
        // if j == 0010, which means third course has been taken, j - 1 will be 2 - 1 = 1. Which is 0001 in binary form. 0001 & 0001 == 0001 and next iteration will be 1-1 = 0 which
        // ends the for loop.
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (count_bit(j) > k) {
                    continue;
                }
            // courseTaken is a number that stores all courses taken. (binary representation of wether certain course is taken or not) for example, 0100 means second course is already taken
            // when you print courseTaken, it is shown in decimal. 0100 will be 8. so 8 means only second course is being taken
            // if courseTaken is equal to total course offered by the university, return 0 (we only need 0 semester to take to total course that is left);
            // (1 << n) - 1 means all courses offered has been taken, for example, 1<<4 - 1 = (10000) base 2 - 1 which is 16 - 1 = 15 which is 1111 in binary form
            // 1111 means all course has been taken. So when courseTaken is 1111 in binary form and equal to (1 << n) - 1 (which is a condition that represent all courses has been taken)
            // return 0;
                int courseTaken = i ^ ((1 << n) - 1);
            // if courseTaken is a subset of masks[j], we satisfy all requirements
                if ((courseTaken & masks[j]) == masks[j]) {
                    dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
                }

            }
        }
        return dp[(1 << n) - 1];
}
// count how many 1's bit we got
private int count_bit(int mask) {
        if (mask == 0) {
            return 0;
        }
        return 1 + count_bit(mask & (mask - 1));
}