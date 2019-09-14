package wsi.service;


import org.springframework.stereotype.Component;
import wsi.model.CarType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component public class CarTypeService {
    private Set<CarType> types;

    public CarTypeService() {
        types = new HashSet<>();
        types.add(new CarType("regular", 4, 2, 1));
        types.add(new CarType("regular+", 5, 2, 1));
        types.add(new CarType("regular pro", 4, 2, 2));
        types.add(new CarType("regular pro+", 5, 2, 2));
    }

    public void addType(CarType nowy) {
        types.add(nowy);
    }

    public List<CarType> getAllTypes() {
        return new ArrayList<>(types);
    }
}
