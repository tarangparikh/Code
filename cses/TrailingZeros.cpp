#include<iostream> 
int main(){int c=0,n;std::cin>>n;for(long f=5;f<=n;c+=n/f,f*=5);std::cout<<c;}