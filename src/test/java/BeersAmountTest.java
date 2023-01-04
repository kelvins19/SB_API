import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BeersAmountTest {

    @Test
    public void testGet20Beers() throws Exception {
        String response = BeersApiClient.getBeers(20);
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(response, JsonArray.class);
        assertEquals(20, array.size());
    }

    @Test
    public void testGet5Beers() throws Exception {
        String response = BeersApiClient.getBeers(5);
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(response, JsonArray.class);
        assertEquals(5, array.size());
    }

    @Test
    public void testGet1Beers() throws Exception {
        String response = BeersApiClient.getBeers(1);
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(response, JsonArray.class);
        assertEquals(1, array.size());
    }

    @Test
    public void testGetAllBeers() throws Exception {
        String response = BeersApiClient.getAllBeers();
        Gson gson = new Gson();
        JsonArray array = gson.fromJson(response, JsonArray.class);
        System.out.println("Amount of Data: "+ array.size());
        assertEquals(25, array.size());

        for (int i = 0; i < array.size(); i++) {
            JsonObject element = array.get(i).getAsJsonObject();
            String name = element.get("name").getAsString();
            System.out.println(name);
        }
    }

    @Test
    public void testGetAllBeersSchema() throws Exception {
        String response = BeersApiClient.getAllBeers();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseNode = mapper.readTree(response);

        // Load the JSON schema document
        JsonNode schemaNode = JsonLoader.fromFile(new File("schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema schema = factory.getSchema(schemaNode);

        // Validate the response against the schema
        Set<ValidationMessage> errors = schema.validate(responseNode);
        assertTrue(errors.isEmpty());
    }
}
