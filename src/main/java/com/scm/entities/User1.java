
package com.scm.entities;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class User1 {
    @Id
    private String userId;
    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    @Column(length = 5000)
    private String about;
    @Column(length = 5000)
    private String profilePic;
    @Column(length = 100)
    private String phone;
    // information
    private boolean enabled=false;
    private boolean emailverified=false;
    private boolean contactverified=false;
    private boolean passwordverified=false;
    // self information like google, facebook, twitter, github,linkedin
    private Providers1 provider=Providers1.SELF;
    private String providerUserId;
    //add more fields if needed
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY, orphanRemoval = true)
   private List<contact> contacts= new ArrayList<>();
    
}
