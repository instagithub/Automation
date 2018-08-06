package com.pega.cs.utils;

import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPIService {
	public TwitterAPIService() 
	{

	}

	protected Twitter getCSTwitterConnection(String userName) {

		if ("CPM PW Test".equals(userName)) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("ETvNnv7OAKBgY2iLkLrvPJjgX")
					.setOAuthConsumerSecret("toLcggCYdgqDRPlD8rHD4pe7W75uYhAEfmh6u8O5TRZidjh5OY")
					.setOAuthAccessToken("2534570551-rDLbTG27YF01bT6mYnGG5FNOQJgIQpV9e2VQk0x")
					.setOAuthAccessTokenSecret("C7qiDuIMtUrtMwJT1xIoE3Cx6rA7tJoIxq1orkc6IEyJg");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		} 
		if ("csqacustomer".equals(userName)) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("ipnmvF0XyGIrssqzN8iOlfarg")
					.setOAuthConsumerSecret("jcxJpxY2o19KvGGz05lsFgq1Lx13O8hMctalg7N9UaPDj3Gw8A")
					.setOAuthAccessToken("4728213313-3MYnaKyKL0FbqmZ34BfFFDgwUukgUDT73tl6x6h")
					.setOAuthAccessTokenSecret("iGD3S5L94ZGJExdK2ZhFXuVW4PRfRvLJ2Pi9o45dtUSTw");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		if("CSSocialUser".equalsIgnoreCase(userName))
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("Xb70QWqdV3ymXouMCZlm5ber8")
					.setOAuthConsumerSecret("ltOBXDbaMyi50yQzaILVZqH6SvtgWJe8Nj4yAkteBoNvpssm6R")
					.setOAuthAccessToken("789321966020796416-tBTIJZPLSe1uMBS0FnT9zSgVkkM1nsI")
					.setOAuthAccessTokenSecret("MWOfkHnBrrsvY1SOqP14Y4mywuKIsC5fgeLnnxCl1Ekrh");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		if("CSSocialCustomer".equalsIgnoreCase(userName))
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("0nmQ9NGmCJkbBrKw9VSwYK3he")
					.setOAuthConsumerSecret("XlkGJzUUTRxoiobOkdUlXagYdPSdFV0qprcXrdOGKBZhqoMqcv")
					.setOAuthAccessToken("789323010205376512-fOE0xlLEnOg4k3YwRUc4h6lsfIWdrO5")
					.setOAuthAccessTokenSecret("4JJqPyC3CiHOy8KO0M83hgc3VRVKf1pSXuP1kdh6yE6xh");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		if("csmsclhandle1".equalsIgnoreCase(userName))
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("2mMHZ6F5l1henjGZsBLcfGRu1")
					.setOAuthConsumerSecret("QTA2gD64XeLqOidi0fYrhUTmUumGcuff74L1CV6MgAjbPbrVcI")
					.setOAuthAccessToken("956002114592894979-AbOjtHdNHXnSCP3qzbDVZinwCry7FDN")
					.setOAuthAccessTokenSecret("pHmS7Uad2E02RlEGCGDa4uE3MH5BriCzluenyVk0yQ6ho");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		if("csmsclhandle2".equalsIgnoreCase(userName))
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("H1K2nPcfXRWz1BoyKytvdXHcu")
					.setOAuthConsumerSecret("MZaQ3ez64S3LKcs7eY1KGUS4ZHfbhvLQUAqyBCNS8R6Z89rwSS")
					.setOAuthAccessToken("956004103838035968-qVvYWcrqQFY6tpIiGUnzhRRdyWrlBik")
					.setOAuthAccessTokenSecret("trPUnymM8XFrRqesplQzBAAMw7kdia7e1TsnKUsGslGwv");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		if("csmsclhandle3".equalsIgnoreCase(userName))
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("3z9Xjs3HE6CqvqcSlF2Rgl1I8")
					.setOAuthConsumerSecret("h69Tj82ePZYqwvFcn4TVrfqylTQ9hr5H4K2q6LNGXh4e2PZDcW")
					.setOAuthAccessToken("957841948013834240-u1Uyr4OpkjQCttFmqqmSFjTJpBz30a7")
					.setOAuthAccessTokenSecret("gGUieK3ROgUo7jpy9EBQhVsp580JfxWU55YUpxCoaFtE1");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		if("csmsclhandle5".equalsIgnoreCase(userName))
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("Zsc0h20v3dD8pSOg0qiWJhc6T")
					.setOAuthConsumerSecret("6FsEipNiTHAayb2e840FsIcXwy8D2kbnTWCKxaz5gY6LbwZDjL")
					.setOAuthAccessToken("957891749082406912-sM6awDUfAr86BKXxtU1ZkV0zJ2AISBp")
					.setOAuthAccessTokenSecret("INiPBJ1YRxNc6fXIJPOjYuGYQoAw3VXecq4rnGllywlHs");
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		}
		else {
			throw new IllegalArgumentException("twitter connection does not exist for the user");
		}

	}

	public void sendTweet(String userName, String message) throws TwitterException {
		Twitter twitter = getCSTwitterConnection(userName);
		Status status = twitter.updateStatus(message);
		System.out.println("successfully posting the tweet");

	}

	public long findTweetByID(String userName, String queryString) throws TwitterException {
		Twitter twitter = getCSTwitterConnection(userName);

		Query query = new Query(queryString);
		QueryResult queryResult = twitter.search(query);

		if (queryResult.getTweets().size() > 0) {
			return queryResult.getTweets().get(0).getId();
		}

		throw new IllegalArgumentException("tweet not available for the queryString " + queryString);
	}

	public long getInReplyToStatusId(String csrResponse) {
		StatusUpdate statusUpdate = new StatusUpdate(csrResponse);
		long inReplyToStatusId = statusUpdate.getInReplyToStatusId();
		return inReplyToStatusId;
		
    }
	
	public void replyToTweet(String userName, long inReplyToStatusId, String replyMessage) throws TwitterException {
		Twitter twitter = getCSTwitterConnection(userName);
		StatusUpdate statusUpdate = new StatusUpdate(replyMessage);
		statusUpdate.inReplyToStatusId(inReplyToStatusId);
		Status status = twitter.updateStatus(statusUpdate);
		System.out.println(status);
		

	}
	
	
	public void sendDM(String userName, String corporateHandle, String message) throws TwitterException {
		Twitter twitter = getCSTwitterConnection(userName);
		DirectMessage dmMessage = twitter.sendDirectMessage(corporateHandle, message);
		System.out.println(dmMessage.getSenderScreenName()+"                 "+dmMessage.getRecipientScreenName());
	}
	
	public void findDMByID(String userName, String corporateHandle, String queryString) throws TwitterException
	{
		Twitter twitter = getCSTwitterConnection(userName);

		DirectMessage message = twitter.showDirectMessage(Long.parseLong(""));
        System.out.println("From: @" + message.getSenderScreenName() + " id:" + message.getId() + " - "+ message.getText());
	}
	
	

}