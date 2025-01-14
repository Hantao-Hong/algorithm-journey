package class157;

// 可持久化线段树模版题，C++版
// 给定一个长度为n的数组arr，下标1~n，一共有q条查询
// 每条查询 l r k : 打印arr[l..r]中第k小的数字
// 1 <= n、q <= 2 * 10^5
// 测试链接 : https://www.luogu.com.cn/problem/P3834
// 如下实现是C++的版本，C++版本和java版本逻辑完全一样
// 提交如下代码，可以通过所有测试用例

//#include <bits/stdc++.h>
//
//using namespace std;
//
//const int MAXN = 200001;
//const int MAXM = MAXN * 22;
//int n, q;
//int arr[MAXN];
//int sorted[MAXN];
//int root[MAXN];
//int ls[MAXM];
//int rs[MAXM];
//int size[MAXM];
//int cnt;
//
//int kth(int num) {
//    int l = 1, r = n, m, ans = 0;
//    while (l <= r) {
//        m = (l + r) / 2;
//        if (sorted[m] <= num) {
//            ans = m;
//            l = m + 1;
//        } else {
//            r = m - 1;
//        }
//    }
//    return ans;
//}
//
//int build(int l, int r) {
//    int rt = ++cnt;
//    size[rt] = 0;
//    if (l < r) {
//        int mid = (l + r) / 2;
//        ls[rt] = build(l, mid);
//        rs[rt] = build(mid + 1, r);
//    }
//    return rt;
//}
//
//int insert(int jobi, int l, int r, int i) {
//    int rt = ++cnt;
//    ls[rt] = ls[i];
//    rs[rt] = rs[i];
//    size[rt] = size[i] + 1;
//    if (l < r) {
//        int mid = (l + r) / 2;
//        if (jobi <= mid) {
//            ls[rt] = insert(jobi, l, mid, ls[rt]);
//        } else {
//            rs[rt] = insert(jobi, mid + 1, r, rs[rt]);
//        }
//    }
//    return rt;
//}
//
//int query(int jobk, int l, int r, int u, int v) {
//    if (l == r) {
//        return l;
//    }
//    int lsize = size[ls[v]] - size[ls[u]];
//    int mid = (l + r) / 2;
//    if (lsize >= jobk) {
//        return query(jobk, l, mid, ls[u], ls[v]);
//    } else {
//        return query(jobk - lsize, mid + 1, r, rs[u], rs[v]);
//    }
//}
//
//void prepare() {
//    cnt = 0;
//    for (int i = 1; i <= n; i++) {
//        sorted[i] = arr[i];
//    }
//    sort(sorted + 1, sorted + n + 1);
//    root[0] = build(1, n);
//    for (int i = 1, x; i <= n; i++) {
//        x = kth(arr[i]);
//        root[i] = insert(x, 1, n, root[i - 1]);
//    }
//}
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    cin >> n >> q;
//    for (int i = 1; i <= n; i++) {
//        cin >> arr[i];
//    }
//    prepare();
//    for (int i = 1, l, r, k; i <= q; i++) {
//        cin >> l >> r >> k;
//        int ans = query(k, 1, n, root[l - 1], root[r]);
//        cout << sorted[ans] << '\n';
//    }
//    return 0;
//}