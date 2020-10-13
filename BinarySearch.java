public class BinarySearch {
    private int[] possibleAddends;
    private int[] addends = new int[2];
    public BinarySearch(int[] userArray)
    {
        possibleAddends = userArray;
    }

    public int[] search (int sum, boolean sorted){
        boolean searchSuccessful;

        // If unsorted then sort it
        if (!sorted) {
            quickSort(0, possibleAddends.length-1);
        }


        if(sum < 0)
        { // If the sum is negative start off by looking for [sum, 0] as the addends, if unsuccessful try [sum+i, -i]
            // Do not check duplicates (ie [2,4], [4,2])
            int cutOff = (int) Math.ceil(sum/2);

            // If (sum + i) exists check if -i exists
            for (int i = 0; i > cutOff; i--)
            {
                searchSuccessful = binSearch(sum - i, 0);

                if(searchSuccessful)
                {
                    searchSuccessful = binSearch(i,1);
                    if (searchSuccessful)
                        return addends;
                }

            }
        } else { // If the sum is positive start off by looking for [sum, 0] as the addends, if unsuccessful try [sum-i, i]
            int cutOff = (int) Math.floor(sum/2);

            // If (sum - i) exists check if i exists
            for (int i = 0; i < cutOff; i++)
            {
                searchSuccessful = binSearch(sum - i, 0);

                if(searchSuccessful)
                {
                    searchSuccessful = binSearch(i,1);
                    if (searchSuccessful)
                        return addends;
                }

            }
        }

        return null;
    }

    /* Search for provided target # */
    private boolean binSearch(int target, int index)
    {
        int left = 0, middle;
        int right = possibleAddends.length -1;

        while (left < right)
        {
            middle = left + (right-left) /2;

            // If the target is found then return it
            if (possibleAddends[middle] == target){
                addends[index] = possibleAddends[middle];
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

    /* To be called if an unsorted array is passed in */
    private void quickSort (int low, int high){
        if (low < high){
            int index = separate(low, high);

            quickSort(low, index-1);
            quickSort(index+1, high);

        }
    }

    private int separate(int low, int high)
    {
        int pi = possibleAddends[high];
        int index = low -1;
        for (int i = low; i < high - 1; i++) {
            if(possibleAddends[i] < pi) {
                index++;

                int temp = possibleAddends[index];
                possibleAddends[index] = possibleAddends[i];
                possibleAddends[i] = temp;
            }
        }
        int temp = possibleAddends[index + 1];
        possibleAddends[index + 1] = possibleAddends[high];
        possibleAddends[high] = temp;

        return index + 1;
    }


}
