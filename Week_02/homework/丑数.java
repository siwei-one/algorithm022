public class 丑数 {

    /**
     *
     * 把三个数组简化成一个数组如下：
     * 1.第一个丑数是1，分别被p2,p3,p5三个指针指向。三个指针分别代表该丑数等待被 * 2 * 3 * 5,或者说是该丑数是否通过* 2 * 3 * 5产生过新丑数的标识（正是因为只是标识，没必要想象三个指针三个数组七里八里的，一个数组就能理解了，每个数三个指针三个标识，用完即用来白标识别的数，就这三个标识一直复用。）
     * （再多说点，这种理解其实用面向对象的思想比较好理解，用指针作为标识还是很别扭的，把每个丑数看成对象，指针看成flag成员变量，保证最多三个对象flag=true）。
     * 2.当一个丑数已经被* 2 * 3 * 5后，对于生成丑数已经没有用了，我们把对应指针前移一位（即复用标识），让下一个丑数等待被*来生成新丑数。
     * 3.每次计算出来个三个丑数的最小的一个作为新丑数加入，然后判断是通过 * 多少得到的来后移对应指针。（这里记得去重）
     * 通过123我们可以发现，我们每次生成的都是最小的丑数（保证是升序），并且每个丑数都尝试过被 *2 *3 *5（保证无遗漏）
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0 , b = 0, c = 0;
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 1; i < n; i ++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            int min = Math.min(Math.min(n2, n3), n5);
            dp[i] = min;
            if (dp[i] == n2) {
                a ++;
            }
            if (dp[i] == n3) {
                b ++;
            }
            if (dp[i] == n5) {
                c ++;
            }
        }

        return dp[n - 1];
    }

}
