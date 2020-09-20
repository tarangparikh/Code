#include <bits/stdc++.h>
using namespace std;

long mod = 1000000007;

long p(long a,long b){
    long p = 1l;
    for(;b>0;a=a*a%mod,b>>=1)
        if(b&1) p=p*a%mod;
    return p;
}

int main(){
    int t; cin >> t;
    int size = 1000001;
    vector<long> f(size , 0);
    vector<long> fi(size, 0);
    f[0] = 1;
    fi[0] = 1;
    for(int i = 1;i<size;i++){
        f[i] = i * f[i-1] % mod;
        fi[i] = p(f[i],mod - 2);
    }
    while(t-->0){
        int a,b; cin >> a >> b;
        long ans = (f[a] * ((fi[a-b] * fi[b])%mod))%mod;
        cout << ans << endl;
    }
    return 0;
}