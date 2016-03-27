import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by v on 3/27/16.
 */
public class RecursiveDivisionMethod {
    int totalWidth;
    int height;
    int width;
    int totalHeight;

    Scanner input = new Scanner(System.in);

    ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>();

    public RecursiveDivisionMethod()
    {
        System.out.println("constructor");
        // set size


        setSize();
        fillMaze();
        devideChamber();



        printMaze();

    }

    private void devideChamber()
    {


        //tagudgagnspukt i en grænse
        //vælg horisontal eller vertical

        int verticalOrHorisontal =0;//= (int)(Math.random()*2);
        // go vertical
        if (verticalOrHorisontal==0)
        {
            int randRow = 3;//= (int)(Math.random()*totalHeight);

            System.out.println("vertical");
            maze.get(3).set(5,"#");
                //maze.get(3).set(2,"#");
            for(int i=0; i <6;i++)
            {


            }
        }
        // go Horisontal
        else if(verticalOrHorisontal==1)
        {
            System.out.println("horisontal");

        }
        else
            System.out.println("error");
                // 0 horisontal ,1 vertical
        // hvis vertical
            // lav et random nummer of start der.
            // ved at sige tag den den række og lav hele rækken om til "#" på nær et tilfældigt sted.
            // check hvor langt der er til den næste væg.
            //udfyld hele rækken.


        //

    }

    private void setSize()
    {
        // set size
        System.out.println("enter width, only EVEN NUMBERS");
        width = input.nextInt();
        System.out.println("your  width is: " + width);

        System.out.println("enter height only EVEN NUMBERS");
        height = input.nextInt();

        System.out.println("your  height is: " + height);


        // we add 4 because of the border takes up 4 spaces.
        this.totalWidth=width+2;
        this.totalHeight=height+2;


    }

    public void fillMaze()
    {

        ArrayList<String> border = new ArrayList<String>();
        for (int j = 0; j <totalWidth ; j++)
        {
            border.add("#");

        }
        //maze.add(border);
        maze.add(border);

        for (int i = 0; i < height ; i++)
        {


            ArrayList<String> list = new ArrayList<String>();
            list.add("#");
            //list.add("#");
            for (int j = 0; j <width ; j++)
            {
                list.add(" ");

            }
            //list.add("#");
            list.add("#");
            maze.add(list);
        }
        maze.get(3).set(5,"#");


        maze.add(border);
        //maze.add(border);
    }
    private void printMaze()
    {


        for (int j = 0; j <totalHeight ; j++)
        {
            System.out.print(j+"\t");
            for (int i = 0; i <totalWidth ; i++)
            {

                System.out.print(maze.get(j).get(i));

            }
            System.out.println();
        }
        System.out.println();

    }
}
