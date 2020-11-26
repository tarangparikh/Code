#include <bits/stdc++.h>
using namespace std;

int main(){
    int n; cin >> n;
    int s; cin >> s;
    int mod = 1000000007;
    vector<int> d(n,0);
    vector<int> dp(s+1,0);
    for(int i = 0;i<n;i++) cin >> d[i];
    dp[0] = 1;
    for(int i = 1;i<=s;i++)
        for(int j  = 0;j<n;j++)
            dp[i] = i - d[j] >= 0 ? (dp[i] + dp[i - d[j]]) % mod : dp[i];
    cout << dp[s] << endl;
    return 0;
}