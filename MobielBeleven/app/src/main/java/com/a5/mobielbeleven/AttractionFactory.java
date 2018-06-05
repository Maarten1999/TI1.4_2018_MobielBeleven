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
                "Zet je wereld op z’n kop en ontsnap aan de draaiende wurggreep van de Cobra die in alle rust op je wacht. " +
                        "Overleef de kronkelende bewegingen op grote hoogte in deze stalen achtbaan met dubbele looping en kurkentrekker.",
                "Turn your world upside down and escape from the turning stranglehold of the cobra that's waiting for you. " +
                        "Survive the winding movements at great hights in this steel rollercoaster with double looping and a corkscrew.",
                "cobra",
                "Spelletje",
                "Snake")
        );
        attractions.add(new Attraction(
                "Pieter en de Slang",
                "Achtbaan",
                "Versla de draak die het koninkrijk teistert. " +
                        "Alle krijgers worden uitgedaagd één van de banen te kiezen en met ‘Aarde’ of ‘Lucht’ het beest te kloppen. " +
                        "Degene die hierin het snelst slaagt, krijgt alle eer na een rit in deze houten racerachtbaan.",
                "Defeat the dragon that plagues the kingdom. " +
                        "All warriors will be challenged to pick one of the tracks to defeat the beast with 'Earth' or 'Air'. " +
                        "The one that succeeds the fastest, gets all the honor after a ride in this wooden rollercoaster.",
                "pieter_deslang",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Vastenavond Festival",
                "Trage baan",
                "Deel vreugde en geluk met elkaar en ontmoet vrolijke mensen. " +
                        "Jokie & Jet nemen je mee op reis naar verschillende landen! " +
                        "Maak kennis met diverse culturen en feest mee met alle rode oortjes ter wereld. " +
                        "Ontdek de verschillen en overeenkomsten in Vastenavond Festival.",
                "Share happyness and luck with each other and meet happy people. " +
                        "Jokie and Jet take you on a journey to different countries! " +
                        "Discover various cultures and party along with all the red ears in the world. " +
                        "Discover the differences and similarities in Shrove Tuesday Festival.",
                "vastenavond",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Goudvis",
                "Wildwaterbaan",
                "In een land hier ver vandaan neemt een wilde rivier je mee langs watervallen, rotsen en totempalen. " +
                        "De stroomversnelling bepaalt jouw route in dit peddelloze avontuur. " +
                        "Probeer deze 3500 meter lange wildwaterrivier te trotseren. Weet jij droog te blijven?",
                "In a country far, far away a wild river takes you along its waterfalls, rocks and totem poles. " +
                        "The rapids decide your route in this paddleless adventure. " +
                        "Try to defy this 3500 metres long wild water river. Will you manage to keep dry?",
                "goudvis",
                "Spelletje",
                "")
        );
        attractions.add(new Attraction(
                "Fat Morgan",
                "Trage Baan",
                "Diep in het Oosterse paleis ligt een schitterende schat verborgen. " +
                        "En terwijl de sultan zich omringt met vrouwen, pracht en praal, vullen de duistere gevangenissen zich met criminelen en ratten. " +
                        "Breng eens wat tijd op het water door en aanschouw allerlei Oosterse taferelen. " +
                        "Een boot voert je door wijken vol armoede maar ook rijkdom. " +
                        "En een reus beschermt het meest waardevolle bezit van de sultan: zijn edelstenen, zilveren kandelaren en goudstukken. ",
                "Deep in the Oriental palace is a glittering treasure hidden. " +
                        "And while the sultan surrounds himself with women, pomp and splendor, the dark prisons fill themselves with criminals and rats. " +
                        "Spend some time on the water and behold varying Oriental scenes. " +
                        "A boat takes you through neighborhoods filled with poverty and riches. " +
                        "And a giant protects the most valuable possession of the sultal: his gems, silver candlesticks and pieces of gold.",
                "fatmorgan",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Villa Ampera",
                "Spookhuis",
                "In de achttiende eeuw trokken de Bokkenrijders plunderend en brandstichtend door het platteland. " +
                        "Leider van dit boevenpak, Hugo van den Loonsche Duynen, belandde na een lange tocht bij de Abdij van Postel. " +
                        "Wat hij daar zag, vervulde zijn hebzucht. Nergens waar ook ter wereld kon hij nog vrede vinden. " +
                        "Zelfs niet in zijn eigen statige huis. Treed binnen voor een duizelingwekkende rit in dit draaiende huis.",
                "In the eighteenth century, the Buckriders pillaged and set fires across the country. " +
                        "The leader of this pack of thieves, Hugo van den Loonsche Duynen, arrived at the Abbey of Poster after a long journey. " +
                        "His greed was fulfilled with everything he saw there. Nowhere else in the world he could ever find peace again. Not even in his own stately home.",
                "villaampera",
                "Weetjes",
                "")
        );
        attractions.add(new Attraction(
                "Henk",
                "Bobslee",
                "Met 90 km/u naar beneden? Slinger door bochten en voel hoe de wind langs je gezicht glijdt. " +
                        "In de bobsleebaan bibber je zelfs zonder sneeuw. De Henk is een 1524 m lange bobbaan en geschikt voor alle waaghalzen.",
                "Want to fly at 60 km/h? Slam through corners and feel the wind in your face. No snow, but you still shake in the bobsleigh run. " +
                        "The Henk is a 1524 m long bobsleigh run and suitable for all daredevils. ",
                "henkslee",
                "Spelletje",
                "")
        );
        attractions.add(new Attraction(
                "Herr Kannibale",
                "Draaimolen",
                "Op het eiland van Herr Kannibale draaien grote kookketels continu rond boven een knapperend vuur. " +
                        "Een ieder die voet aan land zet, mag plaatsnemen in dit duizelingwekkend avontuur totdat ze de kannibaal om genade smeekt.",
                "Giant cooking pots spin on a flickering fire on the island of Herr Kannibale spinning cauldrons. " +
                        "Everyone who sets foot on land may enter this dizzy adventure until they beg for mercy from the cannibal. ",
                "herr_kannibale",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Hongerige Hans",
                "GFT-verslinder",
                "In een land ver van hier leefde een familie die altijd honger had. " +
                        "GFT-afval was het favoriete gerecht dat zij het liefst aten. " +
                        "Ze maakten van het eten van papieren hun beroep en besloten de natuur van de Esteling te beschermen tegen alle troep. " +
                        "Sindsdien stopt de familie niet meer met eten. Heb jij GFT-afval bij je? " +
                        "Probeer Hongerige Hans tijdens je bezoek dan niet te vergeten.",
                "In a land far far away lived a family who were always hungry but didn't like " +
                        "meat, bread or fish, it was in fact biodegradable waste they preferred to gobble up. " +
                        "They made their favourite meal their profession and keep Essteling's enviroment clean and free from rubbish. " +
                        "You will hear them shout 'GFT-afval hier' whenever you pass by, so if you have any biodegradable waste with you during your visit, please stop by and feed them - they will thank you!",
                "hongerigehans",
                "Raadsel",
                "")
        );
        attractions.add(new Attraction(
                "Vogel Blues",
                "Achtbaan",
                "Vogel Blues neemt je mee! In zijn klauwen beleef je een huiveringwekkende vlucht in het donker. " +
                        "Langs slangen door de duisternis totdat de enorme roofvogel met de kracht van wel honderd leeuwen zijn nest bereikt heeft.",
                "The Vogel Blues takes you on an high speed adventure. " +
                        "In its talons you’ll experience a terrifying flight in the dark passing serpents galore until this bird of prey, " +
                        "with the strength of a hundred lions, reaches its nest. You'll feel like Sinbad the Sailor on one of his adventures!",
                "vogelblues",
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

    public ArrayList<Attraction> getAttractions()
    {
        return attractions;
    }
}
