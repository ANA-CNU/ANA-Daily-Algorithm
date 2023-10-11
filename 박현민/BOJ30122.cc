#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll con[3],arr[505050],k;
int N,m,swep[505050],rswep[505050],node[2020202];
void init(int n,int s,int e) {
	if(s == e) {
		node[n] = rswep[s] - s + 1;
		return;
	}
	int mid = (s+e)/2;
	init(n*2,s,mid);
	init(n*2+1,mid+1,e);
	node[n]=max(node[n*2],node[n*2+1]);
}
int query(int n,int s,int e,int l,int r) {
	if(r<s||e<l) return 0;
	if(l<=s&&e<=r) return node[n];
	int mid = (s+e)/2;
	return max(query(n*2,s,mid,l,r),query(n*2+1,mid+1,e,l,r));
}
ll Val(ll x) {
	return x*x*con[0]-x*con[1]+con[2];
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>k;
	for(int i=1;i<=N;i++) {
		cin>>arr[i];
	}
	int l = 1,r = 1;
	con[0]+=1,con[1]+=2*arr[1],con[2]+=arr[1]*arr[1];
	while(r <= N) {
		ll mi = con[1]/con[0];
		if(min(Val(mi/2),Val(mi/2+1LL)) <= k) {
			swep[r] = l;
			r++;
			con[0]+=1,con[1]+=2*arr[r],con[2]+=arr[r]*arr[r];
		}
		else{
			rswep[l] = r-1;
			con[0]-=1,con[1]-=2*arr[l],con[2]-=arr[l]*arr[l];
			l++;
		}
	}
	for(int i=l;i<=N;i++) rswep[i] = N;
	init(1,1,N);
	cin>>m;
	for(int i=0;i<m;i++) {
		int st,ed;cin>>st>>ed;
		if(swep[ed] <= st) cout<<ed-st+1<<'\n';
		else {
			cout<<max(ed-swep[ed]+1,query(1,1,N,st,swep[ed]-1))<<'\n';
		}
	}
	return 0;
}
