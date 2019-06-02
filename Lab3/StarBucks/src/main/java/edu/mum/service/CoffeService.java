package edu.mum.service;

import edu.mum.domain.Coffee;

public interface CoffeService {

    public Coffee findBreed(String roast);
    public String[] findRoast();

}
