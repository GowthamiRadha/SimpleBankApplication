public class Address {
    private String hNo;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private int zipCode;

    public Address(String hNo, String streetAddress, String city, String state, String country, int zipCode) {
        if(hNo==null || hNo.isEmpty())
            throw new IllegalArgumentException("Invalid House No!");
        if(streetAddress==null || streetAddress.isEmpty())
            throw new IllegalArgumentException("Invalid Street Address!");
        if(city==null || city.isEmpty())
            throw new IllegalArgumentException("Invalid City!");
        if(state==null || state.isEmpty())
            throw new IllegalArgumentException("Invalid State!");
        if(country==null || country.isEmpty())
            throw new IllegalArgumentException("Invalid Country!");
        if(zipCode<10000 || zipCode>99999)
            throw new IllegalArgumentException("Invalid Zipcode!");
        this.hNo = hNo;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
