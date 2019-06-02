package edu.mum.serviceimpl;

import edu.mum.domain.Calculator;
import edu.mum.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public int getSum(Calculator calc) {
        return calc.getNumOne() + calc.getNumTwo();
    }

    @Override
    public int getMul(Calculator calc) {
        return calc.getNumThree() * calc.getNumFour();
    }
}
