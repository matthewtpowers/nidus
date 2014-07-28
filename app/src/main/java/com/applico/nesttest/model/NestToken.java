package com.applico.nesttest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by matthewpowers on 7/22/14.]
 * The Nest token is used to authenticate with firebase and the NEST api
 * It has an expiration of ~ 6 weeks
 */
public class NestToken {

    @SerializedName("access_token")
    public String accessToken;

    //This is the number of seconds until it expires
    @SerializedName("expires_in")
    public Long expirationDate;
}
