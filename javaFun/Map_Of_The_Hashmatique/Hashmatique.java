import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
  public void getSongs(){
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("Fire for you", "My heart just dropped, Thinkin' about you, The world just stops, When I'm without you.");
    trackList.put("Circle the Drain", "Split open, watching my heart go round and around, Round and around, Circle the drain, I'm going down");
    trackList.put("Trouble's Coming", "I gave my knuckles a run for their money, spider web, Cracks on the mirror, I see someone but not somebody");
    trackList.put("Skin and Bones", "Close my eyes and drift into the silence, Barely see the ultraviolet, Slipped and fell into the deep end");

    String track1 = trackList.get("Fire for you");
    System.out.println("The first song's lyrics is: " + track1);

    Set<String> titles = trackList.keySet();
    for(String title: titles){
      System.out.println(title);
      System.out.println(trackList.get(title));
    }
  }
}
