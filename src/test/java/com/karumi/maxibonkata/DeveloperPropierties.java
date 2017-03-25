package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by carloscarrasco on 25/3/17.
 */

@RunWith(JUnitQuickcheck.class)
public class DeveloperPropierties {

    public static final String NAME = "Pedro";
    private Developer developerRandom;

    @Before
    public void setUp() throws Exception {
        DevelopersGenerator developersGenerator = new DevelopersGenerator();
        Random random = new Random();
        developerRandom = developersGenerator.generate(new SourceOfRandomness(random));
    }

    @Property
    public void theNumberOfMaxibonAssignedIsPositiveOrZeroWithFixedDeveloper(int numberOfMaxibom) {
        Developer developer = new Developer(NAME, numberOfMaxibom);
        System.out.print(developer.toString());
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Property
    public void theNumberOfMaxibonAssignedIsPositiveOrZeroWithDeveloperGenerator() {
        System.out.print(developerRandom.toString());
        assertTrue(developerRandom.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Test
    public void theNumberOfMaxibomGrap() {
        assertTrue(Karumies.ALBERTO.getNumberOfMaxibonsToGrab() == 1);
        assertTrue(Karumies.PEDRO.getNumberOfMaxibonsToGrab() == 3);
        assertTrue(Karumies.DAVIDE.getNumberOfMaxibonsToGrab() == 0);
        assertTrue(Karumies.SERGIO.getNumberOfMaxibonsToGrab() == 2);
        assertTrue(Karumies.JORGE.getNumberOfMaxibonsToGrab() == 1);
    }
}
