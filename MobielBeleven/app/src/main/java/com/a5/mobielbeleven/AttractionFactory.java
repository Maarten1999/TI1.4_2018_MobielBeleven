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
                "Versla de draak die het koninkrijk teistert. Alle krijgers worden uitgedaagd één van de banen te kiezen en met ‘Aarde’ of ‘Lucht’ het beest te kloppen. Degene die hierin het snelst slaagt, krijgt alle eer na een rit in deze houten racerachtbaan.",
                "",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Vastenavond Festival",
                "Trage baan",
                "Deel vreugde en geluk met elkaar en ontmoet vrolijke mensen. Jokie & Jet nemen je mee op reis naar verschillende landen! Maak kennis met diverse culturen en feest mee met alle rode oortjes ter wereld. Ontdek de verschillen en overeenkomsten in Vastenavond Festival.",
                "",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Goudvis",
                "Wildwaterbaan",
                "In een land hier ver vandaan neemt een wilde rivier je mee langs watervallen, rotsen en totempalen. De stroomversnelling bepaalt jouw route in dit peddelloze avontuur. Probeer deze 3500 meter lange wildwaterrivier te trotseren. Weet jij droog te blijven?",
                "",
                "Spelletje",
                "")
        );
        attractions.add(new Attraction(
                "Fat Morgan",
                "Trage Baan",
                "Diep in het Oosterse paleis ligt een schitterende schat verborgen. En terwijl de sultan zich omringt met vrouwen, pracht en praal, vullen de duistere gevangenissen zich met criminelen en ratten. Breng eens wat tijd op het water door en aanschouw allerlei Oosterse taferelen. Een boot voert je door wijken vol armoede maar ook rijkdom. En een reus beschermt het meest waardevolle bezit van de sultan: zijn edelstenen, zilveren kandelaren en goudstukken. ",
                "",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Villa Ampera",
                "Spookhuis",
                "In de achttiende eeuw trokken de Bokkenrijders plunderend en brandstichtend door het platteland. Leider van dit boevenpak, Hugo van den Loonsche Duynen, belandde na een lange tocht bij de Abdij van Postel. Wat hij daar zag, vervulde zijn hebzucht. Nergens waar ook ter wereld kon hij nog vrede vinden. Zelfs niet in zijn eigen statige huis. Treed binnen voor een duizelingwekkende rit in dit draaiende huis.",
                "",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Henk",
                "Bobslee",
                "Met 90 km/u naar beneden? Slinger door bochten en voel hoe de wind langs je gezicht glijdt. In de bobsleebaan bibber je zelfs zonder sneeuw. De Bob is een 1524 m lange bobbaan en geschikt voor alle waaghalzen.",
                "",
                "Spelletje",
                "")
        );
        attractions.add(new Attraction(
                "Herr Kannibale",
                "Draaimolen",
                "",
                "Op het eiland van Herr Kannibale draaien grote kookketels continu rond boven een knapperend vuur. Een ieder die voet aan land zet, mag plaatsnemen in dit duizelingwekkend avontuur totdat ze de kannibaal om genade smeekt.",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Hongerige Hans",
                "GFT-verslinder",
                "In een land ver van hier leefde een familie die altijd honger had. GFT-afval was het favoriete gerecht dat zij het liefst aten. Ze maakten van het eten van papieren hun beroep en besloten de natuur van de Esteling te beschermen tegen alle troep. Sindsdien stopt de familie niet meer met eten. Heb jij GFT-afval bij je? Probeer Hongerige Hans tijdens je bezoek dan niet te vergeten.",
                "",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Vogel Blues",
                "Achtbaan",
                "Vogel Blues neemt je mee! In zijn klauwen beleef je een huiveringwekkende vlucht in het donker. Langs slangen door de duisternis totdat de enorme roofvogel met de kracht van wel honderd leeuwen zijn nest bereikt heeft.",
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
