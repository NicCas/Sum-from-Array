public class BinarySearch {
    private int[] possibleAddends;
    private int[] addends = new int[2];

    public BinarySearch(int[] userArray)
    {
        possibleAddends = userArray;
    }

    public int[] searchSum (int sum){
        int checkSum;
        for (int i = 0; i < possibleAddends.length; i++) {
            checkSum = sum - possibleAddends[i];
            if(binSearch(checkSum)){
                addends[0] = possibleAddends[i];
                return addends;
            }
        }
        return null;
    }

    /* Search for provided target # */
    private boolean binSearch(int target)
    {
        int left = 0, middle;
        int right = possibleAddends.length -1;

        while (left < right)
        {
            middle = left + (right-left) /2;

            // If the target is found then return it
            if (possibleAddends[middle] == target){
                addends[1] = possibleAddends[middle];
                return true;
            }

            // Else keep looking
            if (possibleAddends[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return false;
    }

}
