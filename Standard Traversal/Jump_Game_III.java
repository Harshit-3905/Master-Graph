class Jump_Game_III {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        return helper(arr, start, vis);
    }

    boolean helper(int[] arr, int index, boolean[] vis) {
        if (arr[index] == 0)
            return true;
        vis[index] = true;
        boolean ans = false;
        if (index - arr[index] >= 0 && vis[index - arr[index]] == false)
            ans |= helper(arr, index - arr[index], vis);
        if (index + arr[index] < arr.length && vis[index + arr[index]] == false)
            ans |= helper(arr, index + arr[index], vis);
        return ans;
    }
}