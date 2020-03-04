package models.csgotm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPriceRequest {
    public Item[] items;
}
