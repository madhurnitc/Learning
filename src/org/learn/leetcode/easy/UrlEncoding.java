package org.learn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class UrlEncoding {

    Map<String, String> urlMapping = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String encodedurl = Integer.toString(longUrl.hashCode());
        urlMapping.put(encodedurl, longUrl);

        return encodedurl;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return urlMapping.get(shortUrl);

    }
}
