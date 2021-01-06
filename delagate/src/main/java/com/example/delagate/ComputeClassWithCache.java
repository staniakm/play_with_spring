package com.example.delagate;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@WithCache

public class ComputeClassWithCache implements IComputeClass {
    private final Set<Integer> computed = new HashSet<>();

    private final IComputeClass delegate;

    public ComputeClassWithCache(final IComputeClass delegate) {
        this.delegate = delegate;
    }


    @Override
    public void doSomeStuff(int value) throws InterruptedException {

        if (computed.contains(value)) {
            System.out.println("Doing with cache");
            System.out.println("Job already done " + value);
            return;
        }
        System.out.println("Delegeting......");
        delegate.doSomeStuff(value);
        computed.add(value);

    }
}
