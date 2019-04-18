package com.edn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GsonTest {

    @Test
    public void deserializeTest() {
        Type collectionType = new TypeToken<Collection<TVMazeApiResponse>>(){}.getType();
        List<TVMazeApiResponse> response = new Gson().fromJson(Constants.TV_MAZE_JSON_RESPONSE, collectionType);

        TVMazeApiResponse firstResponse = response.get(0);
        assertEquals(firstResponse.getScore(), (Double) 17.677668);

        TVMazeApiResponse.Show show = firstResponse.getShow();
        assertEquals(show.getId(), (Integer) 41734);
        assertEquals(show.getUrl(), "http://www.tvmaze.com/shows/41734/girls");
        assertEquals(show.getName(), "GIRLS");
        assertEquals(show.getType(), "Scripted");
        assertEquals(show.getLanguage(), "Mongolian");
        assertEquals(show.getGenres(), singletonList("Comedy"));
        assertEquals(show.getStatus(), "Running");
        assertEquals(show.getRuntime(), (Integer) 41);
        assertNull(show.getPremiered());
        assertNull(show.getOfficialSite());
        assertNull(show.getRating().getAverage());
        assertEquals(show.getWeight(), (Integer) 0);
        assertNull(show.getWebChannel());
        assertNull(show.getSummary());
        assertEquals(show.getUpdated(), (Integer) 1555040569);
        assertEquals(show.getLinks().getSelf().getHref(), "http://api.tvmaze.com/shows/41734");

        TVMazeApiResponse.Schedule schedule = show.getSchedule();
        assertEquals(schedule.getTime(), "");
        assertEquals(schedule.getDays(), singletonList("Thursday"));

        TVMazeApiResponse.Network network = show.getNetwork();
        assertEquals(network.getId(), (Integer) 1672);
        assertEquals(network.getName(), "UBS");
        assertEquals(network.getCountry().getName(), "Mongolia");
        assertEquals(network.getCountry().getCode(), "MN");
        assertEquals(network.getCountry().getTimezone(), "Asia/Ulaanbaatar");

        TVMazeApiResponse.Externals externals = show.getExternals();
        assertNull(externals.getTvrage());
        assertNull(externals.getThetvdb());
        assertEquals(externals.getImdb(), "tt8709752");

        TVMazeApiResponse.Image image = show.getImage();
        assertEquals(image.getMedium(), "http://static.tvmaze.com/uploads/images/medium_portrait/191/478539.jpg");
        assertEquals(image.getOriginal(), "http://static.tvmaze.com/uploads/images/original_untouched/191/478539.jpg");
    }
}
