public class Triangle {
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle (double[] trArr) {
        this.pointA=new Point(trArr[0], trArr[1]);
        this.pointB=new Point(trArr[2], trArr[3]);
        this.pointC=new Point(trArr[4], trArr[5]);
    }

    public double perim() {
        double ab = pointA.lengthCalc(pointB);
        double bc = pointB.lengthCalc(pointC);
        double ac = pointA.lengthCalc(pointC);
        double p = ab + bc + ac;
        return p;
    }

    public double area(){
        double half_p=perim()/2;
        return Math.sqrt(half_p * (half_p - (pointA.lengthCalc(pointB))) * (half_p - (pointB.lengthCalc(pointC))) * (half_p - (pointA.lengthCalc(pointC))));
    }
}
