package fr.riverjach.interop;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class Jhava {
    private int hitPoints = 52489112;
    private String greeting = "BLARGH";

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());
        System.out.println("Noms :");
        Spellbook spellbook = new Spellbook();
        for (String spell : spellbook.spells) {
            System.out.println(spell);
        }

        System.out.println("Nombre maximal de noms : " + Spellbook.MAX_SPELL_COUNT);

        Spellbook.getSpellbookGreeting();

        Function1<String, Unit> translator = Hero.getTranslator();
        translator.invoke("TREVE");
    }

    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void offerFood() {
        Hero.handOverFood("de la Pizza");
    }

    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            System.out.println("Capturé !");
        }
    }
}
