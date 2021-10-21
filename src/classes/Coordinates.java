package classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x,double y){
        this.x = x;
        this.y = y;
    }

}
