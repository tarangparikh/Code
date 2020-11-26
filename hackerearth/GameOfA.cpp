#include<bits/stdc++.h>
using namespace std;
int main(){
    int N = 1000001;
    vector<int> dp(N,0);
    for(int i = 1;i<N;i++){
        int mini = 1000000009;
         for(int j = 2;j<=sqrt(i);j++)
                if((i % j) == 0)
                    mini = min(mini, 1 + dp[max(i / j, j)]);
        dp[i] = mini = min(mini, 1 + dp[i - 1]);
    }
    int T; cin >> T;
    int maxi = dp[0];
    for(int e : dp){
        maxi = max(maxi,e);
    }
    cout << "maxi : " << maxi << endl;
    while(T--){
        int n; cin >> n;
        cout << dp[n] << endl;
    }
    return 0;
}