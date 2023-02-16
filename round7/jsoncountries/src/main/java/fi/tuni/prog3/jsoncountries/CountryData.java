
package fi.tuni.prog3.jsoncountries;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eppuh
 */
public class CountryData {
    
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
    
        List<Country> countries = new ArrayList<>();
        
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(areaFile));
            Json area = gson.fromJson(reader, Json.class);
            
            reader = Files.newBufferedReader(Paths.get(gdpFile));
            Json gdp = gson.fromJson(reader, Json.class);
            
            reader = Files.newBufferedReader(Paths.get(populationFile));
            Json population = gson.fromJson(reader, Json.class);
            
            
            
            
            
            for (int i = 0; i < area.Root.data.record.size(); i++) {
                String name = area.Root.data.record.get(i).field.get(0).value;
                String areaS = area.Root.data.record.get(i).field.get(2).value;
                double areaD = Double.parseDouble(areaS);
                
                String gdpS = gdp.Root.data.record.get(i).field.get(2).value;
                double gdpD = Double.parseDouble(gdpS);
                
                String populationS = population.Root.data.record.get(i).field.get(2).value;
                long populationL = Long.parseLong(populationS);
                
                countries.add(new Country(name, areaD, populationL, gdpD));
            }
            
            
            
            
            // close reader
            reader.close();

        } catch (JsonIOException | JsonSyntaxException | IOException | NumberFormatException ex) {
        }
        
        return countries;
    }
    
    public static void writeToJson(List<Country> countries, String countryFile) {
        //Creating a JSONObject object
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      //Inserting key-value pairs into the json object
      
      try {
            String json = gson.toJson(countries);
          try (FileWriter writer = new FileWriter(countryFile)) {
              writer.write(json);
          }
      } catch (IOException e) {
          // TODO Auto-generated catch block

      }
      
    }
}

class Json {
    Data Root;
  
    
}
class Data {
     Record data;

  
}
class Record {
    List<Field> record;
 
}
class Field {
    List<Values> field;

    
}
class Values {
    String value;
    Attributes attributes;

    
}
class Attributes {
    String name;
    String key;
    
    
}
