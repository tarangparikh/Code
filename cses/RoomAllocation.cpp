#include<bits/stdc++.h>
using namespace std;

int main(){
    int n; cin >> n;
    vector<vector<int>> q;
    for(int i = 0;i<n;i++){
        vector<int> qq(2);
        for(int i = 0;i<2;i++)
            cin >> qq[i];
        qq.push_back(i);
        q.push_back(qq);
    }
    vector<int> allotment(n,0);
    priority_queue<int> free;
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> que;
    
    
    sort(q.begin(),q.end(),[](auto &a,auto &b){
        return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
    });

    int total = 0;
    for(auto &x : q){
        int arr = x[0];
        while(!que.empty() && que.top().first < arr){
            free.push(que.top().second);
            que.pop();
        }
        if(free.empty()){
            total += 1;
            que.push({x[1] , total});
            allotment[x[2]] = total;
        }else{
            que.push({x[1], free.top()});
            allotment[x[2]] = free.top();
            free.pop();
        }
    }
    cout << total << endl;
    for(int x : allotment){
        cout << x << " ";
    }
    cout << endl;
    return 0;
}