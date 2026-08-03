#include<bits/stdc++.h>
using namespace std;
#define vvi vector<vector<int>>
#define vi vector<int>
#define ll long long
int ps(vi &v, int l, int r){
    int j=l-1;
    for(int i=l;i<r;i++){
        if(v[i]<v[r]){
            j++;
            swap(v[i],v[j]);
        }
    }
    swap(v[j+1],v[r]);
    return j+1;
}
void qs(vi &v, int l, int r){
    if(l>=r)return;
    int p=ps(v,l,r);
    //cout<<p;
    qs(v,l,p-1);
    qs(v,p+1,r);

}
signed main(){
    int n;
    cout<<"Enter size of array\n";
    cin>>n;
    vi v(n);
    for(int i=0;i<n;i++)cin>>v[i];
    qs(v,0,n-1);
    for(auto x: v)cout<<x<<" ";
}            
