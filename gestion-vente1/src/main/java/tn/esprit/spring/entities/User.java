package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "users", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "email") 
})
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(max = 20)
	private String username;

    private String firstName;

    private String lastName;

    @NotBlank
	@Size(max = 50)
	@Email
    private String email;

    @NotBlank
	@Size(max = 120)
    private String password;
    
    @NotBlank
	@Size(max = 50)
    private String country;
   
    private int phoneNum;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
    
    public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public User(String username, String firstName, String lastName, String email, String password, String country, int phoneNum) {
		this.email = email;
		this.username=username;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNum = phoneNum;
	}

}
