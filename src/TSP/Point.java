package TSP;

/**
 *
 * @author
 */
public class Point 
{
    public int x,y;

    public Point() 
    { 
        x = y = 0;
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { 
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() { 
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public static double getDistance(Point a, Point b)
    {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    @Override
    public String toString() {
        return "PointGraph{" + "x=" + x + ", y=" + y + '}';
    }   
}
