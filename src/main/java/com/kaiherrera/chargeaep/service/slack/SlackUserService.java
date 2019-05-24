package com.kaiherrera.chargeaep.service.slack;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.kaiherrera.chargeaep.domain.User;
import com.kaiherrera.chargeaep.service.UserService;

public class SlackUserService implements UserService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${slackToken}")
	private String token;
	
	public Optional<User> getUser(String id) throws SlackExceptionResponse {
		try {
			String uri = buildUri(id);
			SlackResponse response = restTemplate.getForObject(uri, SlackResponse.class);
			boolean responseStatus = response.isOk();
		
			if (responseStatus == true) {
				return Optional.of(response.getUser());
			} else {
				return Optional.empty();
			}
			
		} catch (Exception e) {
			throw new SlackExceptionResponse("Error querying Slack.");
		}
	}

	private String buildUri(String id) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https").host("slack.com/api").path("/users.info").query("token={token}&user={id}&pretty=1").buildAndExpand(token, id);
		return uri.toString();
	}
}
