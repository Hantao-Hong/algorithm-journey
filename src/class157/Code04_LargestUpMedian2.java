package class157;

// 区间最大上中位数，C++版
// 给定一个长度为n的数组arr，下标1~n，一共有q条查询
// 每条查询 a b c d : 左端点在[a,b]之间、右端点在[c,d]之间，保证a<b<c<d
//                   哪个区间有最大的上中位数，打印最大的上中位数
// 题目有强制在线的要求，上一次打印的答案为lastAns，初始时lastAns = 0
// 每次给定四个参数，按照如下方式得到a、b、c、d，查询完成后更新lastAns
// (给定的每个参数 + lastAns) % n + 1，得到四个值，从小到大对应a、b、c、d
// 1 <= n <= 20000
// 1 <= q <= 25000
// 1 <= arr[i] <= 10^9
// 测试链接 : https://www.luogu.com.cn/problem/P2839
// 如下实现是C++的版本，C++版本和java版本逻辑完全一样
// 提交如下代码，可以通过所有测试用例

//#include <bits/stdc++.h>
//
//using namespace std;
//
//const int MAXN = 20001;
//const int MAXM = MAXN * 20;
//const int INF = 10000001;
//int n, q;
//vector<pair<int, int>> arr;
//int root[MAXN];
//int ls[MAXM];
//int rs[MAXM];
//int pre[MAXM];
//int suf[MAXM];
//int sum[MAXM];
//int cnt;
//int ques[4], info[3];
//
//int build(int l, int r) {
//    int rt = ++cnt;
//    pre[rt] = suf[rt] = sum[rt] = r - l + 1;
//    if (l < r) {
//        int mid = (l + r) / 2;
//        ls[rt] = build(l, mid);
//        rs[rt] = build(mid + 1, r);
//    }
//    return rt;
//}
//
//void up(int i) {
//    pre[i] = max(pre[ls[i]], sum[ls[i]] + pre[rs[i]]);
//    suf[i] = max(suf[rs[i]], suf[ls[i]] + sum[rs[i]]);
//    sum[i] = sum[ls[i]] + sum[rs[i]];
//}
//
//int update(int jobi, int l, int r, int i) {
//    int rt = ++cnt;
//    ls[rt] = ls[i];
//    rs[rt] = rs[i];
//    pre[rt] = pre[i];
//    suf[rt] = suf[i];
//    sum[rt] = sum[i];
//    if (l == r) {
//        pre[rt] = suf[rt] = sum[rt] = -1;
//    } else {
//        int mid = (l + r) / 2;
//        if (jobi <= mid) {
//            ls[rt] = update(jobi, l, mid, ls[rt]);
//        } else {
//            rs[rt] = update(jobi, mid + 1, r, rs[rt]);
//        }
//        up(rt);
//    }
//    return rt;
//}
//
//void initInfo() {
//    info[0] = info[1] = -INF;
//    info[2] = 0;
//}
//
//void mergeRight(int r) {
//    info[0] = max(info[0], info[2] + pre[r]);
//    info[1] = max(suf[r], info[1] + sum[r]);
//    info[2] += sum[r];
//}
//
//void query(int jobl, int jobr, int l, int r, int i) {
//    if (jobl <= l && r <= jobr) {
//        mergeRight(i);
//    } else {
//        int mid = (l + r) / 2;
//        if (jobl <= mid) {
//            query(jobl, jobr, l, mid, ls[i]);
//        }
//        if (jobr > mid) {
//            query(jobl, jobr, mid + 1, r, rs[i]);
//        }
//    }
//}
//
//void prepare() {
//    sort(arr.begin() + 1, arr.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
//        return a.second < b.second;
//    });
//    cnt = 0;
//    root[1] = build(1, n);
//    for (int i = 2; i <= n; i++) {
//        root[i] = update(arr[i - 1].first, 1, n, root[i - 1]);
//    }
//}
//
//bool check(int a, int b, int c, int d, int v) {
//    initInfo();
//    query(a, b, 1, n, root[v]);
//    int best = info[1];
//    initInfo();
//    query(c, d, 1, n, root[v]);
//    best += info[0];
//    if (b + 1 <= c - 1) {
//        initInfo();
//        query(b + 1, c - 1, 1, n, root[v]);
//        best += info[2];
//    }
//    return best >= 0;
//}
//
//int compute(int a, int b, int c, int d) {
//    int l = 1, r = n, m, ans = 0;
//    while (l <= r) {
//        m = (l + r) / 2;
//        if (check(a, b, c, d, m)) {
//            ans = arr[m].second;
//            l = m + 1;
//        } else {
//            r = m - 1;
//        }
//    }
//    return ans;
//}
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    cin >> n;
//    arr.resize(n + 1);
//    for (int i = 1; i <= n; i++) {
//        arr[i].first = i;
//        cin >> arr[i].second;
//    }
//    prepare();
//    cin >> q;
//    for (int i = 1, lastAns = 0; i <= q; i++) {
//        for (int j = 0; j < 4; j++) {
//            cin >> ques[j];
//            ques[j] = (ques[j] + lastAns) % n + 1;
//        }
//        sort(ques, ques + 4);
//        lastAns = compute(ques[0], ques[1], ques[2], ques[3]);
//        cout << lastAns << '\n';
//    }
//    return 0;
//}