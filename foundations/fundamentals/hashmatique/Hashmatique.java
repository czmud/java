import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    HashMap<String, String> trackList = new HashMap<String, String>();
    
    public void addNewTrack( String title, String lyrics ){
        trackList.put(title, lyrics);
        return;
    }
    public String getTrackByTitle( String title ) {
        return trackList.get(title);
    }
    public void getAllTracks() {
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(String.format("%s: %s", key, trackList.get(key)));   
        }
    }
}


