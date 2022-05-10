package tn.esprit.spring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

	
		private String token;
		private Long id;
		private String firstName;
		private String lastName;
		private String username;
		private String email;
		private List<String> roles;
		
		public JwtResponse(String jwt, Long id2, String username2, String email2, List<String> roles2) {
			this.id = id2;
			this.token = jwt;
			this.email = email2;
			this.roles = roles2;
			this.username = username2;
		}
	

}
