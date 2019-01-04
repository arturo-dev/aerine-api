package com.arturo.aerineapi.user;

import java.util.Collection;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Generated
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    @NotNull(message = "Player.Email.Required")
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = Access.WRITE_ONLY)
    private Boolean enabled;

    @JsonProperty(access = Access.WRITE_ONLY)
    private Boolean credentialsNonExpired;

    @JsonProperty(access = Access.WRITE_ONLY)
    private Boolean accountNonExpired;

    @JsonProperty(access = Access.WRITE_ONLY)
    private Boolean accountNonLocked;

    @JsonProperty(access = Access.WRITE_ONLY)
    private Collection<Authority> authorities;

    @JsonProperty(access = Access.WRITE_ONLY)
    private Date creation;

}