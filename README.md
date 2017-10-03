# The Game of Life

This is my version on the Game of Life coded in Java

Each cell can either be dead (empty) or alive (filled in black).
When the game progresses through to the next generation, each cell's status will be recalculated based on the following rules:
1. If the cell has less than 2 living neighbors, it will die of loneliness
2. If it has more than 3 living neighbors, it will die of overcrowding
3. If it has 2 or 3 living neighbors, it will not change its status
