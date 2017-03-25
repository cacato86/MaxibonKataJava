package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

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

    private Chat chat;

    @Before
    public void setUp() throws Exception {
        chat = mock(Chat.class);
    }

    @Property(trials = 10)
    public void checkIfThereAreMoreThan2MaxibonsRemainingWhenOnlyOneDeveloper(
            @From(DevelopersGenerator.class) Developer developer) {
        System.out.print(developer.toString());
        KarumiHQs karumiHQs = new KarumiHQs();
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);

    }

    @Property
    public void checkIfThereAreMoreThan2MaxibonsRemainingWhenMultipleDevelopers(
            List<@From(DevelopersGenerator.class) Developer> developer) {
        System.out.print(developer.toString());
        KarumiHQs karumiHQs = new KarumiHQs();
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);

    }

    @Property
    public void checkIfHungryDevelopersSendMessageToChat(
            @From(HungryDevelopersGenerator.class) Developer developer) {
        KarumiHQs karumiHQs = new KarumiHQs(chat);
        karumiHQs.openFridge(developer);
        Mockito.verify(chat).sendMessage("Hi guys, I'm " + developer.getName() + ". We need more maxibons!");
    }

    @Property
    public void checkIfNoHungryDevelopersSendMessageToChat(
            @From(NotSoHungryDevelopersGenerator.class) Developer developer) {
        KarumiHQs karumiHQs = new KarumiHQs(chat);
        karumiHQs.openFridge(developer);
        Mockito.verify(chat, never()).sendMessage("Hi guys, I'm " + developer.getName() + ". We need more maxibons!");
    }

}
