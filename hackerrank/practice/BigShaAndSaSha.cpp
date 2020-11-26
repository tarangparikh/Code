#include<bits/stdc++.h>
using namespace std;
int main(){
    long N,K; cin >> N >> K;
    if(K == 1){
        cout << N << endl;
    }else{
        long C = 0;
        for(;N>0;N/=K) C += N % K;
        cout << C << endl;
    }
    return 0;
}