package sa.lendo.gorest.api.Oauthresourceserver.service;


import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import sa.lendo.gorest.api.Oauthresourceserver.client.GorestClient;
import sa.lendo.gorest.api.Oauthresourceserver.client.GorestServiceGenerator;
import sa.lendo.gorest.api.Oauthresourceserver.dto.PostDto;


import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private GorestServiceGenerator gorestServiceGenerator;


    public List<PostDto> getPosts() throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<PostDto>> call = gorestClient.getPosts();
            Response<List<PostDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<PostDto> posts = response.body();
                if (CollectionUtils.isNotEmpty(posts)) {
                    return posts;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getUsersError");

        }
        return null;
    }
    public List<PostDto> getUserPosts(Integer userId) throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<PostDto>> call = gorestClient.getUserPosts(userId);
            Response<List<PostDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<PostDto> userPosts = response.body();
                if (CollectionUtils.isNotEmpty(userPosts)) {
                    return userPosts;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getUserPostsError");

        }
        return null;
    }
}
