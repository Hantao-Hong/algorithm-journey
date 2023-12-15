package class085;

// 范围内的数字计数
// 给定两个正整数a和b，求在[a,b] 中的所有整数中
// 每个数码(digit)各出现了多少次
// 测试链接 : https://www.luogu.com.cn/problem/P2602
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code04_DigitCount2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			long a = (long) in.nval;
			in.nextToken();
			long b = (long) in.nval;
			for (int i = 0; i < 9; i++) {
				out.print(digitsCount(i, a, b) + " ");
			}
			out.println(digitsCount(9, a, b));
		}
		out.flush();
		out.close();
		br.close();
	}

	public static long digitsCount(int d, long low, long high) {
		return count(high, d) - count(low - 1, d);
	}

	public static long count(long n, int d) {
		long ans = 0;
		for (long i = 1, tmp = n, high, cur; tmp != 0; i *= 10, tmp /= 10) {
			high = tmp / 10;
			if (d == 0) {
				if (high == 0) {
					break;
				}
				high--;
			}
			ans += high * i;
			cur = tmp % 10;
			if (cur > d) {
				ans += i;
			} else if (cur == d) {
				ans += n % i + 1;
			}
		}
		return ans;
	}

}
