package class157;

// 更为厉害，C++版
// 测试链接 : https://www.luogu.com.cn/problem/P3899
// 如下实现是C++的版本，C++版本和java版本逻辑完全一样
// 提交如下代码，可以通过所有测试用例

//#include <bits/stdc++.h>
//
//using namespace std;
//
//static const int MAXN = 300001;
//static const int MAXM = MAXN * 22;
//int n, q;
//
//int head[MAXN];
//int to[MAXN << 1];
//int nxt[MAXN << 1];
//int cntg = 0;
//
//int root[MAXN];
//int ls[MAXM];
//int rs[MAXM];
//long long sum[MAXM];
//int cntt = 0;
//
//int dep[MAXN];
//int siz[MAXN];
//int dfn[MAXN];
//int cntd = 0;
//
//void addEdge(int u, int v) {
//    nxt[++cntg] = head[u];
//    to[cntg] = v;
//    head[u] = cntg;
//}
//
//int build(int l, int r) {
//    int rt = ++cntt;
//    sum[rt] = 0LL;
//    if (l < r) {
//        int mid = (l + r) >> 1;
//        ls[rt] = build(l, mid);
//        rs[rt] = build(mid + 1, r);
//    }
//    return rt;
//}
//
//int add(int jobi, long long jobv, int l, int r, int i) {
//    int rt = ++cntt;
//    ls[rt] = ls[i];
//    rs[rt] = rs[i];
//    sum[rt] = sum[i] + jobv;
//    if (l < r) {
//        int mid = (l + r) >> 1;
//        if (jobi <= mid) {
//            ls[rt] = add(jobi, jobv, l, mid, ls[rt]);
//        } else {
//            rs[rt] = add(jobi, jobv, mid + 1, r, rs[rt]);
//        }
//    }
//    return rt;
//}
//
//long long query(int jobl, int jobr, int l, int r, int u, int v) {
//    if (jobl <= l && r <= jobr) {
//        return sum[v] - sum[u];
//    }
//    long long ans = 0;
//    int mid = (l + r) >> 1;
//    if (jobl <= mid) {
//        ans += query(jobl, jobr, l, mid, ls[u], ls[v]);
//    }
//    if (jobr > mid) {
//        ans += query(jobl, jobr, mid + 1, r, rs[u], rs[v]);
//    }
//    return ans;
//}
//
//void dfs1(int u, int f) {
//    dep[u] = dep[f] + 1;
//    siz[u] = 1;
//    dfn[u] = ++cntd;
//    for (int ei = head[u]; ei > 0; ei = nxt[ei]) {
//        if (to[ei] != f) {
//            dfs1(to[ei], u);
//        }
//    }
//    for (int ei = head[u]; ei > 0; ei = nxt[ei]) {
//        if (to[ei] != f) {
//            siz[u] += siz[to[ei]];
//        }
//    }
//}
//
//void dfs2(int u, int f) {
//    root[dfn[u]] = add(dep[u], (long long)siz[u] - 1, 1, n, root[dfn[u] - 1]);
//    for (int ei = head[u]; ei > 0; ei = nxt[ei]) {
//        if (to[ei] != f) {
//            dfs2(to[ei], u);
//        }
//    }
//}
//
//long long compute(int p, int k) {
//    long long ans = query(dep[p] + 1, dep[p] + k, 1, n, root[dfn[p] - 1], root[dfn[p] + siz[p] - 1]);
//    ans += (long long)(siz[p] - 1) * min(k, dep[p] - 1);
//    return ans;
//}
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    cin >> n >> q;
//    for (int i = 1; i < n; i++) {
//        int u, v;
//        cin >> u >> v;
//        addEdge(u, v);
//        addEdge(v, u);
//    }
//    root[0] = build(1, n);
//    dfs1(1, 0);
//    dfs2(1, 0);
//    for(int i = 1; i <= q; i++) {
//        int p, k;
//        cin >> p >> k;
//        cout << compute(p, k) << "\n";
//    }
//    return 0;
//}