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
    // the final value so we choose the right row.
    int finalRandRow;

    Scanner input = new Scanner(System.in);

    ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>();
    int leftVerticalBorder;
    int rightVerticalBorder;

    public RecursiveDivisionMethod()
    {
        System.out.println("constructor");
        // set size

        setSize();
        fillMaze();
        createWallWithHole();

        // 1.store where the boarders are.
        // 2.choose to go vertical or horisontal.

            //  devide the chamber by random. use the information about the borders.
            // mak sure that there is not already a hole there
                // if the wal next to is " " (empty) do not make wall

        // record where the split is. make this into a vertical border.
        // record the new interval from the border that has been created to the next.
        // now make a horisontal border. // next boarders are random.
                //make sure to make the border at least 1 step away from the other horisontal borders
        //

        //Recursion:
        // are there any existing chambers left that bigger than 3 X  3 in size?
        // if not
               // devide that chamber:   createWallWithHole()

        // create 2 chambers


        //makeEntranceAndExit();
        //printMaze();

    }

    private void makeEntranceAndExit()
    {
        // make two holes in the outer perimeter.
        int randomHoleInwall= (int)(Math.random()*(totalWidth-1)+1);
        // make whole in higher boarder.
        maze.get(0).set(randomHoleInwall," ");
        // make hole in lower boarder.

    }

    private void createWallWithHole()
    {


        System.out.println("divide Chamber:");


        //tagudgagnspukt i en grænse
        // første gang er grænsen den grænse
        //vælg horisontal=(0) eller vertical=(1)

        int verticalOrHorisontal = (int)(Math.random()*2);
            System.out.println("verticalOrHorisontal  "+ verticalOrHorisontal);
        int lastVarticalOrHorisontalInput = verticalOrHorisontal;


        //Make Horisontal
        if (verticalOrHorisontal == 0)
        {
            System.out.println("horisontal");
            // generate random number in interval:
            int min = 2;
            int max = height - 1;
            int randRow = min + (int) (Math.random() * ((max - min) + 1));

            //int randRow = (int)(Math.random()*totalHeight+2);
            System.out.println(" randomRow: " + randRow);
            int diference = max - min;
            System.out.println("diference " + diference);

            for (int i = 0; i < totalWidth; i++) {
                maze.get(randRow).set(i, "¤");
            }
            // make a random hole in the wall the hole can be in the interval between [1;max]
            // width is the width of the actual gap between the to borders:
            max = width;
            min = 0;

            int randHole = (int) (Math.random() * (max - min) + 1);
            maze.get(randRow).set(randHole, " ");
            System.out.println("randHoleIndex:  " + randHole);
            System.out.println("New wall ,enter answer");

            // TESTING
            System.out.println("sleep");
            // sleeptes
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2 sec.");

            printMaze();
            createWallWithHole();
        }

        // go vertical
        else if (verticalOrHorisontal == 1) {
            System.out.println("vertical");
            // find a row to form the line from.

            //define min
            // in this first case its 1, since there is
            int min = 2;
            // and max is width between gap, but minus 1, because of we dont want it right up against the next wall.
            int max = width - 1;
            //int randRow=min + (int)(Math.random() * ((max - min) + 1));

            int randColumn = min + (int) (Math.random() * ((max - min) + 1));

            for (int i = 0; i < totalHeight; i++) {
                maze.get(i).set(randColumn, "@");
            }
            // make hole in the wall

            int upperBoundaryIndex = 1; // should be changed!!
            int lowerBoundaryIndex = height;
            int randVerticalWallHole = min + (int) (Math.random() * ((max - min) + 1));

            maze.get(randVerticalWallHole).set(randColumn, " ");

            // TESTING
            // sleeptest
            System.out.println("sleep");
            // sleeptes
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4 sec.");

                printMaze();
                createWallWithHole();

            
        } else
            System.out.println("wierd error");

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
        if (height<3||width<3)
        {
            System.out.println("not allowed to be this small, must be larger than 3");
            setSize();
        }

        // we add 4 because of the border takes up 4 spaces.
        this.totalWidth=width+2;
        this.totalHeight=height+2;

        leftVerticalBorder= 0;
        rightVerticalBorder= width;
        //upperHorisontalborder=



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



        maze.add(border);
        //maze.add(border);
    }
    public void printMaze()
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
