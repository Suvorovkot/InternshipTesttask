public class User {
    private Integer companyID;
    private String name;

    public User(Integer companyID, String name)
    {
        this.companyID = companyID;
        this.name = name;
    }

    public Integer getCompanyID()
    {
        return this.companyID;
    }
}
