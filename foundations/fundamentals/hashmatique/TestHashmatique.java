import java.util.HashMap;
public class TestHashmatique {
    public static void main( String[] args ) {
        // construct track list
        Hashmatique trackList = new Hashmatique();

        trackList.addNewTrack("love the way you fly", "When you fly, I see you in the sky");
        trackList.addNewTrack("frogs", "frogs like rain, they feel no pain");
        trackList.addNewTrack("dogs", "dogs eat bones, they can't use phones");
        trackList.addNewTrack("hogs", "hogs flop in mud, they don't chew their cud");
        // Prevent override song that already exists in trackList
        trackList.addNewTrack("hogs", "can't make me sing");
        
        System.out.println(trackList.getTrackByTitle( "dogs" ));
        
        trackList.getAllTracks();
    }
}