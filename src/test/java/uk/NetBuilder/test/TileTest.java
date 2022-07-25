package uk.NetBuilder.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.NetBuilder.go.Go;
import uk.NetBuilder.go.Tile;



public class TileTest {

    static Tile t = new Tile(new Go(), 0, 0, false, "", 25, 0, 0, 11);
    @Test()
     void tileConstructorTest(){
        Assertions.assertFalse(t.contains(100, 100));
        Assertions.assertTrue(t.contains(1, 1));
        Assertions.assertFalse(t.contains(25, 25));
    }

}
