package  com.gitturami.bikeserver.infra.cafe_places;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeList;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe_places.repository.LightCafe;

import java.util.List;

public interface CafePlacesApi{
    CafeList getCafeList(String location);
    List<CafeRepo> getAllPageCafeList(String location);
    List<LightCafe> getAllLightCafeList(String location);
    CafeRepo getCafeByName(String name);
}