/**
 * 有1000瓶水，3个瓶子可以再换1瓶，一共可以喝多少瓶？
 * 我以前写过博客：https://www.cnblogs.com/dreamkunk/p/6528630.html。挺多人阅读的
 * 分析如下：
 *
 * 1000分为能被3整除的，和不能整除的。1000=999+1：999又可以换333瓶水，1可以先放着，等和后面换的凑成3的倍数，
 * 就可以接着换了（没换到也计入总数）。然后333瓶接着换..., 结果为1499
 *
 * 写成程序分析如下
 *
 * 方法1：假设一开始有n瓶水，f(n) = n/3*3 + f(n/3 + n%3)，当n<3，直接返回n
 *
 * 方法2：模拟真实喝水过程，1瓶1瓶的喝，累计到3个空瓶子就去再换1瓶，然后手里水的个数就加1。喝1瓶水total加1，直到水为0.
 */
public class Count1000Water {
    public static void main(String[] args) {
        System.out.println(f(1000));
        System.out.println(g(1000));
    }

    //算法1
    static int f(int n) {
        if (n < 3) return n;
        int m = n / 3 * 3;
        int t = n % 3 + n / 3;
        return m + f(t);
    }

    //算法2
    static int g(int n) {
        int total = 0;
        int counter = 0;
        while (n > 0) {
            --n;
            ++total;
            ++counter;
            if (counter == 3) {
                counter = 0;
                ++n;
            }
        }
        return total;
    }
}