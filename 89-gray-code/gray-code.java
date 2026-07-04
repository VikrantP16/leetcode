class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> l1=new ArrayList<>();
        int e=((int)Math.pow(2,n))-1;
        for(int i=0;i<=e;i++){
            l1.add(i^(i>>1));
        }
        return l1;
    }
}