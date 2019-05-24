package com.kaiherrera.chargeaep.domain.slack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaiherrera.chargeaep.domain.User;

public class SlackUser implements User {

	@JsonProperty String id;
    @JsonProperty String name;
    
    public SlackUser() {}
    
    public SlackUser(String id, String name) {
		this.id = id;
		this.name = name;
	}
    
    @Override
    public String getId() {
    	return id;
    }
    
    @Override
    public String getName() {
    	return name;
    }

}
