class Content {
    String title;
    Content(String title) { this.title = title; }
}

class Movie extends Content {
    int duration;
    Movie(String t, int d) { super(t); duration = d; }
    public void showMovieInfo() {
        System.out.println("🎬 Movie: " + title + " | Duration: " + duration + " mins");
    }
}

class TVSeries extends Content {
    int seasons;
    TVSeries(String t, int s) { super(t); seasons = s; }
    public void showSeriesInfo() {
        System.out.println("📺 Series: " + title + " | Seasons: " + seasons);
    }
}

class Documentary extends Content {
    String tag;
    Documentary(String t, String tag) { super(t); this.tag = tag; }
    public void showDocInfo() {
        System.out.println("🎥 Documentary: " + title + " | Tag: " + tag);
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Content c = new Movie("Inception", 148); // Upcasting
        if (c instanceof Movie) {                // Downcasting
            Movie m = (Movie) c;
            m.showMovieInfo();
        }
    }
}
