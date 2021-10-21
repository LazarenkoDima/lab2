package classes;

import interfaces.IquadRangle;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class Quadrangle implements IquadRangle {

    private Coordinates dot1;
    private Coordinates dot2;
    private Coordinates dot3;
    private Coordinates dot4;
    protected double angle1;
    protected double angle2;

   public Quadrangle(Coordinates dot1,Coordinates dot2,Coordinates dot3,Coordinates dot4 ,double angle1,double angle2){
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        this.dot4 = dot4;
        this.angle1 = angle1;
        this.angle2 = angle2;
    }


    public Quadrangle(double dot1x,double dot1y,double dot2x,double dot2y,double dot3x,double dot3y,double dot4x,double dot4y,double angle1,double angle2){
        this( new Coordinates(dot1x,dot1y), new Coordinates(dot2x,dot2y),new Coordinates(dot3x,dot3y),new Coordinates(dot4x,dot4y),angle1,angle2);

    }


    @Override
    public double getPerimetr() {
       if(!isExist()){
           return Double.NaN;
       }
       double result=0;
        for (var el :getSidesLenght()) {
            result+=el;
        }
        return result;
    }

    @Override
    public double getSquare() {
        if(!isExist()){
            return Double.NaN;
        }
        double p = getPerimetr()/2;
        ArrayList<Double> sides = getSidesLenght();
        double square=Math.sqrt((p-sides.get(0))*(p-sides.get(1))*(p-sides.get(2))*(p-sides.get(3))- sides.get(0)*sides.get(1)*sides.get(2)*sides.get(3)*(Math.pow((Math.cos((angle1+angle2)/2)),2)));
        return square;
    }

    @Override
    public ArrayList<Double> getSidesLenght() {
        ArrayList<Double> sidesLenght = new ArrayList<Double>();
        Coordinates[] allCoords={dot1,dot2,dot3,dot4};
        double sideLength;
        for (int i = 0;i < allCoords.length;i++){
            if( i != 3 ){
                sideLength = Math.sqrt(Math.pow((allCoords[i].getX() - allCoords[i+1].getX()),2) + Math.pow((allCoords[i].getY() - allCoords[i+1].getY()),2));

            }else{
                sideLength = Math.sqrt(Math.pow((allCoords[allCoords.length-1].getX() - allCoords[0].getX()),2) + Math.pow((allCoords[allCoords.length-1].getY() - allCoords[0].getY()),2));
            }
            sidesLenght.add(sideLength);
        }
        return sidesLenght;
    }

    @Override
    public double[] getDiagonalsLenght() {

        if(!isExist()){
            return  null;
        }
        ArrayList<Double> sides = getSidesLenght();
        double a = sides.get(0);
        double b = sides.get(1);
        double c = sides.get(2);
        double p = Math.sqrt( Math.pow(a,2) + Math.pow(b,2) - 2*a*b*Math.cos(angle1) );
        double q = Math.sqrt( Math.pow(b,2) + Math.pow(c,2) - 2*b*c*Math.cos(angle2) ) ;
        double[] result = {p,q};
        return result;
    }

    @Override
    public boolean isExist() {
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
        if(maxSideLength >=sideLengthWithOutMax){
            return false;
        }else{
            return true;
        }

    }
}
