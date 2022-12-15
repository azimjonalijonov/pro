package RealFirstaparoject.pro.domain;



import RealFirstaparoject.pro.domain.enumiration.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "market_user")
public class User implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationcType.IDENTITY)
      @NotNull
     private Long id;

     private String username;
     private String password;
     private String email;
     private String firstName;
     private String lastName;
     private Status status;
     @ManyToMany(fetch = FetchType.EAGER)
     @JoinTable(
         name = "user_role",
         joinColumns ={@JoinColumn(name = "user_id",referencedColumnName = "id")},
         inverseJoinColumns ={@JoinColumn(name ="role_name",referencedColumnName = "name")}
     )
     private Set<Role> roles= new HashSet<>();

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public Status getStatus() {
          return status;
     }

     public void setStatus(Status status) {
          this.status = status;
     }

     public Set<Role> getRoles() {
          return roles;
     }

     public void setRoles(Set<Role> roles) {
          this.roles = roles;
     }
}
