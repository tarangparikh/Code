#include<bits/stdc++.h>
using namespace std;
class maxc{
    public: 
        bool operator()(pair<int,long> a,pair<int,int> b){
             return a.first > b.first;
        }
};
int main(){
    int x,n; cin >> x >> n;;
    vector<int> d(n,0);
    for(int i = 0;i<n;i++) cin >> d[i];
    //set<int> set;
    set<pair<int,int>, maxc> hash;
    set<int> sett;
    hash.insert({x,1});
    sett.insert(0);
    sett.insert(x);
    for(int e : d){
        // for(int x : sett){
        //     cout << x << " ";
        // }
        // cout << endl;
        // for(auto &x : hash){
        //     cout << "(" <<x.first << ", " << x.second << ")";
        // }
        // cout << endl;

        // cout << endl;
        if(sett.find(e) == sett.end()){
            int l = *sett.upper_bound(e);
            int h = *(--sett.lower_bound(e));
            //cout << l << " " << h << endl;
            pair<int,int> p = *hash.find({l - h,0});
            hash.erase(p);
            if(p.second > 1){
                p.second-=1;
                hash.insert(p);
            }
            int a = l - e;
            int b = e - h;
            if(hash.find({a,0})==hash.end()){
                hash.insert({a,1});
            }else{
                pair<int,int>  p = *hash.find({a,0});
                hash.erase(p);
                p.second+=1;
                hash.insert(p);
            }

            if(hash.find({b,0})==hash.end()){
                hash.insert({b,1});
            }else{
                pair<int,int>  p = *hash.find({b,0});
                hash.erase(p);
                p.second+=1;
                hash.insert(p);
            }
            sett.insert(e);
        }
        pair<int,int> p = *hash.begin();
        cout << p.first << " ";
    }
    return 0;
}