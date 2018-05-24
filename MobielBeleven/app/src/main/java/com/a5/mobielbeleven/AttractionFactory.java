package com.a5.mobielbeleven;

import java.util.ArrayList;

public class AttractionFactory
{
    private static AttractionFactory instance = null;

    private ArrayList<Attraction> attractions = new ArrayList<>();

    private AttractionFactory()
    {
        generate();
    }

    private void generate()
    {
        attractions.add(new Attraction(
                "Cobra",
                "Achtbaan",
                "Zet je wereld op z’n kop en ontsnap aan de draaiende wurggreep van de Cobra die in alle rust op je wacht. Overleef de kronkelende bewegingen op grote hoogte in deze stalen achtbaan met dubbele looping en kurkentrekker.",
                "",
                "Spelletje",
                "Snake")
                        );
        attractions.add(new Attraction(
                "Pieter en de Slang",
                "Achtbaan",
                "",
                "",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Vastenavond Festival",
                "Trage baan",
                "",
                "",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Goudvis",
                "",
                "",
                "",
                "Spelletje",
                "")
        );
        attractions.add(new Attraction(
                "Fat Morgan",
                "Trage Baan",
                "",
                "",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Villa Ampera",
                "Spookhuis",
                "",
                "",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Henk",
                "Bobslee",
                "",
                "",
                "Spelletje",
                "")
        );
        attractions.add(new Attraction(
                "Herr Kannibale",
                "Draaimolen",
                "",
                "",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Hongerige Hans",
                "Afvalbak",
                "",
                "",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Vogel Blues",
                "Achtbaan",
                "",
                "",
                "Spelletje",
                "")
        );
    }

    public static AttractionFactory getInstance()
    {
        if (instance == null)
            instance = new AttractionFactory();

        return instance;
    }


    public ArrayList<Attraction> getFurbies()
    {
        return attractions;
    }
}
