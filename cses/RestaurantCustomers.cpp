#include <bits/stdc++.h>
using namespace std;
class minc{
    public: 
        bool operator()(pair<int,long> a,pair<int,int> b){
             return a.first < b.first;
        }
};
int main(){
    set<pair<int,long>, minc> min;
    int n; cin >> n;
    for(int i = 0;i<n;i++){
        int a,b; cin >> a >> b;
        if(min.find({a,0}) == min.end()){
            min.insert({a,1});
        }else{
            pair<int,long> p = *min.find({a,0});
            min.erase(min.find({a,0}));
            p.second += 1;
            min.insert(p);
        }
       
        if(min.find({b+1,0}) == min.end()){
            min.insert({b+1,-1});
        }else{
            pair<int,long> p = *min.find({b+1,0});
            min.erase(min.find({b+1,0}));
            p.second -= 1;
            min.insert(p);
        }

        // for(auto &x : min){
        //     cout << x.first << " " << x.second << endl;
        // }
    }
    long maxi = 0;
    long cur = 0;
    for(auto &x : min){
        cur+=x.second;
        maxi = max(maxi,cur);
    }
    cout << maxi << endl;
    return 0;
}