public class 分发饼干 {
    // 贪心
    public int findContentChildren(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        for (int i = 0; count < g.length && i < s.length; i++) {
            // 如果当前饼干能满足当前孩子的胃口值，count就加1，否则就继续查找更大的饼干
            if (s[i] >= g[count]) {
                count++;
            }
        }

        return count;

    }

}