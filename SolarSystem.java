/*In response to the feedback , firstly, i wrapped the lines so no line has more than
100 characters . Secondly, this time i laid out correctly the block instructions(if-else,
for loop) with curly brackets even if it has only one instruction
  */

import java.util.ArrayList;

public class SolarSystem
{
    private String systemName;
    private double luminosity;
    /*minLumin variable holds the minimum luminosity required for a planet to be habitable*/
    private double minLumin;
    /*maxLumin variable holds the maximum luminosity required for a planet to be habitable*/
    private double maxLumin;
    /*the currentPlanet variable holds the details for the current */
    private Planet currentPlanet;
    private final String HABITABLE="yes";
    private final String NOT_HABITABLE="no";
    private final String NEWLINE="\n";
    private boolean habitableValue;
    private String output="";
    ArrayList<Planet> planetList=new ArrayList<>();


    /*The SolarSystem constructor sets the name and also the luminosity of
    the current solar system*/
    public SolarSystem(String name, double luminosity)
    {
        setName(name);
        setLuminosity(luminosity);
    }
    /*addPlanet method adds a new planet to the arraylist*/
    public void addPlanet(String name, double mass, double distance)
    {
        this.currentPlanet=new Planet(name,mass,distance);
        planetList.add(currentPlanet);
    }

    /*setLuminosity method sets the luminosity of the solar system and also the
    minimum and maximum luminosity required for a planet to be habitable*/
    public void setLuminosity(double luminosity)
    {
        this.luminosity = luminosity;
        minLumin=0.75*Math.sqrt(luminosity);
        maxLumin=2.0*Math.sqrt(luminosity);
    }

    /*setName method sets the name of the solar system*/
    public void setName(String name)
    {
        this.systemName=name;
    }

    /*getName method returns the name of the solar system*/
    public String getName()
    {
        return systemName;
    }

    /*getLuminosity method returns the luminosity of the solar system*/
    public double getLuminosity()
    {
        return luminosity;
    }

    /*the toString method joins the name of the solar system, as well as the details of all
    planets into one String variable called output, and then returns the variable*/
    public String toString()
    {
        output=output+getName()+NEWLINE;
        /*the for-ach loop gets through the planets of the arraylist and joins the String
        returned by the toPlanet method to the output String*/
        for(Planet planet:planetList)
        {
            output=output+planet.toPlanet();
            /*the habitableValue variable is true if the planet is habitable and is false
            if the planet is not habitable*/
            habitableValue=(planet.getMass()>=0.6 && planet.getMass()<=7.0 &&
                    planet.getDistance()>=minLumin && planet.getDistance()<=maxLumin);
            /*this if statement adds the HABITABLE String to the ouput if habitableValue is true
            and in the other case it adds the NOT_HABITABLE String*/
            if(habitableValue)
            {
                output=output+HABITABLE+NEWLINE;
            }
            else
            {
                output=output+NOT_HABITABLE+NEWLINE;
            }
        }
        return(output);
    }
}
