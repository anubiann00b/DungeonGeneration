package dungeon.gen;

import java.util.Arrays;
import static dungeon.Main.WIDTH;
import static dungeon.Main.HEIGHT;

public class CellularAutomataGen extends DungeonGen {
    
    @Override
    public char[][] create() {
        makeCaves();
        return tiles;
    }
    
    public void makeCaves() {
        randomizeTiles(0.55);
        smooth(5,5);
    }
    
    private void randomizeTiles(double chanceOfFloor) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                tiles[x][y] = Math.random() < chanceOfFloor ? '.' : '#';
            }
        }
    }
    
    private void smooth(int times, int liveAmount) {
        char[][] tiles2 = new char[WIDTH][HEIGHT];
        for (int time = 0; time < times; time++) {
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                int floors = 0;
                int walls = 0;

                for (int ox = -1; ox < 2; ox++) {
                    for (int oy = -1; oy < 2; oy++) {
                    if (x + ox < 0 || x + ox >= WIDTH || y + oy < 0 || y + oy >= HEIGHT)
                        continue;
                    if (tiles[x + ox][y + oy] == '.')
                        floors++;
                    else
                        walls++;
                    }
                }
                if (walls >= liveAmount) {
                    tiles2[x][y] = 1;
                } else if (walls == 0) {
                    tiles2[x][y] = 1;
                } else {
                    tiles2[x][y] = 0;
                }
                tiles2[x][y] = floors >= walls ? '.' : '#';
                }
            }
            tiles = Arrays.copyOf(tiles2, tiles2.length);
        }
        tiles = Arrays.copyOf(tiles2, tiles2.length);
    }
}
