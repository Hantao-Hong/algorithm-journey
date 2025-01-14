package class157;

// 区间内没有出现的最小自然数，C++版
// 给定一个长度为n的数组arr，下标1~n，一共有q条查询
// 每条查询 l r : 打印arr[l..r]内没有出现过的最小自然数，注意0是自然数
// 1 <= n、q、arr[i] <= 2 * 10^5
// 测试链接 : https://www.luogu.com.cn/problem/P4137
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
//int root[MAXN];
//int ls[MAXM];
//int rs[MAXM];
//int lateLeft[MAXM];
//int cnt;
//
//int build(int l, int r) {
//    int rt = ++cnt;
//    lateLeft[rt] = 0;
//    if (l < r) {
//        int mid = (l + r) / 2;
//        ls[rt] = build(l, mid);
//        rs[rt] = build(mid + 1, r);
//    }
//    return rt;
//}
//
//int update(int jobi, int jobv, int l, int r, int i) {
//    int rt = ++cnt;
//    ls[rt] = ls[i];
//    rs[rt] = rs[i];
//    lateLeft[rt] = lateLeft[i];
//    if (l == r) {
//        lateLeft[rt] = jobv;
//    } else {
//        int mid = (l + r) / 2;
//        if (jobi <= mid) {
//            ls[rt] = update(jobi, jobv, l, mid, ls[rt]);
//        } else {
//            rs[rt] = update(jobi, jobv, mid + 1, r, rs[rt]);
//        }
//        lateLeft[rt] = min(lateLeft[ls[rt]], lateLeft[rs[rt]]);
//    }
//    return rt;
//}
//
//int query(int pos, int l, int r, int i) {
//    if (l == r) {
//        return l;
//    }
//    int mid = (l + r) / 2;
//    if (lateLeft[ls[i]] < pos) {
//        return query(pos, l, mid, ls[i]);
//    } else {
//        return query(pos, mid + 1, r, rs[i]);
//    }
//}
//
//void prepare() {
//    cnt = 0;
//    root[0] = build(1, n);
//    for (int i = 1; i <= n; i++) {
//        if (arr[i] >= n) {
//            root[i] = root[i - 1];
//        } else {
//            root[i] = update(arr[i], i, 0, n, root[i - 1]);
//        }
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
//    for (int i = 0, l, r; i < q; i++) {
//        cin >> l >> r;
//        cout << query(l, 0, n, root[r]) << "\n";
//    }
//    return 0;
//}