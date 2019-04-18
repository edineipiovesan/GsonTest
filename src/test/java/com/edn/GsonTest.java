package com.edn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GsonTest {

    @Test
    public void deserializeTest() {
        Type collectionType = new TypeToken<Collection<TVMazeApiResponse>>(){}.getType();
        List<TVMazeApiResponse> response = new Gson().fromJson(Constants.TV_MAZE_JSON_RESPONSE, collectionType);

        TVMazeApiResponse firstResponse = response.stream().findFirst().orElse(new TVMazeApiResponse());
        assertEquals(firstResponse.getScore(), (Double) 17.677668);

        TVMazeApiResponse.Show show = firstResponse.getShow();
        assertEquals((Integer) 41734, show.getId());
        assertEquals("http://www.tvmaze.com/shows/41734/girls", show.getUrl());
        assertEquals("GIRLS", show.getName());
        assertEquals("Scripted", show.getType());
        assertEquals("Mongolian", show.getLanguage());
        assertEquals(singletonList("Comedy"), show.getGenres());
        assertEquals("Running", show.getStatus());
        assertEquals((Integer) 41, show.getRuntime());
        assertNull(show.getPremiered());
        assertNull(show.getOfficialSite());
        assertNull(show.getRating().getAverage());
        assertEquals((Integer) 0, show.getWeight());
        assertNull(show.getWebChannel());
        assertNull(show.getSummary());
        assertEquals((Integer) 1555040569, show.getUpdated());
        assertEquals("http://api.tvmaze.com/shows/41734", show.getLinks().getSelf().getHref());

        TVMazeApiResponse.Schedule schedule = show.getSchedule();
        assertEquals("", schedule.getTime());
        assertEquals(singletonList("Thursday"), schedule.getDays());

        TVMazeApiResponse.Network network = show.getNetwork();
        assertEquals((Integer) 1672, network.getId());
        assertEquals("UBS", network.getName());
        assertEquals("Mongolia", network.getCountry().getName());
        assertEquals("MN", network.getCountry().getCode());
        assertEquals("Asia/Ulaanbaatar", network.getCountry().getTimezone());

        TVMazeApiResponse.Externals externals = show.getExternals();
        assertNull(externals.getTvrage());
        assertNull(externals.getThetvdb());
        assertEquals("tt8709752", externals.getImdb());

        TVMazeApiResponse.Image image = show.getImage();
        assertEquals("http://static.tvmaze.com/uploads/images/medium_portrait/191/478539.jpg", image.getMedium());
        assertEquals("http://static.tvmaze.com/uploads/images/original_untouched/191/478539.jpg", image.getOriginal());
    }

    @Test
    public void deserializeAsMap() {
        Type collectionType = new TypeToken<Collection<TVMazeApiResponse>>() {
        }.getType();
        List<TVMazeApiResponse> response = new Gson().fromJson(Constants.TV_MAZE_JSON_RESPONSE, collectionType);

        Map<Integer, TVMazeApiResponse.Show> showMap = new HashMap<>();
        response.forEach(r -> showMap.put(r.getShow().getId(), r.getShow()));

        assertEquals("Girls", showMap.get(139).getName());
        assertEquals("Good Girls", showMap.get(23542).getName());
    }
}
