package  com.gitturami.bikeserver.infra.cafe_places;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe_places.repository.LightCafe;

import java.util.List;

public interface CafePlacesApi{
    CafeResponse getCafeList(String location);
    CafeResponse getAllCafeList();
    List<LightCafe> getAllLightCafeList();
    CafeRepo getCafeByName(String name);
}