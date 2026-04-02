package projet.fst.ma.starsgallery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;
import projet.fst.ma.starsgallery.R;
import projet.fst.ma.starsgallery.beans.Star;
import java.util.ArrayList;
import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {
    private List<Star> stars; // Liste originale (complète)
    private List<Star> starsFilter; // Liste affichée (filtrée)
    private Context context;
    private NewFilter mfilter;

    public StarAdapter(Context context, List<Star> stars) {
        this.context = context;
        this.stars = stars;
        this.starsFilter = new ArrayList<>(stars); // Initialement identique
        this.mfilter = new NewFilter(this);
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.star_item, parent, false);
        return new StarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star s = starsFilter.get(position);
        holder.name.setText(s.getName().toUpperCase());
        holder.rating.setRating(s.getRating());

        String imgData = s.getImg();

        try {
            // On essaie de voir si c'est un nombre (ID de ressource locale)
            int resourceId = Integer.parseInt(imgData);
            Glide.with(context)
                    .load(resourceId) // Charge depuis drawable
                    .into(holder.img);
        } catch (NumberFormatException e) {
            // Si ce n'est pas un nombre, c'est une URL Web (ancienne méthode)
            Glide.with(context)
                    .load(imgData) // Charge depuis Internet
                    .placeholder(R.drawable.star) // Image par défaut
                    .into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return starsFilter.size();
    }

    @Override
    public Filter getFilter() {
        return mfilter;
    }

    public class StarViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CircleImageView img;
        RatingBar rating;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            // Vérifiez bien que ces IDs correspondent à star_item.xml
            img = itemView.findViewById(R.id.imgStar);
            name = itemView.findViewById(R.id.tvName);
            rating = itemView.findViewById(R.id.rating);
        }
    }

    // Classe interne pour la logique de filtrage
    public class NewFilter extends Filter {
        private final StarAdapter mAdapter;

        public NewFilter(StarAdapter mAdapter) {
            this.mAdapter = mAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Star> filtered = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0) {
                filtered.addAll(stars);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Star s : stars) {
                    if (s.getName().toLowerCase().startsWith(filterPattern)) {
                        filtered.add(s);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtered;
            results.count = filtered.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            starsFilter = (List<Star>) filterResults.values;
            mAdapter.notifyDataSetChanged();
        }
    }
}