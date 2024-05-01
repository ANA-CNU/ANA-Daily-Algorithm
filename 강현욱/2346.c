#include <stdio.h>
int main()
{
	int num=0;
	scanf("%d",&num);
	int arr[num+1];
	int pri[num+1];
	for(int t=0;t<num+1;t++)
	{
		arr[t]=0;
		pri[t]=0;
	}
	int u=0;
	for(u=1;u<num+1;u++)
	{
		scanf("%d",&arr[u]);
	}
	int pointer=1;
	int count=0;
	pri[1]=pointer;
	for(u=2;u<num+1;u++)
	{
		count=arr[pointer];
		arr[pointer]=0;
		if(count>0)
		{
			while(count!=0)
			{
				pointer++;
				if (pointer > (sizeof(arr)/sizeof(int)-1))
				{
						pointer=1;
				}
				if(arr[pointer]==0)
				{
					continue;
				}
				count--;
			}
		}
		else if(count<0)
		{   
			count=-count;
			while(count!=0)
			{
				pointer--;
				if (pointer < 1) 
				{
						pointer=(sizeof(arr)/sizeof(int)-1);
				}
				if(arr[pointer]==0)
				{
					continue;
				}
				count--;
			}
		}
		pri[u]=pointer;
	}
	for(u=1;u<num+1;u++)
	{
		printf("%d ",pri[u]);
	}
	
}
