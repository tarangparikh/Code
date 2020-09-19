#include<bits/stdc++.h>
using namespace std;
class minc{
    public: 
        bool operator()(pair<int,long> a,pair<int,int> b){
             return a.first < b.first;
        }
};
int main(){
    int n,m; cin >> n >> m;
    vector<int> d(n,0);
    vector<int> t(m,0);
    for(int i = 0;i<n;i++) cin >> d[i];
    for(int i = 0;i<m;i++) cin >> t[i];
    set<pair<int,int>, minc> hash;
    for(int e : d){
        if(hash.find({e,0}) == hash.end()){
            hash.insert({e,1});
        }else{
            pair<int,int>  p = *hash.find({e,0});
            hash.erase(hash.find({e,0}));
            p.second+=1;
            hash.insert(p);
        }
    }
    int onecount = 0;;
    for(int e : t) if(e == 1) onecount++;
    int nn = 0;
    for(int e : t){
        if(++nn == m && onecount == 200000){
            cout << -1 << endl;
            continue;
        }
        //cout << nn << " " << onecount << endl;
        if(hash.empty()){
            cout << -1 << endl;
            continue;
        }
        if(hash.lower_bound({e,0}) != hash.end()){
            pair<int,int> p = *hash.lower_bound({e,0});
            if(p.first > e){
                if(--hash.lower_bound({e,0}) == hash.end()){
                    cout << -1 << endl;
                    continue;
                }else{
                    p = *(--hash.lower_bound({e,0}));
                    cout << p.first << endl;
                    hash.erase(--hash.lower_bound({e,0}));
                    if(p.second > 1){
                        hash.insert({p.first,p.second - 1});
                    }
                }
            }else{
                cout << p.first << endl;
                hash.erase(hash.lower_bound({e,0}));
                if(p.second > 1){
                    hash.insert({p.first,p.second - 1});
                }
            }
        }else{
            if(--hash.lower_bound({e,0}) == hash.end()){
                cout << -1 << endl;
                continue;
            }else{
                pair<int,int> p = *(--hash.lower_bound({e,0}));
                cout << p.first << endl;
                hash.erase(--hash.lower_bound({e,0}));
                if(p.second > 1){
                    hash.insert({p.first,p.second - 1});
                }
            }
        }
        
    }

    return 0;
}