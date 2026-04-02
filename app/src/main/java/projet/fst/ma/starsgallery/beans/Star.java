package projet.fst.ma.starsgallery.beans;

public class Star {
    private int id;
    private String name;
    private String img; // Contiendra l'URL ou le nom de l'image
    private float rating; // Note de la star (0 à 5)
    private static int counter = 0;

    public Star(String name, String img, float rating) {
        this.id = ++counter;
        this.name = name;
        this.img = img;
        this.rating = rating;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getImg() { return img; }
    public float getRating() { return rating; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setImg(String img) { this.img = img; }
    public void setRating(float rating) { this.rating = rating; }
}