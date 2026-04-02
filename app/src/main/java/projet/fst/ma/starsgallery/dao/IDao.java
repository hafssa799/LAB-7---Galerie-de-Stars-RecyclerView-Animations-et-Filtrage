package projet.fst.ma.starsgallery.dao;

import java.util.List;

/**
 * Interface générique pour les opérations CRUD (Create, Read, Update, Delete)
 * @param <T> Le type d'objet manipulé (ici ce sera Star)
 */
public interface IDao<T> {

    // Ajouter un nouvel objet
    boolean create(T o);

    // Mettre à jour un objet existant
    boolean update(T o);

    // Supprimer un objet
    boolean delete(T o);

    // Rechercher un objet par son identifiant unique
    T findById(int id);

    // Récupérer la liste complète des objets
    List<T> findAll();
}