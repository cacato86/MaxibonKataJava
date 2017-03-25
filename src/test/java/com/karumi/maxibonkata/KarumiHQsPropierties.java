package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by carloscarrasco on 25/3/17.
 */

@RunWith(JUnitQuickcheck.class)
public class KarumiHQsPropierties {

    //Bad Practice but works
//    private Developer developer;
//    @Before
//    public void setUp() throws Exception {
//        DevelopersGenerator generator = new DevelopersGenerator();
//        developer = generator.generate(new SourceOfRandomness(new Random()));
//    }
//
//    @Property
//    public void checkIfThereAreMaxibonsRemaining(){
//        System.out.print(developer.toString());
//        KarumiHQs karumiHQs = new KarumiHQs();
//        karumiHQs.openFridge(developer);
//        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
//
//    }

    @Property
    public void checkIfThereAreMoreThan2MaxibonsRemaining(@From(DevelopersGenerator.class) Developer developer){
        System.out.print(developer.toString());
        KarumiHQs karumiHQs = new KarumiHQs();
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);

    }
}
