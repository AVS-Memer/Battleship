import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    clearScreen();
    int prevx = 0;
    int prevy = 0;
    System.out.println("Welcome to Battleship! Let's start by setting up the game.\nHow tall should the board be? ");
    int height = input.nextInt();
    if (height <= 0) {
      System.out.println("Invalid input");
      System.exit(0);
    }
    System.out.println("How wide should the board be? ");
    int width = input.nextInt();
    if (width <= 0) {
      System.out.println("Invalid input");
      System.exit(0);
    }
    
    String[][] view_board1 = new String[width][height];
    boolean[][] ship_cor1 = new boolean[width][height];
    String[][] view_board2 = new String[width][height];
    boolean[][] ship_cor2 = new boolean[width][height];
    for (int i = 0; i < width; i ++) {
      for (int j = 0; j < height; j++) {
        view_board1[i][j] = " -";
        view_board2[i][j] = " -";
      }
    }
    System.out.println("How many 2-unit ships? ");
    int unit_2 = input.nextInt();
    if (unit_2 < 0) {
      System.out.println("Invalid input");
      System.exit(0);
    }
    System.out.println("How many 3-unit ships? ");
    int unit_3 = input.nextInt();
    if (unit_3 < 0) {
      System.out.println("Invalid input");
      System.exit(0);
    }
    System.out.println("How many 4-unit ships? ");
    int unit_4 = input.nextInt();
    if (unit_4 < 0 || unit_2+unit_3+unit_4==0) {
      System.out.println("Invalid input");
      System.exit(0);
    }
    clearScreen();
    if (unit_2+unit_3+unit_4 == 1) {
      System.out.println("Okay, it's time for Player 1 to set up their ship! You will be asked to type in the coordinates for your ship.\n");
    } else {
      System.out.println("Okay, it's time for Player 1 to set up their ships! You will be asked to type in the coordinates for each of your ships.\n");
    }
    grid(ship_cor1);
    //enter cors for 2 unit ships
    if (unit_2 > 0) {
      if (unit_2 == 1) {
        System.out.println("\nNow entering coordinates for your 2-unit ship.");
      } else {
        System.out.println("\nNow entering coordinates for your " + unit_2 + " 2-unit ships.");
      }
      for (int k = 0; k < unit_2; k++) {
        for (int j = 0; j < 2; j++) {
          System.out.print("Pick a row: ");
          int p1_row = input.nextInt();
          System.out.print("Pick a column: ");
          int p1_column = input.nextInt();
          while (true) {
            if (p1_row < height && p1_column < width) {
              if (ship_cor1[p1_row][p1_column]) {
                System.out.print("You already placed a ship there!\nPick a row: ");
                p1_row = input.nextInt();
                System.out.print("Pick a column: ");
                p1_column = input.nextInt();
              }
              else {
                if (j == 1) {
                  while (!((prevx >= p1_column-1 && prevx <= p1_column+1) && (prevy >= p1_row-1 && prevy <= p1_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p1_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p1_column = input.nextInt();
                  }
                  ship_cor1[p1_row][p1_column] = true;
                  System.out.println("New 2-unit ship has been successfully added.");
                  break;
                }
                else {
                  ship_cor1[p1_row][p1_column] = true;
                  prevx = p1_column;
                  prevy = p1_row;
                  break;
                }
              }
            }
            else {
              System.out.print("These coordinates are out of bounds!\nPick a row: ");
              p1_row = input.nextInt();
              System.out.print("Pick a column: ");
              p1_column = input.nextInt();
            }
          }
        }
      }
      clearScreen();
      if (unit_2 == 1) {
        System.out.println("Your 2-unit ship has been successfully added.\n");
      } else {
        System.out.println("All of your 2-unit ships have been successfully added.\n");
      }
      grid(ship_cor1);
    } else {
      clearScreen();
    }
    //enter cors for 3 unit ships
    if (unit_3 > 0) {
      if (unit_3 == 1) {
        System.out.println("\nNow entering coordinates for your 3-unit ship.");
      } else {
        System.out.println("\nNow entering coordinates for your " + unit_3 + " 3-unit ships.");
      }
      for (int k = 0; k < unit_3; k++) {
        for (int j = 0; j < 3; j++) {
          System.out.print("Pick a row: ");
          int p1_row = input.nextInt();
          System.out.print("Pick a column: ");
          int p1_column = input.nextInt();
          while (true) {
            if (p1_row < height && p1_column < width) {
              if (ship_cor1[p1_row][p1_column]) {
                System.out.print("You already placed a ship there!\nPick a row: ");
                p1_row = input.nextInt();
                System.out.print("Pick a column: ");
                p1_column = input.nextInt();
              }
              else {
                if (j == 1) {
                  while (!((prevx >= p1_column-1 && prevx <= p1_column+1) && (prevy >= p1_row-1 && prevy <= p1_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p1_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p1_column = input.nextInt();
                  }
                  ship_cor1[p1_row][p1_column] = true;
                  prevx = p1_column;
                  prevy = p1_row;
                  break;
                }
                else if (j == 2) {
                  while (!((prevx >= p1_column-1 && prevx <= p1_column+1) && (prevy >= p1_row-1 && prevy <= p1_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p1_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p1_column = input.nextInt();
                  }
                  ship_cor1[p1_row][p1_column] = true;
                  System.out.println("New 3-unit ship has been successfully added.");
                  break;
                }
                else {
                  ship_cor1[p1_row][p1_column] = true;
                  prevx = p1_column;
                  prevy = p1_row;
                  break;
                }
              }
            }
            else {
              System.out.print("These coordinates are out of bounds!\nPick a row: ");
              p1_row = input.nextInt();
              System.out.print("Pick a column: ");
              p1_column = input.nextInt();
            }
          }
        }
      }
      clearScreen();
      if (unit_3 == 1) {
        System.out.println("Your 3-unit ship has been successfully added.\n");
      } else {
        System.out.println("All of your 3-unit ships have been successfully added.\n");
      }
      grid(ship_cor1);
    } else {
      clearScreen();
    }
    //enter cors for 4 unit ships
    if (unit_4 > 0) {
      if (unit_4 == 1) {
        System.out.println("\nNow entering coordinates for your 4-unit ship.");
      } else {
        System.out.println("\nNow entering coordinates for your " + unit_4 + " 4-unit ships.");
      }
      for (int k = 0; k < unit_4; k++) {
        for (int j = 0; j < 4; j++) {
          System.out.print("Pick a row: ");
          int p1_row = input.nextInt();
          System.out.print("Pick a column: ");
          int p1_column = input.nextInt();
          while (true) {
            if (p1_row < height && p1_column < width) {
              if (ship_cor1[p1_row][p1_column]) {
                System.out.print("You already placed a ship there!\nPick a row: ");
                p1_row = input.nextInt();
                System.out.print("Pick a column: ");
                p1_column = input.nextInt();
              }
              else {
                if (j % 3 != 0) {
                  while (!((prevx >= p1_column-1 && prevx <= p1_column+1) && (prevy >= p1_row-1 && prevy <= p1_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p1_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p1_column = input.nextInt();
                  }
                  ship_cor1[p1_row][p1_column] = true;
                  prevx = p1_column;
                  prevy = p1_row;
                  break;
                  
                }
                else if (j == 3) {
                  while (!((prevx >= p1_column-1 && prevx <= p1_column+1) && (prevy >= p1_row-1 && prevy <= p1_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p1_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p1_column = input.nextInt();
                  }
                  ship_cor1[p1_row][p1_column] = true;
                  System.out.println("New 4-unit ship has been successfully added.");
                  break;
                }
                else {
                  ship_cor1[p1_row][p1_column] = true;
                  prevx = p1_column;
                  prevy = p1_row;
                  break;
                  
                }
              }
            }
            else {
              System.out.print("These coordinates are out of bounds!\nPick a row: ");
              p1_row = input.nextInt();
              System.out.print("Pick a column: ");
              p1_column = input.nextInt();
            }
          }
        }
      }
      clearScreen();
      if (unit_4 == 1) {
        System.out.println("Your 4-unit ship has been successfully added.\n");
      } else {
        System.out.println("All of your 4-unit ships have been successfully added.\n");
      }
    } else {
      clearScreen();
    }
    if (unit_2+unit_3+unit_4 == 1) {
      System.out.println("Okay, it's time for Player 2 to set up their ship! You will be asked to type in the coordinates for your ship.\n");
    } else {
      System.out.println("Okay, it's time for Player 2 to set up their ships! You will be asked to type in the coordinates for each of your ships.\n");
    }
    grid(ship_cor2);
    //enter cors for 2 unit ships
    if (unit_2 > 0) {
      if (unit_2 == 1) {
        System.out.println("\nNow entering coordinates for your 2-unit ship.");
      } else {
        System.out.println("\nNow entering coordinates for your " + unit_2 + " 2-unit ships.");
      }
      for (int k = 0; k < unit_2; k++) {
        for (int j = 0; j < 2; j++) {
          System.out.print("Pick a row: ");
          int p2_row = input.nextInt();
          System.out.print("Pick a column: ");
          int p2_column = input.nextInt();
          while (true) {
            if (p2_row < height && p2_column < width) {
              if (ship_cor2[p2_row][p2_column]) {
                System.out.print("You already placed a ship there!\nPick a row: ");
                p2_row = input.nextInt();
                System.out.print("Pick a column: ");
                p2_column = input.nextInt();
              }
              else {
                if (j == 1) {
                  while (!((prevx >= p2_column-1 && prevx <= p2_column+1) && (prevy >= p2_row-1 && prevy <= p2_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p2_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p2_column = input.nextInt();
                  }
                  ship_cor2[p2_row][p2_column] = true;
                  System.out.println("New 2-unit ship has been successfully added.");
                  break;
                }
                else {
                  ship_cor2[p2_row][p2_column] = true;
                  prevx = p2_column;
                  prevy = p2_row;
                  break;
                }
              }
            }
            else {
              System.out.print("These coordinates are out of bounds!\nPick a row: ");
              p2_row = input.nextInt();
              System.out.print("Pick a column: ");
              p2_column = input.nextInt();
            }
          }
        }
      }
      clearScreen();
      if (unit_2 == 1) {
        System.out.println("Your 2-unit ship has been successfully added.\n");
      } else {
        System.out.println("All of your 2-unit ships have been successfully added.\n");
      }
      grid(ship_cor2);
    } else {
      clearScreen();
    }
    //enter cors for 3 unit ships
    if (unit_3 > 0) {
      if (unit_3 == 1) {
        System.out.println("\nNow entering coordinates for your 3-unit ship.");
      } else {
        System.out.println("\nNow entering coordinates for your " + unit_3 + " 3-unit ships.");
      }
      for (int k = 0; k < unit_3; k++) {
        for (int j = 0; j < 3; j++) {
          System.out.print("Pick a row: ");
          int p2_row = input.nextInt();
          System.out.print("Pick a column: ");
          int p2_column = input.nextInt();
          while (true) {
            if (p2_row < height && p2_column < width) {
              if (ship_cor2[p2_row][p2_column]) {
                System.out.print("You already placed a ship there!\nPick a row: ");
                p2_row = input.nextInt();
                System.out.print("Pick a column: ");
                p2_column = input.nextInt();
              }
              else {
                if (j == 1) {
                  while (!((prevx >= p2_column-1 && prevx <= p2_column+1) && (prevy >= p2_row-1 && prevy <= p2_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p2_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p2_column = input.nextInt();
                  }
                  ship_cor2[p2_row][p2_column] = true;
                  prevx = p2_column;
                  prevy = p2_row;
                  break;
                }
                else if (j == 2) {
                  while (!((prevx >= p2_column-1 && prevx <= p2_column+1) && (prevy >= p2_row-1 && prevy <= p2_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p2_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p2_column = input.nextInt();
                  }
                  ship_cor2[p2_row][p2_column] = true;
                  System.out.println("New 3-unit ship has been successfully added.");
                  break;
                }
                else {
                  ship_cor2[p2_row][p2_column] = true;
                  prevx = p2_column;
                  prevy = p2_row;
                  break;         
                }
              }
            }
            else {
              System.out.print("These coordinates are out of bounds!\nPick a row: ");
              p2_row = input.nextInt();
              System.out.print("Pick a column: ");
              p2_column = input.nextInt();
            }
          }
        }
      }
      clearScreen();
      if (unit_3 == 1) {
        System.out.println("Your 3-unit ship has been successfully added.\n");
      } else {
        System.out.println("All of your 3-unit ships have been successfully added\n");
      }
      grid(ship_cor2);
    } else {
      clearScreen();
    }
    //enter cors for 4 unit ships
    if (unit_4 > 0) {
      if (unit_4 == 1) {
        System.out.println("\nNow entering coordinates for your 4-unit ship.");
      } else {
        System.out.println("\nNow entering coordinates for your " + unit_4 + " 4-unit ships.");
      }
      for (int k = 0; k < unit_4; k++) {
        for (int j = 0; j < 4; j++) {
          System.out.print("Pick a row: ");
          int p2_row = input.nextInt();
          System.out.print("Pick a column: ");
          int p2_column = input.nextInt();
          while (true) {
            if (p2_row < height && p2_column < width) {
              if (ship_cor2[p2_row][p2_column]) {
                System.out.print("You already placed a ship there!\nPick a row: ");
                p2_row = input.nextInt();
                System.out.print("Pick a column: ");
                p2_column = input.nextInt();
              }
              else {
                if (j % 3 != 0) {
                  while (!((prevx >= p2_column-1 && prevx <= p2_column+1) && (prevy >= p2_row-1 && prevy <= p2_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p2_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p2_column = input.nextInt();
                  }
                  ship_cor2[p2_row][p2_column] = true;
                  prevx = p2_column;
                  prevy = p2_row;
                  break;
                }
                if (j == 3) {
                  while (!((prevx >= p2_column-1 && prevx <= p2_column+1) && (prevy >= p2_row-1 && prevy <= p2_row+1))) {
                    System.out.print("That isn't next to the other part of the ship!\nPick a row: ");
                    p2_row = input.nextInt();
                    System.out.print("Pick a column: ");
                    p2_column = input.nextInt();
                  }
                  ship_cor2[p2_row][p2_column] = true;
                  System.out.println("New 4-unit ship has been successfully added.");
                  break;
                }
                else {
                  ship_cor2[p2_row][p2_column] = true;
                  prevx = p2_column;
                  prevy = p2_row;
                  break;
                }
              }
            }
            else {
              System.out.print("These coordinates are out of bounds!\nPick a row: ");
              p2_row = input.nextInt();
              System.out.print("Pick a column: ");
            }
          }
        }
      }
      clearScreen();
      if (unit_4 == 1) {
        System.out.println("Your 4-unit ship has been successfully added.");
      } else {
        System.out.println("All of your 4-unit ships have been successfully added.");
      }
    } else {
      clearScreen();
    }
    //alternate turns
    int pcount = 2*unit_2 + 3*unit_3 + 4*unit_4;
    int p1count = 0;
    int p2count = 0;
    while (p1count < pcount && p2count < pcount) {
      System.out.println("\nIt is player 1's turn:");
      view(view_board1);
      System.out.print("Pick a row: ");
      int p1_row = input.nextInt();
      System.out.print("Pick a column: ");
      int p1_column = input.nextInt();
      while (true) {
        if (p1_row < height && p1_column < width) {
          if (hitmiss(1,p1_row,p1_column,ship_cor2)) {
            System.out.println("Hit! :]");
            ship_cor2[p1_row][p1_column] = false;
            view_board1[p1_row][p1_column] = " x";
            p1count++;
          }
          else {
            System.out.println("miss :[");
            view_board1[p1_row][p1_column] = " o";
          }
          break;
        }
        else {
          System.out.print("These coordinates are out of bounds!\nPick a row: ");
          p1_row = input.nextInt();
          System.out.print("Pick a column: ");
          p1_column = input.nextInt();
        }
      }
      if (!(p1count < pcount)) {
        continue;
      }
      System.out.println("\nIt is player 2's turn:");
      view(view_board2);
      System.out.print("Pick a row: ");
      int p2_row = input.nextInt();
      System.out.print("Pick a column: ");
      int p2_column = input.nextInt();
      while (true) {
        if (p2_row < height && p2_column < width) {
          if (hitmiss(2,p2_row,p2_column,ship_cor1)) {
            System.out.println("Hit! :]");
            ship_cor1[p2_row][p2_column] = false;
            view_board2[p2_row][p2_column] = " x";
            p2count++;
          }
          else {
            System.out.println("miss :[");
            view_board2[p2_row][p2_column] = " o";
          }
          break;
        }
        else {
          System.out.print("These coordinates are out of bounds!\nPick a row: ");
          p2_row = input.nextInt();
          System.out.print("Pick a column: ");
          p2_column = input.nextInt();
        }
      }
    }
    if (p1count > p2count) {
      view(view_board1);
      System.out.println("\n Player 1 won!");
    }
    else {
      view(view_board2);
      System.out.println("\n Player 2 won!");
    }
  }
  public static void grid(boolean[][] ship_cor) {
    for (int i = 0; i < ship_cor.length; i++) {
      for (int j = 0; j < ship_cor[0].length; j++) {
        if (ship_cor[i][j]) {
        System.out.print(" x");
        }
        else {
          System.out.print(" -");
        }
      }
      System.out.println();
    }
  }
  public static boolean hitmiss(int player,int x,int y,boolean[][] ship_cor) {
    if (player == 1) {
      return ship_cor[x][y];
    }
    else {
      return ship_cor[x][y];
    }
  }
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");
    System.out.flush();  
  }
  public static void view(String[][] view_board) {
    for (int i = 0; i < view_board.length; i++) {
      for (int j = 0; j < view_board[0].length; j++) {
        System.out.print(view_board[i][j]);
      }
      System.out.println();
    }
  }
}
