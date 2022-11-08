package sa.lendo.gorest.api.Oauthresourceserver.service;


import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import sa.lendo.gorest.api.Oauthresourceserver.client.GorestClient;
import sa.lendo.gorest.api.Oauthresourceserver.client.GorestServiceGenerator;
import sa.lendo.gorest.api.Oauthresourceserver.dto.UserDto;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private GorestServiceGenerator gorestServiceGenerator;

    public List<UserDto> getUsers() throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<UserDto>> call = gorestClient.getUsers();
            Response<List<UserDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<UserDto> users = response.body();
                if (CollectionUtils.isNotEmpty(users)) {
                    return users;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getUsersError");

        }
        return null;
    }
}
