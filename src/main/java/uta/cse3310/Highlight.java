package uta.cse3310;


public class Highlight{

    String[][] cells = new String[25][25];
    String[] colors = new String[4];
    
    public void fillcells(){
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                cells[i][j] = "white";
            }
        }
    }

    public void playerColors(){
        colors[0] = "lightcoral"; 
        colors[1] = "lightskyblue"; 
        colors[2] = "lightgreen"; 
        colors[3] = "plum"; 
    }

    public void highlight(int row, int col, int playerIdx){
        cells[row][col] = colors[playerIdx];
    }

    public void checkWordbank(){
        //collect values from cells to create a word
        //cycle through wordbank comparing word created by cells against list of word bank words
        //if part of wordbank approve word for highlighting, if not deny word
    }

    public void highlightMiddleCells(UserEvent U){
        int firstRow = 25; 
        int firstCol = 25;
        int secondRow = 25;
        int secondCol = 25;
        int rowDiff = 0;
        int colDiff = 0;
        
        int x = U.X;
        int y = U.Y;
        int playerIdx = U.PlayerIdx;

        if (firstRow == 25 && firstCol == 25) {
            firstRow = x;
            firstCol = y;
            highlight(firstRow, firstCol, playerIdx);
        } 
        else if (secondRow == 25 && secondCol == 25) {
            secondRow = x;
            secondCol = y;

            if(firstCol < secondCol){
                colDiff = secondCol - firstCol;
            }
              
            else if(secondCol < firstCol){
                colDiff = firstCol - secondCol;
            }
            
            if(firstRow < secondRow){
                rowDiff = secondRow - firstRow;
            }
              
            else if(secondRow < firstRow){
                rowDiff = firstRow - secondRow;
            } 
    
        }
        
        
        if (firstRow == secondRow){
          if(firstCol < secondCol){
            while(firstCol  < secondCol){
              highlight(firstCol +1, firstRow, playerIdx);
              firstCol++;
            }
          }
          else if(secondCol < firstCol){
            while(secondCol < firstCol){
              highlight(secondCol, firstRow, playerIdx);
              secondCol++;
            }
          }
        }
        else if(firstCol == secondCol){
          if(firstRow < secondRow){
            while(firstRow < secondRow){
              highlight(firstRow, firstCol, playerIdx);
              firstRow++;
            }
          }
          if(secondRow < firstRow){
            while(secondRow < firstRow){
              highlight(secondRow, firstCol, playerIdx);
              secondRow++;
            }
          }
        }
        else if(firstCol != secondCol && firstRow != secondCol && rowDiff == colDiff){
            while(firstRow != secondRow && firstCol != secondCol){
                if(firstRow < secondRow){
                    while(firstCol <= secondCol){
                        if(firstCol <= secondCol){
                            highlight(firstRow, firstCol, playerIdx);
                            firstRow++;
                            firstCol++;
                        }
                        else if(secondCol <= firstCol){
                            highlight(firstRow, firstCol, playerIdx);
                            firstRow++;
                            firstCol--;
                        }
                    }
                }
                else if(secondRow < firstRow){
                    while(secondRow <= firstRow){
                        if(firstCol <= secondCol){
                            highlight(firstRow, firstCol, playerIdx);
                            firstRow--;
                            firstCol++;
                        }
                        else if(secondCol <= firstCol){
                            highlight(firstRow, firstCol, playerIdx);
                            firstRow--;
                            firstCol--;
                        }
                    }
                }
            }
        }
        else{
            cells[firstRow][firstCol] = "white";
            //reset variables
            firstRow = 25; 
            firstCol = 25;
            secondRow = 25;
            secondCol = 25;
            rowDiff = 0;
            colDiff = 0;
        }
    }
}




