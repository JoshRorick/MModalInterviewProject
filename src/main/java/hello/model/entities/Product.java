package hello.model.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private String name;
    private String description;
    private String cost;

    @JsonCreator
    public Product(@JsonProperty("name") String name, @JsonProperty("description") String description,
                   @JsonProperty("cost") String cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
