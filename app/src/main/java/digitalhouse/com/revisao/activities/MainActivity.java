package digitalhouse.com.revisao.activities;

import android.app.ProgressDialog;
import android.os.RemoteCallbackList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.com.revisao.R;
import digitalhouse.com.revisao.adapters.BookAdapter;
import digitalhouse.com.revisao.adapters.PostAdapter;
import digitalhouse.com.revisao.helpers.RecyclerViewClickListener;
import digitalhouse.com.revisao.helpers.RecyclerViewTouchListener;
import digitalhouse.com.revisao.models.book;
import digitalhouse.com.revisao.models.posts;
import digitalhouse.com.revisao.network.ApiService;
import digitalhouse.com.revisao.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private List<book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<posts> postsList = new ArrayList<>();
    private PostAdapter postAdapter;
    ProgressDialog progressDialog; //esse progressbar é o mesmo que o loading

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        initRetrofit();
    }

    private void initRetrofit(){

        ApiService service = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        Call<List<posts>> call = service.getAllPosts();

        call.enqueue(new Callback<List<posts>>() {
            @Override
            public void onResponse(Call<List<posts>> call, Response<List<posts>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<posts>> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

    private void generateDataList(final List<posts> postsList){
        recyclerView = (RecyclerView) findViewById(R.id.);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecyclerViewClickListener() ){
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is long pressed!", Toast.LENGTH_SHORT).show();

            }

    });

        postAdapter = new PostAdapter(postsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.ItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(postAdapter);

    }


    private void initBookData() {
        book book = new book("Hello Android", "Ed Burnette");
        bookList.add(book);

        book = new book("Beginning Android 3", "Mark Murphy");
        bookList.add(book);

        book = new book("Unlocking Android", " W. Frank Ableson");
        bookList.add(book);

        book = new book("Android Tablet Development", "Wei Meng Lee");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        bookAdapter.notifyDataSetChanged();
    }
}
