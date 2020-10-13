public class BruteForce {
    private int[] possibleAddends;
    private int[] addends = new int[2];
    public BruteForce(int[] userArray)
    {
        possibleAddends = userArray;
    }


    public int[] bFMethod (int sum){
        for (int i = 0; i < possibleAddends.length; i++)
        {
            for (int j = 1; j < possibleAddends.length; j++)
            {
                if (sum == (possibleAddends[i] + possibleAddends[j])){
                    addends[0] = possibleAddends[i];
                    addends[1] = possibleAddends[j];
                    return addends;
                }
            }
        }
        return null;
    }
}
