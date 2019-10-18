import java.text.DecimalFormat;

public class Planet
{
    private String name;
    private double mass;
    private double distance;
    private double orbitalPeriod;

    /*we create an object of the DecimalFormat class so no variable of the Planet class
    has more than 3 decimals each(mass, distance, orbitalPeriod)*/
    DecimalFormat df=new DecimalFormat("0.0##");

    /*The Planet constructor sets the name,the mass, the distance and also the orbital period
    * of the Planet*/
    public Planet(String name, double mass, double distance)
    {
        setNamePlanet(name);
        setMass(mass);
        setDistance(distance);
        setOrbitalPeriod();
    }

    /*we write a no argument constructor as we loose the free one by writing the above constructor*/
    public Planet()
    {
    }

    /*setNamePlanet method sets the name of the planet*/
    public void setNamePlanet(String name)
    {
        this.name = name;
    }

    public String getNamePlanet()
    {
        return name;
    }

    /*setNamePlanet method sets the name of the planet*/
    public void setMass(double mass)
    {
        this.mass=mass;
    }

    /*getMass method returns the mass of the planet*/
    public double getMass()
    {
        return mass;
    }

    /*setNamePlanet method sets the distance of the planet*/
    public void setDistance(double distance)
    {
        this.distance=distance;
    }

    /*getDistance method returns the distance of the planet*/
    public double getDistance()
    {
        return distance;
    }

    /*setNamePlanet method sets the orbital period of the planet*/
    public void setOrbitalPeriod()
    {
        this.orbitalPeriod = Math.sqrt(distance*distance*distance);
    }

    /*getOrbitalPeriod method returns the orbitalPeriod of the planet*/
    public double getOrbitalPeriod()
    {
        return orbitalPeriod;
    }

    /*the toPlanet method returns a String which contains the name of the planet, as well as
    the mass, the distance, and the orbital period of the planet*/
    public String toPlanet()
    {
        /*df.format sets all the values to not have more than 3 decimals and replace(",",".")
        sets the group separator to be "." instead of ","*/
        return("Planet "+getNamePlanet()+" has a mass of "+df.format(getMass()).replace(",",".")
                +" Earths, is "+df.format(getDistance()).replace(",",".")
                +"AU from its star, and orbits in "+
                df.format(getOrbitalPeriod()).replace(",",".")+" years: could be habitable? ");
    }
}
