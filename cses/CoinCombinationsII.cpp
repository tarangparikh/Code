#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,x;
    long mod = 1000000007;
    cin >> n >> x;
    vector<int> d(n , 0);
    vector<long> dp(x+1,0);
    dp[0] = 1;
    for(int i = 0;i<n;i++) cin >> d[i];
    for(int i = 0;i<n;i++)
        for(int j = 1,h=x+1;j<h;j++)
            dp[j] = (dp[j] + ( j - d[i] >= 0 ? dp[j - d[i]] : 0))%mod;
    cout << dp[x];
    return 0;
}