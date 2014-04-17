package dungeon;

import dungeon.gen.CellularAutomataGen;
import dungeon.gen.DungeonGen;

public class Main {
    
    public static int WIDTH = 200;
    public static int HEIGHT = 80;
    
    public static void main(String[] args) {
        DungeonGen d = new CellularAutomataGen();        
        printTiles(d.create());
    }

    private static void printTiles(char[][] tiles) {
        for(int i=0;i<HEIGHT;i++) {
            for(int j=0;j<WIDTH;j++) {
                System.out.print(tiles[j][i]);
            }
            System.out.println();
        }
    }
}
