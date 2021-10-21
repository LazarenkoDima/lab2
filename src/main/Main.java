package main;

import classes.Coordinates;
import classes.Parallelogram;
import classes.Quadrangle;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Quadrangle> getNQuadrangles(int n){
        ArrayList<Quadrangle> result = new ArrayList<Quadrangle>();
        Coordinates dotA = new Coordinates(0,0);
        Coordinates dotB = new Coordinates(1,0);
        Coordinates dotC = new Coordinates(0,1);
        Coordinates dotD = new Coordinates(1,1);
        Quadrangle quadr = new Quadrangle(dotA,dotB,dotC,dotD,100,70);
        result.add(quadr);
        for(int i =0;i<n;i++){
            Coordinates dot1 = new Coordinates(0+Math.random()*10,0+Math.random()*10);
            Coordinates dot2 = new Coordinates(-10 + Math.random()*10,0+Math.random()*10);
            Coordinates dot3 = new Coordinates(0+Math.random()*10,-10 + Math.random()*10);
            Coordinates dot4 = new Coordinates(-10 + Math.random()*10,-10 + Math.random()*10);
            Quadrangle quad = new Quadrangle(dot1,dot2,dot3,dot4,1+Math.random()*90,1+Math.random()*90);
            result.add(quad);
        }
        return result;
    }

    public static ArrayList<Parallelogram> getMParallelogram(int m){
        ArrayList<Parallelogram> result = new ArrayList<Parallelogram>();
        Coordinates dotA = new Coordinates(0,0);
        Coordinates dotB = new Coordinates(1,0);
        Coordinates dotC = new Coordinates(0,1);
        Coordinates dotD = new Coordinates(1,1);
        Coordinates dotA1 = new Coordinates(0,0);
        Coordinates dotB1 = new Coordinates(10,0);
        Coordinates dotC1 = new Coordinates(0,10);
        Coordinates dotD1 = new Coordinates(10,10);
        Parallelogram parallelogram = new Parallelogram(dotA,dotB,dotC,dotD,30,60);
        Parallelogram par = new Parallelogram(dotA1,dotB1,dotC1,dotD1,90,90);
        result.add(parallelogram);
        result.add(par);
        for(int i =0;i<m-1;i++){
            Coordinates dot1 = new Coordinates(0+Math.random()*5,0+Math.random()*10);
            Coordinates dot2 = new Coordinates(0 + Math.random()*5,0+Math.random()*10);
            Coordinates dot3 = new Coordinates(0+Math.random()*10,0 + Math.random()*5);
            Coordinates dot4 = new Coordinates(0 + Math.random()*5,0 + Math.random()*10);
            Parallelogram parl = new Parallelogram(dot1,dot2,dot3,dot4,1+Math.random()*90,1+Math.random()*90);
            result.add(parl);
        }
        return result;
    }

    public  static double getAverageSquare(int n){

        ArrayList<Quadrangle> quadrangles = getNQuadrangles(n);
        double avarageSuqre = 0;
        double size = quadrangles.size();
        for (var el:quadrangles) {
            double square = el.getSquare();
            if(!Double.isNaN(square)){
                avarageSuqre += square;
            }else{
                if(size!=0){
                    size--;
                }

            }
        }
        avarageSuqre = avarageSuqre / size;
        return avarageSuqre;
    }

    public static Parallelogram getMinParallelogramSquare(ArrayList<Parallelogram> list){
        Parallelogram result = new Parallelogram(0,0,0,0,0,0,0,0,0,0);
        double min = Double.MAX_VALUE;
        for (var el : list) {
            double tempSquare = el.getSquare();
            if( tempSquare< min && tempSquare != Double.NaN){
                min = tempSquare;
                result = el;
            }
        }

        return  result;
    }

    public  static Parallelogram getMaxParallelogramSquare(ArrayList<Parallelogram> list){
        Parallelogram result = new Parallelogram(0,0,0,0,0,0,0,0,0,0);
        double max = Double.MIN_VALUE;
        for (var el: list) {
            double tempSquare = el.getSquare();
            if(tempSquare > max && tempSquare != Double.NaN){
                max = tempSquare;
                result = el;
            }
        }
        return  result;
    }


    public static void main(String[] args) {
        double avarageSquare = getAverageSquare(10);
        System.out.println("Average square of quadrangles: "+ Double.toString(avarageSquare));
        ArrayList<Parallelogram> parallelograms = getMParallelogram(10);
        System.out.println("Parallelogram with max square: " + getMaxParallelogramSquare(parallelograms).toString() );
        System.out.println("Parallelogram with min square: " + getMinParallelogramSquare(parallelograms).toString());
    }
}
