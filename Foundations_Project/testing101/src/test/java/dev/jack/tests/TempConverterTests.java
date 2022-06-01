package dev.jack.tests;

import dev.jack.science.AbsoluteZeroException;
import dev.jack.science.TempConvertor;
import dev.jack.science.TempType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TempConverterTests {

    static TempConvertor tempConvertor = null;

    @Test
    public void f_to_c(){
        double c = tempConvertor.convertFahrenheitCelcius(212):
        Assertions.assertEquals(100,c);

    }

    @Test
    public void c_to_f(){
        double f = tempConvertor.convertCelciusFahrenheit(100);
        Assertions.assertEquals(212,f);
    }
     @Test
    public void convert_upper(){

        double f = tempConvertor.convert_upper("Celcius, Fahrenheit, 0");
        Assertions.assertEquals(32,f);
    }
    public void convert_lower() {

        double f = tempConvertor.convert_lower("Celcius, Fahrenheit, 0");
        Assertions.assertEquals(32, f);

    }
    public void convert_mixed_case() {

        double f = tempConvertor.convert("Celcius, Fahrenheit, 0");
        Assertions.assertEquals(32, f);

    }


    @Test
    public void convert_enums(){
        double f = tempConvertor.convert(TempType.Celcius, TempType.Fahrenheit, 0);
        Assertions.assertEquals(32,f);
    }

    public void below_absolute_zero(){

        Assertions.assertThrows(AbsoluteZeroException.class, ()->{
           tempConvertor.convert("f", to "c"-2000);
        });
    }

}
