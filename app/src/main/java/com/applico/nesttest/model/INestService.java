package com.applico.nesttest.model;
import com.applico.nesttest.utils.GenericConstants;

import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;
import retrofit.Callback;
import java.util.Map;

/**
 * Created by matthewpowers on 7/22/14.
 */
public interface INestService {

    //"https://api.home.nest.com/oauth2/access_token?code=AUTHORIZATION_CODE&client_id=2ed12941-0134-4e77-85f9-793896e44e24&client_secret=V08y0eCN7KX5HwNEPfKrQysy7&grant_type=authorization_code";

    @POST(GenericConstants.NEST_AUTH_PATH)
    public void getToken(@QueryMap Map<String,String> tokenParams, Callback<NestToken> callback);

}
