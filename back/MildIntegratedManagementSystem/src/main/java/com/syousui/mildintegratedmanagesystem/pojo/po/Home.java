package com.syousui.mildintegratedmanagesystem.pojo.po;

import java.util.Date;

public class Home {
    private Integer homeId;

    private String title;

    private Double price;

    private Date updatedTime;

    private Integer homeTypeId;

    public Integer getHomeId ( ) {
        return homeId;
    }

    public void setHomeId ( Integer homeId ) {
        this.homeId = homeId;
    }

    public String getTitle ( ) {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title == null ? null : title.trim( );
    }

    public Double getPrice ( ) {
        return price;
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }

    public Date getUpdatedTime ( ) {
        return updatedTime;
    }

    public void setUpdatedTime ( Date updatedTime ) {
        this.updatedTime = updatedTime;
    }

    public Integer getHomeTypeId ( ) {
        return homeTypeId;
    }

    public void setHomeTypeId ( Integer homeTypeId ) {
        this.homeTypeId = homeTypeId;
    }

    @Override
    public String toString ( ) {
        return "[ Home: ]" +
                homeId + ", " +
                title + ", " +
                price + ", " +
                updatedTime + ", " +
                homeTypeId + " ]";
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
        Home other = (Home) that;
        return (this.getHomeId( ) == null ? other.getHomeId( ) == null : this.getHomeId( ).equals( other.getHomeId( ) ))
                && (this.getTitle( ) == null ? other.getTitle( ) == null : this.getTitle( ).equals( other.getTitle( ) ))
                && (this.getPrice( ) == null ? other.getPrice( ) == null : this.getPrice( ).equals( other.getPrice( ) ))
                && (this.getUpdatedTime( ) == null ? other.getUpdatedTime( ) == null : this.getUpdatedTime( ).equals( other.getUpdatedTime( ) ))
                && (this.getHomeTypeId( ) == null ? other.getHomeTypeId( ) == null : this.getHomeTypeId( ).equals( other.getHomeTypeId( ) ));
    }

    @Override
    public int hashCode ( ) {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHomeId( ) == null) ? 0 : getHomeId( ).hashCode( ));
        result = prime * result + ((getTitle( ) == null) ? 0 : getTitle( ).hashCode( ));
        result = prime * result + ((getPrice( ) == null) ? 0 : getPrice( ).hashCode( ));
        result = prime * result + ((getUpdatedTime( ) == null) ? 0 : getUpdatedTime( ).hashCode( ));
        result = prime * result + ((getHomeTypeId( ) == null) ? 0 : getHomeTypeId( ).hashCode( ));
        return result;
    }
}