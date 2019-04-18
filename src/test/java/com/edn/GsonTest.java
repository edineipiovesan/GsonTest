package com.edn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.*;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class GsonTest {

    @Test
    public void deserializeTest() {
        Type collectionType = new TypeToken<Collection<TVMazeApiResponse>>(){}.getType();
        List<TVMazeApiResponse> response = new Gson().fromJson(Constants.TV_MAZE_JSON_RESPONSE, collectionType);

        TVMazeApiResponse firstResponse = response.get(0);

        assertEquals(firstResponse.getScore(), (Double) 17.677668);
        assertEquals(firstResponse.getShow().getId(), (Integer) 41734);
        assertEquals(firstResponse.getShow().getUrl(), "http://www.tvmaze.com/shows/41734/girls");
        assertEquals(firstResponse.getShow().getName(), "GIRLS");
        assertEquals(firstResponse.getShow().getType(), "Scripted");
        assertEquals(firstResponse.getShow().getLanguage(), "Mongolian");
        assertEquals(firstResponse.getShow().getGenres(), singletonList("Comedy"));
        assertEquals(firstResponse.getShow().getStatus(), "Running");
        assertEquals(firstResponse.getShow().getRuntime(), (Integer) 41);
        assertNull(firstResponse.getShow().getPremiered());
        assertNull(firstResponse.getShow().getOfficialSite());
        assertEquals(firstResponse.getShow().getSchedule().getTime(), "");
        assertEquals(firstResponse.getShow().getSchedule().getDays(), singletonList("Thursday"));
        assertNull(firstResponse.getShow().getRating().getAverage());
        assertEquals(firstResponse.getShow().getWeight(), (Integer) 0);
        assertEquals(firstResponse.getShow().getNetwork().getId(), (Integer) 1672);
        assertEquals(firstResponse.getShow().getNetwork().getName(), "UBS");
        assertEquals(firstResponse.getShow().getNetwork().getCountry().getName(), "Mongolia");
        assertEquals(firstResponse.getShow().getNetwork().getCountry().getCode(), "MN");
        assertEquals(firstResponse.getShow().getNetwork().getCountry().getTimezone(), "Asia/Ulaanbaatar");
        assertNull(firstResponse.getShow().getWebChannel());
        assertNull(firstResponse.getShow().getExternals().getTvrage());
        assertNull(firstResponse.getShow().getExternals().getThetvdb());
        assertEquals(firstResponse.getShow().getExternals().getImdb(), "tt8709752");
        assertEquals(firstResponse.getShow().getImage().getMedium(), "http://static.tvmaze.com/uploads/images/medium_portrait/191/478539.jpg");
        assertEquals(firstResponse.getShow().getImage().getOriginal(), "http://static.tvmaze.com/uploads/images/original_untouched/191/478539.jpg");
        assertNull(firstResponse.getShow().getSummary());
        assertEquals(firstResponse.getShow().getUpdated(), (Integer) 1555040569);
        assertEquals(firstResponse.getShow().getLinks().getSelf().getHref(), "http://api.tvmaze.com/shows/41734");
    }
}
