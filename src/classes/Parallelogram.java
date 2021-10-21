package classes;

import java.util.ArrayList;

public class Parallelogram extends Quadrangle{
    public Parallelogram(Coordinates dot1, Coordinates dot2, Coordinates dot3, Coordinates dot4,double angle1,double angle2) {
        super(dot1, dot2, dot3, dot4 ,angle1,angle2);
    }

    public Parallelogram(double dot1x, double dot1y, double dot2x, double dot2y, double dot3x, double dot3y, double dot4x, double dot4y,double angle1,double angle2) {
        super(dot1x, dot1y, dot2x, dot2y, dot3x, dot3y, dot4x, dot4y,angle1,angle2);
    }


    public double getSquare(){
        if(!isExist()){
            return Double.NaN;
        }
        ArrayList<Double> sides = getSidesLenght();
        double square = sides.get(0) * sides.get(1) * Math.sin(angle1);
        return square;
    }


    @Override
    public boolean isExist(){
        ArrayList<Double> sides = getSidesLenght();
        double maxSideLength = 0;
        for (var el:sides) {
            if(el>maxSideLength){
                maxSideLength=el;
            }
        }
        double sideLengthWithOutMax =0;
        for (var el : sides) {
            if(el !=maxSideLength){
                sideLengthWithOutMax+=el;
            }
        }
        boolean checkForParallelogram = (int)Math.round(sides.get(0)) == (int)Math.round(sides.get(2)) && (int)Math.round(sides.get(1)) == (int)Math.round(sides.get(3));
        if(maxSideLength < sideLengthWithOutMax && checkForParallelogram ){
            return true;
        }else{
            return false;
        }
    }

}
