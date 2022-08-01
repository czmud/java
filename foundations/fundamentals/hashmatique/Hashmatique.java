import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    HashMap<String, String> trackList = new HashMap<String, String>();
    
    public void addNewTrack( String title, String lyrics ){
        if ( !trackList.containsKey(title)){
            trackList.put(title, lyrics);
            System.out.println("Saved successfully.");
        } else {
            System.out.println("Track title already exists. Did not save.");
        }
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


