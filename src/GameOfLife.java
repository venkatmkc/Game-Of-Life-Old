import java.util.Scanner;
public class GameOfLife {
    int size;
    int [][]grid;
    public GameOfLife()
    {
        System.out.println("Enter the size of the grid : ");
        Scanner input= new Scanner(System.in);
        size=input.nextInt();
        System.out.println("Enter the initial configuration");
        grid=new int[size][size];
        for(int i=0;i<size;i++)
        {
            grid[i]=new int[size];
            for(int j=0;j<size;j++)
                grid[i][j]=input.nextInt();
        }
    }
    public void nextState()
    {
        int alive_count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i!=0)
                {
                    if(grid[i-1][j]==1)
                        alive_count++;
                }
                if(j!=0)
                {
                    if(grid[i][j-1]==1)
                        alive_count++;
                }
                if(i!=size)
                {
                    if(grid[i+1][j]==1)
                        alive_count++;
                }
                if(j!=size)
                {
                    if(grid[i][j+1]==1)
                        alive_count++;
                }
                if(i!=0&&j!=0)
                {
                    if (grid[i-1][j-1]==1)
                        alive_count++;
                }
                if(i!=size&&j!=size)
                {
                    if(grid[i+1][j+1]==1)
                        alive_count++;
                }
                if(i!=0&&j!=size)
                {
                    if(grid[i-1][j+1]==1)
                        alive_count++;
                }
                if(i!=size&&j!=0) {
                    if (grid[i + 1][j - 1] == 1)
                        alive_count++;
                }
                if(alive_count>3||alive_count<2)
                    grid[i][j]=0;
                if(alive_count==3)
                    grid[i][j]=1;

            }

        }
    }
    public void printState()
    {
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0)
                    System.out.print("A ");
                else
                    System.out.print("D ");

            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        GameOfLife game=new GameOfLife();
        game.printState();
        game.nextState();
        game.printState();
    }
}
