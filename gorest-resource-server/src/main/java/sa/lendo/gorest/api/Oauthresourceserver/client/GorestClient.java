package sa.lendo.gorest.api.Oauthresourceserver.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sa.lendo.gorest.api.Oauthresourceserver.dto.CommentDto;
import sa.lendo.gorest.api.Oauthresourceserver.dto.PostDto;
import sa.lendo.gorest.api.Oauthresourceserver.dto.UserDto;

import java.util.List;

public interface GorestClient {
    //https://gorest.co.in/
    @GET("/public/v2/users")
    Call<List<UserDto>> getUsers();

    @GET("/public/v2/posts")
    Call<List<PostDto>> getPosts();

    @GET("/public/v2/comments")
    Call<List<CommentDto>> getComments();

    @GET("/public/v2/users/{userId}/posts")
    Call<List<PostDto>> getUserPosts(@Path("userId") Integer userId);

    @GET("/public/v2/posts/{postId}/comments")
    Call<List<CommentDto>> getPostComments(@Path("postId") Integer postId);
}
