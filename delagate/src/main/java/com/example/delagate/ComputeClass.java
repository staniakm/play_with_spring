package com.example.delagate;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@WithoutCache
public class ComputeClass implements IComputeClass {

    @Override
    public void doSomeStuff(int value) throws InterruptedException {
        System.out.println("Doing stuff " + value);
        Thread.sleep(2000);
        System.out.println("Finished doing stuff " + value);
    }
}
