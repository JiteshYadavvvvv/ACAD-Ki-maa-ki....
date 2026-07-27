#include<bits/stdc++.h>
using namespace std;
void bubs(int a[], int n){
    int c=0;
    for(int i=1;i<n;i++){
        int j=i;
        while(j>0&&a[j]<a[j-1]){
            swap(a[j],a[j-1]);
            j--;
        }
    }
    for(int i=0;i<n;i++)cout<<a[i]<<" ";
}
void sels(int a[], int n){
    int c=0;
    for(int i=1;i<n;i++){
    	for(int j=i;j<n;j++){
    	}
    }

}




int main(){
    int n;
    cout<<"Enter number of elements";
    cin>>n;
    int a[n];
    cout<<"Enter elements";
    for(int i=0;i<n;i++)cin>>a[i];
    cout<<"Enter\n 1.Bubble Sort\n 2.Selection sort";
    int x;
    cin>>x;
    if((x-1))sels(a,n);
    else bubs(a,n);
}
