package mum.edu.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeneratedNumbers {

    private int control;
    private int first;
    private int second;
    private int third;

    public GeneratedNumbers(int control, int first, int second, int third){
        this.control = control;
        this.first = first;
        this.second = second;
        this.third = third;
    }



}
