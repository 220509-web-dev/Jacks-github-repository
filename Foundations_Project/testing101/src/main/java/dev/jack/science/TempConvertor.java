package dev.jack.science;

//convert celcius fahrenheit and kelivin
public interface TempConvertor {


     public double convertFahrenheitCelcius(double fahrenheit);
    public double convertFahrenheitKelvin(double fahrenheit);

    public double convertCelciusFahrenheit(double celcius);
    public double convertCelciusKelvin(double celcius);

    public double convertKelvinCelcius(double kelvin);
    public double convertKelvinFahrenheit(double kelvin);

    public double convert(String from, String to, double temp);

    public double convert(TempType from,)


}



