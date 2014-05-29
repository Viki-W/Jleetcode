/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsLine {
    public int maxPoints(Point[] points) {
        if (points == null){
            return 0;
        } 
        if (points.length <= 2){
            return points.length;
        }
        HashMap<Double, Integer> slopes = new HashMap<Double, Integer> ();
        Point origin = null, point = null;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            origin = points[i];
            int sCount = 1, vCount = 0, hCount = 0, mCount = 0, count = 0;
	        for (int j = i + 1; j < points.length; j++){
	            point = points[j];
	            if (point.x == origin.x && point.y == origin.y ){
	            	sCount++;
	            }else if (point.x == origin.x ){
	                vCount++;
	            }else if (point.y == origin.y ){
	                hCount++;
	            }else{
	                double slope = (double)(point.y-origin.y)/(point.x - origin.x);
	                int temp  = slopes.get(slope) == null ? 0 : slopes.get(slope);
	                temp++;
	                slopes.put(slope, temp);
	            }
	        }
	        
	        if(!slopes.isEmpty()){
	            for (Map.Entry<Double, Integer> entry : slopes.entrySet()){
	                if (mCount < entry.getValue()){
	                    mCount = entry.getValue();
	                } 
	            }
	        }
	        
	        count = vCount > hCount? vCount : hCount;
	        count = mCount > count? mCount : count;
	        count += sCount;
	        result = result < count? count : result;
	        if(result > 2 && result >= points.length / 2){
	            break;
	        }
	        slopes.clear();
	    }   
        return result; //origin
    }
}