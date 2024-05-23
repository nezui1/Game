import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntityLoader {

    public static Entity loadFromFile(String fileName) {
        Entity entity = new Entity();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String fieldName = parts[0].trim();
                    String valueStr = parts[1].trim();

                    switch (fieldName) {
                        case "step":
                            entity.setStep(Integer.parseInt(valueStr));
                            break;
                        case "stepSec":
                            entity.setStepSec(Integer.parseInt(valueStr));
                            break;
                        case "stepChance":
                            entity.setStepChance(Integer.parseInt(valueStr));
                            break;
                        case "cookieCounter":
                            entity.setCookieCounter(Integer.parseInt(valueStr));
                            break;
                        case "price1":
                            entity.setPrice1(Integer.parseInt(valueStr));
                            break;
                        case "price2":
                            entity.setPrice2(Integer.parseInt(valueStr));
                            break;
                        case "price3":
                            entity.setPrice3(Integer.parseInt(valueStr));
                            break;
                        case "priceImg":
                            entity.setPriceImg(Integer.parseInt(valueStr));
                            break;
                        default:
                            System.out.println("Unknown field: " + fieldName);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entity;
    }


}
