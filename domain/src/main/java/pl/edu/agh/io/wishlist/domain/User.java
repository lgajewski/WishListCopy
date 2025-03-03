package pl.edu.agh.io.wishlist.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//@Entity
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

//    @Column(length = 60)
    private String password;

    private boolean enabled;

    private boolean tokenExpired;

    private List<String> friends;

    private List<String> friendsRequests;

    @DBRef
    private List<Gift> gifts;

    //

//    @ManyToMany
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") )
    private Collection<Role> roles;

    public User() {
        super();
        this.enabled = false;
        this.tokenExpired = false;
        this.friends = new ArrayList<>();
        this.friendsRequests = new ArrayList<>();
        this.gifts = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<String> getFriends() {
        return friends;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(final boolean expired) {
        this.tokenExpired = expired;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        if (!username.equals(user.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [username=").append(username).append("]")
                .append("[firstName=").append(firstName).append("]")
                .append("[lastName=").append(lastName).append("]")
                .append("[username=").append(email).append("]")
                .append("[friends=").append(friends).append("]")
                .append("[friendsRequests=").append(friendsRequests).append("]")
                .append("[gifts=").append(gifts).append("]");
        return builder.toString();
    }


    public List<String> getFriendsRequests() {
        return friendsRequests;
    }

    public void setFriendsRequests(List<String> friendsRequests) {
        this.friendsRequests = friendsRequests;
    }

    public void addFriendRequest(String friendRequest){
        this.friendsRequests.add(friendRequest);
    }
}