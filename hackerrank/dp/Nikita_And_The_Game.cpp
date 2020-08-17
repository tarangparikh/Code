#include <bits/stdc++.h>
using namespace std;
typedef vector<long> vi;
typedef long long ll;


int lb(vi d,int i,int j,long v){
    while(i<j){
        int mid = (i + j)>>1;
        if(v<=d[mid]) j = mid;
            else i = mid+1;
    }
    if(i>=d.size() || d[i] != v) return -1;
    return i;
}

long dfs(vi p,int s,int e){
    if(e-s<1) return 0;
    long sum = p[e] - p[s-1];
    if(sum%2==1) return 0;
    sum>>=1;
    long find = p[s-1] + sum;
    int index = lb(p,s,e,find);
    if(index < 0) return 0;
    long a = dfs(p,s,index);
    long b = dfs(p,index+1,e);
    return max(a+1,b+1);
}



int main(){
    ios_base::sync_with_stdio(0);
    int t; cin >> t;
    while(t-->0){
        int n; cin >> n;
        vi p(n+1,0);
        for(int i = 1,h=p.size();i<h;i++){
            cin >> p[i];
            p[i] += p[i-1];
        }
        cout << dfs(p,1,p.size() - 1) << "\n";
    }
}

vi ni(int n){
    vi s(n,0);
    for(int i = 0;i<n;i++)
        cin >> s[i];
    return s;
}