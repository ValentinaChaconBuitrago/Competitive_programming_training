    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int numRotations = d%n;

        int[] first_part = Arrays.copyOfRange(a,numRotations,n);
        int[] second_part = Arrays.copyOfRange(a,0,numRotations);

        int fLength = first_part.length;
        int sLength = second_part.length;
        int[] ans = new int[fLength + sLength];

        System.arraycopy(first_part,0,ans,0,fLength);
        System.arraycopy(second_part,0,ans,fLength,sLength);

        return ans;
    }