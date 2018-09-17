package digitalhouse.com.revisao.network;

import java.util.List;

import digitalhouse.com.revisao.models.posts;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/posts")
    Call <List<posts>> getAllPosts();
}
