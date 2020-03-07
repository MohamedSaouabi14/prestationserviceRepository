package org.sid.prestationservices.security;

public interface SecurityParams {
    String JWT_HEADER_NAME = "Authorization";
    String SECRET = "mohamedsaouabi7@gmail.com";
    long EXPIRATION = 10 * 24 * 3600;
    String HEADER_PREFIX = "Bearer ";
}
