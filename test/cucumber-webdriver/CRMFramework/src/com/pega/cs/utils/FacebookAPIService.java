package com.pega.cs.utils;

import java.util.HashMap;
import java.util.Map;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.RawAPIResponse;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;
public class FacebookAPIService {

        Map<String, String> userAccessTokenMap = new HashMap<String, String>();

        public FacebookAPIService() {
                userAccessTokenMap
                                .put("cssocialqa",
                                                "EAAZAW0CF7gXcBAPouOO1FBvmQVxhMswoKXUTIPVG6m5WLyzBsEOEZBQWmg0ieWJrw6gPoNRi5PJid8ouCU7MqIb9Lg0ZA8ZB2bm4roZBcNN4eeVvEZBgPMjvL15glZCaZBS4dNFQSLfZBy8qWckP4ZCcCLVKZBlEaPvkj8ZD");
                // TODO: Add more users and tokens here.
        }

        public String postMessageOnPage(String userName, String facebookPageId,
                        String message) throws FacebookException, JSONException {

                Facebook facebook = getFacebookInstance(userName);

                
                Map<String, String> params = new HashMap<String, String>();
                params.put("message", message);
                RawAPIResponse rawResult = facebook.callPostAPI(facebookPageId
                                + "/feed", params);

                JSONObject resultObject = rawResult.asJSONObject();
                return resultObject.getString("id");

        }

        private Facebook getFacebookInstance(String userName) {
                String userAccessToken = userAccessTokenMap.get(userName);
                if (userAccessToken == null) {
                        throw new IllegalArgumentException(
                                        "userAccess token does not exist for userName : "
                                                        + userName);
                }

                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true).setOAuthAppId("1784301775192439")
                                .setOAuthAppSecret("7a61f6c650ae035449bcd99423f82495")
                                .setOAuthAccessToken(userAccessToken);

                FacebookFactory ff = new FacebookFactory(cb.build());
                Facebook facebook = ff.getInstance();
                return facebook;
        }

        public String getReplyIdForRepliedMessage(String userName, String postId,
                        String csrReplyMessage) throws FacebookException, JSONException {
                Facebook facebook = getFacebookInstance(userName);
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("filter", "stream");
                RawAPIResponse res = facebook.callGetAPI(postId + "/comments",
                                parameters);

                JSONObject commentsReplyObject = res.asJSONObject();
                JSONArray allReplies = commentsReplyObject.getJSONArray("data");

                for (int replyIndex = 0; replyIndex != allReplies.length(); replyIndex++) {
                        JSONObject replyObject = allReplies.getJSONObject(replyIndex);
                        if (csrReplyMessage.equals(replyObject.getString("message"))) {
                                return replyObject.getString("id");
                        }
                }

                throw new IllegalArgumentException(String.format(
                                "no post exist with id : %s and with reply : %s", postId,
                                csrReplyMessage));

        }

        public void commentOnReply(String userName, String replyId, String message)
                        throws FacebookException {
                Facebook facebook = getFacebookInstance(userName);

                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("message", message);
                RawAPIResponse response = facebook.callPostAPI(replyId + "/comments",
                                parameters);

                System.out.println(response);
        }

}