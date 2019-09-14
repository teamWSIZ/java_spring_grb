package wsi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarType {
    String name;
    Integer wheels;
    Integer shields;
    Integer engines;

}
