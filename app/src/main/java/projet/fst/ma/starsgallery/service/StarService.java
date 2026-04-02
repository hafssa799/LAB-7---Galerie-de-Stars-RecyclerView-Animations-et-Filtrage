package projet.fst.ma.starsgallery.service;

import projet.fst.ma.starsgallery.R; // Très important pour reconnaître les photos
import projet.fst.ma.starsgallery.beans.Star;
import projet.fst.ma.starsgallery.dao.IDao;
import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {
    private List<Star> stars;
    private static StarService instance;

    private StarService() {
        stars = new ArrayList<>();
        seed();
    }

    public static StarService getInstance() {
        if (instance == null) instance = new StarService();
        return instance;
    }

    private void seed() {
        // Association des noms aux profils (R.drawable.nom_du_fichier)
        stars.add(new Star("Scarlett Johansson", String.valueOf(R.drawable.scarlett), 3.5f));
        stars.add(new Star("Leonardo DiCaprio", String.valueOf(R.drawable.leonardo), 5.0f));
        stars.add(new Star("Brad Pitt", String.valueOf(R.drawable.brad), 4.0f));
        stars.add(new Star("tom cruise", String.valueOf(R.drawable.tomcruise), 3.5f));
    }

    @Override
    public boolean create(Star o) { return stars.add(o); }

    @Override
    public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setName(o.getName());
                s.setImg(o.getImg());
                s.setRating(o.getRating());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star o) { return stars.remove(o); }

    @Override
    public Star findById(int id) {
        for (Star s : stars) if (s.getId() == id) return s;
        return null;
    }

    @Override
    public List<Star> findAll() { return stars; }
}