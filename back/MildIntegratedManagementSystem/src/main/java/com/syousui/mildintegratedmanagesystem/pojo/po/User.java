package com.syousui.mildintegratedmanagesystem.pojo.po;

import java.util.Date;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private Integer role;

    private String avatarUrl;

    private String phone;

    private String email;

    private Date createdTime;

    private Date updatedTime;

    public Integer getUserId ( ) {
        return userId;
    }

    public void setUserId ( Integer userId ) {
        this.userId = userId;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username == null ? null : username.trim( );
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password == null ? null : password.trim( );
    }

    public Integer getRole ( ) {
        return role;
    }

    public void setRole ( Integer role ) {
        this.role = role;
    }

    public String getAvatarUrl ( ) {
        return avatarUrl;
    }

    public void setAvatarUrl ( String avatarUrl ) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim( );
    }

    public String getPhone ( ) {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email == null ? null : email.trim( );
    }

    public Date getCreatedTime ( ) {
        return createdTime;
    }

    public void setCreatedTime ( Date createdTime ) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime ( ) {
        return updatedTime;
    }

    public void setUpdatedTime ( Date updatedTime ) {
        this.updatedTime = updatedTime;
    }

    public User ( ) {
    }

    public User ( String username, String password, Integer role, String avatarUrl, String phone, String email, Date createdTime, Date updatedTime ) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.email = email;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public User ( Integer userId, String username, String password, Integer role, String avatarUrl, String phone, String email, Date createdTime, Date updatedTime ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.email = email;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString ( ) {
        return "[ User: " +
                userId + ", " +
                username + ", " +
                password + ", " +
                role + ", " +
                avatarUrl + ", " +
                phone + ", " +
                email + ", " +
                createdTime + ", " +
                updatedTime + ", " + " ]";
    }

    @Override
    public boolean equals ( Object that ) {
        if ( this == that ) {
            return true;
        }
        if ( that == null ) {
            return false;
        }
        if ( getClass( ) != that.getClass( ) ) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId( ) == null ? other.getUserId( ) == null : this.getUserId( ).equals( other.getUserId( ) ))
                && (this.getUsername( ) == null ? other.getUsername( ) == null : this.getUsername( ).equals( other.getUsername( ) ))
                && (this.getPassword( ) == null ? other.getPassword( ) == null : this.getPassword( ).equals( other.getPassword( ) ))
                && (this.getRole( ) == null ? other.getRole( ) == null : this.getRole( ).equals( other.getRole( ) ))
                && (this.getAvatarUrl( ) == null ? other.getAvatarUrl( ) == null : this.getAvatarUrl( ).equals( other.getAvatarUrl( ) ))
                && (this.getPhone( ) == null ? other.getPhone( ) == null : this.getPhone( ).equals( other.getPhone( ) ))
                && (this.getEmail( ) == null ? other.getEmail( ) == null : this.getEmail( ).equals( other.getEmail( ) ))
                && (this.getCreatedTime( ) == null ? other.getCreatedTime( ) == null : this.getCreatedTime( ).equals( other.getCreatedTime( ) ))
                && (this.getUpdatedTime( ) == null ? other.getUpdatedTime( ) == null : this.getUpdatedTime( ).equals( other.getUpdatedTime( ) ));
    }

    @Override
    public int hashCode ( ) {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId( ) == null) ? 0 : getUserId( ).hashCode( ));
        result = prime * result + ((getUsername( ) == null) ? 0 : getUsername( ).hashCode( ));
        result = prime * result + ((getPassword( ) == null) ? 0 : getPassword( ).hashCode( ));
        result = prime * result + ((getRole( ) == null) ? 0 : getRole( ).hashCode( ));
        result = prime * result + ((getAvatarUrl( ) == null) ? 0 : getAvatarUrl( ).hashCode( ));
        result = prime * result + ((getPhone( ) == null) ? 0 : getPhone( ).hashCode( ));
        result = prime * result + ((getEmail( ) == null) ? 0 : getEmail( ).hashCode( ));
        result = prime * result + ((getCreatedTime( ) == null) ? 0 : getCreatedTime( ).hashCode( ));
        result = prime * result + ((getUpdatedTime( ) == null) ? 0 : getUpdatedTime( ).hashCode( ));
        return result;
    }
}