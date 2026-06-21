public boolean mr1(int [][]meetings)
{
    Arrays.sort(meetings,(a,b)->a[0]-b[0]);
    for(int i=1;i<meetings.length;i++)
    {
        int st_current = meetings[i][0];
        int end_prev = meetings[i-1][1];
        if(st_current<end_prev)
            return false;
    }
    return true;
}

public int mr2(int []st,int []et)
{
    Arrays.sort(st);
    Arrays.sort(et);
    int mr = 0;
    int cr = 0;
    int i=0;
    int j=0;
    while(i<st.length)
    {
        if(st[i]<et[j]) //I need a room
        {
            cr++;
            i++;
        }
        else // Room is free
        {
            cr--;
            j++;
        }
        mr = Math.max(mr,cr);
    }
    return mr;
}


public boolean canJump(int[] arr) {
    int mr  = 0;
    for(int i=0;i<arr.length;i++)
    {
        if(mr<i)
            return false;
        mr = Math.max(mr,i+arr[i]);
        if(mr == arr.length-1)
            return true;
    }
    return true;
}

public int jump(int[] nums) {
    int mr =0;
    int cr =0;
    int jump =0;

    for(int i=0;i<nums.length-1;i++)
    {
        mr = Math.max(mr,nums[i]+i);

        if(i==cr)
        {
            jump++;
            cr= mr;
        }
    }
    return jump;
}


public int canCompleteCircuit(int[] gas, int[] cost) {
    int tgas = 0;
    int tdist = 0;

    for(int i:gas)
        tgas+=i;

    for(int i:cost)
        tdist+=i;

    if(tdist>tgas)
        return -1;

    int fuel =0;
    int ans =0;
    for(int i=0;i<gas.length;i++)
    {
        int delta = gas[i]-cost[i];
        fuel+=delta;

        if(fuel<0)
        {
            ans=i+1;
            fuel = 0;
        }
    }
    return ans;
}