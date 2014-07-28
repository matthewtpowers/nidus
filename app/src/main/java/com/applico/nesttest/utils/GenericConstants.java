package com.applico.nesttest.utils;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;


/**
 * Created by matthewpowers on 7/22/14.
 */
public class GenericConstants {

    //Auth Path
    public static final String NEST_AUTH_PATH = "/oauth2/access_token";
    //API Endpoint for the development API
    public static final String NEST_FIREBASE_URI = "wss://developer-api.nest.com";
    //NEST Client ID
    public static final String NEST_CLIENT_ID = "2ed12941-0134-4e77-85f9-793896e44e24";
    //Nest Client Secret
    public static final String NEST_CLIENT_SECRET = "V08y0eCN7KX5HwNEPfKrQysy7";
    //Nest Auth URI
    public static final String NEST_AUTH_URI = "https://home.nest.com/login/oauth2?client_id=";
    //Nest API Endpoint
    public static final String NEST_API_URI = "https://api.home.nest.com";
    //Nest Grant Type
    //TODO, this is going to need to increment itself everytime its used, will move away from this in the future
    public static final String NEST_GRANT_TYPE ="authorization_code";

    //Shared Preferences
    public static final String NEST_SHARED_PREF_KEY = "nest_shared_pref";
    public static final String NEST_AUTH_CODE_KEY = "nest_auth_code_key";
    public static final String NEST_AUTH_TOKEN = "nest_auth_token";
    public static final String NEST_AUTH_TOKEN_EXPIRATION = "nest_seconds_to_expiration";
     //Used globally throughout the application to make sure that its authorized
    public static final String NEST_IS_AUTH = "nest_is_auth";

    //"https://api.home.nest.com/oauth2/access_token?code=AUTHORIZATION_CODE&client_id=2ed12941-0134-4e77-85f9-793896e44e24&client_secret=V08y0eCN7KX5HwNEPfKrQysy7&grant_type=authorization_code";




}
