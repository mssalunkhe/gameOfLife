package com.example.lifegame;

import static com.example.lifegame.CELLVALUE.ALIVE;
import static com.example.lifegame.CELLVALUE.DEAD;


public class GameOFLife {

    private final int numOfRows;
    private final int numOfColumns;

    private CELLVALUE[][] currentStateOfBoard;

    public GameOFLife(int i, int j) {
        numOfRows=i;
        numOfColumns =j;

    }





    public boolean setCurrentStateOfBoard(CELLVALUE[][] input){

        int inputRows= input.length;
        int inputColumns=input[0].length;
        if (inputRows >25 || inputColumns >25) {
            System.out.println("Number of rows or columns cannot exceed 25");
            return false;
        }

            currentStateOfBoard = input;

        return true;
    }
    public CELLVALUE[][] getStateOfBoard(){
         return currentStateOfBoard;
    }
    public void findNextStateOfBoard(){
        CELLVALUE[][] nextStateOfBoard;
        nextStateOfBoard = new CELLVALUE[numOfRows][numOfColumns];

        for(int i = 0; i< numOfRows; i++)
            for (int j = 0; j< numOfColumns; j++)
                nextStateOfBoard[i][j]= findNextStateOfCell(i,j);


        currentStateOfBoard=nextStateOfBoard;
    }
    CELLVALUE findNextStateOfCell(int row, int column)  {
        int aliveNeighbours = 0;
        aliveNeighbours = findAliveNeighbours(row, column);

        switch (currentStateOfBoard[row][column]) {
            case DEAD -> {
                if (aliveNeighbours == 3)
                    return ALIVE;
                else return DEAD;
            }
            case ALIVE -> {
                if (aliveNeighbours < 2 || aliveNeighbours > 3)
                    return DEAD;
                else return ALIVE;
            }

        }
        return DEAD;
    }
    private int findAliveNeighbours(int row, int column) {
        int aliveNeighbours =0;
        int i,j;
        for ( i=row-1; i<row+2;i++)
            for ( j = column - 1; j < column + 2; j++)
                if(!areIndicesOutOfRange(i,j))
                    //skip the cell at the index [row][ column] whose alive neighbours are to be counted
                    if (!(i == row && j == column) && currentStateOfBoard[i][j] == ALIVE)
                        aliveNeighbours++;
        return aliveNeighbours;
    }

    private boolean areIndicesOutOfRange(int i,int j){
        if (i<0 || j <0)
            return true;
        if (i>=numOfRows || j>= numOfColumns)
            return true;

        return false;
    }

}
