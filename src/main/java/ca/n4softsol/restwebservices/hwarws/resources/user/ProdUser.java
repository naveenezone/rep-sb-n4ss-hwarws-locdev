package ca.n4softsol.restwebservices.hwarws.resources.user;

import javax.persistence.Entity;

import org.springframework.context.annotation.Profile;

@Profile(value= {"prod"})
@Entity(name = "prod_user")
public class ProdUser extends AbstractUser {

}
