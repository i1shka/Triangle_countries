public class Point {
    double x;
    double y;

    public Point (double x, double y){
        this.x=x;
        this.y=y;
    }

    public double lengthCalc(Point second){
        return Math.sqrt(Math.pow((x-second.x),2)+Math.pow((y-second.y),2));
    }

}