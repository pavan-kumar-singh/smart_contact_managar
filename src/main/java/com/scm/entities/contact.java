
package com.scm.entities;
// import java.util.*;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class contact  {
    @Id
    private String Id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String discription;
    private boolean favorite=false;
    private String webSiteLink;
    private String linkedin;

//    private List<String>socialLinks =new ArrayList<>();
@ManyToOne
private User1 user; 

 @OneToMany(mappedBy = "contact" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> links= new ArrayList<>();

}
