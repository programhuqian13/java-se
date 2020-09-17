package principle.dimit;


public class Agent {

    private Star star;

    private Company company;

    private Fans fans;


    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Fans getFans() {
        return fans;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void meeting(){
        System.out.println(fans.getName() + "与明星" + star.getName() + "可以见面了");
    }

    public void business(){
        System.out.println(company.getName() + "与明星" + star.getName() + "洽淡业务");
    }
}
