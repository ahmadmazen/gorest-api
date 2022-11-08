package sa.lendo.gorest.api.Oauthresourceserver.service;


import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import sa.lendo.gorest.api.Oauthresourceserver.client.GorestClient;
import sa.lendo.gorest.api.Oauthresourceserver.client.GorestServiceGenerator;
import sa.lendo.gorest.api.Oauthresourceserver.dto.CommentDto;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private GorestServiceGenerator gorestServiceGenerator;

    public List<CommentDto> getComments() throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<CommentDto>> call = gorestClient.getComments();
            Response<List<CommentDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<CommentDto> comments = response.body();
                if (CollectionUtils.isNotEmpty(comments)) {
                    return comments;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getCommentsError");

        }
        return null;
    }
    public List<CommentDto> getPostComments(Integer postId) throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<CommentDto>> call = gorestClient.getPostComments(postId);
            Response<List<CommentDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<CommentDto> postComments = response.body();
                if (CollectionUtils.isNotEmpty(postComments)) {
                    return postComments;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getPostCommentsError");

        }
        return null;
    }
}
