package TSP;

/**
 * Need Javadocs -- you do!! 
 * @author Henry Ang 
 */
public class Cities 
{
    // instance variables 
    private String vertex; 
    private int x; 
    private int y; 
 
    // Default construtor 
    public Cities() {
        vertex =  "";
        x = 0;
        y = 0;
    }
    
    // Constructor
    public Cities(String vertex, int x, int y) {
        this.vertex = vertex;
        this.x = x;
        this.y = y;
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
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

    @Override
    public String toString() {
        return "City{" + "vertex=" + vertex + ", x=" + x + ", y=" + y + '}';
    }
    
//    public boolean equal(City vertex)
//    {
//        if(this.getName().equalsIgnoreCase(vertex.getName()) && 
//           closeEnough(this.getPopulation(), vertex.getPopulation()))
//            return true;
//        else
//            return false; 
//    }
    
    // Need Java Docs 
    private boolean closeEnough(float x, float y)
    {
        final double EPSILON = 1E-9; 
        return Math.abs(x - y) < EPSILON;  
    }
}
