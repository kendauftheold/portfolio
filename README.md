# portfolio

This is my version on the Game of Life

Each cell can either be dead (empty) or alive (filled in black).
When the game progresses through to the next generation, each cell's status will be recalculated based on the following rules:
1. If the cell has less than 2 living neighbors, it will die of loneliness
2. if it has more than 3 living neighbors, it will die of overcrowding
3. if it has 2 or 3 living neighbors, it will not change its status
