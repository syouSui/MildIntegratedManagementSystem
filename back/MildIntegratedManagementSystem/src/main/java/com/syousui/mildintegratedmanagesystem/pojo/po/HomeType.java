package com.syousui.mildintegratedmanagesystem.pojo.po;

public class HomeType {
    private Integer homeTypeId;

    private String homeType;

    public Integer getHomeTypeId ( ) {
        return homeTypeId;
    }

    public void setHomeTypeId ( Integer homeTypeId ) {
        this.homeTypeId = homeTypeId;
    }

    public String getHomeType ( ) {
        return homeType;
    }

    public void setHomeType ( String homeType ) {
        this.homeType = homeType == null ? null : homeType.trim( );
    }

    @Override
    public String toString ( ) {
        return "[ HomeType :" +
                homeTypeId + ", " +
                homeType + " ]";
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
        HomeType other = (HomeType) that;
        return (this.getHomeTypeId( ) == null ? other.getHomeTypeId( ) == null : this.getHomeTypeId( ).equals( other.getHomeTypeId( ) ))
                && (this.getHomeType( ) == null ? other.getHomeType( ) == null : this.getHomeType( ).equals( other.getHomeType( ) ));
    }

    @Override
    public int hashCode ( ) {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHomeTypeId( ) == null) ? 0 : getHomeTypeId( ).hashCode( ));
        result = prime * result + ((getHomeType( ) == null) ? 0 : getHomeType( ).hashCode( ));
        return result;
    }
}