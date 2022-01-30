package ca.n4softsol.restwebservices.hwarws.resources.user;

import javax.persistence.Entity;

import org.springframework.context.annotation.Profile;

@Profile(value= {"dev","default"})
@Entity(name = "dev_user")
public class DevUser extends AbstractUser {

}
