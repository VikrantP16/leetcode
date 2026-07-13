class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startingStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            // Add the net gain/loss of gas at the current station
            currentTank += gas[i] - cost[i];
            
            // If the tank drops below zero, this station and all previous ones are invalid starts
            if (currentTank < 0) {
                startingStation = i + 1; // Try the next station
                currentTank = 0;         // Reset the tank for the new starting point
            }
        }
        
        // If total gas >= total cost, a solution is guaranteed to exist
        return totalGas >= totalCost ? startingStation : -1;
    }
}