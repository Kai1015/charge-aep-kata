package com.kaiherrera.chargeaep.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.kaiherrera.chargeaep.domain.User;
import com.kaiherrera.chargeaep.domain.slack.SlackUser;
import com.kaiherrera.chargeaep.domain.slack.SlackUserResponse;
import com.kaiherrera.chargeaep.service.slack.SlackErrorResponse;
import com.kaiherrera.chargeaep.service.slack.SlackResponse;
import com.kaiherrera.chargeaep.service.slack.SlackUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SlackUserServiceTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private SlackUserService service;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(service, "token", "test");
	}
	
	@Test
	public void validIdReturnsUserObject() throws Exception {
		SlackUser user = new SlackUser("test", "name");
		
		Mockito
			.when(restTemplate.getForObject("https://slack.com/api/users.info?token=test&user=test&pretty=1", SlackResponse.class))
			.thenReturn(new SlackUserResponse(true, user));
		Optional<User> testUser = service.getUser("test");
		
		assertEquals("name", testUser.get().getName());
	}
	
	@Test
	public void invalidIdReturnsEmptyObject() throws Exception {
		Mockito
			.when(restTemplate.getForObject("https://slack.com/api/users.info?token=test&user=test&pretty=1", SlackResponse.class))
			.thenReturn(new SlackErrorResponse(false, ""));
		
		boolean testUser = service.getUser("test").isPresent();
		assertEquals(false, testUser);
	}
	
}
