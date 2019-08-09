package com.gitturami.bikeserver.config;

import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.net.ssl.*")
public class RetrofitConfigTest {
    private RetrofitConfig config;

    @Before
    public void setUp() {
        config = new RetrofitConfig();
    }

    @Test
    public void testGetBikeRetrofit() {
        final String bikeUrl = "http://openapi.seoul.go.kr:8088/4b64546d6862687339384d4b625366/json/";
        config.setBikeUrl(bikeUrl);
        BikeRetrofit bikeRetrofit = config.getBikeRetrofit();
        assertNotNull(bikeRetrofit);
    }
}
