#include <bits/stdc++.h>
using namespace std;
bool comp(pair<int,int> a,pair<int,int> b){
            return a.first < b.first;
}
int bs1(vector<pair<int,int>>& d,int i,int j,int v){
        int mid = (i+j) >> 1;
        while(i < j){
            mid = (i+j)>>1;
            if(v <= d[mid].first) j=mid;
            else i = mid+1;
        }
        mid = (i + j) >> 1;
        return d[mid].first == v ? mid : d[mid].first < v ? -mid - 2 : -mid - 1;
}
int main(){
    int n; cin >> n;
    vector<pair<int,int>> d(n);
    for(int i = 0;i<n;i++){
        int a,b; cin >> a >> b;
        d[i] = make_pair(a,b);
    }
    sort(d.begin(),d.end(),comp);
    vector<int> max_till(n + 1,0);
    for(int i = n-1 ;i>=0;i--){
        int index = bs1(d,i + 1,n - 1,d[i].second);
        if(index  < 0) index = -(index + 1);
        max_till[i] = max(1 + max_till[index],max_till[i+1]);
    } 
    cout << max_till[0] << endl;
    return 0;
}