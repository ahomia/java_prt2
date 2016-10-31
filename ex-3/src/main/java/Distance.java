/**
 * Created by ahomia on 31.10.2016.
 */
public class Distance {
    public static double distance(Point p1, Point p2){
        double result;
        result= Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
        return result;
    }
}
