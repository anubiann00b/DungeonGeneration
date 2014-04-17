package dungeon.gen;

import static dungeon.Main.WIDTH;
import static dungeon.Main.HEIGHT;

public abstract class DungeonGen {
    
    public DungeonGen() {
        tiles = new char[WIDTH][HEIGHT];
    }
    
    protected char[][] tiles;
    
    public abstract char[][] create();
}
