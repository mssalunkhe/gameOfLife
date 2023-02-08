package com.example.lifegame;

import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.*;




public class TestLifeGame {
    @Test
    public void Test1(){


        CELLVALUE[][] inputBox ={{CELLVALUE.DEAD,CELLVALUE.ALIVE,CELLVALUE.DEAD},{CELLVALUE.DEAD,CELLVALUE.DEAD, CELLVALUE.ALIVE},{CELLVALUE.ALIVE,CELLVALUE.ALIVE,CELLVALUE.ALIVE},{CELLVALUE.DEAD,CELLVALUE.DEAD, CELLVALUE.DEAD}};
        CELLVALUE[][] expectedBox ={{CELLVALUE.DEAD,CELLVALUE.DEAD, CELLVALUE.DEAD},{CELLVALUE.ALIVE,CELLVALUE.DEAD, CELLVALUE.ALIVE},{CELLVALUE.DEAD,CELLVALUE.ALIVE,CELLVALUE.ALIVE},{CELLVALUE.DEAD,CELLVALUE.ALIVE,CELLVALUE.DEAD}};

        GameOFLife gameObject= new GameOFLife(4,3);
        gameObject.setCurrentStateOfBoard(inputBox);
        gameObject.findNextStateOfBoard();
        assertArrayEquals(expectedBox, gameObject.getStateOfBoard());

    }
    @Test
    public void Test2(){


        CELLVALUE[][] inputBox ={{CELLVALUE.ALIVE,CELLVALUE.ALIVE},{CELLVALUE.ALIVE, CELLVALUE.DEAD}};
        CELLVALUE[][] expectedBox ={{CELLVALUE.ALIVE,CELLVALUE.ALIVE},{CELLVALUE.ALIVE, CELLVALUE.ALIVE}};


        GameOFLife gameObject= new GameOFLife(2,2);
        gameObject.setCurrentStateOfBoard(inputBox);
        gameObject.findNextStateOfBoard();
        assertArrayEquals(expectedBox, gameObject.getStateOfBoard());

    }


}
