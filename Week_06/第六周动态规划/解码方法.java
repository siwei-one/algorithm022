public class 解码方法 {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int len = s.length();
        if (len <= 1) {
            return len;
        }

        int[] dp = new int[len];
        char[] charArray = s.toCharArray();
        dp[0] = 1;
        // 25
        if (Integer.parseInt(s.substring(0, 2)) <= 26) {
            if (charArray[1] == '0') {
                dp[1] = 1;
            } else {
                dp[1] = 2;
            }
        } else { // 77
            if (charArray[1] == '0') {
                dp[1] = 0;
            } else {
                dp[1] = 1;
            }
        }


        for (int i = 2; i < len; i ++) {
            if (charArray[i] == '0') {
                if (charArray[i - 1] == '0') {
                    // 出现 200这种情况，直接为0种解法
                    return 0;
                } else {
                    if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                        dp[i] = dp[i - 2];
                    } else { // 230 270 后面两个数字大于26 0种解法
                        return 0;
                    }
                }
            } else { // 123
                if (charArray[i - 1] == '0') { // 102
                    dp[i] = dp[i - 1];
                } else { // 123
                    if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    } else { // 233 273 后面两个数字大于26
                        dp[i] = dp[i - 1];
                    }

                }
            }
        }

        return dp[len - 1];
    }

}