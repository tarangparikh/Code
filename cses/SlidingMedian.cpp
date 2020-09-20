#include<bits/stdc++.h>
using namespace std;
class minc{ 
    public: 
        bool operator()(pair<int,int> a,pair<int,int> b){
             return a.second == b.second ? a.first < b.first : a.second < b.second;
        }
};
class maxc{
    public:
        bool operator()(pair<int,int> a,pair<int,int> b){
            return a.second == b.second ? a.first < b.first : a.second > b.second;
        }
};

void printMax(set<pair<int,int> , maxc> max){
    cout << "status : --------" << endl;
    for(auto &x : max){
        cout <<  "[" << x.first << ", " << x.second <<"]" << endl;
    }
    cout << "-----------------" << endl;
}
void printMin(set<pair<int,int> , minc> min){
    cout << "status : --------" << endl;
    for(auto &x : min){
        cout <<  "[" << x.first << ", " << x.second <<"]" << endl;
    }
    cout << "-----------------" << endl;
}

int add(set<pair<int,int>,maxc>& max, set<pair<int,int>,minc>& min, pair<int,int> p ){
    int n = max.size();
    int m = min.size();
    //cout << n << " " << m << endl;
    if( n == m){
        if(n==0) max.insert(p);
        else{
            pair<int,int> r = *max.begin();
            if(p.second > r.second) min.insert(p);
            else max.insert(p); 
        }
    }else{
        pair<int,int> r;

        if(n > m){
            r = *max.begin();
            max.erase(max.begin());
        }else{
            r = *min.begin();
            min.erase(min.begin());
        }

        // cout<< r.first << " " << r.second << endl;
        // cout<< p.first << " " << p.second << endl;

        if(r.second > p.second){
            min.insert(r);
            max.insert(p);
        }else{
            min.insert(p);
            max.insert(r);
        }

    }

    pair<int,int> s;
    if(max.size() >= min.size()) s = *max.begin();
    else s = *min.begin();

    // printMax(max);
    // printMin(min);

    

    return s.second;
}

int remove(set<pair<int,int>,maxc>& max, set<pair<int,int>,minc>& min, pair<int,int> p){
    if(min.find(p) != min.end()) min.erase(p);
    else max.erase(p);

    int n = max.size();
    int m = min.size();

    if(n > m + 1){
        pair<int,int> in = *max.begin();
        max.erase(max.begin());
        min.insert(in);
    }
    else if(m > n + 1){
        pair<int,int> in = *min.begin();
        min.erase(min.begin());
        max.insert(in);
    }

    pair<int,int> s;
    if(max.size() >= min.size()) s = *max.begin();
    else s = *min.begin();
    //cout << s.second << " : removed" << endl;
    return s.second;
}


int main(){
    set<pair<int,int>,maxc> max;
    set<pair<int,int>,minc> min;

    int n,k; cin >> n >> k;
    vector<int> d(n,0);
    for(int i = 0;i<n;i++) cin >> d[i];
    int median;
    for(auto i = 0 ; i!=d.size() ; i++){
        median = add(max,min,{i,d[i]});
        if(i - k >= 0) median = remove(max,min,{i-k,d[i - k]});
        if(i >= k - 1) cout << median << " "; 
    }

    return 0;
}