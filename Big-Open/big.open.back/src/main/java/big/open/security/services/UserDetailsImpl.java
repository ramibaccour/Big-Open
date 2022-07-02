package big.open.security.services;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import big.open.entity.User;

public class UserDetailsImpl implements UserDetails 
{
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	public UserDetailsImpl(String id, String username, String password,Collection<? extends GrantedAuthority> authorities) 
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	public static UserDetailsImpl build(User user) 
	{
		GrantedAuthority authoritie = new SimpleGrantedAuthority("admin");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authoritie);
		return new UserDetailsImpl(
				user.getId() + "", 
				user.getUsername(), 
				user.getPassword(), 
				authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return authorities;
	}
	public String getId() 
	{
		return id;
	}
	public String getEmail() 
	{
		return email;
	}
	@Override
	public String getPassword() 
	{
		return password;
	}
	@Override
	public String getUsername() 
	{
		return username;
	}
	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean equals(Object o) 
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}