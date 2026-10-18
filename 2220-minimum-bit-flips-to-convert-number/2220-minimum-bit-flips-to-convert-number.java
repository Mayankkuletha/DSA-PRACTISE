class Solution {
    public int minBitFlips(int start, int goal) {
        int Xor = start ^ goal;
        return Integer.bitCount(Xor);
    }
}