package digitalhouse.com.revisao.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import digitalhouse.com.revisao.R;
import digitalhouse.com.revisao.models.posts;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private List<posts> postsList;

    public PostAdapter(List<posts> postsList) {
        this.postsList = postsList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_recycler_main, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override

    //esse cara holder. é quem vai buscar as infos no meu pojo
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.title.setText(postsList.get(position).getTitle());
        holder.author.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView author;

        public PostViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
        }
    }
}

