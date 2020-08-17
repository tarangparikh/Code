#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;

int main(){
    int n; cin >> n;
    vi hash(101,0);
    for(int i = 0,t;i<n;i++){
        cin >> t;
        hash[t]++;
    }
    int count = 0;
    for(int e : hash)
        count += e>>1;
    cout << count << "\n";
    return 0;
}