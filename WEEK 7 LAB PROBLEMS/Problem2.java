class Post {
    String author, content;
    String time;

    Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println(author + " posted: " + content + " at " + time);
    }
}

class InstagramPost extends Post {
    InstagramPost(String a, String c, String t) { super(a, c, t); }
    public void display() {
        System.out.println("📸 Instagram | " + author + ": " + content + " #trending ❤️ Likes");
    }
}

class TwitterPost extends Post {
    TwitterPost(String a, String c, String t) { super(a, c, t); }
    public void display() {
        System.out.println("🐦 Twitter | " + author + ": " + content + " (" + content.length() + " chars) 🔁 Retweets");
    }
}

class LinkedInPost extends Post {
    LinkedInPost(String a, String c, String t) { super(a, c, t); }
    public void display() {
        System.out.println("💼 LinkedIn | " + author + " shared professionally: " + content + " 🤝 Connections");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Post p1 = new InstagramPost("Alice", "Vacation in Bali!", "10:00AM");
        Post p2 = new TwitterPost("Bob", "Learning Java Polymorphism!", "11:00AM");
        Post p3 = new LinkedInPost("Charlie", "New job opportunity!", "12:00PM");

        p1.display();
        p2.display();
        p3.display();
    }
}
