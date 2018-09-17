package digitalhouse.com.revisao.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import digitalhouse.com.revisao.R;
import digitalhouse.com.revisao.models.book;

public class BookAdapter extends RecyclerView.BookAdapter<BookAdapter.BookViewHolder> {

    private List<book> bookList;

    public BookAdapter(List<book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_recycler_main, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.title.setText(bookList.get(position).getTitle());
        holder.author.setText(bookList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
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
}